package com.library.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Book implements Serializable
{

    private long idBook;

    private String title;
    private Date relaseDate;
    private int relase;

    private List<Hiring> hirings;

    public Book()
    {

    }

    public Book(String title, Date relaseDate, int relase)
    {
        super();
        this.title = title;
        this.relaseDate = relaseDate;
        this.relase = relase;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Date getRelaseDate()
    {
        return relaseDate;
    }

    public void setRelaseDate(Date relaseDate)
    {
        this.relaseDate = relaseDate;
    }

    public int getRelase()
    {
        return relase;
    }

    public void setRelase(int relase)
    {
        this.relase = relase;
    }

    public long getIdBook()
    {
        return idBook;
    }

    public void setIdBook(long idBook)
    {
        this.idBook = idBook;
    }

    public List<Hiring> getHirings()
    {
        return hirings;
    }

    public void setHirings(List<Hiring> hirings)
    {
        this.hirings = hirings;
    }

    @Override
    public String toString()
    {
        return "Book{" +
                "idBook=" + idBook +
                ", title='" + title + '\'' +
                ", relaseDate=" + relaseDate +
                ", relase=" + relase +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (getIdBook() != book.getIdBook()) return false;
        if (getRelase() != book.getRelase()) return false;
        if (!getTitle().equals(book.getTitle())) return false;
        return  (getRelaseDate().equals(book.getRelaseDate()));


    }

}
