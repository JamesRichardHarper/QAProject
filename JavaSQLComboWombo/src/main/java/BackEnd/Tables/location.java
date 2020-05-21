package BackEnd.Tables;

import BackEnd.ConnectMethod;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class location implements CRUDMethod{

    int LID;
    String StreetAddress;
    String PostCode;
    String City;
    String Email;
    String Query;

    public location() {
    }

    public location(int LID,
                    String streetAddress,
                    String postCode,
                    String city,
                    String email) {
        this.LID = LID;
        StreetAddress = streetAddress;
        PostCode = postCode;
        City = city;
        Email = email;
    }

    public void createRecord(String streetAddress,
                               String postCode,
                               String city,
                               String email){

        Query = "INSERT INTO location (streetAddress, postCode, city, email) VALUES ( ? , ? , ? , ? )";
        PreparedStatement SQLState = ConnectMethod.prepareStatement(Query);

        try{
            SQLState.setString(1, streetAddress);
            SQLState.setString(2, postCode);
            SQLState.setString(3, city);
            SQLState.setString(4, email);
            SQLState.executeUpdate();
        }
        catch(SQLException exception){
            exception.printStackTrace();
        }
    }

    public location getRecord(int ID){

        Query = "SELECT * FROM location WHERE LID =?";
        PreparedStatement SQLState = ConnectMethod.prepareStatement(Query);

        int LID = 0;
        String streetAddress = null;
        String postCode = null;
        String city = null;
        String email = null;
        try{
            SQLState.setInt(1, ID);
            ResultSet Results = SQLState.executeQuery();
            System.out.println(Results);
            while(Results.next()){
                LID = Results.getInt("LID");
                streetAddress = Results.getString("streetAddress");
                postCode = Results.getString("postCode");
                city = Results.getString("city");
                email = Results.getString("email");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return new location(LID, streetAddress, postCode, city, email);
    }

    public int getLID() {
        return LID;
    }

    public String getStreetAddress() {
        return StreetAddress;
    }

    public String getPostCode() {
        return PostCode;
    }

    public String getCity() {
        return City;
    }

    public String getEmail() {
        return Email;
    }

    @Override
    public ArrayList<String> getAll() {
        ResultSet Results = ConnectMethod.executeQuery("SELECT * FROM location;");
        String location;
        ArrayList<String> LocationList = new ArrayList<>();
        try {
            while (Results.next()) {
                location = "LID: " + Results.getString("LID") + " - " +
                        "Address: " + Results.getString("streetAddress") + " " +
                        "Postcode: " + Results.getString("postCode") + " - " +
                        "City: " + Results.getString("city") + " - " +
                        "Email: " +Results.getString("email");
                LocationList.add(location);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return LocationList;
    }

    @Override
    public void editTable(int ID, String FieldToEdit, String FieldAlteration) {
        Query = "UPDATE location SET " + FieldToEdit + " =? WHERE LID =?";
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
        Query = "UPDATE location SET " + FieldToEdit + " =? WHERE LID =?";
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
        Query = "DELETE FROM location WHERE " + FieldToDeleteFrom + " =?";
        PreparedStatement SQLState = ConnectMethod.prepareStatement(Query);
        try{
            SQLState.setInt(1, Identifier);
            SQLState.executeUpdate();
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void deleteRecord(String FieldToDeleteFrom, String Identifier) {
        Query = "DELETE FROM location WHERE " + FieldToDeleteFrom + " =?";
        PreparedStatement SQLState = ConnectMethod.prepareStatement(Query);
        try{
            SQLState.setString(1, Identifier);
            SQLState.executeUpdate();
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void deleteAll() {
        Query = "DELETE FROM customer";
        PreparedStatement SQLState = ConnectMethod.prepareStatement(Query);
        try{
            SQLState.executeUpdate();
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
    }
}
