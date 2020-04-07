package bd.edu.seu.springbootdemo.repository;

import bd.edu.seu.springbootdemo.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findByName(String name);
    List<Student> findAllByNameContains(String partial);
    List<Student> findAllByCgpaGreaterThanEqual(double cgpa);
}
