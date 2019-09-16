package vn.tommy.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.tommy.demo.model.Student;
import vn.tommy.demo.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
    @Autowired
    StudentService service;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> listStudent= service.getAll();
        return new ResponseEntity<>(listStudent, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = service.getById(id);
        if (student == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        service.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
