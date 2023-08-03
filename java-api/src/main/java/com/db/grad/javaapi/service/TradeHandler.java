package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TradeHandler implements ITradeService{
        private TradeRepository tradeRepo;

        @Autowired
        public TradeHandler( TradeRepository tradeRep ) {this.tradeRepo = tradeRep;}

        @Override
        public List<Trade> getAllTrades() {return tradeRepo.getAllTrades();}

        @Override
        public Trade getTradesById(Long id) {
                return tradeRepo.findById(id).get();
        }

        @Override
        public Trade updateTradeDetails(Trade tradeToUpdate) {return tradeRepo.save( tradeToUpdate );}

        @Override
        public boolean removeTrade(long uniqueId)
        {
                boolean result = false;

                Optional<Trade> theTrade = tradeRepo.findById(uniqueId);
                if(theTrade.isPresent())
                {
                        tradeRepo.delete(theTrade.get());
                        result = true;
                }

                return  result;
        }

        @Override
        public Trade addTrade(Trade trade) {
                return tradeRepo.save(trade);
        }
}
