package com.company.clase.singleton;

import com.company.clase.enumerari.TipCarte;
import com.company.clase.enumerari.TipPersoana;
import com.company.clase.mostenire.Autor;
import com.company.clase.mostenire.Cititor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SingletonCititor {
    private static SingletonCititor single_instance = null;
    private List<Cititor> cititori = new ArrayList<Cititor>();

    public static SingletonCititor getInstance(){
        if(single_instance == null)
            single_instance = new SingletonCititor();
        return single_instance;
    }

    public void setCititori(List<Cititor> cititori)
    {
        this.cititori = cititori;
    }

    public List<Cititor> getCititori(){
        return cititori;
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

    public void transmiteCSVcicitor() {
        try {
            var coloane = SingletonCititor.getColoaneCSV("Z:\\PROJECTS_PAO\\pao-labs\\ProjectFinale\\src\\com\\company\\clase\\csv\\CSVcititor.csv");
            for(var linie : coloane){

                TipCarte tipCarte = TipCarte.HORROR;
                int stil = Integer.parseInt(linie[0]);

                if(stil == 2)
                    tipCarte = TipCarte.DRAMA;
                else if(stil == 3)
                    tipCarte = TipCarte.COMEDIE;

                TipPersoana tipPersoana;
                int varsta = Integer.parseInt(linie[3]);

                if(varsta < 18)
                    tipPersoana = TipPersoana.COPIL;
                else if(varsta > 17 && varsta < 25)
                    tipPersoana = TipPersoana.ADOLESCENT;
                else
                    tipPersoana = TipPersoana.ADULT;

                var newCititor = new Cititor(
                        tipCarte,
                        tipPersoana,
                        linie[1],
                        linie[2],
                        varsta
                );
                cititori.add(newCititor);
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
