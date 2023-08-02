package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Trade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITradeService {
    public List<Trade> getAllTrades();
}
