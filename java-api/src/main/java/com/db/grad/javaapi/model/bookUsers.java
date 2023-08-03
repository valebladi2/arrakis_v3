package com.db.grad.javaapi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "book_users")
public class bookUsers {
    @Id
    private int bookUserId;
    private String bondHolder;
    private String bookName;

    @Column(name = "book_user_Id", nullable = false)
    public int getBookUserId() {return bookUserId;}
    public void setBookUserId(int bookUserId) {this.bookUserId = bookUserId;}

    @Column(name = "bond_holder", nullable = false)
    public String getBondHolder() {return bondHolder;}
    public void setBondHolder(String bondHolder) {this.bondHolder = bondHolder;}

    @Column(name = "book_name", nullable = false)
    public String getBookName() {return bookName;}
    public void setBookName(String bookName) {this.bookName = bookName;}

}
