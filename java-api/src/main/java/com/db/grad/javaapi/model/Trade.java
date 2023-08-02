package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Trade")
public class Trade
{
    @Id
    private long id;
    private String currency;
    private String type;
    private String settlementDate;
    private boolean status;
    private String tradeDate;

    @Id
    @Column(name = "trade_id", nullable = false)
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    @Column(name = "type", nullable = false)
    public String getType() {return type;}
    public void setType(String type) {this.type = type;}

    @Column(name = "currency", nullable = false)
    public String getCurrency(){return currency;}
    public void setCurrency(String currency){this.currency = currency;}

    @Column(name = "settlementDate", nullable = false)
    public String getSettlementDate() {return settlementDate;}
    public void setSettlementDate(String settlementDate) {this.settlementDate = settlementDate;}

    @Column(name = "status", nullable = false)
    public boolean getStatus() {return this.status;}
    public void setStatus(boolean status) {this.status = status;}

    @Column(name = "tradeDate", nullable = false)
    public String getTradeDate() {
        return tradeDate;
    }
    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

}

