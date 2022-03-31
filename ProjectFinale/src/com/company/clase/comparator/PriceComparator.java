package com.company.clase.comparator;

import com.company.clase.Carte;

import java.util.Comparator;

public class PriceComparator implements Comparator<Carte> {
    @Override
    public int compare(Carte x, Carte y){
        if(x.getPret() > y.getPret())
            return 1;
        return -1;
    }
}
