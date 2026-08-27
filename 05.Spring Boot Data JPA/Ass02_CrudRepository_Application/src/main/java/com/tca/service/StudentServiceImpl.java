package com.tca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tca.entity.Student;
import com.tca.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService 
{
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) 
	{
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Optional<Student> findById(int rno) 
	{
		return studentRepository.findById(rno);
	}

	@Override
	public List<Student> findAllById(List<Integer> ids) {
		// TODO Auto-generated method stub
		return (List<Student>) studentRepository.findAllById(ids);
	}

	@Override
	public List<Student> fetchAllStudent() {
		return (List<Student>) studentRepository.findAll();
	}

	@Override
	public Boolean deleteStudent(int rno) 
	{
		if (studentRepository.existsById(rno))
		{
			studentRepository.deleteById(rno);
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public List<Student> saveAll(List<Student> listStudent) {
		return (List<Student>) studentRepository.saveAll(listStudent);
	}

}
