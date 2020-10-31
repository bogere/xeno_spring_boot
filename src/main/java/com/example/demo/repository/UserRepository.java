package com.example.demo.repository;

import com.example.demo.model.User;

import java.util.List;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * The interface User repository.
 * @author  goldsoft25
 * Repository class for <code>Owner</code> domain objects All method names are compliant
 * with Spring Data naming conventions so this interface can easily be extended for Spring
 * Data. See:
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation
 * Thanks - @author Ken Krebs
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	//String findByUsername(String username);
	//@Transactional(readOnly = true)
	//@Collection <User> findByUserName();
	User findByUsername(String username);
	
	User  findByEmail(String email);
}
