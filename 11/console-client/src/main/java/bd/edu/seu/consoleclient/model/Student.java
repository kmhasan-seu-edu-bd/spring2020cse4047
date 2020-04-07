package bd.edu.seu.consoleclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private long id;
    private String name;
    private double cgpa;
    private LocalDate dateOfBirth;
}
