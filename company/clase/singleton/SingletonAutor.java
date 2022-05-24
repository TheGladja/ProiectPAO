package com.company.clase.singleton;

import com.company.clase.enumerari.TipCarte;
import com.company.clase.enumerari.TipPersoana;
import com.company.clase.mostenire.Autor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SingletonAutor {
    private static SingletonAutor single_instance = null;
    private List<Autor> autori = new ArrayList<>();

    public static SingletonAutor getInstance(){
        if(single_instance == null)
            single_instance = new SingletonAutor();
        return single_instance;
    }

    public void setAutori(List<Autor> autori)
    {
        this.autori = autori;
    }

    public List<Autor> getAutori(){
        return autori;
    }

    private static List<String[]> getColoaneCSV(String fisierIn){
        List<String[]> coloane = new ArrayList<>();

        try(var in = new BufferedReader(new FileReader(fisierIn))) {

            String line;

            while((line = in.readLine()) != null ) {
                String[] linie = line.replaceAll(" ", "").split(",");
                coloane.add(linie);
            }
        } catch (IOException e) {
            System.out.println("Error");
        }

        return coloane;
    }

    public void transmiteCSVautor() {
        try {
            var coloane = SingletonAutor.getColoaneCSV("Z:\\PROJECTS_PAO\\pao-labs\\ProjectFinale\\src\\com\\company\\clase\\csv\\CSVautor.csv");
            for(var linie : coloane){

                TipCarte tipCarte = TipCarte.HORROR;
                int stil = Integer.parseInt(linie[0]);

                TipPersoana tipPersoana;
                int varsta = Integer.parseInt(linie[4]);

                if(stil == 2)
                    tipCarte = TipCarte.DRAMA;
                else if(stil == 3)
                    tipCarte = TipCarte.COMEDIE;

                if(varsta < 18)
                    tipPersoana = TipPersoana.COPIL;
                else if(varsta > 17 && varsta < 25)
                    tipPersoana = TipPersoana.ADOLESCENT;
                else
                    tipPersoana = TipPersoana.ADULT;

                var newAutor = new Autor(
                        tipCarte,
                        Integer.parseInt(linie[1]),
                        tipPersoana,
                        linie[2],
                        linie[3],
                        varsta
                );
                autori.add(newAutor);
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public void ScrieAutoriCSV(){
        try{
            var writer = new FileWriter("Z:\\PROJECTS_PAO\\pao-labs\\ProjectFinale\\src\\com\\company\\clase\\csv\\CSVautorAfisare.csv");
            for(var autor : this.autori){
                writer.write(autor.toCSV());
                writer.write("\n");
            }
            writer.close();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }

}
