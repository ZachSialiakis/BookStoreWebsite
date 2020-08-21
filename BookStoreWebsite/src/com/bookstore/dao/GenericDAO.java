package com.bookstore.dao;

import java.util.List;

import com.bookstore.entity.Book;

public interface GenericDAO<E> {

	public E create(E t);

	public E update(E t);

	public E get(Object id);

	public void delete(Object id);

	public List listAll();

	public long count();

	Book findByTitle(String title);

}
