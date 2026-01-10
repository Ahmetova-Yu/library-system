package com.example.crud.service;

import com.example.crud.entity.Book;

public interface BookService {

    Book createBook(Book book);

    String readBook();

    Book updateBook(Integer id, Book book);

    String deleteBook(Integer id);
}
