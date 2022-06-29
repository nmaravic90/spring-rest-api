package com.nikola.rest.api.student;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, name="first_name")
	private String name;
	
	@Column(nullable = false, name="last_name")
	private String lastName;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private LocalDate dob;
	
	@Transient
	private Integer age;
	
	public Student() {}
	
	public Student(String name, String lastName, String email, LocalDate dob) {
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.dob = dob;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	public Integer getAge() {
		return Period.between(this.dob, LocalDate.now()).getYears();
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", lastName=" + lastName + ", email=" + email + ", dob=" + dob
				+ ", age=" + age + "]";
	}
	
}
