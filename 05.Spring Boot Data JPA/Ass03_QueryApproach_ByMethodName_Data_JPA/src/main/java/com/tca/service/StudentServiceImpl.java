package com.tca.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tca.entity.Student;
import com.tca.enums.Gender;
import com.tca.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Optional<Student> findById(int rno) {
		return studentRepository.findById(rno);
	}

	@Override
	public List<Student> fetchAllStudent() {
		return (List<Student>) studentRepository.findAll();
	}

	@Override
	public List<Student> fetchByGender(Gender gender) {
		return studentRepository.findByGender(gender);
	}

	@Override
	public List<Student> fetchByName(String name) {

		return studentRepository.findByName(name);
	}

	@Override
	public List<Student> fetchByPer(Double per) {
		return studentRepository.findByPer(per);
	}

	@Override
	public List<Student> fetchByBirthDate(LocalDate d) {
		return studentRepository.findByBirthDate(d);
	}

	@Override
	public List<Student> fetchByGenderAndName(Gender gender, String name) {
		return studentRepository.findByGenderAndName(gender, name);
	}

	@Override
	public List<Student> fetchByNameOrPer(String name, Double per) {
		return studentRepository.findByNameOrPer(name, per);
	}

	@Override
	public List<Student> fetchByPerLessThan(Double per) {
		return studentRepository.findByPerLessThan(per);
	}

	@Override
	public List<Student> fetchByPerGreaterThanEqual(Double per) {
		return studentRepository.findByPerGreaterThanEqual(per);
	}

	@Override
	public List<Student> fetchByPerBetween(Double startPer, Double endPer) {
		return studentRepository.findByPerBetween(startPer, endPer);
	}

	@Override
	public List<Student> fetchByNameLike(String name) {
		return studentRepository.findByNameLike(name);
	}

	@Override
	public List<Student> fetchByNameContaining(String name) {
		return studentRepository.findByNameContaining(name);
	}

	@Override
	public List<Student> fetchByNameStartWith(String name) {
		return studentRepository.findByNameStartsWith(name);
	}

	@Override
	public List<Student> fetchByNameEndWith(String name) {
		return studentRepository.findByNameEndsWith(name);
	}

	@Override
	public List<Student> fetchByNameIgnoreCase(String name) {
		return studentRepository.findByNameIgnoreCase(name);
	}
	
	

}
