package com.example.crud.service;

import com.example.crud.book.Book;

public interface BasicService {

    Book createBook(Book book);

    String readBook();

    Book updateBook(Integer id, Book book);

    void deleteBook(Integer id);
}
