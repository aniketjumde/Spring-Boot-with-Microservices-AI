package com.tca.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.tca.entity.Author;
import com.tca.entity.Book;
import com.tca.service.BookService;

import jakarta.transaction.Transactional;

@Component
public class MyRunners implements ApplicationRunner {

	@Autowired
	private BookService bookService;
	
	@Transactional
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
/*
 * 			
 	TEST CASE : Saved Book and Author

		
		Book book=new Book();
		book.setBid(1L);
		book.setBookName("CProgramming");
		
		Author a1=new Author();
		a1.setAid(101L);
		a1.setAuthorName("Pradeep");
		
		Author a2=new Author();
		a2.setAid(102L);
		a2.setAuthorName("Kaushal");
		
		List<Author> authors = Arrays.asList(a1,a2);
		
		book.setAuthors(authors);
	
		book = bookService.saveBook(book);
		System.out.println("Book & Authors saved !!");
		
*/
		

/*		
	//TEST CASE : FETCHED BOOK  BY AUTHORS	
		
		Book b = bookService.fetchById(1L);
		
		System.out.println("Book ID   :" +  b.getBid());
		System.out.println("Book Name :" +  b.getBookName());
		System.out.println("====================================================");
		
		List<Author> authors = b.getAuthors();
		
		for(Author a : authors)
		{
			System.out.println("AUTHOR ID   :" +  a.getAid());
			System.out.println("AUTHOR Name :" +  a.getAuthorName());
			System.out.println("-------------------------------------------------");
		}
*/
	
		
		bookService.removeBook(1L);
		System.out.println("Book Removed !!");
	}

}
