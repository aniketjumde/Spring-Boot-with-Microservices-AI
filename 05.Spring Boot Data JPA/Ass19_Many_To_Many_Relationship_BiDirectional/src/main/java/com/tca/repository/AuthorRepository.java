package com.tca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tca.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
