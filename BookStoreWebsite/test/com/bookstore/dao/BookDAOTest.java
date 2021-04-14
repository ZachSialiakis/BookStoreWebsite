package com.bookstore.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

public class BookDAOTest {
	private static BookDAO bookDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bookDao = new BookDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		bookDao.close();
	}

	@Test
	public void testUpdateBook() throws ParseException, IOException {
		Book existBook = new Book();

		Category category = new Category("Java Core");
		category.setCategoryId(1);
		existBook.setCategory(category);

		existBook.setTitle("Effective Java (3nd edition)");
		existBook.setAuthor("Joshua Bloch");
		existBook.setDescription("New coverage of generics, enums, annotations, autoboxing");
		existBook.setPrice(40f);
		existBook.setIsbn("03211356683");

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		Date publishDate = dateFormat.parse("05/28/2008");
		existBook.setPublishDate(publishDate);

		String imagePath = "C:\\Users\\sialiakis\\Desktop\\books for site\\books\\Effective JAVA.JPG";

		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));

		existBook.setImage(imageBytes);

		Book updatedBook = bookDao.create(existBook);

		assertEquals(updatedBook.getTitle(), "Effective Java (3rd Edition)");
	}

	@Test
	public void testCreateBook() throws ParseException, IOException {
		Book newBook = new Book();

		Category category = new Category("HORROR");
		category.setCategoryId(2);
		newBook.setCategory(category);

		newBook.setTitle("The Carrow Haunt");
		newBook.setAuthor("Darcy Coates");
		newBook.setDescription("Remy is a tour guide for Carrow House, a notoriously haunted building. When she's asked to host seven guests for a week-long stay to research Carrow's phenomena, she hopes to finally experience some of the sightings that made the house famous.");
		newBook.setPrice(33.57f);
		newBook.setIsbn("126895678A");

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		Date publishDate = dateFormat.parse("05/28/2008");
		newBook.setPublishDate(publishDate);

		String imagePath = "C:\\Users\\sialiakis\\Desktop\\books for site\\books\\Effective JAVA.JPG";

		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));

		newBook.setImage(imageBytes);

		Book createdBook = bookDao.create(newBook);

		assertTrue(createdBook.getBookId() > 0);
	}

	@Test
	public void testCreate2ndBook() throws ParseException, IOException {
		Book newBook = new Book();

		Category category = new Category("Java Core");
		category.setCategoryId(1);
		newBook.setCategory(category);

		newBook.setTitle("Java 8 in Action");
		newBook.setAuthor("Dillon Danis");
		newBook.setDescription("Java 8 in Action is a clearly written guide to the new feaurures of Java 8");
		newBook.setPrice(36.72f);
		newBook.setIsbn("1617291994");

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		Date publishDate = dateFormat.parse("05/28/2014");
		newBook.setPublishDate(publishDate);

		String imagePath = "C:\\Users\\sialiakis\\Desktop\\books for site\\books\\Java 8 in Action.JPG";

		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));

		newBook.setImage(imageBytes);

		Book createdBook = bookDao.create(newBook);

		assertTrue(createdBook.getBookId() > 0);
	}

	@Test(expected = EntityNotFoundException.class)
	public void testDeleteBookFail() {
		Integer bookId = 100;
		bookDao.delete(bookId);

	}

	@Test(expected = EntityNotFoundException.class)
	public void testGetBookFail() {
		Integer bookId = 99;
		Book book = bookDao.get(bookId);
		assertNull(book);

	}

	@Test
	public void testGetBookSuccess() {
		Integer bookId = 2;
		Book book = bookDao.get(bookId);
		assertNotNull(book);

	}

	@Test
	public void testListAll() {
		List<Book> listBooks = bookDao.listAll();

		for (Book aBook : listBooks) {
			System.out.println(aBook.getTitle() + "-" + aBook.getAuthor());

		}

		assertFalse(listBooks.isEmpty());

	}

	@Test
	public void testFindByTitleNotExist() {
		String title = "Thinking in Java";
		Book book = bookDao.findByTitle(title);

		assertNull(book);

	}

	@Test
	public void testFindByTitleExist() {
		String title = "Java 8 in Action";
		Book book = bookDao.findByTitle(title);

		System.out.println(book.getTitle());
		System.out.println(book.getAuthor());
		assertNotNull(book);

	}
	
	@Test
	public void testCount() {
		long totalBooks = bookDao.count();
		
		assertEquals(2, totalBooks);
		
	}

	@Test
	public void testDeleteBookSuccess() {
		Integer bookId = 1;
		bookDao.delete(bookId);

		assertTrue(true);

	}
	
	@Test
	public void testListNewBooks() {
		List<Book> listNewBooks = bookDao.listNewBooks();
		for(Book aBook : listNewBooks) {
			System.out.println(aBook.getTitle() + " - " + aBook.getPublishDate());
			
		}
		assertEquals(4, listNewBooks.size());
		
		
	}
	
	@Test
	public void testListByCategory() {
		int categoryId = 1;
		
		List<Book> listBooks = bookDao.listByCategory(categoryId);
		
		assertTrue(listBooks.size() > 0);
	}
	}


