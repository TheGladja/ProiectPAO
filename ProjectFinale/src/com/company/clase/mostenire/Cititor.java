package com.company.clase.mostenire;

import com.company.clase.Persoana;
import com.company.clase.enumerari.TipCarte;
import com.company.clase.enumerari.TipPersoana;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public List<Cititor> Read(){
        Scanner input = new Scanner(System.in);

        List<Cititor> cititori = new ArrayList<Cititor>();

        TipCarte preferinta = TipCarte.COMEDIE;
        TipPersoana tip;
        String nume, prenume;
        int nr_cititori, task, varsta;

        while (true) {
            System.out.print("\nIntroduceti numarul de cititori ai acestei carti: ");
            try {
                nr_cititori = Integer.parseInt(input.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Trebuie introdus un integer nu un string!!!");
            }
        }

        for(int i = 1; i <= nr_cititori; i++)
        {
            System.out.println("\nCititorul cu numarul " + i);

            while (true) {
                System.out.print("Introduceti numarul din dreptul preferintei cititorului [1: Horror, 2: Drama, 3: Comedie]: ");
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
                    preferinta = TipCarte.HORROR;
                    break;
                }
                case 2:
                {
                    preferinta = TipCarte.DRAMA;
                    break;
                }
                case 3: {
                    preferinta = TipCarte.COMEDIE;
                    break;
                }
                default:
                    System.out.println("Nu ati introdus un numar dintre cele 3");
            }

            System.out.print("Introduceti numele cititorului: ");
            nume = input.next();

            System.out.print("Introduceti prenumele cititorului: ");
            prenume = input.next();

            input.nextLine();

            while (true) {
                System.out.print("Introduceti varsta cititorului: ");
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

            Cititor cititor = new Cititor(preferinta, tip, nume, prenume, varsta);
            cititori.add(cititor);

            System.out.println("\n");
            System.out.println(cititor.toString());
            System.out.println("\n");
        }

        return cititori;
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
