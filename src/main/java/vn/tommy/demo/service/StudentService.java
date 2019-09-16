package vn.tommy.demo.service;

import vn.tommy.demo.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    Student getById(Long id);
    void save(Student student);
}
