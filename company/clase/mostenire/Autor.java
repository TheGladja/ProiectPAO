package com.company.clase.mostenire;

import com.company.clase.Persoana;
import com.company.clase.enumerari.TipCarte;
import com.company.clase.enumerari.TipPersoana;

public class Autor extends Persoana {
    private TipCarte stil;
    private int rating;

    public Autor(){}
    public Autor(TipCarte stil, int rating, TipPersoana tip, String nume, String prenume, int varsta){
        ct += 1;
        this.id = ct;
        this.stil = stil;
        this.rating = rating;
        this.tip = tip;
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
    }

    public TipCarte getStil(){
        return stil;
    }

    public void setStil(TipCarte stil){
        this.stil = stil;
    }

    public int getRating(){
        return rating;
    }

    public void setRating(int rating){
        this.rating = rating;
    }

    public int getId(){
        return id;
    }

    @Override
    public TipPersoana getTip() {
        return tip;
    }

    @Override
    public void setTip(TipPersoana tip) {
        this.tip = tip;
    }

    @Override
    public String getNume() {
        return nume;
    }

    @Override
    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public String getPrenume() {
        return prenume;
    }

    @Override
    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    @Override
    public int getVarsta() {
        return varsta;
    }

    @Override
    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    @Override
    public String toString(){
        return "Autorul: [#ID: " + id + ", Stil: " + stil + ", Rating: " + rating + ", Tip: " + tip + ", Nume: " + nume + ", Prenume: " + prenume + ", Varsta: " + varsta + "]";
    }

    public String toCSV(){
        return id + ", " + rating + ", " + nume + ", " + prenume + ", " + varsta;
    }

}
