package bd.edu.seu.hibernatedemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@Entity
public class Product {
    @Id
    private long id;
    private String name;
    private double pricePerUnit;
    private double unitsInStock;
}
