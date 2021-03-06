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
                             Date dateReleased,
                             String genre,
                             double gamePrice){

        Query = "INSERT INTO games (gameName, ageRating, dateReleased, genre, gamePrice) VALUES ( ? , ? , ? , ? , ?)";
        PreparedStatement SQLState = ConnectMethod.prepareStatement(Query);

        try{
            SQLState.setString(1, gameName);
            SQLState.setInt(2, ageRating);
            SQLState.setDate(3, dateReleased);
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
                PID = Results.getInt(PID);
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

    @Override
    public ArrayList<String> getAll() {
        ResultSet Results = ConnectMethod.executeQuery("SELECT * FROM games;");
        String location;
        ArrayList<String> LocationList = new ArrayList<>();
        try {
            while (Results.next()) {
                location = Results.getString("PID") + " - " +
                        Results.getString("streetAddress") + " " +
                        Results.getString("postCode") + " - " +
                        Results.getString("city") + " - " +
                        Results.getString("email");
                LocationList.add(location);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return LocationList;
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
