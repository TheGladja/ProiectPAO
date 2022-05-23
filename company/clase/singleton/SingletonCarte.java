package com.company.clase.singleton;

import com.company.clase.Carte;
import com.company.clase.enumerari.TipCarte;
import com.company.clase.enumerari.TipPersoana;
import com.company.clase.mostenire.Autor;
import com.company.clase.mostenire.Cititor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SingletonCarte {
    private static SingletonCarte single_instance = null;
    private List<Carte> carti = new ArrayList<Carte>();

    public static SingletonCarte getInstance(){
        if(single_instance == null)
            single_instance = new SingletonCarte();
        return single_instance;
    }

    public void setCarti(List<Carte> carti)
    {
        this.carti = carti;
    }

    public List<Carte> getCarti(){
        return carti;
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

    public void transmiteCSVcarte(List<Autor> autori) {
        Random random = new Random();

        try {
            var coloane = SingletonCarte.getColoaneCSV("Z:\\PROJECTS_PAO\\pao-labs\\ProjectFinale\\src\\com\\company\\clase\\csv\\CSVcarte.csv");
            for(var linie : coloane){

                List<Cititor> cititori = new ArrayList<Cititor>();
                SingletonCititor sc = new SingletonCititor();
                sc.transmiteCSVcicitor();

                cititori = sc.getCititori();

                int index = random.nextInt(autori.size());
                Autor autor = autori.get(index);

                var newCarte = new Carte(
                        cititori,
                        autor,
                        linie[0],
                        Integer.parseInt(linie[1]),
                        Integer.parseInt(linie[2])
                );
                carti.add(newCarte);
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public void ScrieCartiCSV(){
        try{
            var writer = new FileWriter("Z:\\PROJECTS_PAO\\pao-labs\\ProjectFinale\\src\\com\\company\\clase\\csv\\CSVcarteAfisare.csv");
            for(var carte : this.carti){
                writer.write(carte.toCSV());
                writer.write("\n");
            }
            writer.close();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }

}
