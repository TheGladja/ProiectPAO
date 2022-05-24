package com.company.clase.audit;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Audit {
    FileWriter writer;

    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void Imprimare(String action) throws IOException {
        writer.append(action);
        writer.append(",");
        writer.append(formatter.format(LocalDateTime.now()));
        writer.append("\n");
        writer.flush();
    }

    public Audit() {
        try{
            this.writer = new FileWriter("Z:\\PROJECTS_PAO\\pao-labs\\ProjectFinale\\src\\com\\company\\clase\\csv\\CSVafisare.csv");
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
