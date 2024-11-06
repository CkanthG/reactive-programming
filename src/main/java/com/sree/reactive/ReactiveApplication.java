package com.sree.reactive;

import com.sree.reactive.entity.Student;
import com.sree.reactive.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentService service) {
		return args -> {
			for (int i = 0; i < 100; i++) {
				service.save(
					Student.builder()
							.firstName("Sree " + i)
							.lastName("Kanth " + i)
							.age(i)
							.build()
				).subscribe();
			}
		};
	}

}
