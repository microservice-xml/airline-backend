package com.example.airlinebackend.service;

import com.example.airlinebackend.dto.PurchaseDto;
import com.example.airlinebackend.exception.NotFoundException;
import com.example.airlinebackend.exception.TicketException;
import com.example.airlinebackend.model.Ticket;
import com.example.airlinebackend.repository.FlightRepository;
import com.example.airlinebackend.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;
    private final FlightRepository flightRepository;
    private final FlightService flightService;

    public Ticket add(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    public Ticket findById(String id) {
        return ticketRepository.findById(id).orElseThrow(() -> new NotFoundException("Ticket doesn't exist"));
    }

    public void purchase(PurchaseDto purchaseDto) {
        var flight = flightRepository.findById(purchaseDto.getFlightId()).orElseThrow(() -> new NotFoundException("Flight is not found"));
        if (purchaseDto.getCount() > flight.getAvailableSeats()) {
            throw new TicketException("There are not enough available tickets");
        }
        ticketRepository.saveAll(generateTickets(purchaseDto));
        flightService.purchaseTickets(flight, purchaseDto.getCount());
    }

    private List<Ticket> generateTickets(PurchaseDto purchaseDto) {
        var tickets = new ArrayList<Ticket>();
        for (int i = 0; i < purchaseDto.getCount(); i++) {
            var ticket = Ticket.builder()
                    .userId(purchaseDto.getUserId())
                    .flightId(purchaseDto.getFlightId())
                    .payedPrice(purchaseDto.getPayedPrice())
                    .build();
            tickets.add(ticket);
        }
        return tickets;
    }

    public List<Ticket> getAllByUser(String userId) {
        return ticketRepository.findAllByUserId(userId);
    }
}