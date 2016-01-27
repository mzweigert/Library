package com.library.service;

import com.library.domain.Book;

import javax.enterprise.context.ApplicationScoped;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class BookManager {

    private List<Book> BookDB = new ArrayList<Book>();

    public BookManager() {

        //Seeding
//        Book book = new Book();
//        book.setIdBook(1L);
//        book.setTitle("example book");
//        book.setRelaseDate(new Date(2015-01-01));
//        book.setRelase(150);
//        BookDB.add(book);
    }

    public void addBook(Book book) {
        Book newBook = new Book();

        newBook.setTitle(book.getTitle());
        newBook.setRelaseDate(book.getRelaseDate());
        newBook.setRelase(book.getRelase());

        if (BookDB.size() > 0) {
            newBook.setIdBook(BookDB.get(BookDB.size() - 1).getIdBook() + 1);
        } else {
            newBook.setIdBook(1L);
        }

        BookDB.add(newBook);
    }

    public void deleteBook(Book book) {
        BookDB.remove(book);
    }

    public List<Book> getAllBooks() {
        return BookDB;
    }

    public void updateBook(Book book) {

        for (Book b : getAllBooks()) {
            if (b.getIdBook() == book.getIdBook())
            {
                b = book;

                break;
            }
        }
    }

}
