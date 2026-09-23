package com.tca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tca.entity.Author;
import com.tca.repository.AuthorRepository;

@Service("AuthorService")
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public Author saveAuthor(Author author) {
		return authorRepository.save(author);
	}

	@Override
	public Author fetchById(Long aid) {
		return authorRepository.findById(aid).get();
	}
	
}
