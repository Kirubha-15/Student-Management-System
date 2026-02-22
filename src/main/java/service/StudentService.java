package com.example.student.service;

import com.example.student.model.Student;
import java.util.List;

public interface StudentService {

    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(Long id);   // THIS ONE

    Student updateStudent(Long id, Student student);

    void deleteStudent(Long id);

    List<Student> searchStudents(String keyword);
}