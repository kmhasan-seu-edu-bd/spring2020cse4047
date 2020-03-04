package bd.edu.seu.hibernatedemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Supplier {
    @Id
    private int id;
    private String name;
    private String address;
}
