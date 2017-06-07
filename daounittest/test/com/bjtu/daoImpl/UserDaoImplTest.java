package com.bjtu.daoImpl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.dbunit.DatabaseUnitException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Assert;
import java.io.IOException;
import java.sql.SQLException;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bjtu.entity.NannyUserAuthInfo;
import com.bjtu.entity.UserBaseInfo;
import com.bjtu.util.AbstractDbUnitTestCase;


@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"file:src/beans.xml"})  

public class UserDaoImplTest  extends AbstractDbUnitTestCase{
	
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
		bakcupOneTable("nannyuser");
	}

	
	@Test
	public void testAddUserBaseInfo() {
		UserDaoImpl udi = new UserDaoImpl();
		UserBaseInfo ubi = new UserBaseInfo();
		ubi.setId_card("12306");
		ubi.setAddress("日本省");
		ubi.setCity("大阪市");
		ubi.setName("胡天毅");
		ubi.setPhoneNumber("18877765432");
		ubi.setUser_id(200);
		udi.addUserBaseInfo(ubi);
		Assert.assertEquals(200,udi.getIdByUsername("胡天毅"));
		
	}
	@Test
	public void testGetIdByUsername() {
		UserDaoImpl udi = new UserDaoImpl();
		Assert.assertEquals(0,udi.getIdByUsername("韩天放"));
	}
	

	@Test
	public void testNannyUserAuthInfo() {
		UserDaoImpl udi = new UserDaoImpl();
		NannyUserAuthInfo nuai = new NannyUserAuthInfo();
		nuai.setUser_id(200);
		nuai.setChild_is_local("是");
		nuai.setEducation("中专");
		nuai.setExperience(null);
		nuai.setFaith("无");
		nuai.setIntroduction(null);
		nuai.setIs_home("是");
	    udi.nannyUserAuthInfo(nuai);
		Assert.assertEquals(nuai,udi.getNannyInfoById(200));
	}
	
	/*
	@Test
	public void testGetAllUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsExists() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void testRegister() {
		fail("Not yet implemented");
	}

	

	


	@Test
	public void testEmployerUserAuthInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetIdentity() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEmployerInfoById() {
		fail("Not yet implemented");
	}

	

	@Test
	public void testGetNannyUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserBaseInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddSkillDescribe() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllLabel() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllEmployerLabel() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSkillLabelJson() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEmployerLabelJson() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddEmployerSkill() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddOrderInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOrderInfo() {
		fail("Not yet implemented");
	}
	*/
	
	@After
	public void tearDown() throws DatabaseUnitException, SQLException, IOException{
		resumeTable();
	}

}
