package bd.edu.seu.hibernatedemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product { // POJO (Plain Old Java Object) class
    @Id
    private long id;
    private String name;
    private double pricePerUnit;
    private double unitsInStock;
    private boolean discontinued;
    @OneToMany
    private List<Supplier> supplierList;
}
