package com.company;

import com.company.clase.ServiciuCarte;
import com.company.clase.Carte;
import com.company.clase.audit.Audit;
import com.company.clase.enumerari.TipCarte;
import com.company.clase.mostenire.Autor;
import com.company.clase.singleton.SingletonAutor;
import com.company.clase.singleton.SingletonCarte;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Audit a = new Audit();
        Scanner input = new Scanner(System.in);
        ServiciuCarte act = new ServiciuCarte();

        List<Carte> carti = new ArrayList<Carte>();
        List<Autor> autori = new ArrayList<Autor>();

        SingletonAutor sa = new SingletonAutor();
        sa.transmiteCSVautor();

        autori = sa.getAutori();

        SingletonCarte sc = new SingletonCarte();
        sc.transmiteCSVcarte(autori);

        carti = sc.getCarti();

        int task = 1;

        while(task > 0 && task < 16) {

            System.out.println("1 - Afisarea numarului de cititori dupa genul cartii");
            System.out.println("2 - Afisarea cartii dupa un id dat");
            System.out.println("3 - Afisarea cartii dupa un titlu dat");
            //System.out.println("4 - Afisarea autorului dupa un id dat");
            System.out.println("5 - Stergerea unei carti dupa un id dat");
            System.out.println("6 - Stergerea unei carti dupa un nume dat");
            System.out.println("7 - Sortarea cartilor dupa anul publicatiei");
            System.out.println("8 - Sortarea cartilor dupa pret");
            System.out.println("9 - Afisarea cititorilor unei carti cu un id dat");
            //System.out.println("10 - Afisarea autorilor");
            System.out.println("11 - Afisarea cartilor");
            System.out.println("12 - Adaugarea unei carti");
            //System.out.println("13 - Adaugarea unui autor");
            //System.out.println("14 - Sortarea autorilor dupa rating");
            //System.out.println("15 - Sortarea autorilor dupa varsta");
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
                    try {
                        a.Imprimare("nrCititoriDupaPreferinta");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    int numar_selectat;
                    TipCarte tc;
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
                    try {
                        a.Imprimare("afiseazaCarteDupaId");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

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
                    try {
                        a.Imprimare("afiseazaCarteDupaTitlu");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    String titlu;

                    System.out.print("Introdueti titlul cartii: ");
                    titlu = input.next();

                    System.out.print("\nCartea cu titlul " + titlu + " este ");
                    act.afiseazaCarteDupaTitlu(carti, titlu);
                    System.out.println("\n");
                    break;
                }
                case 4: {
                    try {
                        a.Imprimare("afiseazaAutorDupaId");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

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
                    try {
                        a.Imprimare("StergeCarteDupaId");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

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
                    try {
                        a.Imprimare("stergeCarteDupaTitlu");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    String titlu;

                    System.out.print("Introdueti titlul cartii: ");
                    titlu = input.next();

                    input.nextLine();

                    act.stergeCarteDupaTitlu(carti, titlu);
                    System.out.println("\n");
                    break;
                }
                case 7: {
                    try {
                        a.Imprimare("sorteazaCarteDupaAn");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    act.sorteazaCarteDupaAn(carti);
                    System.out.println("\n");
                    break;
                }
                case 8: {
                    try {
                        a.Imprimare("sorteazaCarteDupaPret");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    act.sorteazaCarteDupaPret(carti);
                    System.out.println("\n");
                    break;
                }
                case 9: {
                    try {
                        a.Imprimare("afiseazaCititoriCarteDupaId");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

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
                    try {
                        a.Imprimare("afiseazaAutori");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    act.afiseazaAutori(autori);
                    System.out.println("\n");
                    break;
                }
                case 11: {
                    try {
                        a.Imprimare("afiseazaCarti");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    act.afiseazaCarti(carti);
                    System.out.println("\n");
                    break;
                }
                case 12: {
                    try {
                        a.Imprimare("ReadSingleCarte");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    System.out.println("\n");
                    carti.add(act.ReadSingleCarte(autori));
                    System.out.println("\n");
                    break;
                }
                case 13: {
                    try {
                        a.Imprimare("ReadSingleAutor");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    System.out.println("\n");
                    autori.add(act.ReadSingleAutor());
                    System.out.println("\n");
                    break;
                }
                case 14: {
                    try {
                        a.Imprimare("sorteazaAutorDupaRating");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    act.sorteazaAutorDupaRating(autori);
                    System.out.println("\n");
                    break;
                }
                case 15: {
                    try {
                        a.Imprimare("sorteazaAutorDupaVarsta");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    act.sorteazaAutorDupaVarsta(autori);
                    System.out.println("\n");
                    break;
                }
            }
        }

        sa.ScrieAutoriCSV();
        sc.ScrieCartiCSV();

        try {
            a.Imprimare("Oprire program");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
