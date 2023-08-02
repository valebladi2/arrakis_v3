package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class Book
{
    @Id
    private long id;
    private String name;
    private String holder;

    @Id
    @Column(name = "book_id", nullable = false)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "holder", nullable = false)
    public String getBookHolder(){return holder;}
    public void setBookHolder(String bookHolder){this.holder = holder;}
}
