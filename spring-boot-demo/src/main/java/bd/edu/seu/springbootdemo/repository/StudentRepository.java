package bd.edu.seu.springbootdemo.repository;

import bd.edu.seu.springbootdemo.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
