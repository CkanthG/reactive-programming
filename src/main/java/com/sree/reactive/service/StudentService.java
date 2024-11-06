package com.sree.reactive.service;

import com.sree.reactive.entity.Student;
import com.sree.reactive.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Flux<Student> findAllStudents() {
        return studentRepository.findAll()
                .delayElements(Duration.ofMillis(1));
    }

    public Mono<Student> save(Student student) {
        return studentRepository.save(student);
    }

    public Mono<Student> findStudentById(Integer studentId) {
        return studentRepository.findById(studentId);
    }
}
