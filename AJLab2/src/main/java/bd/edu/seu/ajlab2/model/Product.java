/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.seu.ajlab2.model;

/**
 *
 * @author kmhasan
 */
public class Product {
    private int productID;
    private String productName;
    private String quantityPerUnit;
    private double unitPrice;
    private double unitsInStock;
    private double unitsOnOrder;
    private double reorderLevel;
    private boolean discontinued;

    public Product() {
    }

    public Product(int productID, String productName, String quantityPerUnit, double unitPrice, double unitsInStock, double unitsOnOrder, double reorderLevel, boolean discontinued) {
        this.productID = productID;
        this.productName = productName;
        this.quantityPerUnit = quantityPerUnit;
        this.unitPrice = unitPrice;
        this.unitsInStock = unitsInStock;
        this.unitsOnOrder = unitsOnOrder;
        this.reorderLevel = reorderLevel;
        this.discontinued = discontinued;
    }

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getUnitsInStock() {
        return unitsInStock;
    }

    public double getUnitsOnOrder() {
        return unitsOnOrder;
    }

    public double getReorderLevel() {
        return reorderLevel;
    }

    public boolean isDiscontinued() {
        return discontinued;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productName=" + productName + ", quantityPerUnit=" + quantityPerUnit + ", unitPrice=" + unitPrice + ", unitsInStock=" + unitsInStock + ", unitsOnOrder=" + unitsOnOrder + ", reorderLevel=" + reorderLevel + ", discontinued=" + discontinued + '}';
    }
}
