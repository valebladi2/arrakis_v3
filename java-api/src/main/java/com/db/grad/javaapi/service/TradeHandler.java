package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Trades;
import com.db.grad.javaapi.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeHandler implements ITradeService{
        private TradeRepository tradeRepo;

        @Autowired
        public TradeHandler( TradeRepository tradeRep ) {this.tradeRepo = tradeRep;}

        @Override
        public List<Trades> getAllTrades() {return tradeRepo.getAllTrades();}
}
