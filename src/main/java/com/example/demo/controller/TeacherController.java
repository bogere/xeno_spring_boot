/**
 * 
 */
package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Teacher;
import com.example.demo.repository.TeacherRepository;
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
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;
  
    /**
     * Get all teachers list.
     *
     * @return the list
     */
    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers() {
      return teacherRepository.findAll();
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
    public Teacher createTeacher(@Valid @RequestBody Teacher teacher) {
      return teacherRepository.save(teacher);
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
  
      teacher.setJoinDate(teacherDetails.getJoinDate());
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
