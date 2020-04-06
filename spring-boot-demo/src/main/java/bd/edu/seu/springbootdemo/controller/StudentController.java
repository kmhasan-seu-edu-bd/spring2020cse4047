package bd.edu.seu.springbootdemo.controller;

import bd.edu.seu.springbootdemo.model.Student;
import bd.edu.seu.springbootdemo.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("students")
public class StudentController {
    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //    @GetMapping("")
//    public String sayHi() {
//        return "Hi";
//    }

//    @GetMapping("hello")
//    public String sayHello() {
//        return "Hello";
//    }

//    @GetMapping("hello")
//    public String sayHello(@RequestParam String name) {
//        return "Hello, " + name;
//    }

    @GetMapping("")
    public List<Student> getStudents() {
        List<Student> studentList = new ArrayList<>();
        Iterable<Student> studentIterable = studentRepository.findAll();
        studentIterable.forEach(studentList::add);
        return studentList;
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable long id) {
        Student student = studentRepository.findById(id).get(); // This is sooooo wrong
        return student;
    }

    @PostMapping("")
    public Student createStudent(@RequestBody Student student) {
        Student savedStudent = studentRepository.save(student);
        return savedStudent;
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable long id) {
        studentRepository.deleteById(id);
    }
}
