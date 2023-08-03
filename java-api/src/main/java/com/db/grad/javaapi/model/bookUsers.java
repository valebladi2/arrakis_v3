package com.db.grad.javaapi.model;

import javax.persistence.*;


@Entity
@Table(name = "booksusers")
public class bookUsers {
    @Id
    private int bookUserId;
    private String bondHolder;
    private String bookName;

    @Column(name = "bookuserId", nullable = false)
    public int getBookUserId() {return bookUserId;}
    public void setBookUserId(int bookUserId) {this.bookUserId = bookUserId;}

    @Column(name = "bondholder", nullable = false)
    public String getBondHolder() {return bondHolder;}
    public void setBondHolder(String bondHolder) {this.bondHolder = bondHolder;}

    @Column(name = "bookname", nullable = false)
    public String getBookName() {return bookName;}
    public void setBookName(String bookName) {this.bookName = bookName;}

}
