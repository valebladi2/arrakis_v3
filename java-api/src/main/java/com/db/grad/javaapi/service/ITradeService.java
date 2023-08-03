package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Trades;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITradeService {
    public List<Trades> getAllTrades();
}
