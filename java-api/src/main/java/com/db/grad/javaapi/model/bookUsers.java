package com.db.grad.javaapi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "bookUsers")
public class bookUsers {
    @Id
    private int bookUserId;
    private String bondHolder;
    private String bookName;

    @Column(name = "bookUserId", nullable = false)
    public int getBookUserId() {return bookUserId;}
    public void setBookUserId(int bookUserId) {this.bookUserId = bookUserId;}

    @Column(name = "bondHolder", nullable = false)
    public String getBondHolder() {return bondHolder;}
    public void setBondHolder(String bondHolder) {this.bondHolder = bondHolder;}

    @Column(name = "bookName", nullable = false)
    public String getBookName() {return bookName;}
    public void setBookName(String bookName) {this.bookName = bookName;}

}
