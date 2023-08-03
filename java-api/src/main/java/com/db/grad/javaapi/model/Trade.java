package com.db.grad.javaapi.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "trade")
public class Trade
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
    @Column(name = "tradeid", nullable = false)
    public long getTradeId() {return tradeId;}
    public void setTradeId(long id) {this.tradeId = id;}

    @Column(name = "tradetype", nullable = false)
    public String getTradeType() {return tradeType;}
    public void setTradeType(String type) {this.tradeType = type;}

    @Column(name = "tradecurrency", nullable = false)
    public String getTradeCurrency(){return tradeCurrency;}
    public void setTradeCurrency(String tradeCurrency){this.tradeCurrency = tradeCurrency;}

    @Column(name = "tradesettlementdate", nullable = false)
    public LocalDate getTradeSettlementDate() {return tradeSettlementDate;}
    public void setTradeSettlementDate(LocalDate tradeSettlementDate) {this.tradeSettlementDate = tradeSettlementDate;}

    @Column(name = "tradestatus", nullable = false)
    public String getTradeStatus() {return this.tradeStatus;}
    public void setTradeStatus(String status) {this.tradeStatus = status;}

    @Column(name = "tradedate", nullable = false)
    public LocalDate getTradeDate() {return tradeDate;}
    public void setTradeDate(LocalDate tradeDate){this.tradeDate = tradeDate;}

    @Column(name = "quantity", nullable = false) // Column bondHolder: "quantity"
    public int getQuantity(){return quantity;}
    public void setQuantity(int quantity){this.quantity = quantity;}

    @Column(name = "bookname", nullable = false)
    public String getBookName() {return bookName;}
    public void setBookName(String bookName) {this.bookName = bookName;}

    @Column(name = "isin", nullable = false)
    public String getIsin() {
        return isin;
    }
    public void setIsin(String isin) {this.isin = isin;}
}

