package com.library.domain;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Reader implements Serializable
{

    private long idReader;

    private String name;
    private String surname;
    private Date joinDate;

    private List<Hiring> hirings;

    public Reader()
    {

    }

    public Reader(String name, String surname, Date joinDate)
    {

        this.name = name;
        this.surname = surname;
        this.joinDate = joinDate;
    }


    public String getName()
    {
        return name;
    }
    @Size(min = 3, max = 10)
    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }
    @Size(min = 3, max = 10)
    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public Date getJoinDate()
    {
        return joinDate;
    }

    public void setJoinDate(Date joinDate)
    {
        this.joinDate = joinDate;
    }

    public long getIdReader()
    {
        return idReader;
    }

    public void setIdReader(long idReader)
    {
        this.idReader = idReader;
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
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Reader)) return false;

        Reader reader = (Reader) o;

        if (getIdReader() != reader.getIdReader()) return false;
        if (!getName().equals(reader.getName())) return false;
        if (!getSurname().equals(reader.getSurname())) return false;
        return (getJoinDate().equals(reader.getJoinDate()));

    }
}
