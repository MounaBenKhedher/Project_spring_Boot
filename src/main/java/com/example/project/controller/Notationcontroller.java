package com.example.project.controller;

/*

import com.example.project.service.Notationservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
/*@RestController
@RequestMapping("api/auth/privillege")
@CrossOrigin(origins="*")
@Controller
/*public class Notationcontroller {

    @Autowired
    Notationservice notationService;

    @PostMapping
    public ResponseEntity<Notationdto> createNotation(@RequestBody Notationdto notationdto) {
        try {
            Notationdto createdNotation = notationService.createNotation(notationdto);
            return new ResponseEntity<>(createdNotation, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            // Handle specific exceptions for invalid input
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            // Handle generic exceptions
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public Notationdto getNotationById(@PathVariable Long id) {
        return notationService.getNotationById(id);
    }

    // Other endpoints for update, delete, etc.
}*/