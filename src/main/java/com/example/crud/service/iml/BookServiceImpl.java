package com.example.crud.service.iml;

import com.example.crud.entity.Book;
import com.example.crud.repository.BookRepository;
import com.example.crud.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
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


        if (existingBook != null) {

            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setYear(book.getYear());
            existingBook.setShelf(book.getShelf());

            return repository.save(existingBook);
        }

        System.out.println("Книга не найдена");
        return null;
    }

    @Override
    public String deleteBook(Integer id) {
        if (!repository.existsById(id)) {
            return "Книга не найдена";
        }

        String name  = repository.findById(id).get().getTitle();

        repository.deleteById(id);
        return "Книга " + name + " удалена";
    }
}
