package com.library.service;

import com.library.domain.Hiring;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class HiringManager {

    private List<Hiring> HiringDB = new ArrayList<Hiring>();

    public void addHiring(Hiring hiring) {
        Hiring newHiring = new Hiring();

        newHiring.setBook(hiring.getBook());
        newHiring.setReader(hiring.getReader());
        newHiring.setHireDate(hiring.getHireDate());

        newHiring.setIdBook(hiring.getIdBook());
        newHiring.setIdReader(hiring.getIdReader());

        if (HiringDB.size() > 0) {
            newHiring.setIdHiring(HiringDB.get(HiringDB.size() - 1).getIdHiring() + 1);
        }
        else {
            newHiring.setIdHiring(1L);
        }

        HiringDB.add(newHiring);
    }

    public void deleteHiring(Hiring hiring) {
        HiringDB.remove(hiring);
    }

    public List<Hiring> getAllHirings() {
        return HiringDB;
    }

    public void updateHiring(Hiring hiring) {

        for (Hiring h : getAllHirings()) {
            if (h.getIdHiring() == hiring.getIdHiring()) {
                h = hiring;

                break;
            }
        }
    }

}
