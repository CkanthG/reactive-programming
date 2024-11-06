package com.sree.reactive.controller;

import com.sree.reactive.entity.Student;
import com.sree.reactive.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @PostMapping("/save")
    public Mono<Student> save(@RequestBody Student student) {
        return service.save(student);
    }

    @GetMapping
    public Flux<Student> getAll() {
        return service.findAllStudents();
    }

    @GetMapping("/{studentId}")
    public Mono<Student> findById(@PathVariable Integer studentId) {
        return service.findStudentById(studentId);
    }
}
