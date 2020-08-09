package kr.co.yougolf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.yougolf.data.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
	

}
