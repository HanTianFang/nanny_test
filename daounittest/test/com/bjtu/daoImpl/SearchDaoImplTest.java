package com.bjtu.daoImpl;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.dbunit.DatabaseUnitException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bjtu.util.AbstractDbUnitTestCase;


@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"file:src/beans.xml"})  

public class SearchDaoImplTest extends AbstractDbUnitTestCase{
	
	SessionFactory sessionFactory = null;

	@Before
	public void setUp() throws Exception {
		try{
			StandardServiceRegistry  registry = new StandardServiceRegistryBuilder()
					.configure() // configures settings from hibernate.cfg.xml
					.build();
			
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
			}catch(Exception e){
				e.printStackTrace();
			}
		bakcupOneTable("userbaseinfo");
		
	}

	@Test
	public void testSearchNanny() {
		SearchDaoImpl sdi = new SearchDaoImpl();
		ArrayList<Integer> resultTest = new ArrayList<Integer>();
		HashMap<String,String> map1 = new HashMap<>();
		map1.put("education", "本科以上");
		resultTest = sdi.searchNanny(map1);
		int i = resultTest.get(0);
		Assert.assertEquals(109, i);
		
	}
	
	@After
	public void tearDown() throws DatabaseUnitException, SQLException, IOException{
		resumeTable();
	}

}
