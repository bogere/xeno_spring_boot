/**
 * 
 */
package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author goldsoft25
 *
 */

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;
  
    /**
     * Get all students list.
     *
     * @return the list
     */
    @GetMapping("/students")
    public List<Student> getAllStudents() {
      return studentRepository.findAll();
    }
  
    /**
     * Gets students by id.
     *
     * @param studentId the student id
     * @return the students by id
     * @throws ResourceNotFoundException the resource not found exception
     */
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentsById(@PathVariable(value = "id") Long studentId)
        throws ResourceNotFoundException {
      Student student =
          studentRepository
              .findById(studentId)
              .orElseThrow(() -> new ResourceNotFoundException("Student not found on :: " + studentId));
      return ResponseEntity.ok().body(student);
    }
  
    /**
     * Create student student.
     *
     * @param student the student
     * @return the student
     */
    @PostMapping("/students")
    public Student createStudent(@Valid @RequestBody Student student) {
      return studentRepository.save(student);
    }
  
    /**
     * Update student response entity.
     *
     * @param studentId the student id
     * @param studentDetails the student details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(
        @PathVariable(value = "id") Long studentId, @Valid @RequestBody Student studentDetails)
        throws ResourceNotFoundException {
  
      Student student =
          studentRepository
              .findById(studentId)
              .orElseThrow(() -> new ResourceNotFoundException("Student not found on :: " + studentId));
  
      student.setGuardian(studentDetails.getGuardian());
      student.setGuardianContact(studentDetails.getGuardianContact());
      student.setStudentAddress(studentDetails.getStudentAddress());
      student.setUpdatedAt(new Date());
      final Student updatedStudent = studentRepository.save(student);
      return ResponseEntity.ok(updatedStudent);
    }
  
    /**
     * Delete student map.
     *
     * @param studentId the student id
     * @return the map
     * @throws Exception the exception
     */
    @DeleteMapping("/students/{id}")
    public Map<String, Boolean> deleteStudent(@PathVariable(value = "id") Long studentId) throws Exception {
      Student student =
          studentRepository
              .findById(studentId)
              .orElseThrow(() -> new ResourceNotFoundException("Student not found on :: " + studentId));
  
      studentRepository.delete(student);
      Map<String, Boolean> response = new HashMap<>();
      response.put("deleted", Boolean.TRUE);
      return response;
    }

}
