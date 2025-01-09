package com.StudentAPI.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentAPI.Model.Student;
import com.StudentAPI.Repositroy.IStudentRepositroy;

@Service
public class StudentService implements IStudentService {
	

	
	@Autowired
    private IStudentRepositroy studentRepository;

	@Override
	public void addStudent(int rollNo, String name, String address, String phoneNo) {
		if (!studentRepository.existsById(rollNo)) {
            Student student = new Student();
            student.setRollNo(rollNo);
            student.setName(name);
            student.setAddress(address);
            student.setPhone_No(phoneNo);
            studentRepository.save(student);
        } else {
            System.out.println("Student with RollNo " + rollNo + " already exists.");
        }
	}

	@Override
	public Student getStudentByRollNo(int rollNo) {
		Optional<Student> student = studentRepository.findById(rollNo);
        return student.orElse(null);
	}

	@Override
	public void updateStudent(int rollNo, String name, String address, String phoneNo) {
		 if (studentRepository.existsById(rollNo)) {
	            Student student = studentRepository.findById(rollNo).orElse(null);
	            if (student != null) {
	                student.setName(name);
	                student.setAddress(address);
	                student.setPhone_No(phoneNo);
	                studentRepository.save(student);
	            }
	        } else {
	            System.out.println("Student with RollNo " + rollNo + " not found.");
	        }
	}

	@Override
	public void deleteStudent(int rollNo) {
		 if (studentRepository.existsById(rollNo)) {
	            studentRepository.deleteById(rollNo);
	        } else {
	            System.out.println("Student with RollNo " + rollNo + " not found.");
	        }
	}

	@Override
	public List<Student> getAllStudents() {
		 return studentRepository.findAll();
	}

	
}
