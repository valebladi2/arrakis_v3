package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User
{
    @Id
    private long userId;
    private String bondHolder;
    private String type;

    @Id //Set the user_id as the ID for the table
    @Column(name = "userId", nullable = false)
    public long getUserId() {return userId;}
    public void setUserId(long userId){this.userId = userId;}

    @Column(name = "type", nullable = false) // Column bondHolder: "type"
    public String getType() {return type;}
    public void setType(String type){this.type = type;}

    @Column(name = "bondHolder", nullable = false) // bondHolder of User
    public String getBondHolder() {
        return bondHolder;
    }
    public void setBondHolder(String bondHolder) {this.bondHolder = bondHolder;}

}
