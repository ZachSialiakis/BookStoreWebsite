package com.bookstore.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

public class BookDAO extends JpaDAO<Book> implements GenericDAO<Book> {

	public BookDAO(EntityManager entityManager) {
		super(entityManager);
		
	}
	@Override
	public Book create(Book book) {
		book.setLastUpdateTime(new Date(0, 0, 0));
		return super.create(book);
	}
	
	@Override
	public Book update(Book book) {
		book.setLastUpdateTime(new Date(0, 0, 0));
		return super.update(book);
		
	}
	
	@Override
	public void delete(Object bookId ) {
		super.delete(Book.class, bookId);
	
	}

	@Override
	public Book get(Object bookId) {
		return super.find(Book.class, bookId);
	}


	@Override
	public List<Book> listAll() {
		
		return super.findWidthNamedQuery("Book.findAll");
	}
	
	
	public Book findByTitle(String title) {
		List<Book> result = super.findWidthNamedQuery("Book.findByTitle", "title", title);
		
		if (!result.isEmpty()) {
			return result.get(0);
			
		}
			
		return null;
	}
	
	public List<Book> listByCategory(int categoryId){
		
		return super.findWidthNamedQuery("Book.findByCategory","catId", categoryId);
		
		
	}
	
	public List<Book> listNewBooks() {
	Query query = entityManager.createNamedQuery("Book.listNew");
	query.setFirstResult(0);
	query.setMaxResults(4);
	
	return query.getResultList();
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Book.countAll");
	}

		
}
