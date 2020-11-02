/**
 * 
 */
package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Teacher;
import com.example.demo.model.User;
import com.example.demo.repository.TeacherRepository;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


/**
 * @author goldsoft25
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;
    
    @Autowired
    private UserRepository userRepository;
  
    /**
     * Get all teachers list.
     *
     * @return the list
     */
    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers() {
      //return teacherRepository.findAll();
    	 List<Teacher> teacherList = teacherRepository.findAll();
    	
    	/*for(Object teacher: teacherList) {
    	    System.out.print(teacher);
    	    //User user = userRepository.findById(teacher.userId);
    	    
    	}*/
    	 //teacherList.forEach(teacher->System.out.println(teacher.getUserId()));
    	 //teacherList.forEach(teacher->System.out.println(userRepository.findById(teacher.getUserId())));
    	  teacherList.forEach(teacher->{
    		  long userId = teacher.getUserId();
    		  System.out.println("UserId for" + userId);
    		  Optional<User> existingUser = userRepository.findById(userId);
    		  System.out.print(existingUser);
    	  });
    	
    	return teacherList;
    }
  
    /**
     * Gets teachers by id.
     *
     * @param teacherId the teacher id
     * @return the teachers by id
     * @throws ResourceNotFoundException the resource not found exception
     */
    @GetMapping("/teachers/{id}")
    public ResponseEntity<Teacher> getTeachersById(@PathVariable(value = "id") Long teacherId)
        throws ResourceNotFoundException {
      Teacher teacher =
          teacherRepository
              .findById(teacherId)
              .orElseThrow(() -> new ResourceNotFoundException("Teacher not found on :: " + teacherId));
      return ResponseEntity.ok().body(teacher);
    }
  
    /**
     * Create teacher teacher.
     *
     * @param teacher the teacher
     * @return the teacher
     */
    @PostMapping("/teachers")
    /*public Teacher createTeacher(@Valid @RequestBody Teacher teacher) {
      return teacherRepository.save(teacher);
    }*/
    public ResponseEntity<Object> createTeacher(@Valid @RequestBody Teacher teacher) throws Exception{
    
    	//DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    	//Date joinDate = df.parse(teacher.getJoinDate().toString());
    	//teacher.setJoinDate(joinDate);
    	teacherRepository.save(teacher);
    	return new ResponseEntity<>("Teacher created successful", HttpStatus.CREATED);
    }
  
    /**
     * Update teacher response entity.
     *
     * @param teacherId the teacher id
     * @param teacherDetails the teacher details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PutMapping("/teachers/{id}")
    public ResponseEntity<Teacher> updateTeacher(
        @PathVariable(value = "id") Long teacherId, @Valid @RequestBody Teacher teacherDetails)
        throws ResourceNotFoundException {
  
      Teacher teacher =
          teacherRepository
              .findById(teacherId)
              .orElseThrow(() -> new ResourceNotFoundException("Teacher not found on :: " + teacherId));
  
      //teacher.setJoinDate(teacherDetails.getJoinDate());
      teacher.setContact(teacherDetails.getContact());
      teacher.setAddress(teacherDetails.getAddress());
      teacher.setUpdatedAt(new Date());
      final Teacher updatedTeacher = teacherRepository.save(teacher);
      return ResponseEntity.ok(updatedTeacher);
    }
  
    /**
     * Delete teacher map.
     *
     * @param teacherId the teacher id
     * @return the map
     * @throws Exception the exception
     */
    @DeleteMapping("/teachers/{id}")
    public Map<String, Boolean> deleteTeacher(@PathVariable(value = "id") Long teacherId) throws Exception {
      Teacher teacher =
          teacherRepository
              .findById(teacherId)
              .orElseThrow(() -> new ResourceNotFoundException("Teacher not found on :: " + teacherId));
  
      teacherRepository.delete(teacher);
      Map<String, Boolean> response = new HashMap<>();
      response.put("deleted", Boolean.TRUE);
      return response;
    }


}
