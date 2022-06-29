package com.nikola.rest.api.student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
	
	public final StudentRepository repo;
	
	public StudentService(StudentRepository repo) {
		this.repo = repo;
	}
	
	public List<Student> getStudents() {
		return repo.findAll();
	}

	public void addNewStudent(Student student) {
		Optional<Student> studentByEmail = repo.findByEmail(student.getEmail());
		if(studentByEmail.isPresent()) {
			throw new IllegalStateException("The Email is already taken!");
		}
		repo.save(student);
	}

	public void deleteStudent(Long studentId) {
		// Optional<Student> student = repo.findById(id);
		// if(student.isPresent()) {
		//	 repo.deleteById(id);
		// }
		if(!repo.existsById(studentId)){
			throw new IllegalStateException("Studnet with id: " + studentId + " already deleted!");
		}
		repo.deleteById(studentId);
	}

	@Transactional
	public void updateStudent(Long studentId, String name, String email) {

		Student student = repo.findById(studentId)
				.orElseThrow(() -> new IllegalStateException("Student with id: " + studentId + "doesn't exixst!"));

		if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
			student.setName(name);
		}

		if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {

			Optional<Student> studentByEmail = repo.findByEmail(email);
			if (studentByEmail.isPresent()) {
				throw new IllegalStateException("The Email is already taken!");
			}
			student.setEmail(email);
		}
	}
}
