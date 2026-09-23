package com.tca.service;

import com.tca.entity.Book;

public interface BookService {

	public Book saveBook(Book book);
	public Book fetchById(Long bid);
	public void removeBook(Long bid);
}
