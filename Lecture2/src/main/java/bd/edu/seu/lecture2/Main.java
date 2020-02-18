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

    private double getAverageCgpa(List<Student> studentList) {
        double sum = 0;
        for (int i = 0; i < studentList.size(); i++) {
            sum = sum + studentList.get(i).getCgpa();
        }
        double average = sum / studentList.size();
        return average;
    }

    private double getAverageCgpaWithEnhancedForLoop(List<Student> studentList) {
        double sum = 0;
        for (Student student : studentList) {
            sum = sum + student.getCgpa();
        }
        double average = sum / studentList.size();
        return average;
    }

    private double getAverageCgpaWithStream(List<Student> studentList) {
        return studentList
                .stream()
                .mapToDouble(student -> student.getCgpa())
                .average()
                .getAsDouble();
    }

    private double getAverageCgpaWithParallelStream(List<Student> studentList) {
        return studentList
                .stream()
                .parallel()
                .mapToDouble(student -> student.getCgpa())
                .average()
                .getAsDouble();
    }

    public Main() {
        StudentService studentService = new StudentService();
        long start, stop;
        start = System.currentTimeMillis();
        List<Student> studentList = studentService.getStudentList();
        stop = System.currentTimeMillis();
        System.out.println(studentList.size() + " students");
        System.out.printf("Time taken %.3f seconds\n", (stop - start) / 1000.0);

        start = System.currentTimeMillis();
        double avgCgpa1 = getAverageCgpa(studentList);
        stop = System.currentTimeMillis();
        System.out.printf("Average CGPA: %.3f\n", avgCgpa1);
        System.out.printf("Time taken %.3f seconds\n", (stop - start) / 1000.0);

        start = System.currentTimeMillis();
        double avgCgpa2 = getAverageCgpaWithEnhancedForLoop(studentList);
        stop = System.currentTimeMillis();
        System.out.printf("Average CGPA: %.3f\n", avgCgpa2);
        System.out.printf("Time taken %.3f seconds\n", (stop - start) / 1000.0);

        start = System.currentTimeMillis();
        double avgCgpa3 = getAverageCgpaWithStream(studentList);
        stop = System.currentTimeMillis();
        System.out.printf("Average CGPA: %.3f\n", avgCgpa3);
        System.out.printf("Time taken %.3f seconds\n", (stop - start) / 1000.0);

        start = System.currentTimeMillis();
        double avgCgpa4 = getAverageCgpaWithParallelStream(studentList);
        stop = System.currentTimeMillis();
        System.out.printf("Average CGPA: %.3f\n", avgCgpa4);
        System.out.printf("Time taken %.3f seconds\n", (stop - start) / 1000.0);

        start = System.currentTimeMillis();
        studentList = studentList
                .stream()
                .parallel()
                .sorted((s1, s2) -> {
                    int cgpa1 = (int) (s1.getCgpa() * 1000);
                    int cgpa2 = (int) (s2.getCgpa() * 1000);
                    return cgpa1 - cgpa2;
                })
                .collect(Collectors.toList());
        stop = System.currentTimeMillis();
        System.out.printf("Time taken for sorting %.3f seconds\n", (stop - start) / 1000.0);

        /*
        System.out.println("Before sorting");
        for (Student student : studentList) {
            System.out.println(student);
        }

//        Comparator<Student> studentComparator = new StudentIdComparator();
//        Comparator<Student> studentComparator = new StudentCgpaComparator();
//        Comparator<Student> studentComparator = new StudentCgpaComparatorAscending();
        
//        Comparator<Student> studentComparator = new Comparator<Student>() {
//            @Override
//            public int compare(Student a, Student b) {
//                if (a.getCgpa() < b.getCgpa()) {
//                    return -1;
//                } else if (a.getCgpa() > b.getCgpa()) {
//                    return +1;
//                } else {
//                    return 0;
//                }
//            }
//        };

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
         */
    }

    public static void main(String args[]) {
        new Main();
    }
}
