package com.company.clase.mostenire;

import com.company.clase.Persoana;
import com.company.clase.enumerari.TipCarte;
import com.company.clase.enumerari.TipPersoana;

public class Cititor extends Persoana {
    private TipCarte preferinta;

    public Cititor(){}
    public Cititor(TipCarte preferinta,TipPersoana tip, String nume, String prenume, int varsta){
        this.preferinta = preferinta;
        this.tip = tip;
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
    }

    public TipCarte getPreferinta(){
        return preferinta;
    }

    public void setPreferinta(TipCarte preferinta){
        this.preferinta = preferinta;
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
        return "Cititorul: [Preferinta: " + preferinta + ", Tip: " + tip + ", Nume: " + nume + ", Prenume: " + prenume + ", Varsta: " + varsta + "]";
    }

}
