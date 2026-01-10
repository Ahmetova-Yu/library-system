package com.example.crud.service.iml;

import com.example.crud.book.Book;
import com.example.crud.repository.BasicRepository;
import com.example.crud.service.BasicService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BasicServiceImpl implements BasicService {
    private BasicRepository repository;

    public BasicServiceImpl(BasicRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book createBook(Book book) {
        return repository.save(book);
    }

    @Override
    public String readBook() {
        List<Book> books = repository.findAll();

        return books.stream().map(Book::toString).collect(Collectors.joining("\n"));
    }

    @Override
    public Book updateBook(Integer id, Book book) {
        Book existingBook = repository.findById(id)
                .orElse(null);

        System.out.println(existingBook.getTitle() + " " + existingBook.getAuthor() + " " + existingBook.getYear());

        if (existingBook != null) {

            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setYear(book.getYear());

            System.out.println(existingBook.getTitle() + " " + existingBook.getAuthor() + " " + existingBook.getYear());
            System.out.println("Book updated");

            return repository.save(existingBook);
        }

        System.out.println("Книга не найдена");
        return null;
    }

    @Override
    public void deleteBook(Integer id) {
        if (!repository.existsById(id)) {
            System.out.println("Книга не найдена");
            return;
        }

        repository.deleteById(id);
    }
}
