package bd.edu.seu.springbootdemo;

import bd.edu.seu.springbootdemo.model.Student;
import bd.edu.seu.springbootdemo.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class SpringBootDemoApplicationTests {
	@Autowired
	private StudentRepository studentRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void createStudent() {
		Student student = new Student();
		student.setId(21344L);
		student.setName("Md. Ashiqur Rahman");
		student.setCgpa(3.99);

		Student savedStudent = studentRepository.save(student);
		System.out.println(savedStudent);

		Assertions.assertEquals(student.getId(), savedStudent.getId());
		Assertions.assertEquals(student.getName(), savedStudent.getName());
		Assertions.assertEquals(student.getCgpa(), savedStudent.getCgpa(), 0.001);
	}

	@Test
	void readStudent() {
		Optional<Student> optionalStudent = studentRepository.findById(21344L);
//		optionalStudent.ifPresent(System.out::println);
		Student student = optionalStudent.get();
		System.out.println(student);
	}

	@Test
	void readStudents() {
		Iterable<Student> studentIterable = studentRepository.findAll();
		List<Student> studentList = new ArrayList<>();
		studentIterable.forEach(studentList::add);

		System.out.println(studentList);
		System.out.println(studentList.size() + " students");
	}

	// HW: try out the delete and update methods

	@Test
	public void readStudentByName() {
		Student student = new Student();
		student.setId(114);
		student.setName("Md. Ashiqur Rahman");
		student.setCgpa(3.54);
		studentRepository.save(student);
		student.setId(116);
		student.setName("Md. Ashiqun Nabi");
		student.setCgpa(3.67);
		studentRepository.save(student);
		student.setId(117);
		student.setName("Md. Ashiqur Rahman");
		student.setCgpa(3.67);
		studentRepository.save(student);

		List<Student> studentList = studentRepository.findByName("Md. Ashiqur Rahman");
		studentList.stream().forEach(System.out::println);
	}

	@Test
	public void readStudentByPartialNameMatch() {
		Student student = new Student();
		student.setId(114);
		student.setName("Md. Ashiqur Rahman");
		student.setCgpa(3.54);
		studentRepository.save(student);
		student.setId(116);
		student.setName("Md. Ashiqun Nabi");
		student.setCgpa(3.67);
		studentRepository.save(student);
		student.setId(117);
		student.setName("Md. Ashiqur Rahman");
		student.setCgpa(3.67);
		studentRepository.save(student);

		List<Student> studentList = studentRepository.findAllByNameContains("Ashiq");
		studentList.stream().forEach(System.out::println);
	}

	// HW: find out all the students whose date of birth falls between 1990 and 2000

	// HW: find out all the students with CGPA >= 3.75

	// HW: create an account on Heroku using your official email address
}
