package bd.edu.seu.springbootdemo.controller;

import bd.edu.seu.springbootdemo.exception.ResourceAlreadyExistsException;
import bd.edu.seu.springbootdemo.exception.ResourceNotFoundException;
import bd.edu.seu.springbootdemo.model.Student;
import bd.edu.seu.springbootdemo.repository.StudentRepository;
import bd.edu.seu.springbootdemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> studentList = studentService.findAll();
        return ResponseEntity.ok(studentList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable long id) {
        try {
            Student student = studentService.findById(id);
            return ResponseEntity.ok(student);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        try {
            Student createdStudent = studentService.create(student);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
        } catch (ResourceAlreadyExistsException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable long id) {
        // TODO HW
//        studentRepository.deleteById(id);
    }

    // TODO HW: Write an update REST endpoint
}
