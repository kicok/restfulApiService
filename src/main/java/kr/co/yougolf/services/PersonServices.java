package kr.co.yougolf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.yougolf.converter.DozerConverter;
import kr.co.yougolf.data.model.Person;
import kr.co.yougolf.data.vo.PersonVO;
import kr.co.yougolf.exception.ResourceNotFoundException;
import kr.co.yougolf.repository.PersonRepository;
 
@Service
public class PersonServices {
	
	@Autowired
	PersonRepository repository;
	
	public PersonVO create(PersonVO personVo) {	
		Person entity = DozerConverter.parseObject(personVo, Person.class);
		PersonVO vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public List<PersonVO> findAll(){
		return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
	}
	
	public PersonVO findById(Long id) {
		
		 Person entity = repository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("No records found for this Id"));
		
		return DozerConverter.parseObject(entity, PersonVO.class);
	}	
	
	public PersonVO update(PersonVO personVo) {
		Person entity = repository.findById(personVo.getId())
				.orElseThrow(()->new ResourceNotFoundException("No records found for this Id"));			
		entity.setFirstName(personVo.getFirstName());
		entity.setLastName(personVo.getLastName());
		entity.setAddress(personVo.getAddress());
		entity.setGender(personVo.getGender());		
		
		PersonVO vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);		 
		return vo;	
	}
	
	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("No records found for this Id"));		
		repository.delete(entity);
	}

	
}
