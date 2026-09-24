package com.tca.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.tca.entity.Passport;
import com.tca.entity.Person;
import com.tca.service.PersonService;

import jakarta.transaction.Transactional;

@Component
public class MyRunners implements ApplicationRunner {

	
	@Autowired
	private PersonService personService;
	
	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception {

		
	/*	//TEST CASE : Save Person And Passport
		
		Passport passport=new Passport(2222222L,LocalDate.of(2030, 2, 2));
		Person person=new Person();
		person.setPersonName("Suyash");
		person.setDateOfBirth(LocalDate.of(2005, 9, 19));
		person.setPassport(passport);

		personService.savePerson(person);
	*/
		
		

/*		//TEST CASE : Fetch Person Passport
		
		Person person=personService.fetchById(1L);
		
		System.out.println("Person Id :"+person.getPid());
		System.out.println("Person Name :"+person.getPersonName());
		System.out.println("Person BirthDate :"+person.getDateOfBirth());
		System.out.println("--------------------------------------------");
		
		Passport passport=person.getPassport();
		System.out.println("Passport Id :"+passport.getPassportId());
		System.out.println("Passport expiry Date :"+passport.getExpiryDate());
*/
		
		//TEST CASE : Remove Person way passport
		personService.removeById(2L);
		System.out.println("Person and Passport Details Remove Successfully !!!");

		
	}

}
