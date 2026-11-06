package com.tca.service;

import com.tca.exception.BookAlreadyExitsException;
import com.tca.model.Book;
import com.tca.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service( "bookService")
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book save(Book book) {

        if(bookRepository.existsById(book.getId()))
        {
            throw new BookAlreadyExitsException("Book already exists"+book.getId());
        }
        else{
            return bookRepository.save(book);
        }
    }

    @Override
    public Book getById(Integer id) {

        if(bookRepository.existsById(id))
        {
            return bookRepository.findById(id).get();
        }
        else{
            throw new BookAlreadyExitsException("Book not found"+id);
        }
    }

    @Override
    public void deleteById(Integer id) {

        if(bookRepository.existsById(id))
        {
            bookRepository.deleteById(id);
        }
        else{
            throw new BookAlreadyExitsException("Book not found"+id);
        }
    }

    @Override
    public List<Book> getAllBooks() {

        if(bookRepository.findAll().isEmpty())
         {
             throw new BookAlreadyExitsException("No books found");
         }
         else{
             return bookRepository.findAll();
         }
    }
}
