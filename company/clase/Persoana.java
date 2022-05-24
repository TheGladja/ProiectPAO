package com.company.clase;

import com.company.clase.enumerari.TipPersoana;

public abstract class Persoana {
    protected TipPersoana tip;
    protected String nume, prenume;
    protected int varsta, id;
    protected static int ct = 0;

    public Persoana(){}
    public Persoana(TipPersoana tip, String nume, String prenume, int varsta){
        ct += 1;
        this.id = id;
        this.tip = tip;
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
    }

    public abstract TipPersoana getTip();
    public abstract void setTip(TipPersoana tip);

    public abstract String getNume();
    public abstract void setNume(String nume);

    public abstract String getPrenume();
    public abstract void setPrenume(String prenume);

    public abstract int getVarsta();
    public abstract void setVarsta(int varsta);

    @Override
    public String toString(){
        return "[Tip: " + tip + ", Nume: " + nume + ", Prenume: " + prenume + ", Varsta: " + varsta + "]";
    }
}
