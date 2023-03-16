package com.example.airlinebackend.controller;

import com.example.airlinebackend.dto.PurchaseDto;
import com.example.airlinebackend.model.Ticket;
import com.example.airlinebackend.model.User;
import com.example.airlinebackend.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @GetMapping
    public List<Ticket> findAll() {
        return ticketService.findAll();
    }

    @PostMapping
    public Ticket add(@RequestBody Ticket ticket) {
        return ticketService.add(ticket);
    }

    @GetMapping("/{id}")
    public Ticket findById(@PathVariable("id") String id){
        return ticketService.findById(id);
    }

    @PostMapping
    @RequestMapping("/purchase")
    public void purchase(@RequestBody PurchaseDto purchaseDto) {
        ticketService.purchase(purchaseDto);
    }

    @GetMapping
    @RequestMapping("/user/{userId}")
    public List<Ticket> getAllByUser(@PathVariable("userId") String userId) {
        return ticketService.getAllByUser(userId);
    }
}