package com.company.clase;

import com.company.clase.comparator.ComparatorAn;
import com.company.clase.comparator.PriceComparator;
import com.company.clase.enumerari.TipCarte;
import com.company.clase.interfata.ICarte;
import com.company.clase.mostenire.Autor;
import com.company.clase.mostenire.Cititor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Actiuni implements ICarte {

    @Override
    public int nrCititoriDupaPreferinta(List<Carte> carti,TipCarte tipCarte) {
        int nr_cititori = 0;

        for(Carte carte : carti)
            for(Cititor cititor : carte.getCicitori())
                if(cititor.getPreferinta() == tipCarte)
                    nr_cititori++;

        return nr_cititori;
    }

    @Override
    public Carte getCarteDupaId(List<Carte> carti, int id){
        for(Carte carte : carti)
            if(carte.getId() == id)
                return carte;
        return null;
    }

    @Override
    public void afiseazaCarteDupaId(List<Carte> carti, int id) {
        for(Carte carte : carti)
            if(carte.getId() == id)
            {
                System.out.println(carte.toString());
                break;
            }
    }

    @Override
    public Carte getCarteDupaTitlu(List<Carte> carti, String titlu){
        for(Carte carte : carti)
            if(carte.getTitlu().equals(titlu))
                return carte;
        return null;
    }

    @Override
    public void afiseazaCarteDupaTitlu(List<Carte> carti, String titlu) {
        for(Carte carte : carti)
            if(carte.getTitlu().equals(titlu))
            {
                System.out.println(carte.toString());
                break;
            }
    }

    @Override
    public void afiseazaAutorDupaId(List<Autor> autori, int id) {
        for(Autor autor : autori)
            if(autor.getId() == id)
            {
                System.out.println(autor.toString());
                break;
            }
    }

    @Override
    public void stergeCarteDupaId(List<Carte> carti, int id) {
        carti.remove(getCarteDupaId(carti, id));
    }

    @Override
    public void stergeCarteDupaTitlu(List<Carte> carti, String titlu) {
        carti.remove(getCarteDupaTitlu(carti, titlu));
    }

    @Override
    public void sorteazaCarteDupaAn(List<Carte> carti) {
        Collections.sort(carti, new ComparatorAn());
    }

    @Override
    public void sorteazaCarteDupaPret(List<Carte> carti) {
        Collections.sort(carti, new PriceComparator());
    }

    @Override
    public void afiseazaCititoriCarteDupaId(List<Carte> carti, int id) {
        for(Carte carte : carti)
            if(carte.getId() == id)
            {
                for(Cititor cititor : carte.getCicitori())
                    System.out.println(cititor.toString());
                break;
            }
    }

    @Override
    public void afiseazaAutori(List<Autor> autori) {
        for(Autor autor : autori)
            System.out.println(autor.toString());
    }

    @Override
    public void afiseazaCarti(List<Carte> carti) {
        for(Carte carte : carti)
            System.out.println(carte.toString());
    }
}
