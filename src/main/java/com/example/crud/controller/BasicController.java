package com.example.crud.controller;

import com.example.crud.entity.Book;
import com.example.crud.service.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BasicController {
    private BasicService service;

    @Autowired
    public BasicController(BasicService service) {
        this.service = service;
    }

    @PostMapping
    Book createBook(@RequestBody Book book) {
        return service.createBook(book);
    }

    @GetMapping
    String readBook() {
        return service.readBook();
    }

    @PutMapping("/{id}")
    Book updateBook(@PathVariable Integer id, @RequestBody Book book) {
        System.out.println(id + " " + book.getTitle() + " " + book.getAuthor() + book.getYear());
        return service.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    void deleteBook(@PathVariable Integer id) {
        service.deleteBook(id);
    }
}
