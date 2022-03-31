package com.company;

import com.company.clase.Actiuni;
import com.company.clase.Carte;
import com.company.clase.enumerari.TipCarte;
import com.company.clase.interfata.ICarte;
import com.company.clase.mostenire.Autor;
import com.company.clase.mostenire.Cititor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Actiuni act = new Actiuni();
        Autor a = new Autor();
        Carte c = new Carte();
        List<Carte> carti = new ArrayList<Carte>();
        List<Autor> autori = new ArrayList<Autor>();

        autori = a.Read();
        carti = c.Read(autori);

        int task = 1;

        while(task > 0 && task < 14) {

            System.out.println("1 - Afisarea numarului de cititori dupa genul cartii");
            System.out.println("2 - Afisarea cartii dupa un id dat");
            System.out.println("3 - Afisarea cartii dupa un titlu dat");
            System.out.println("4 - Afisarea autorului dupa un id dat");
            System.out.println("5 - Stergerea unei carti dupa un id dat");
            System.out.println("6 - Stergerea unei carti dupa un nume dat");
            System.out.println("7 - Sortarea cartilor dupa anul publicatiei");
            System.out.println("8 - Sortarea cartilor dupa pret");
            System.out.println("9 - Afisarea cititorilor unei carti un id dat");
            System.out.println("10 - Afisarea autorilor");
            System.out.println("11 - Afisarea cartilor");
            System.out.println("12 - Adaugarea unei carti");
            System.out.println("13 - Adaugarea unui autor");
            System.out.println("Orice alt numar pentru oprirea programului");

            while (true) {
                System.out.print("\nIntroduceti numarul operatiei: ");
                try {
                    task = Integer.parseInt(input.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Trebuie introdus un integer nu un string!!!");
                }
            }

            switch (task) {
                case 1: {
                    int numar_selectat;
                    TipCarte tc = TipCarte.HORROR;
                    while (true) {
                        System.out.print("Introduceti numarul din dreptul preferintei cititorului [1: Horror, 2: Drama, 3: Comedie]: ");
                        try {
                            numar_selectat = Integer.parseInt(input.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.println("Trebuie introdus un integer nu un string!!!");
                        }
                    }
                    if(numar_selectat == 1)
                        tc = TipCarte.HORROR;
                    else if(numar_selectat == 2)
                        tc = TipCarte.DRAMA;
                    else
                        tc = TipCarte.COMEDIE;

                    System.out.print("\nNumarul de cititori cu preferinta " + tc + " este ");
                    System.out.println(act.nrCititoriDupaPreferinta(carti, tc));
                    System.out.println("\n");
                    break;
                }
                case 2: {
                    int id;

                    while (true) {

                        System.out.print("Introduceti id-ul cartii pe care vreti sa o afisati: ");
                        try {
                            id = Integer.parseInt(input.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.println("Trebuie introdus un integer nu un string!!!");
                        }
                    }

                    System.out.print("\nCartea cu id-ul " + id + " este ");
                    act.afiseazaCarteDupaId(carti,id);
                    System.out.println("\n");
                    break;
                }
                case 3: {
                    String titlu;

                    System.out.print("Introdueti titlul cartii: ");
                    titlu = input.next();

                    System.out.print("\nCartea cu titlul " + titlu + " este ");
                    act.afiseazaCarteDupaTitlu(carti, titlu);
                    System.out.println("\n");
                    break;
                }
                case 4: {
                    int id;

                    while (true) {

                        System.out.print("Introduceti id-ul autorului pe care vreti sa il afisati: ");
                        try {
                            id = Integer.parseInt(input.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.println("Trebuie introdus un integer nu un string!!!");
                        }
                    }

                    System.out.print("\nAutorul cu id-ul " + id + " este ");
                    act.afiseazaAutorDupaId(autori, id);
                    System.out.println("\n");
                    break;
                }
                case 5: {
                    int id;

                    while (true) {

                        System.out.print("Introduceti id-ul cartii pe care vreti sa o stergeti: ");
                        try {
                            id = Integer.parseInt(input.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.println("Trebuie introdus un integer nu un string!!!");
                        }
                    }

                    act.stergeCarteDupaId(carti, id);
                    System.out.println("\n");
                    break;
                }
                case 6: {
                    String titlu;

                    System.out.print("Introdueti titlul cartii: ");
                    titlu = input.next();

                    act.stergeCarteDupaTitlu(carti, titlu);
                    System.out.println("\n");
                    break;
                }
                case 7: {
                    act.sorteazaCarteDupaAn(carti);
                    System.out.println("\n");
                    break;
                }
                case 8: {
                    act.sorteazaCarteDupaAn(carti);
                    System.out.println("\n");
                    break;
                }
                case 9: {
                    int id;

                    while (true) {

                        System.out.print("Introduceti id-ul cartii: ");
                        try {
                            id = Integer.parseInt(input.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.println("Trebuie introdus un integer nu un string!!!");
                        }
                    }

                    act.afiseazaCititoriCarteDupaId(carti, id);
                    System.out.println("\n");
                    break;
                }
                case 10: {
                    act.afiseazaAutori(autori);
                    System.out.println("\n");
                    break;
                }
                case 11: {
                    act.afiseazaCarti(carti);
                    System.out.println("\n");
                    break;
                }
                case 12: {
                    System.out.println("\n");
                    carti.add(c.ReadSingle(autori));
                    System.out.println("\n");
                    break;
                }
                case 13: {
                    System.out.println("\n");
                    autori.add(a.ReadSingle());
                    System.out.println("\n");
                    break;
                }
            }
        }
    }
}
