package com.company.clase.comparator;

import com.company.clase.Carte;

import java.util.Comparator;

public class ComparatorAn implements Comparator<Carte> {
    @Override
    public int compare(Carte x, Carte y){
        if(x.getAn_publicatie() > y.getAn_publicatie())
            return 1;
        return -1;
    }
}
