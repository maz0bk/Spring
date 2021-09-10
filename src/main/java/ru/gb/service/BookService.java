package ru.gb.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.gb.entities.Book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class BookService {
    private List<Book> repository;

    public BookService() {
        this.repository = new ArrayList<Book>(
                List.of(new Book("qw","Pushkin","Onegin"),
                        new Book("qw","Pushkin2","Onegin2"),
                        new Book("qw","Pushkin3","Onegin3"),
                        new Book("qw","Pushkin4","Onegin4")
                )
        );
    }

    public Collection<Book> getBooks() {
        return repository;
    }


    public Book addBook(Book book) {
        repository.add(book);
        return book;
    }
}
