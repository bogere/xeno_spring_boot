/**
 * 
 */
package com.example.demo.repository;

import com.example.demo.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author goldsoft25
 *
 */
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>  {
	
	

}
