package com.company.clase.databaseconnection;

import com.company.clase.enumerari.TipCarte;
import com.company.clase.enumerari.TipPersoana;
import com.company.clase.mostenire.Autor;
import databaseExperiment.DB;
import databaseExperiment.Person;

import java.sql.*;
import java.util.Scanner;

public class AutorRepositoryPreparedStatement {
    public void createAutorTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS autor" + "(id int PRIMARY KEY AUTO_INCREMENT, stil_scriere enum('HORROR', 'DRAMA', 'COMEDIE') NOT NULL, rating int, nume varchar(30), prenume varchar(30), varsta int)";

        Connection connection = DatabaseConnection.getDatabaseConnection();

        try{
            Statement stat = connection.createStatement();
            stat.execute(createTableSql);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addAutor(){
        Scanner input = new Scanner(System.in);

        String nume, prenume, stil = "COMEDIE";
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

        if(task == 1)
            stil = "HORROR";
        else if(task == 2)
            stil = "DRAMA";

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

        String addAutor = "INSERT INTO autor (stil_scriere, rating, nume, prenume, varsta) VALUES (?, ?, ?, ?, ?)";

        Connection connection = DatabaseConnection.getDatabaseConnection();

        try {
            PreparedStatement preparedStat = connection.prepareStatement(addAutor);
            preparedStat.setString(1, stil);
            preparedStat.setInt(2, rating);
            preparedStat.setString(3, nume);
            preparedStat.setString(4,prenume);
            preparedStat.setInt(5, varsta);
            preparedStat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayAutori(){
        String selectSQL = "SELECT * FROM autor";
        int ct = 0;

        Connection connection = DatabaseConnection.getDatabaseConnection();

        try {
            Statement stat = connection.createStatement();
            ResultSet resultSet = stat.executeQuery(selectSQL);
            while(resultSet.next()) {
                ct++;
                System.out.println("Id: " + resultSet.getInt(1) + " ,Stil scriere: " + resultSet.getString(2) + " ,Rating: " + resultSet.getInt(3) + " ,Nume: " + resultSet.getString(4) + " ,Prenume: " + resultSet.getString(5) + " ,Varsta: " + resultSet.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(ct == 0)
            System.out.println("NU EXISTA");
    }

    public void afiseazaAutorDupaID(int id){
        String selectSql = "SELECT * FROM autor WHERE id = ?";
        int ct = 0;

        Connection connection = DatabaseConnection.getDatabaseConnection();

        try {
            PreparedStatement preparedStat = connection.prepareStatement(selectSql);
            preparedStat.setInt(1, id);
            ResultSet resultSet = preparedStat.executeQuery();
            if(resultSet.next())
            {
                ct++;
                System.out.println("Id: " + resultSet.getInt(1) + " ,Stil scriere: " + resultSet.getString(2) + " ,Rating: " + resultSet.getInt(3) + " ,Nume: " + resultSet.getString(4) + " ,Prenume: " + resultSet.getString(5) + " ,Varsta: " + resultSet.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(ct == 0)
            System.out.println("NU EXISTA");
    }

    public void sorteazaAutorDupaRating() {
        String selectSQL = "SELECT * FROM autor order by rating";

        Connection connection = DatabaseConnection.getDatabaseConnection();

        try {
            Statement stat = connection.createStatement();
            ResultSet resultSet = stat.executeQuery(selectSQL);
            while(resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1) + " ,Stil scriere: " + resultSet.getString(2) + " ,Rating: " + resultSet.getInt(3) + " ,Nume: " + resultSet.getString(4) + " ,Prenume: " + resultSet.getString(5) + " ,Varsta: " + resultSet.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void sorteazaAutorDupaVarsta() {
        String selectSQL = "SELECT * FROM autor order by varsta";

        Connection connection = DatabaseConnection.getDatabaseConnection();

        try {
            Statement stat = connection.createStatement();
            ResultSet resultSet = stat.executeQuery(selectSQL);
            while(resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1) + " ,Stil scriere: " + resultSet.getString(2) + " ,Rating: " + resultSet.getInt(3) + " ,Nume: " + resultSet.getString(4) + " ,Prenume: " + resultSet.getString(5) + " ,Varsta: " + resultSet.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAutor(int rating, int id){
        String updateRatingSql = "UPDATE autor SET rating = ? WHERE id = ?";

        Connection connection = DatabaseConnection.getDatabaseConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(updateRatingSql);
            preparedStatement.setInt(1,rating);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteAutor(int id){
        CarteRepositoryPreparedStatement carteRepositoryPreparedStatement = new CarteRepositoryPreparedStatement();
        carteRepositoryPreparedStatement.deleteCarteDupaIdAutor(id);

        String deleteSql = "DELETE FROM autor WHERE id = ?";

        Connection connection = DatabaseConnection.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public int getRandomAutorId(){
        String selectSql = "select * from autor a, (select max(id)*rand() randid from autor) b where a.id >= b.randid limit 1;";

        Connection connection = DatabaseConnection.getDatabaseConnection();

        try{
            Statement stat = connection.createStatement();
            ResultSet resultSet = stat.executeQuery(selectSql);

            if(resultSet.next())
                return resultSet.getInt(1);

        }catch(SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public int getNumarAutori() {
        String selectSql = "select count(*) from autor;";

        Connection connection = DatabaseConnection.getDatabaseConnection();

        try{
            Statement stat = connection.createStatement();
            ResultSet resultSet = stat.executeQuery(selectSql);

            if(resultSet.next())
                return resultSet.getInt(1);

        }catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
}
