package com.library.web;

import com.library.domain.Book;
import com.library.service.BookManager;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named("bookBean")
@SessionScoped
public class BookFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Book book = new Book();

	private ListDataModel<Book> books = new ListDataModel<Book>();

	@Inject
	private BookManager pm;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String resetBook() {
		this.book = new Book();

		return null;
	}

	public String loadBook() {
		for (Book p : pm.getAllBooks()) {
			if (p.getIdBook() == getId()) {
				this.book = p;
				break;
			}
		}

		return null;
	}

	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}

	public ListDataModel<Book> getAllBooks() {
		books.setWrappedData(pm.getAllBooks());
		return books;
	}

	// Actions
	public String addBook() {
		pm.addBook(book);
		return "showBooks";
	}

	public String deleteBook() {
		Book bookToDelete = books.getRowData();
		pm.deleteBook(bookToDelete);
		return null;
	}

	public String updateBook() {
		pm.updateBook(book);
		return "showBooks";
	}
}
