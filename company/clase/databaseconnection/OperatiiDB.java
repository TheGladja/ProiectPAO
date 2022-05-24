package com.company.clase.databaseconnection;
import com.company.clase.audit.Audit;

import java.io.IOException;
import java.util.Scanner;

public class OperatiiDB {
    public static void main(String[] args) {
        Audit a = new Audit();
        Scanner input = new Scanner(System.in);

        AutorRepositoryPreparedStatement autorRepositoryPreparedStatement = new AutorRepositoryPreparedStatement();
        autorRepositoryPreparedStatement.createAutorTable();

        CarteRepositoryPreparedStatement carteRepositoryPreparedStatement = new CarteRepositoryPreparedStatement();
        carteRepositoryPreparedStatement.createCarteTable();

        CititorRepositoryPreparedStatement cititorRepositoryPreparedStatement = new CititorRepositoryPreparedStatement();
        cititorRepositoryPreparedStatement.createCititorTable();

        int task = 1;

        while(task > 0 && task < 17) {

            System.out.println("1 - Afisarea numarului de cititori in functie de preferinta selectata");
            System.out.println("2 - Afisarea cartii dupa un id dat");
            System.out.println("3 - Afisarea cartii dupa un titlu dat");
            System.out.println("4 - Afisarea autorului dupa un id dat");
            System.out.println("5 - Stergerea unei carti dupa un id dat");
            System.out.println("6 - Stergerea unei carti dupa un nume dat");
            System.out.println("7 - Sortarea cartilor dupa anul publicatiei");
            System.out.println("8 - Sortarea cartilor dupa pret");
            System.out.println("9 - Afisarea cititorilor unei carti cu un id dat");
            System.out.println("10 - Afisarea autorilor");
            System.out.println("11 - Afisarea cartilor");
            System.out.println("12 - Adaugarea unei carti");
            System.out.println("13 - Adaugarea unui autor");
            System.out.println("14 - Sortarea autorilor dupa rating");
            System.out.println("15 - Sortarea autorilor dupa varsta");
            System.out.println("16 - Stergerea unui autor dupa un id dat");
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
                        a.Imprimare("getNrCititoriDupaPreferinta");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    int numar_selectat;
                    String preferinta = "COMEDIE";
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
                        preferinta = "HORROR";
                    else if(numar_selectat == 2)
                        preferinta = "DRAMA";

                    System.out.print("\nNumarul de cititori cu preferinta " + preferinta + " este ");
                    System.out.println(cititorRepositoryPreparedStatement.getNrCititoriDupaPreferinta(preferinta));
                    System.out.println("\n");
                    break;
                }
                case 2: {
                    try {
                        a.Imprimare("afiseazaCarteDupaID");
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
                    carteRepositoryPreparedStatement.afiseazaCarteDupaID(id);
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

                    input.nextLine();

                    System.out.print("\nCartea cu titlul " + titlu + " este ");
                    carteRepositoryPreparedStatement.afiseazaCarteDupaTitlu(titlu);
                    System.out.println("\n");
                    break;
                }
                case 4: {
                    try {
                        a.Imprimare("afiseazaAutorDupaID");
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
                    autorRepositoryPreparedStatement.afiseazaAutorDupaID(id);
                    System.out.println("\n");
                    break;
                }
                case 5: {
                    try {
                        a.Imprimare("deleteCarte");
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

                    carteRepositoryPreparedStatement.deleteCarte(id);
                    System.out.println("\n");
                    break;
                }
                case 6: {
                    try {
                        a.Imprimare("deleteCarteDupaTitlu");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    String titlu;

                    System.out.print("Introdueti titlul cartii: ");
                    titlu = input.next();

                    input.nextLine();

                    carteRepositoryPreparedStatement.deleteCarteDupaTitlu(titlu);
                    System.out.println("\n");
                    break;
                }
                case 7: {
                    try {
                        a.Imprimare("sorteazaCarteDupaAn");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    carteRepositoryPreparedStatement.sorteazaCarteDupaAn();
                    System.out.println("\n");
                    break;
                }
                case 8: {
                    try {
                        a.Imprimare("sorteazaCarteDupaAn");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    carteRepositoryPreparedStatement.sorteazaCarteDupaAn();
                    System.out.println("\n");
                    break;
                }
                case 9: {
                    try {
                        a.Imprimare("afiseazaCititoriDupaIdCarte");
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

                    System.out.println();
                    cititorRepositoryPreparedStatement.afiseazaCititoriDupaIdCarte(id);
                    System.out.println("\n");
                    break;
                }
                case 10: {
                    try {
                        a.Imprimare("displayAutori");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    autorRepositoryPreparedStatement.displayAutori();
                    System.out.println("\n");
                    break;
                }
                case 11: {
                    try {
                        a.Imprimare("displayCarti");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    carteRepositoryPreparedStatement.displayCarti();
                    System.out.println("\n");
                    break;
                }
                case 12: {
                    try {
                        a.Imprimare("addCarte");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if(autorRepositoryPreparedStatement.getNumarAutori() > 0)
                    {
                        System.out.println("\n");
                        carteRepositoryPreparedStatement.addCarte();
                        System.out.println("\n");
                    }
                    else
                        System.out.println("\nLista autorilor este goala! Trebuie sa adaugati un autor inainte de a adauga o carte\n");
                    break;
                }
                case 13: {
                    try {
                        a.Imprimare("addAutor");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    System.out.println("\n");
                    autorRepositoryPreparedStatement.addAutor();
                    System.out.println("\n");
                    break;
                }
                case 14: {
                    try {
                        a.Imprimare("sorteazaAutorDupaRating");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    autorRepositoryPreparedStatement.sorteazaAutorDupaRating();
                    System.out.println("\n");
                    break;
                }
                case 15: {
                    try {
                        a.Imprimare("sorteazaAutorDupaVarsta");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    autorRepositoryPreparedStatement.sorteazaAutorDupaVarsta();
                    System.out.println("\n");
                    break;
                }
                case 16: {
                    try {
                        a.Imprimare("deleteAutor");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    int id;

                    while (true) {

                        System.out.print("Introduceti id-ul autorului pe care vreti sa il stergeti: ");
                        try {
                            id = Integer.parseInt(input.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.println("Trebuie introdus un integer nu un string!!!");
                        }
                    }

                    autorRepositoryPreparedStatement.deleteAutor(id);
                    System.out.println("\n");
                    break;
                }
            }
            }

        try {
            a.Imprimare("Oprirea programului");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nAti oprit programul cu succes!!!");

        DatabaseConnection.closeDatabaseConfiguration();
    }
}
