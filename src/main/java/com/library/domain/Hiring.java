package com.library.domain;

import java.io.Serializable;
import java.sql.Date;

public class Hiring implements Serializable
{


    private long idHiring;

    private Book book;
    private Reader reader;
    private Date hireDate;

    private Long idBook;
    private Long idReader;


    public Hiring()
    {
    }

    public Hiring(Book book, Reader reader, Date hireDate)
    {
        super();
        this.book = book;
        this.reader = reader;
        this.hireDate = hireDate;
    }

    public Book getBook()
    {
        return book;
    }

    public void setBook(Book book)
    {
        this.book = book;
    }

    public Reader getReader()
    {
        return reader;
    }

    public void setReader(Reader reader)
    {
        this.reader = reader;
    }

    public Date getHireDate()
    {
        return hireDate;
    }

    public void setHireDate(Date hireDate)
    {
        this.hireDate = hireDate;
    }

    public long getIdHiring()
    {
        return idHiring;
    }

    public void setIdHiring(long idHiring)
    {
        this.idHiring = idHiring;
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public Long getIdReader() {
        return idReader;
    }

    public void setIdReader(Long idReader) {
        this.idReader = idReader;
    }

    @Override
    public String toString()
    {
        return "Hiring{" +
                "idHiring=" + idHiring +
                ", book=" + book +
                ", reader=" + reader +
                ", hireDate=" + hireDate +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Hiring)) return false;

        Hiring hiring = (Hiring) o;

        if (getIdHiring() != hiring.getIdHiring()) return false;
        if (!getBook().equals(hiring.getBook())) return false;
        if (!getReader().equals(hiring.getReader())) return false;
        return getHireDate().equals(hiring.getHireDate());

    }
}
