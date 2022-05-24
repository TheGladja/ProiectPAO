package com.company.clase.databaseconnection;

import com.company.clase.Carte;
import com.company.clase.ServiciuCarte;
import com.company.clase.enumerari.TipCarte;
import com.company.clase.enumerari.TipPersoana;
import com.company.clase.mostenire.Autor;
import com.company.clase.mostenire.Cititor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CarteRepositoryPreparedStatement {
    public void createCarteTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS carte" + "(id int PRIMARY KEY AUTO_INCREMENT, titlu varchar(30), an_publicatie int, pret int, id_autor int NOT NULL)";

        Connection connection = DatabaseConnection.getDatabaseConnection();

        try{
            Statement stat = connection.createStatement();
            stat.execute(createTableSql);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCarte(){
        CititorRepositoryPreparedStatement cititorRepositoryPreparedStatement = new CititorRepositoryPreparedStatement();

        Scanner input = new Scanner(System.in);

        String titlu;
        int an_publicatie, pret;

        System.out.print("Introduceti titlul cartii: ");
        titlu = input.nextLine();

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

        String preferinta = "COMEDIE", nume, prenume;;
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

        AutorRepositoryPreparedStatement autorRepositoryPreparedStatement = new AutorRepositoryPreparedStatement();
        int randIdAutor = autorRepositoryPreparedStatement.getRandomAutorId();

        String addCarte = "INSERT INTO carte (titlu, an_publicatie, pret, id_autor) VALUES (?, ?, ?, ?)";

        Connection connection = DatabaseConnection.getDatabaseConnection();

        try {
            PreparedStatement preparedStat = connection.prepareStatement(addCarte);
            preparedStat.setString(1, titlu);
            preparedStat.setInt(2, an_publicatie);
            preparedStat.setInt(3, pret);
            preparedStat.setInt(4, randIdAutor);
            preparedStat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for(int i = 1; i <= nr_cititori; i++) {
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
            if (task == 1)
                preferinta = "HORROR";
            else if (task == 2)
                preferinta = "DRAMA";

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

            int id_carte = getIdUltimaCarte();

            cititorRepositoryPreparedStatement.addCititor(preferinta, nume, prenume, varsta, id_carte);
        }
    }

    public int getIdUltimaCarte(){
        String selectSql = "select max(id) from carte;";

        Connection connection = DatabaseConnection.getDatabaseConnection();

        try {
            Statement stat = connection.createStatement();
            ResultSet resultSet = stat.executeQuery(selectSql);
            if(resultSet.next())
            {
                return resultSet.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public void displayCarti(){
        String selectSQL = "SELECT * FROM carte";
        int ct = 0;

        Connection connection = DatabaseConnection.getDatabaseConnection();

        try {
            Statement stat = connection.createStatement();
            ResultSet resultSet = stat.executeQuery(selectSQL);
            while(resultSet.next()) {
                ct++;
                System.out.println("Id: " + resultSet.getInt(1) + " ,Titlu: " + resultSet.getString(2) + " ,Anul publicatiei: " + resultSet.getInt(3) + " ,Pret: " + resultSet.getInt(4) + " ,Id autor: " + resultSet.getInt(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(ct == 0)
            System.out.println("NU EXISTA");
    }

    public void afiseazaCarteDupaID(int id){
        String selectSql = "SELECT * FROM carte WHERE id = ?";
        int ct = 0;

        Connection connection = DatabaseConnection.getDatabaseConnection();

        try {
            PreparedStatement preparedStat = connection.prepareStatement(selectSql);
            preparedStat.setInt(1, id);
            ResultSet resultSet = preparedStat.executeQuery();
            if(resultSet.next())
            {
                ct++;
                System.out.println("Id: " + resultSet.getInt(1) + " ,Titlu: " + resultSet.getString(2) + " ,Anul publicatiei: " + resultSet.getInt(3) + " ,Pret: " + resultSet.getInt(4) + " ,Id autor: " + resultSet.getInt(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(ct == 0)
            System.out.println("NU EXISTA");
    }

    public void afiseazaCarteDupaTitlu(String titlu){
        String selectSql = "SELECT * FROM carte WHERE titlu LIKE ? ;";
        int ct = 0;

        Connection connection = DatabaseConnection.getDatabaseConnection();

        titlu = "%" + titlu + "%";

        try {
            PreparedStatement preparedStat = connection.prepareStatement(selectSql);
            preparedStat.setString(1, titlu);
            ResultSet resultSet = preparedStat.executeQuery();
            if(resultSet.next())
            {
                ct ++;
                System.out.println("Id: " + resultSet.getInt(1) + " ,Titlu: " + resultSet.getString(2) + " ,Anul publicatiei: " + resultSet.getInt(3) + " ,Pret: " + resultSet.getInt(4) + " ,Id autor: " + resultSet.getInt(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(ct == 0)
            System.out.println("NU EXISTA");
    }

    public void updateCarte(int pret, int id){
        String updatePretSql = "UPDATE carte SET pret = ? WHERE id = ?";

        Connection connection = DatabaseConnection.getDatabaseConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(updatePretSql);
            preparedStatement.setInt(1, pret);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteCarte(int id){
        CititorRepositoryPreparedStatement cititorRepositoryPreparedStatement = new CititorRepositoryPreparedStatement();
        cititorRepositoryPreparedStatement.deleteCititorDupaIdCarte(id);

        String deleteSql = "DELETE FROM carte WHERE id = ?";

        Connection connection = DatabaseConnection.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteCarteDupaTitlu(String titlu){
        CititorRepositoryPreparedStatement cititorRepositoryPreparedStatement = new CititorRepositoryPreparedStatement();
        String deleteSql = "DELETE FROM carte WHERE titlu LIKE ? ;";
        String selectSql = "SELECT * FROM carte WHERE titlu LIKE ? ;";

        titlu = "%" + titlu + "%";

        Connection connection = DatabaseConnection.getDatabaseConnection();

        try{
            PreparedStatement preparedStatementSelect = connection.prepareStatement(selectSql);
            preparedStatementSelect.setString(1, titlu);
            ResultSet resultSet = preparedStatementSelect.executeQuery();

            if(resultSet.next())
            {
                cititorRepositoryPreparedStatement.deleteCititorDupaIdCarte(resultSet.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        try {
            PreparedStatement preparedStatementDelete = connection.prepareStatement(deleteSql);
            preparedStatementDelete.setString(1, titlu);

            preparedStatementDelete.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteCarteDupaIdAutor(int id_autor){
        CititorRepositoryPreparedStatement cititorRepositoryPreparedStatement = new CititorRepositoryPreparedStatement();
        cititorRepositoryPreparedStatement.deleteCititorDupaIdAutor(id_autor);

        String deleteSql = "DELETE FROM carte WHERE id_autor = ?";

        Connection connection = DatabaseConnection.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1, id_autor);

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void sorteazaCarteDupaAn() {
        String selectSQL = "SELECT * FROM carte order by an_publicatie";

        Connection connection = DatabaseConnection.getDatabaseConnection();

        try {
            Statement stat = connection.createStatement();
            ResultSet resultSet = stat.executeQuery(selectSQL);
            while(resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1) + " ,Titlu: " + resultSet.getString(2) + " ,Anul publicatiei: " + resultSet.getInt(3) + " ,Pret: " + resultSet.getInt(4) + " ,Id autor: " + resultSet.getInt(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void sorteazaCarteDupaPret() {
        String selectSQL = "SELECT * FROM carte order by pret";

        Connection connection = DatabaseConnection.getDatabaseConnection();

        try {
            Statement stat = connection.createStatement();
            ResultSet resultSet = stat.executeQuery(selectSQL);
            while(resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1) + " ,Titlu: " + resultSet.getString(2) + " ,Anul publicatiei: " + resultSet.getInt(3) + " ,Pret: " + resultSet.getInt(4) + " ,Id autor: " + resultSet.getInt(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
