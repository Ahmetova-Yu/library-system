package com.example.crud.repository;

import com.example.crud.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasicRepository extends JpaRepository<Book, Integer> {
}
