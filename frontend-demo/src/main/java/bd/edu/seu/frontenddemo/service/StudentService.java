package bd.edu.seu.frontenddemo.service;

import bd.edu.seu.frontenddemo.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StudentService {
    private static final String BASE_URL = "http://student-spring-boot-demo.herokuapp.com/students/";
    private RestTemplate restTemplate;

    public StudentService() {
        restTemplate = new RestTemplate();
    }

    public Student saveStudent(Student student) throws Exception{
        System.out.println(student);
        ResponseEntity<Student> studentResponseEntity
                = restTemplate.postForEntity(BASE_URL, student, Student.class);
        HttpStatus statusCode = studentResponseEntity.getStatusCode();
        Student savedStudent = studentResponseEntity.getBody();
        System.out.println("Status code:" + statusCode);
        System.out.println(savedStudent);

        if (!statusCode.equals(HttpStatus.CREATED))
            throw new Exception("Couldn't create student " + student);

        return savedStudent;
    }
}
