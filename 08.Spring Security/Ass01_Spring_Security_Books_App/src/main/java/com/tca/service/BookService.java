package com.tca.service;

import com.tca.model.Book;

import java.util.List;

public interface BookService {

    public Book save(Book book);
    public Book getById(Integer id);
    public void deleteById(Integer id);
    public List<Book> getAllBooks();
}
