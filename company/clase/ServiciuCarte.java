package com.company.clase;

import com.company.clase.comparator.ComparatorAn;
import com.company.clase.comparator.PriceComparator;
import com.company.clase.enumerari.TipCarte;
import com.company.clase.enumerari.TipPersoana;
import com.company.clase.interfata.ICarte;
import com.company.clase.mostenire.Autor;
import com.company.clase.mostenire.Cititor;

import java.util.*;

public class ServiciuCarte implements ICarte {

    @Override
    public List<Carte> ReadCarte(List<Autor> autori){
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        ServiciuCarte sc = new ServiciuCarte();

        List<Carte> carti = new ArrayList<Carte>();
        List<Cititor> cititori = new ArrayList<Cititor>();
        String titlu;
        int nr_carti, an_publicatie, pret;

        while (true) {
            System.out.print("\nIntroduceti numarul de carti: ");
            try {
                nr_carti = Integer.parseInt(input.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Trebuie introdus un integer nu un string!!!");
            }
        }

        for(int i = 1; i <= nr_carti; i++)
        {
            System.out.println("\nCartea cu numarul " + i);

            System.out.print("Introduceti titlul cartii: ");
            titlu = input.next();

            input.nextLine();

            while (true) {
                System.out.print("Introduceti anul publicatiei: ");
                try {
                    an_publicatie = Integer.parseInt(input.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Trebuie introdus un integer nu un string!!!");
                }
            }

            while (true) {
                System.out.print("Introduceti pretul cartii: ");
                try {
                    pret = Integer.parseInt(input.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Trebuie introdus un integer nu un string!!!");
                }
            }

            int index = random.nextInt(autori.size());
            Autor autor = autori.get(index);

            cititori = sc.ReadCititor();

            Carte carte = new Carte(cititori, autor, titlu, an_publicatie, pret);
            carti.add(carte);

            System.out.println("\n");
            System.out.println(carte.toString());
            System.out.println("\n");
        }

        return carti;
    }

    @Override
    public Carte ReadSingleCarte(List<Autor> autori){
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        ServiciuCarte sc = new ServiciuCarte();

        Cititor c = new Cititor();
        List<Cititor> cititori = new ArrayList<Cititor>();
        String titlu;
        int an_publicatie, pret;

        System.out.print("Introduceti titlul cartii: ");
        titlu = input.next();

        input.nextLine();

        while (true) {
            System.out.print("Introduceti anul publicatiei: ");
            try {
                an_publicatie = Integer.parseInt(input.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Trebuie introdus un integer nu un string!!!");
            }
        }

        while (true) {
            System.out.print("Introduceti pretul cartii: ");
            try {
                pret = Integer.parseInt(input.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Trebuie introdus un integer nu un string!!!");
            }
        }

        int index = random.nextInt(autori.size());
        Autor autor = autori.get(index);

        cititori = sc.ReadCititor();

        Carte carte = new Carte(cititori, autor, titlu, an_publicatie, pret);

        System.out.println("\n");
        System.out.println(carte.toString());
        System.out.println("\n");

        return carte;
    }

    @Override
    public List<Autor> ReadAutor(){
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

    @Override
    public Autor ReadSingleAutor(){
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

    @Override
    public List<Cititor> ReadCititor(){
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

    @Override
    public int nrCititoriDupaPreferinta(List<Carte> carti,TipCarte tipCarte) {
        int nr_cititori = 0;

        for(Carte carte : carti)
            for(Cititor cititor : carte.getCicitori())
                if(cititor.getPreferinta() == tipCarte)
                    nr_cititori++;

        return nr_cititori;
    }

    @Override
    public Carte getCarteDupaId(List<Carte> carti, int id){
        for(Carte carte : carti)
            if(carte.getId() == id)
                return carte;
        return null;
    }

    @Override
    public void afiseazaCarteDupaId(List<Carte> carti, int id) {
        for(Carte carte : carti)
            if(carte.getId() == id)
            {
                System.out.println(carte.toString());
                break;
            }
    }

    @Override
    public Carte getCarteDupaTitlu(List<Carte> carti, String titlu){
        for(Carte carte : carti)
            if(carte.getTitlu().equals(titlu))
                return carte;
        return null;
    }

    @Override
    public void afiseazaCarteDupaTitlu(List<Carte> carti, String titlu) {
        for(Carte carte : carti)
            if(carte.getTitlu().equals(titlu))
            {
                System.out.println(carte.toString());
                break;
            }
    }

    @Override
    public void afiseazaAutorDupaId(List<Autor> autori, int id) {
        for(Autor autor : autori)
            if(autor.getId() == id)
            {
                System.out.println(autor.toString());
                break;
            }
    }

    @Override
    public void stergeCarteDupaId(List<Carte> carti, int id) {
        carti.remove(getCarteDupaId(carti, id));
    }

    @Override
    public void stergeCarteDupaTitlu(List<Carte> carti, String titlu) {
        carti.remove(getCarteDupaTitlu(carti, titlu));
    }

    @Override
    public void sorteazaCarteDupaAn(List<Carte> carti) {
        Collections.sort(carti, new ComparatorAn());
    }

    @Override
    public void sorteazaCarteDupaPret(List<Carte> carti) {
        Collections.sort(carti, new PriceComparator());
    }

    @Override
    public void sorteazaAutorDupaRating(List<Autor> autori){
        Collections.sort(autori, (a1, a2) -> a1.getRating() - a2.getRating());
    }

    @Override
    public void sorteazaAutorDupaVarsta(List<Autor> autori){
        Collections.sort(autori, (a1, a2) -> a1.getVarsta() - a2.getVarsta());
    }

    @Override
    public void afiseazaCititoriCarteDupaId(List<Carte> carti, int id) {
        for(Carte carte : carti)
            if(carte.getId() == id)
            {
                for(Cititor cititor : carte.getCicitori())
                    System.out.println(cititor.toString());
                break;
            }
    }

    @Override
    public void afiseazaAutori(List<Autor> autori) {
        for(Autor autor : autori)
            System.out.println(autor.toString());
    }

    @Override
    public void afiseazaCarti(List<Carte> carti) {
        for(Carte carte : carti)
            System.out.println(carte.toString());
    }
}
