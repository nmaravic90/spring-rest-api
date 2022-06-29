package com.nikola.rest.api.student;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/student")
public class StudentController {
	
	//	@Autowired
	public final StudentService service;
	
	public StudentController(StudentService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Student> getStudents() {
		return service.getStudents();
	}
	
	@PostMapping
	public void addNewStrudent(@RequestBody Student student) {
		service.addNewStudent(student);
	}
	
	@DeleteMapping(path = "{studentId}")
	public void deleteStudent(@PathVariable("studentId") Long studentId) {
		service.deleteStudent(studentId);
	}
	
	@PutMapping(path = "{studentId}")
	public void updateStudent(@PathVariable("studentId") Long studentId, @RequestParam(required = false) String name,
			@RequestParam(required = false) String email) {
		service.updateStudent(studentId, name, email);
	}

}
