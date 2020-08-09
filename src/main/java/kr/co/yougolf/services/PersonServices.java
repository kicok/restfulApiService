package kr.co.yougolf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.yougolf.data.model.Person;
import kr.co.yougolf.exception.ResourceNotFoundException;
import kr.co.yougolf.repository.PersonRepository;
 
@Service
public class PersonServices {
	
	@Autowired
	PersonRepository repository;
	
	public Person create(Person person) {
		return repository.save(person);
	}
	
	public List<Person> findAll(){
		return repository.findAll();
	}
	
	public Person findById(Long id) {
		
		return repository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("No records found for this Id"));
	}	
	
	public Person update(Person person) {
		Person entity = findById(person.getId());				
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		return entity;
	}
	
	public void delete(Long id) {
		Person entity = findById(id);
		repository.delete(entity);
	}

	
}
