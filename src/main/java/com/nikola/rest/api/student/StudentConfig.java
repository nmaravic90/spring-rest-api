package com.nikola.rest.api.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
	
	@Bean
	CommandLineRunner commandLineRunner (StudentRepository studentRepository) {
		return args -> {
			
			Student nikola = new Student("Nikola", "Maravic", "email@nikola.com",
					LocalDate.of(1990, Month.SEPTEMBER, 25));
			
			Student ana = new Student("Ana", "Petrovic", "ana@email.com",
					LocalDate.of(1988, Month.AUGUST, 4));
			
			Student petar = new Student("Petar", "Ilic", "pera@ilic.com",
					LocalDate.of(1995, Month.JANUARY, 12));
			
			Student milos = new Student("Milos", "Miljkovic", "milos@miljkovic.com",
					LocalDate.of(1998, Month.JULY, 8));
			
			studentRepository.saveAll(List.of(nikola, ana, petar, milos));
			
		};
		
	}

}
