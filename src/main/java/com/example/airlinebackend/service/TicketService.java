package com.example.airlinebackend.service;

import com.example.airlinebackend.exception.NotFoundException;
import com.example.airlinebackend.model.Ticket;
import com.example.airlinebackend.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;

    public Ticket add(Ticket ticket){ return ticketRepository.save(ticket); }

    public List<Ticket> findAll(){ return ticketRepository.findAll(); }

    public Ticket findById(String id){
        return ticketRepository.findById(id).orElseThrow(() -> new NotFoundException("Ticket doesn't exist"));
    }

}
