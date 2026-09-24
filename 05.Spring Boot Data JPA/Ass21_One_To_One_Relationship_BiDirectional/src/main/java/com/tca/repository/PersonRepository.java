package com.tca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tca.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
