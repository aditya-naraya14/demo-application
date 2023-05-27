package com.ecom.demoApplication.DTO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.demoApplication.entity.Student;
import com.ecom.demoApplication.exceptionhandler.StudentNotFoundException;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
	
	private List<Student> studentList;

	@PostConstruct
	public void loadData()
	{
		this.studentList = new ArrayList<>();
		studentList.add(new Student("John", "Wick", 42));
		studentList.add(new Student("Stephn", "Flem", 21));
		studentList.add(new Student("John", "Mac", 34));
	}
	
	@GetMapping("/students")
	public List<Student> getStudent()
	{
		return studentList;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudentForId(@PathVariable int studentId)
	{
		if((this.studentList.size() < studentId) || (studentId < 0))
			throw new StudentNotFoundException("Student not found for - " + studentId);
			
		return this.studentList.get(studentId);
	}
}
