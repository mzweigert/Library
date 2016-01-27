package com.library.service;

import com.library.domain.Reader;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class ReaderManager {

    private List<Reader> ReaderDB = new ArrayList<Reader>();

    public ReaderManager() {

        //Seeding
        Reader newReader = new Reader();
        newReader.setIdReader(1L);
        newReader.setName("Mateusz");
        newReader.setSurname("Zweigert");
        newReader.setJoinDate(java.sql.Date.valueOf("2015-01-01"));
        ReaderDB.add(newReader);
    }

    public void addReader(Reader reader) {
        Reader newReader = new Reader();

        newReader.setName(reader.getName());
        newReader.setSurname(reader.getSurname());
        newReader.setJoinDate(reader.getJoinDate());

        if (ReaderDB.size() > 0) {
            newReader.setIdReader(ReaderDB.get(ReaderDB.size() - 1).getIdReader() + 1);
        }
        else {
            newReader.setIdReader(1L);
        }

        ReaderDB.add(newReader);
    }

    public void deleteReader(Reader reader) {
        ReaderDB.remove(reader);
    }

    public List<Reader> getAllReaders() {
        return ReaderDB;
    }

    public void updateReader(Reader reader) {

        for (Reader r : getAllReaders()) {
            if (r.getIdReader() == reader.getIdReader()) {
                r = reader;

                break;
            }
        }
    }

}
