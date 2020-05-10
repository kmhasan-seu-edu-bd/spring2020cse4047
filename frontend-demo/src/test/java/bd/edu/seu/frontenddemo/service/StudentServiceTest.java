package bd.edu.seu.frontenddemo.service;

import bd.edu.seu.frontenddemo.model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class StudentServiceTest {
    @Autowired
    private StudentService studentService;

    @Test
    public void testSaveStudent() throws Exception {
        Student student = new Student(11, "Jane Doe", 0.78, LocalDate.now());
        Student savedStudent = studentService.saveStudent(student);
        Assertions.assertEquals(student.getName(), savedStudent.getName());
    }
}
