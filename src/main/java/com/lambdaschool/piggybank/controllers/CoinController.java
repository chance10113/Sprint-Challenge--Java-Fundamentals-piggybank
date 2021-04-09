package com.lambdaschool.piggybank.controllers;

//import com.lambdaschool.piggybank.controllers.CheckCoin;
import com.lambdaschool.piggybank.models.Coin;
import com.lambdaschool.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;

@RestController
public class CoinController {
    @Autowired
    private CoinRepository coinRepository;

    @GetMapping(value = "/piggybank/total", produces = "application/json")
    public ResponseEntity<?> getTotal() {
        double total = 0.0;

        List<Coin> piggyBank = new ArrayList<>();
        coinRepository.findAll().iterator().forEachRemaining(e -> piggyBank.add(e));
        for (Coin e :piggyBank) {
            total += e.getValue() * e.getQuantity();
            System.out.println(e.getQuantity() + e.getName());
        }
        System.out.println("The piggy bank holds " + total);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


}
