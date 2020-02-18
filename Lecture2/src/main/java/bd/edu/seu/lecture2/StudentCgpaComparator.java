/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.seu.lecture2;

import java.util.Comparator;

/**
 *
 * @author seu
 */
public class StudentCgpaComparator implements Comparator<Student> {

    @Override
    public int compare(Student a, Student b) {
        if (a.getCgpa() > b.getCgpa())
            return -1;
        else if (a.getCgpa() < b.getCgpa())
            return +1;
        else return 0;
    }
    
}
