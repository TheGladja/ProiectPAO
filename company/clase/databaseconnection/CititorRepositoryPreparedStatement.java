package com.company.clase.databaseconnection;

import java.sql.*;

public class CititorRepositoryPreparedStatement {
    public void createCititorTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS cititor" + "(id int PRIMARY KEY AUTO_INCREMENT, preferinta enum('HORROR', 'DRAMA', 'COMEDIE') NOT NULL, nume varchar(30), prenume varchar(30), varsta int, id_carte int NOT NULL)";

        Connection connection = DatabaseConnection.getDatabaseConnection();

        try{
            Statement stat = connection.createStatement();
            stat.execute(createTableSql);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCititor(String preferinta, String nume, String prenume, int varsta, int id_carte){
        String addCititor = "INSERT INTO cititor (preferinta, nume, prenume, varsta, id_carte) VALUES (?, ?, ?, ?, ?)";

        Connection connection = DatabaseConnection.getDatabaseConnection();

        try {
            PreparedStatement preparedStat = connection.prepareStatement(addCititor);
            preparedStat.setString(1, preferinta);
            preparedStat.setString(2, nume);
            preparedStat.setString(3, prenume);
            preparedStat.setInt(4,varsta);
            preparedStat.setInt(5, id_carte);
            preparedStat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayCititori(){
        String selectSQL = "SELECT * FROM cititor";

        Connection connection = DatabaseConnection.getDatabaseConnection();

        try {
            Statement stat = connection.createStatement();
            ResultSet resultSet = stat.executeQuery(selectSQL);
            while(resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1) + " ,Preferinta: " + resultSet.getString(2) + " ,Nume: " + resultSet.getString(3) + " ,Prenume: " + resultSet.getString(4) + " ,Varsta: " + resultSet.getInt(5) + " ,Id carte cicita: " + resultSet.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void afiseazaCititorDupaID(int id){
        String selectSql = "SELECT * FROM cititor WHERE id = ?";

        Connection connection = DatabaseConnection.getDatabaseConnection();

        try {
            PreparedStatement preparedStat = connection.prepareStatement(selectSql);
            preparedStat.setInt(1, id);
            ResultSet resultSet = preparedStat.executeQuery();
            if(resultSet.next())
            {
                System.out.println("Id: " + resultSet.getInt(1) + " ,Preferinta: " + resultSet.getString(2) + " ,Nume: " + resultSet.getString(3) + " ,Prenume: " + resultSet.getString(4) + " ,Varsta: " + resultSet.getInt(5) + " ,Id carte cicita: " + resultSet.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void afiseazaCititoriDupaIdCarte(int id) {
        String selectSql = "select * from cititor where id_carte = ?;";
        int ct = 0;

        Connection connection = DatabaseConnection.getDatabaseConnection();

        try {
            PreparedStatement preparedStat = connection.prepareStatement(selectSql);
            preparedStat.setInt(1, id);
            ResultSet resultSet = preparedStat.executeQuery();
            while(resultSet.next())
            {
                ct++;
                System.out.println("Id: " + resultSet.getInt(1) + " ,Preferinta: " + resultSet.getString(2) + " ,Nume: " + resultSet.getString(3) + " ,Prenume: " + resultSet.getString(4) + " ,Varsta: " + resultSet.getInt(5) + " ,Id carte cicita: " + resultSet.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(ct == 0)
            System.out.println("NU EXISTA");
    }

    public void updateCititor(int id_carte, int id){
        String updateIdCarteSql = "UPDATE cititor SET id_carte = ? WHERE id = ?";

        Connection connection = DatabaseConnection.getDatabaseConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(updateIdCarteSql);
            preparedStatement.setInt(1,id_carte);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteCititor(int id){
        String deleteSql = "DELETE FROM cititor WHERE id = ?";

        Connection connection = DatabaseConnection.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteCititorDupaIdCarte(int id_carte)
    {
        String deleteSql = "DELETE FROM cititor WHERE id_carte = ?";

        Connection connection = DatabaseConnection.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1, id_carte);

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteCititorDupaIdAutor(int id_autor){
        String deleteSql = "DELETE FROM cititor c where c.id_carte = ANY (select id from carte car where car.id_autor = ?);";

        Connection connection = DatabaseConnection.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1, id_autor);

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public int getNrCititoriDupaPreferinta(String preferinta){
        String selectSql = "SELECT count(*) FROM cititor where preferinta = ?;";

        Connection connection = DatabaseConnection.getDatabaseConnection();

        try {
            PreparedStatement preparedStat = connection.prepareStatement(selectSql);
            preparedStat.setString(1, preferinta);
            ResultSet resultSet = preparedStat.executeQuery();
            if(resultSet.next())
            {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
