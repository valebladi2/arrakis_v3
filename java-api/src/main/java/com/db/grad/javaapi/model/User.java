package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User
{
    @Id
    private long id;
    private String name;
    private int quantity;
    private float unitPrice;
    private String book;

    @Id //Set the user_id as the ID for the table
    @Column(name = "user_id", nullable = false)

    // getter and setter methods for ID
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "book", nullable = false) // Column name: "book"

    // getter and setter methods for book
    public String getBook() {
        return book;
    }
    public void setBook(String book){
        this.book = book;
    }

    @Column(name = "name", nullable = false) // name of User

    // getter and setter methods for the name of the user
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "unitPrice", nullable = false) // Column name: "unitPrice"

    // getter and setter methods for unitPrice of bond
    public float getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Column(name = "quantity", nullable = false) // Column name: "quantity"

    // getter and setter methods for quantity of bonds
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}
