package com.example.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final QuoteRepository quoteRepository;

    public MessageController(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @GetMapping("/")
    public Quote radomQuote()
    {
        return quoteRepository.findRandomQuote();
    }

    @GetMapping("/quotes")
    public List<Quote> getAll()
    {
        return quoteRepository.findAll();
    }

    @GetMapping("/quotes/{id}")
    public ResponseEntity<Quote> getQuote(@PathVariable("id") Integer id) {
        Optional<Quote> quote = quoteRepository.findById(id);
        if (quote.isPresent()) {
            return new ResponseEntity<>(quote.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
