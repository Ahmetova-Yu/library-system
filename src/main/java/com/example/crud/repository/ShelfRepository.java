package com.example.crud.repository;

import com.example.crud.entity.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShelfRepository extends JpaRepository<Shelf, Integer> {
}
