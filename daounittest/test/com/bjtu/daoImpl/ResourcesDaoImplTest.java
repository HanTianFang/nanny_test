package com.bjtu.daoImpl;

import static org.junit.Assert.*;
import java.io.IOException;
import java.sql.SQLException;

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
public class ResourcesDaoImplTest  extends AbstractDbUnitTestCase{
	
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
	public void testGetImageUrl() {
		
		ResourcesDaoImpl rdi = new ResourcesDaoImpl();
		rdi.setSessionFactory(sessionFactory);
		Assert.assertEquals("./imgResources/7.jpg", rdi.getImageUrl(1).get(0));
		Assert.assertEquals("./imgResources/8.jpg", rdi.getImageUrl(1).get(1));
		Assert.assertEquals(null, rdi.getImageUrl(1).get(7));
		Assert.assertEquals("./imgResources/8.jpg", rdi.getImageUrl(1).get(8));
		Assert.assertEquals("./imgResources/9.jpg", rdi.getImageUrl(1).get(9));
		Assert.assertEquals("./imgResources/10.jpg", rdi.getImageUrl(1).get(10));
		Assert.assertEquals("./imgResources/11.jpg", rdi.getImageUrl(1).get(11));
		Assert.assertEquals("./imgResources/12.jpg", rdi.getImageUrl(1).get(12));
		
}
	@Test
	public void testSavePicUrl() throws IOException, DatabaseUnitException, SQLException{
		
		
		ResourcesDaoImpl rdi = new ResourcesDaoImpl();
		rdi.setSessionFactory(sessionFactory);
		String url = "./imgResources/test.jpg";
		rdi.savePicUrl(7,url);
		Assert.assertEquals(url, rdi.getImageUrl(1).get(7));
		
	
	}

	@After
	public void tearDown() throws DatabaseUnitException, SQLException, IOException{
		resumeTable();
	}

}
