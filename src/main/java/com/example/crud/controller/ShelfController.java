package com.example.crud.controller;

import com.example.crud.entity.Book;
import com.example.crud.entity.Shelf;
import com.example.crud.service.BookService;
import com.example.crud.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shelf")
public class ShelfController {
    private ShelfService service;

    @Autowired
    public ShelfController(ShelfService service) {
        this.service = service;
    }

    @PostMapping
    Shelf createShelf(@RequestBody Shelf shelf) {
        return service.createShelf(shelf);
    }

    @GetMapping
    String readShelf() {
        return service.readShelf();
    }

    @PutMapping("/{id}")
    Shelf updateShelf(@PathVariable Integer id, @RequestBody Shelf shelf) {
        return service.updateShelf(id, shelf);
    }

    @DeleteMapping("/{id}")
    String deleteBook(@PathVariable Integer id) {
        return service.deleteShelf(id);
    }
}
