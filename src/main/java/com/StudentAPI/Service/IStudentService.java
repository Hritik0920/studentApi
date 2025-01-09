package com.StudentAPI.Service;

import java.util.List;

import com.StudentAPI.Model.Student;

public interface IStudentService {
	
	 // Method to add a new student
    void addStudent(int rollNo, String name, String address, String phoneNo);

    // Method to retrieve student details by RollNo
    Student getStudentByRollNo(int rollNo);

    // Method to update student information
    void updateStudent(int rollNo, String name, String address, String phoneNo);

    // Method to delete a student by RollNo
    void deleteStudent(int rollNo);

    // Optional method to retrieve all students
    List<Student> getAllStudents();
}


