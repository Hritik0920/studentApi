package com.StudentAPI.Repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.StudentAPI.Model.Student;

@Repository
public interface IStudentRepositroy extends JpaRepository<Student, Integer>{

	

}
