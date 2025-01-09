package com.StudentAPI.Controller;

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

import com.StudentAPI.Model.Student;
import com.StudentAPI.Service.IStudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	  @Autowired
	    private IStudentService studentService;

	    // Get all students
	    @GetMapping
	    public List<Student> getAllStudents() {
	        return studentService.getAllStudents();
	    }

	    // Get a student by RollNo
	    @GetMapping("/{rollNo}")
	    public ResponseEntity<Student> getStudentByRollNo(@PathVariable int rollNo) {
	        Student student = studentService.getStudentByRollNo(rollNo);
	        if (student != null) {
	            return ResponseEntity.ok(student);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Add a new student
	    @PostMapping
	    public ResponseEntity<String> addStudent(@RequestBody Student student) {
	        studentService.addStudent(student.getRollNo(), student.getName(), student.getAddress(), student.getPhone_No());
	        return ResponseEntity.ok("Student added successfully");
	    }

	    // Update an existing student
	    @PutMapping("/{rollNo}")
	    public ResponseEntity<String> updateStudent(@PathVariable int rollNo, @RequestBody Student student) {
	        Student existingStudent = studentService.getStudentByRollNo(rollNo);
	        if (existingStudent != null) {
	            studentService.updateStudent(rollNo, student.getName(), student.getAddress(), student.getPhone_No());
	            return ResponseEntity.ok("Student updated successfully");
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Delete a student by RollNo
	    @DeleteMapping("/{rollNo}")
	    public ResponseEntity<String> deleteStudent(@PathVariable int rollNo) {
	        Student student = studentService.getStudentByRollNo(rollNo);
	        if (student != null) {
	            studentService.deleteStudent(rollNo);
	            return ResponseEntity.ok("Student deleted successfully");
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

}
