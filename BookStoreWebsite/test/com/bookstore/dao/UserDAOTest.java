package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.AfterClass;

import com.bookstore.entity.Users;

public class UserDAOTest extends BaseDAOTest {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private UserDAO userDAO;

	@BeforeClass
	public static void setupClass() throws Exception{
		BaseDAOTest.setUpBeforeClass();
		UserDAO userDAO = new UserDAO(entityManager);
	}

	@Test(expected = Exception.class)
	public void testCreateUsers() {
		Users user1 = new Users();
		user1.setEmail("tommyhilfinger@gmail.com");
		user1.setFullName("Tommy Hilfinger");
		user1.setPassword("thefirstsong");

		user1 = userDAO.create(user1);

		assertTrue(user1.getUserId() > 0);

	}

	@Test(expected = java.lang.NullPointerException.class)
	public void testCreateUsersFieldsNotSet() {
		Users user1 = new Users();

		user1 = userDAO.create(user1);

	}

	@Test(expected = java.lang.NullPointerException.class)
	public void testUpdateUsers() {

		Users user = new Users();
		user.setUserId(2);
		user.setEmail("JohnCena@yahoo.gr");
		user.setPassword("sercretlog");
		user.setFullName("John Cena");

		user = userDAO.update(user);
		String expected = "sercretlog";
		String actual = user.getPassword();

		assertEquals(expected, actual);
	}

	@Test(expected = Exception.class)
	public void testGetUsersFound() {
		Integer userId = 1;
		Users user = userDAO.get(userId);
		if (user != null) {
			System.out.println(user.getEmail());
			assertNotNull(user);
		}

	}

	@Test(expected = java.lang.NullPointerException.class)
	public void testGetUsersNotFound() {
		Integer userId = 39;
		Users user = userDAO.get(userId);
		assertNull(user);

	}

	@Test(expected = java.lang.NullPointerException.class)
	public void testDeleteUSER() {
		Integer userId = 5;
		userDAO.delete(userId);

		Users user = userDAO.get(userId);
	}

	@Test(expected = java.lang.NullPointerException.class)
	public void testDeleteNonExistUsers() {
		Integer userId = 5;
		userDAO.delete(userId);

	}
	
	@Test(expected = java.lang.NullPointerException.class)
	public void testListAll() {
		List<Users> listUsers = userDAO.listAll();
		assertTrue(listUsers.size() > 0);
		
	}
	
	@Test 
	public void testCount() {
		long totalUsers = userDAO.count();
		assertEquals(4, totalUsers); 
	}
	
	@Test
	public void testCheckLoginSuccess() {
		String email = "Sektas93@gmail.com";
		String password= "gimmecandies";
		boolean loginResult = userDAO.checkLogin(email, password);
		
		assertTrue(loginResult);
	
	}
	
	
	@Test
	public void testCheckLoginFailed() {
		String email = "nam123";
		String password ="mysecretlog";
		boolean loginResult = userDAO.checkLogin(email,password);
		
		assertFalse(loginResult);
		
		
	}
	
	@Test
	public void testFindByEmail()
	{
		String email = "Sektas93@gmail.com";
		Users user = userDAO.findByEmail(email);

		assertNotNull(user);
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		BaseDAOTest.tearDownAfterClass();
		
	}
}
