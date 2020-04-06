package bd.edu.seu.springbootdemo.service;

import bd.edu.seu.springbootdemo.model.Student;
import bd.edu.seu.springbootdemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;

@Service
public class DummyDataService {
    private StudentRepository studentRepository;

    public DummyDataService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addDummyData() {
        studentRepository.save(new Student(574,
                "Rajon Bardhan",
                3.54,
                LocalDate.of(1990, Month.DECEMBER, 23)));
        studentRepository.save(new Student(575,
                "Ishan Arefin",
                3.87,
                LocalDate.of(1998, Month.APRIL, 20)));
    }
}
