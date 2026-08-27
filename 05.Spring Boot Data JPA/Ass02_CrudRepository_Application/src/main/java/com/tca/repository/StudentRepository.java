package com.tca.repository;

import org.springframework.data.repository.CrudRepository;

import com.tca.entity.Student;

public interface StudentRepository extends CrudRepository<Student,Integer> {

}
