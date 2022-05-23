package com.company.clase;

import com.company.clase.mostenire.Autor;
import com.company.clase.mostenire.Cititor;

import java.util.ArrayList;
import java.util.List;

public class Carte {
    private List<Cititor> cicitori = new ArrayList<Cititor>();
    private Autor autor;
    private String titlu;
    private int an_publicatie, pret, id;
    private static int ct = 0;

    public Carte(){}
    public Carte(List<Cititor> cititori, Autor autor, String titlu, int an_publicatie, int pret){
        ct += 1;
        this.id = ct;
        this.cicitori = cititori;
        this.autor = autor;
        this.titlu = titlu;
        this.an_publicatie = an_publicatie;
        this.pret = pret;
    }

    public List<Cititor> getCicitori(){
        return cicitori;
    }

    public void setCicitori(List<Cititor> cicitori){
        this.cicitori = cicitori;
    }

    public Autor getAutor(){
        return autor;
    }

    public void setAutor(Autor autor){
        this.autor = autor;
    }

    public String getTitlu(){
        return titlu;
    }

    public void setTitlu(String titlu){
        this.titlu = titlu;
    }

    public int getAn_publicatie(){
        return an_publicatie;
    }

    public void setAn_publicatie(int an_publicatie){
        this.an_publicatie = an_publicatie;
    }

    public int getPret(){
        return pret;
    }

    public void setPret(int pret){
        this.pret = pret;
    }

    public int getId(){
        return id;
    }

    @Override
    public String toString(){
        return "Cartea: [#Id: " + id + ", Autor: " + autor.getNume() + " " + autor.getPrenume() + ", Titlu: " + titlu + ", An publicatie: " + an_publicatie + ", Pret: " + pret + "]";
    }

    public String toCSV(){
        return titlu + ", " + an_publicatie + ", " + pret;
    }
}
