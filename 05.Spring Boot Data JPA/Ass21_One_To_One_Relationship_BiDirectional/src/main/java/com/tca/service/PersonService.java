package com.tca.service;

import com.tca.entity.Person;

public interface PersonService {

	public Person savePerson(Person person);
	public Person fetchById(Long pid);
	public void removeById(Long pid);
}
