package vn.tommy.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.tommy.demo.model.Student;
import vn.tommy.demo.repository.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    IStudentRepository studentRepository;

    // lay tat danh sach sinh vien
    public List<Student> getAll() {
        List<Student> studentList = studentRepository.findAll();
        if (studentList.size() > 0) {
            return studentList;
        } else {
            return Collections.emptyList();
        }
    }

    // lay thong tin mot sinh vien
    public Student getById(Long id){
        Student student = null;
        try {
            student = studentRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            return null;
        }
        return student;
    }

    public void save(Student student) {
        studentRepository.save(student);
    }
}
