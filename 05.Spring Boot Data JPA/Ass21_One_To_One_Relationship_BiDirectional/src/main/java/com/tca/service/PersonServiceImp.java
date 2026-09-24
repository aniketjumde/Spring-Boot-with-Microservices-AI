package com.tca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tca.entity.Person;
import com.tca.repository.PersonRepository;

@Service("personService")
public class PersonServiceImp implements PersonService
{

	@Autowired
	private PersonRepository personRepository;

	@Override
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}

	@Override
	public Person fetchById(Long pid) {
		return personRepository.findById(pid).get();
	}

	@Override
	public void removeById(Long pid) {
		 personRepository.deleteById(pid);;
	}
	
}
