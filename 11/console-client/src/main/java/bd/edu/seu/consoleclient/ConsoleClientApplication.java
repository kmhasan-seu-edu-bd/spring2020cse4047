package bd.edu.seu.consoleclient;

import bd.edu.seu.consoleclient.model.Student;
import bd.edu.seu.consoleclient.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ConsoleClientApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ConsoleClientApplication.class, args);
        StudentService studentService = run.getBean(StudentService.class);
        studentService.sayHello();
        studentService.getStudent(575);
//        studentService.getStudent(572);
        studentService.createStudent(new Student(784, "Donald Trump", 3.24, LocalDate.now()));
    }

}
