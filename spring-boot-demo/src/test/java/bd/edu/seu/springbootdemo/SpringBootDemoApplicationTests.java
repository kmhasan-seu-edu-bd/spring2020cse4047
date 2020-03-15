package bd.edu.seu.springbootdemo;

import bd.edu.seu.springbootdemo.model.Student;
import bd.edu.seu.springbootdemo.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootDemoApplicationTests {
	@Autowired
	private StudentRepository studentRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void createStudent() {
		Student student = new Student(21344l, "Md. Ashiqur Rahman", 3.99);
		Student savedStudent = studentRepository.save(student);

	}
}
