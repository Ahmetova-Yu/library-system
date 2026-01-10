package com.example.crud.controller;

import com.example.crud.entity.Book;
import com.example.crud.entity.Shelf;
import com.example.crud.service.BookService;
import com.example.crud.service.ShelfService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private BookService serviceBook;

//    @Autowired
//    public BookController(BookService service) {
//        this.serviceBook = service;
//    }

    @PostMapping
    ResponseEntity<Book> createBook(@RequestBody Book book) {
        try {
            Book createdBook = serviceBook.createBook(book);
            return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    ResponseEntity<String> readBook() {
        try {
            String book = serviceBook.readBook();
            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    ResponseEntity<Book> updateBook(@PathVariable Integer id, @RequestBody Book book) {
        try {
            Book updatedBook = serviceBook.updateBook(id, book);
            return new ResponseEntity<>(updatedBook, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteBook(@PathVariable Integer id) {
        try {
            String deleteBook = serviceBook.deleteBook(id);
            return new ResponseEntity<>(deleteBook, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Page<Book>> getAllBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "title") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Book> booksPage = serviceBook.getAllBooks(pageable);

        return new ResponseEntity<>(booksPage, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Book>> searchBooks(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Book> booksPage = serviceBook.searchBooks(keyword, pageable);

        return new ResponseEntity<>(booksPage, HttpStatus.OK);
    }
}
