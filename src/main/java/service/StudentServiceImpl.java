package com.example.student.service;

import com.example.student.model.Student;
import com.example.student.service.StudentService;
import com.example.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }
    @Override
    public Student getStudentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student existing = repository.findById(id).orElseThrow();
        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setCourse(student.getCourse());
        return repository.save(existing);
    }

    @Override
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

    // 🔍 SEARCH LOGIC
    @Override
    public List<Student> searchStudents(String keyword) {
        return repository
                .findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
                        keyword, keyword
                );
    }
}