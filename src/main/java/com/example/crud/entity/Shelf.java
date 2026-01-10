package com.example.crud.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
public class Shelf {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "shelf")
    @JoinColumn(name = "id")
    List<Book> books;
}
