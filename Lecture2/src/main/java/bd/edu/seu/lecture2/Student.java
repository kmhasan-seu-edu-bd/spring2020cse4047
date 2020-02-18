/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.seu.lecture2;

/**
 *
 * @author seu
 */
public class Student {
    private long id;
    private String name;
    private double cgpa;

    public Student(long id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", cgpa=" + cgpa + '}';
    }
    
    
}
