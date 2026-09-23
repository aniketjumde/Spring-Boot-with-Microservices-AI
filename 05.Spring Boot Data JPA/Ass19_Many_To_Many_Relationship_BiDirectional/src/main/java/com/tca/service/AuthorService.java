package com.tca.service;

import com.tca.entity.Author;

public interface AuthorService {

	public Author saveAuthor(Author author);
	public Author fetchById(Long aid);
}
