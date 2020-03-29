package bd.edu.seu.springbootdemo.repository;

import bd.edu.seu.springbootdemo.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findByName(String name);
    List<Student> findAllByNameContains(String partial);
}
