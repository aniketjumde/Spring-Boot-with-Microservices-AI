package com.tca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tca.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
