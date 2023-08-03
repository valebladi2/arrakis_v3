package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "trade") //change DB to trades, now is a new db
public class Trades
{
    @Id
    private long tradeId;
    private String tradeCurrency;
    private String tradeType;
    private LocalDate tradeSettlementDate;
    private String tradeStatus;
    private LocalDate tradeDate;
    private int quantity;
    private String bookName;
    private String isin;

    @Id
    @Column(name = "tradeId", nullable = false)
    public long getTradeId() {return tradeId;}
    public void setTradeId(long id) {this.tradeId = tradeId;}

    @Column(name = "tradeType", nullable = false)
    public String getTradeType() {return tradeType;}
    public void setTradeType(String type) {this.tradeType = tradeType;}

    @Column(name = "tradeCurrency", nullable = false)
    public String getTradeCurrency(){return tradeCurrency;}
    public void setTradeCurrency(String tradeCurrency){this.tradeCurrency = tradeCurrency;}

    @Column(name = "tradeSettlementDate", nullable = false)
    //public LocalDate getTradeSettlementDate() {return tradeSettlementDate;}
    //public void setTradeSettlementDate(int year, int month, int day) {this.tradeSettlementDate = LocalDate.of(year, month, day);}
    public void getTradeSettlementDate(){}
    public void setTradeSettlementDate(){}

    @Column(name = "tradeStatus", nullable = false)
    public String getTradeStatus() {return this.tradeStatus;}
    public void setTradeStatus(String status) {this.tradeStatus = status;}

    @Column(name = "tradeDate", nullable = false)
    //public LocalDate getTradeDate() {return tradeDate;}
    //public void setTradeDate(int year, int month, int day){LocalDate tradeDate = LocalDate.of(year, month, day);}
    public void getTradeDate() {}
    public void setTradeDate(){}
    @Column(name = "quantity", nullable = false) // Column bondHolder: "quantity"
    public int getQuantity(){return quantity;}
    public void setQuantity(int quantity){this.quantity = quantity;}

    @Column(name = "bookName", nullable = false)
    public String getBookName() {return bookName;}
    public void setBookName(String bookName) {this.bookName = bookName;}

    @Column(name = "isin", nullable = false)
    public String getIsin() {
        return isin;
    }
    public void setIsin(String isin) {
        this.isin = isin;
    }
}