package BackEnd.Tables;

import BackEnd.ConnectMethod;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class games implements CRUDMethod{

    int PID;
    String gameName;
    int ageRating;
    Date dateReleased;
    String genre;
    double gamePrice;
    String Query;

    public games() {
    }

    public games(int PID,
                 String gameName,
                 int ageRating,
                 Date dateReleased,
                 String genre,
                 double gamePrice) {
        this.PID = PID;
        this.gameName = gameName;
        this.ageRating = ageRating;
        this.dateReleased = dateReleased;
        this.genre = genre;
        this.gamePrice = gamePrice;
    }

    public void createRecord(String gameName,
                             int ageRating,
                             String dateReleased,
                             String genre,
                             double gamePrice){

        Query = "INSERT INTO games (gameName, ageRating, dateReleased, genre, gamePrice) VALUES ( ? , ? , ? , ? , ?)";
        PreparedStatement SQLState = ConnectMethod.prepareStatement(Query);

        try{
            SQLState.setString(1, gameName);
            SQLState.setInt(2, ageRating);
            SQLState.setString(3, dateReleased);
            SQLState.setString(4, genre);
            SQLState.setDouble(5, gamePrice);
            SQLState.executeUpdate();
        }
        catch(SQLException exception){
            exception.printStackTrace();
        }
    }

    public games getRecord(int ID){

        Query = "SELECT * FROM games WHERE PID =?";
        PreparedStatement SQLState = ConnectMethod.prepareStatement(Query);

        PID = 0;
        gameName = null;
        ageRating = 0;
        dateReleased = null;
        genre = null;
        gamePrice = 0.0;
        try{
            SQLState.setInt(1, ID);
            ResultSet Results = SQLState.executeQuery();
            while(Results.next()){
                PID = Results.getInt("PID");
                gameName = Results.getString("gameName");
                ageRating = Results.getInt("ageRating");
                dateReleased = Results.getDate("dateReleased");
                genre = Results.getString("genre");
                gamePrice = Results.getDouble("gamePrice");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return new games(PID, gameName, ageRating, dateReleased, genre, gamePrice);
    }

    public int getPID() {
        return PID;
    }

    public String getGameName() {
        return gameName;
    }

    public int getAgeRating() {
        return ageRating;
    }

    public Date getDateReleased() {
        return dateReleased;
    }

    public String getGenre() {
        return genre;
    }

    public double getGamePrice() {
        return gamePrice;
    }

    @Override
    public ArrayList<String> getAll() {
        ResultSet Results = ConnectMethod.executeQuery("SELECT * FROM games;");
        String game;
        ArrayList<String> GamesList = new ArrayList<>();
        try {
            while (Results.next()) {
                game = "PID: " + Results.getString("PID") + " - " +
                        "Title: " + Results.getString("gameName") + " " +
                        "Age Rating: " + Results.getString("ageRating") + " - " +
                        "Release Date: " + Results.getString("dateReleased") + " - " +
                        "Genre: " + Results.getString("genre") + " - " +
                        "Price: " + Results.getString("gamePrice");
                GamesList.add(game);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return GamesList;
    }

    @Override
    public void editTable(int ID, String FieldToEdit, String FieldAlteration) {
        Query = "UPDATE games SET " + FieldToEdit + " =? WHERE PID =?";
        PreparedStatement SQLState = ConnectMethod.prepareStatement(Query);
        try{
            SQLState.setString(1, FieldAlteration);
            SQLState.setInt(2, ID);
            SQLState.executeUpdate();
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void editTable(int ID, String FieldToEdit, int FieldAlteration) {
        Query = "UPDATE games SET " + FieldToEdit + " =? WHERE PID =?";
        PreparedStatement SQLState = ConnectMethod.prepareStatement(Query);
        try{
            SQLState.setInt(1, FieldAlteration);
            SQLState.setInt(2, ID);
            SQLState.executeUpdate();
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void deleteRecord(String FieldToDeleteFrom, int Identifier) {
        Query = "DELETE FROM games WHERE " + FieldToDeleteFrom + " =?";
        PreparedStatement SQLState = ConnectMethod.prepareStatement(Query);
        try{
            SQLState.setInt(1, Identifier);
            System.out.println(SQLState);
            SQLState.executeUpdate();
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void deleteRecord(String FieldToDeleteFrom, String Identifier) {
        Query = "DELETE FROM games WHERE " + FieldToDeleteFrom + " =?";
        PreparedStatement SQLState = ConnectMethod.prepareStatement(Query);
        try{
            SQLState.setString(1, Identifier);
            System.out.println(SQLState);
            SQLState.executeUpdate();
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void deleteAll() {
        Query = "DELETE FROM games";
        PreparedStatement SQLState = ConnectMethod.prepareStatement(Query);
        try{
            SQLState.executeUpdate();
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
    }
}
