package com.company.clase.mostenire;

import com.company.clase.Persoana;
import com.company.clase.enumerari.TipCarte;
import com.company.clase.enumerari.TipPersoana;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public Autor ReadSingle(){
        Scanner input = new Scanner(System.in);

        TipCarte stil = TipCarte.COMEDIE;
        TipPersoana tip;
        String nume, prenume;
        int task, varsta, rating;

            while (true) {
                System.out.print("Introduceti numarul din dreptul stilului autorului [1: Horror, 2: Drama, 3: Comedie]: ");
                try {
                    task = Integer.parseInt(input.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Trebuie introdus un integer nu un string!!!");
                }
            }
            switch (task){
                case 1:
                {
                    stil = TipCarte.HORROR;
                    break;
                }
                case 2:
                {
                    stil = TipCarte.DRAMA;
                    break;
                }
                case 3: {
                    stil = TipCarte.COMEDIE;
                    break;
                }
            }

            while (true) {
                System.out.print("Introduceti ratingul autorului (intre 0 si 10): ");
                try {
                    rating = Integer.parseInt(input.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Trebuie introdus un integer nu un string!!!");
                }
            }

            System.out.print("Introduceti numele autorului: ");
            nume = input.next();

            System.out.print("Introduceti prenumele autorului: ");
            prenume = input.next();

            input.nextLine();

            while (true) {
                System.out.print("Introduceti varsta autorului: ");
                try {
                    varsta = Integer.parseInt(input.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Trebuie introdus un integer nu un string!!!");
                }
            }

            if(varsta < 18)
                tip = TipPersoana.COPIL;
            else if(varsta > 17 && varsta < 25)
                tip = TipPersoana.ADOLESCENT;
            else
                tip = TipPersoana.ADULT;

            Autor autor = new Autor(stil, rating, tip, nume, prenume, varsta);

            System.out.println("\n");
            System.out.println(autor.toString());
            System.out.println("\n");

        return autor;
    }

    public List<Autor> Read(){
        Scanner input = new Scanner(System.in);

        List<Autor> autori = new ArrayList<Autor>();

        TipCarte stil = TipCarte.COMEDIE;
        TipPersoana tip;
        String nume, prenume;
        int nr_autori, task, varsta, rating;

        while (true) {
            System.out.print("Introduceti numarul de autori: ");
            try {
                nr_autori = Integer.parseInt(input.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Trebuie introdus un integer nu un string!!!");
            }
        }

        for(int i = 1; i <= nr_autori; i++)
        {
            System.out.println("\nAutorul cu numarul " + i);

            while (true) {
                System.out.print("Introduceti numarul din dreptul stilului autorului [1: Horror, 2: Drama, 3: Comedie]: ");
                try {
                    task = Integer.parseInt(input.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Trebuie introdus un integer nu un string!!!");
                }
            }
            switch (task){
                case 1:
                {
                    stil = TipCarte.HORROR;
                    break;
                }
                case 2:
                {
                    stil = TipCarte.DRAMA;
                    break;
                }
                case 3: {
                    stil = TipCarte.COMEDIE;
                    break;
                }
            }

            while (true) {
                System.out.print("Introduceti ratingul autorului (intre 0 si 10): ");
                try {
                    rating = Integer.parseInt(input.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Trebuie introdus un integer nu un string!!!");
                }
            }

            System.out.print("Introduceti numele autorului: ");
            nume = input.next();

            System.out.print("Introduceti prenumele autorului: ");
            prenume = input.next();

            input.nextLine();

            while (true) {
                System.out.print("Introduceti varsta autorului: ");
                try {
                    varsta = Integer.parseInt(input.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Trebuie introdus un integer nu un string!!!");
                }
            }

            if(varsta < 18)
                tip = TipPersoana.COPIL;
            else if(varsta > 17 && varsta < 25)
                tip = TipPersoana.ADOLESCENT;
            else
                tip = TipPersoana.ADULT;

            Autor autor = new Autor(stil, rating, tip, nume, prenume, varsta);
            autori.add(autor);

            System.out.println("\n");
            System.out.println(autor.toString());
            System.out.println("\n");
        }

        return autori;
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

}
