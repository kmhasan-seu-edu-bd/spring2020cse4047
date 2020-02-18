/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.seu.lecture2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author seu
 */
public class Main {

    // inner class
    class StudentCgpaComparatorAscending implements Comparator<Student> {

        @Override
        public int compare(Student a, Student b) {
            if (a.getCgpa() < b.getCgpa()) {
                return -1;
            } else if (a.getCgpa() > b.getCgpa()) {
                return +1;
            } else {
                return 0;
            }
        }
    }

    public Main() {
        StudentService studentService = new StudentService();
        List<Student> studentList = studentService.getStudentList();

        System.out.println("Before sorting");
        for (Student student : studentList) {
            System.out.println(student);
        }

//        Comparator<Student> studentComparator = new StudentIdComparator();
//        Comparator<Student> studentComparator = new StudentCgpaComparator();
//        Comparator<Student> studentComparator = new StudentCgpaComparatorAscending();
        /*Comparator<Student> studentComparator = new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                if (a.getCgpa() < b.getCgpa()) {
                    return -1;
                } else if (a.getCgpa() > b.getCgpa()) {
                    return +1;
                } else {
                    return 0;
                }
            }
        };*/
        Comparator<Student> studentComparator = (a, b) -> {
            int inta = (int) (a.getCgpa() * 1000);
            int intb = (int) (b.getCgpa() * 1000);
            return -inta + intb;
        };
        Collections.sort(studentList,
                (a, b) -> (int) a.getId() - (int) b.getId());

        System.out.println("After sorting");
//        for (Student student : studentList) {
//            if (student.getCgpa() >= 3.00)
//                System.out.println(student);
//        }

        studentList
                .stream()
                .filter(student -> student.getCgpa() < 3.00)
                .filter(student -> student.getName().endsWith("ul"))
                .forEach(student -> System.out.println(student));

        List<Student> filteredStudentList = studentList
                .stream()
                .filter(student -> student.getCgpa() < 3.00)
                .filter(student -> student.getName().endsWith("ul"))
                .collect(Collectors.toList());
        System.out.println("Filtered out " + filteredStudentList.size() + " students");

        // find the max CGPA from the low CGPA holders
        studentList
                .stream()
                .filter(student -> student.getCgpa() < 3.00)
                .filter(student -> student.getName().endsWith("ul"))
                .mapToDouble(student -> student.getCgpa())
                .max()
                .ifPresent(maxCgpa -> System.out.println("Max CGPA " + maxCgpa));
    }

    public static void main(String args[]) {
        new Main();
    }
}
