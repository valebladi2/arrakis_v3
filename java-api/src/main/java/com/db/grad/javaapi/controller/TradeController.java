package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.service.TradeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class TradeController {
    private TradeHandler TradeService;

    @Autowired
    public TradeController(TradeHandler bs)
    {
        TradeService = bs;
    }

    @GetMapping("/trades")
    public List <Trade> getAllTrades() {return TradeService.getAllTrades();}

    @GetMapping("/trades/{id}")
    public ResponseEntity <Trade> getEmployeeById(@PathVariable(value = "id") Long id)
    throws ResourceNotFoundException {
        Trade trade = TradeService.getTradesById(id);
        return ResponseEntity.ok().body(trade);
    }

    @PostMapping("/trades")
    public Trade createTrade(@Valid @RequestBody Trade trade) {
        return TradeService.addTrade(trade);
    }

    @PutMapping("/trades/{id}")
    public ResponseEntity < Trade > updateTrade(@PathVariable(value = "id") Long id,
        @Valid @RequestBody Trade trade) throws ResourceNotFoundException {

        final Trade updatedTrades = TradeService.updateTradeDetails(trade);
        return ResponseEntity.ok(updatedTrades);
    }

    @DeleteMapping("/trades/{id}")
    public Map < String, Boolean > deleteTrade(@PathVariable(value = "id") Integer id)
    throws ResourceNotFoundException {
    	boolean removed = TradeService.removeTrade(id);

        Map < String, Boolean > response = new HashMap <>();
        if( removed )
            response.put("deleted", Boolean.TRUE);
        else
            response.put("deleted", Boolean.FALSE);

        return response;
    }
}
