package cat.proven.statementultimo.model;

import java.util.Objects;

/**
 * ADT for product.
 *
 * @author mati
 */
public class Product {

    //attributes
    private String code;
    private String description;
    private double price;
    private int stock;

    /**
     * Full initialization constructor.
     * @param code the value for the code attribute.
     * @param description
     * @param price
     * @param stock 
     */
    public Product(String code, String description, double price, int stock) {
        this.code = code;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    /**
     * Default constructor.
     */
    public Product() {
    }

    public Product(String code) {
        this.code = code;
    }
    
    /**
     * Copy constructor
     * @param other the product to copy
     */
    public Product(Product other) {
        this.code = other.code;
        this.description = other.description;
        this.price = other.price;
        this.stock = other.stock;
    }    
    
    // accessors

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.code);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        boolean b;
        if (obj == null) { //null object
            b = false;
        } else {
            if (this == obj) { //same object
                b = true;
            } else {
                if (obj instanceof Product) { //obj is a product
                    Product other = (Product) obj;
                    b = (this.code.equals(other.code));
                } else {
                    b = false;
                }
            }
        }
        return b;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Product{");
        sb.append("[code="); sb.append(code); sb.append("]");
        sb.append("[description="); sb.append(description); sb.append("]");
        sb.append("[price="); sb.append(price); sb.append("]");
        sb.append("[stock="); sb.append(stock); sb.append("]");
        sb.append("}");
        return sb.toString();
    }
}
