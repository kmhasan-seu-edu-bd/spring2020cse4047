package bd.edu.seu.consoleclient.service;

import bd.edu.seu.consoleclient.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StudentService {
    private RestTemplate restTemplate;

    public StudentService() {
        restTemplate = new RestTemplate();
    }

    public void sayHello() {
        System.out.println("Hello");
    }

    public void getStudent(long id) {
        String baseUrl = "http://student-spring-boot-demo.herokuapp.com/students";
        // TODO HW: put the next block in try/catch to catch exceptions when the resource is not found
        ResponseEntity<Student> studentEntity = restTemplate
                .getForEntity(baseUrl + "/" + id, Student.class);
        if (studentEntity.getStatusCode() == HttpStatus.OK) {
            System.out.println(studentEntity.getBody());
        } else {
            System.out.println("Http status: " + studentEntity.getStatusCode());
        }
    }

    public void createStudent(Student student) {
        System.out.println("Creating " + student);
        // TODO add your code here
    }
}
