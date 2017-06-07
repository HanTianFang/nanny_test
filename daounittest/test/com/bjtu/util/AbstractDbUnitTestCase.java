package com.bjtu.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.dbunit.util.Base64.InputStream;

import junit.framework.Assert;

public class AbstractDbUnitTestCase {
	public static IDatabaseConnection dbunitCon;
	private File tempFile;
 
	@BeforeClass
	public static void init() throws DatabaseUnitException, SQLException {
		dbunitCon = new DatabaseConnection(DbUtil.getConnection());
	}
 
	protected IDataSet createDateSet(String tname) throws DataSetException, IOException {
		java.io.InputStream is = AbstractDbUnitTestCase.class.getClassLoader().getResourceAsStream(tname + ".xml");
		Assert.assertNotNull("dbunit�Ļ��������ļ�������", is);
		return new FlatXmlDataSet(is);
	}
 
	protected void backupAllTable() throws SQLException, IOException, DataSetException {
		IDataSet ds = dbunitCon.createDataSet();
		writeBackupFile(ds);
	}
 
	private void writeBackupFile(IDataSet ds) throws IOException, DataSetException {
		tempFile = File.createTempFile("back", "xml");
		FlatXmlDataSet.write(ds, new FileWriter(tempFile));
	}
 
	protected void backupCustomTable(String[] tname) throws DataSetException, IOException, SQLException {
		QueryDataSet ds = new QueryDataSet(dbunitCon);
		for (String str : tname) {
			ds.addTable(str);
		}
		writeBackupFile(ds);
	}
 
	protected void bakcupOneTable(String tname) throws DataSetException, IOException, SQLException {
		backupCustomTable(new String[] { tname });
	}
 
	protected void resumeTable() throws DatabaseUnitException, SQLException, IOException {
		IDataSet ds = new FlatXmlDataSet(tempFile);
		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon, ds);
	}
	
	
	/** 
	 * Export data for the table names by the given IDatabaseConnection into the resultFile.<br> 
	 * The export data will be DBUnit format. 
	 *  
	 * @param conn 
	 * @param tableNameList 
	 * @param resultFile 
	 * @throws SQLException 
	 * @throws DatabaseUnitException 
	 * @throws FileNotFoundException 
	 * @throws IOException 
	 */  
	public void exportData(IDatabaseConnection iconn, List<String> tableNameList, String resultFile) throws SQLException, DatabaseUnitException, FileNotFoundException, IOException {  
	    QueryDataSet dataSet = null;  
	    if (iconn == null) {  
	        return;  
	    }  
	    if (tableNameList == null || tableNameList.size() == 0) {  
	        return;  
	    }  
	    try {  
	        dataSet = new QueryDataSet(iconn);  
	        for (String tableName : tableNameList) {  
	            dataSet.addTable(tableName);  
	        }  
	    } finally {  
	        if (dataSet != null) {  
	            FlatXmlDataSet.write(dataSet, new FileOutputStream(resultFile));  
	        }  
	    }  
	  
	}  
 
	@AfterClass
	public static void destory() {
		try {
			if (dbunitCon != null)
				dbunitCon.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}