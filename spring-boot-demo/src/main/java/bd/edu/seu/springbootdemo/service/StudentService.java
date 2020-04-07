package bd.edu.seu.springbootdemo.service;

import bd.edu.seu.springbootdemo.exception.ResourceAlreadyExistsException;
import bd.edu.seu.springbootdemo.exception.ResourceNotFoundException;
import bd.edu.seu.springbootdemo.model.Student;
import bd.edu.seu.springbootdemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        studentRepository.findAll().forEach(studentList::add);
        return studentList;
    }

    public Student findById(long id) throws ResourceNotFoundException {
        Student student = studentRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
        return student;
    }

    public Student create(Student student) throws ResourceAlreadyExistsException {
        if (studentRepository.existsById(student.getId())) {
            throw new ResourceAlreadyExistsException();
        } else {
            Student savedStudent = studentRepository.save(student);
            return savedStudent;
        }
    }

    public void deleteById(long id) {
        // TODO HW implement this one
    }
}
