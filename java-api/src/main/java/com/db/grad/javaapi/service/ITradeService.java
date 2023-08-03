package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Trade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITradeService {
    List<Trade> getAllTrades();

    Trade getTradesById(Long id);

    Trade updateTradeDetails(Trade tradeToUpdate);

    Trade addTrade(Trade trade);

    boolean removeTrade(long uniqueId);
}
