package com.company.clase.interfata;

import com.company.clase.Carte;
import com.company.clase.enumerari.TipCarte;
import com.company.clase.mostenire.Autor;

import java.util.List;

public interface ICarte {
    int nrCititoriDupaPreferinta(List<Carte> carti, TipCarte tipCarte);
    Carte getCarteDupaId(List<Carte> carti, int id);
    void afiseazaCarteDupaId(List<Carte> carti, int id);
    void afiseazaCarteDupaTitlu(List<Carte> carti, String titlu);
    Carte getCarteDupaTitlu(List<Carte> carti, String titlu);
    void afiseazaAutorDupaId(List<Autor> autori, int id);
    void stergeCarteDupaId(List<Carte> carti, int id);
    void stergeCarteDupaTitlu(List<Carte> carti, String titlu);
    void sorteazaCarteDupaAn(List<Carte> carti);
    void sorteazaCarteDupaPret(List<Carte> carti);
    void afiseazaCititoriCarteDupaId(List<Carte> carti, int id);
    void afiseazaAutori(List<Autor> autori);
    void afiseazaCarti(List<Carte> carti);
}
