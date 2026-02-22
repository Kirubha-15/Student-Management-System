package com.example.student.controller;

import com.example.student.model.Student;
import com.example.student.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // CREATE
    @PostMapping
    public Student addStudent(@Valid @RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // READ ALL
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id,
                                 @Valid @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    // SEARCH


    @GetMapping("/search")
    public List<Student> searchStudents(@RequestParam String keyword) {
        return studentService.searchStudents(keyword);
    }
}