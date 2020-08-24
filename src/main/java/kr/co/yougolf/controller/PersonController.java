package kr.co.yougolf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.yougolf.data.vo.PersonVO;
import kr.co.yougolf.data.vo.v2.PersonVOV2;
import kr.co.yougolf.services.PersonServices;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {
	
	@Autowired
	private PersonServices services;
	
	@GetMapping(produces = {"application/json", "application/xml"})
	public List<PersonVO> findAll(){
		
		return services.findAll();		
	}	
	
	@GetMapping(value = "/{id}", produces = {"application/json", "application/xml"})
	public PersonVO findById(@PathVariable("id") Long id){
		
		return services.findById(id);		
	}

	@PostMapping(produces = {"application/json", "application/xml"},
				consumes = {"application/json", "application/xml"})
	public PersonVO create(@RequestBody PersonVO PersonVO){
		
		return services.create(PersonVO);		
	}
	
	@PostMapping(value="/v2", produces = {"application/json", "application/xml"},
			consumes = {"application/json", "application/xml"})
	public PersonVOV2 create2(@RequestBody PersonVOV2 PersonVO){
		
		return services.createV2(PersonVO);		
	}
	
	
	@PutMapping(produces = {"application/json", "application/xml"},
			consumes = {"application/json", "application/xml"})
	public PersonVO update(@RequestBody PersonVO PersonVO){
		
		return services.update(PersonVO);		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		
		services.delete(id);	
		
		return ResponseEntity.ok().build();
	}	
	
	
	
	
}
  