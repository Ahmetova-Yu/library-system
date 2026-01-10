package com.example.crud.book;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
@Data
//@RequiredArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String author;
    private Integer year;
}
