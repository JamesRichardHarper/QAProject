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

        Query = "SELECT * FROM location WHERE CID =?";
        PreparedStatement SQLState = ConnectMethod.prepareStatement(Query);

        int LID = 0;
        String streetAddress = null;
        String postCode = null;
        String city = null;
        String email = null;
        try{
            SQLState.setInt(1, ID);
            ResultSet Results = SQLState.executeQuery();
            while(Results.next()){
                LID = Results.getInt(LID);
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

    @Override
    public ArrayList<String> getAll() {
        ResultSet Results = ConnectMethod.executeQuery("SELECT * FROM location;");
        String location;
        ArrayList<String> LocationList = new ArrayList<>();
        try {
            while (Results.next()) {
                location = Results.getString("LID") + " - " +
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

    public void editLocation(int LID, String FieldToEdit, String FieldAlteration) {
        Query = "UPDATE customer SET" + FieldToEdit +;
        PreparedStatement SQLState = ConnectMethod.prepareStatement(Query);

        Query = "UPDATE BackEnd.Tables.customer SET " + FieldToEdit + " = " + FieldAlteration + " WHERE CID =" + CID + " ;";
        ConnectMethod.executeUpdate(Query);
    }

    public void editLocation(int LID, String FieldToEdit, int FieldAlteration) {

        Query = "UPDATE BackEnd.Tables.customer SET " + FieldToEdit + " = " + FieldAlteration + " WHERE CID =" + CID + " ;";
        ConnectMethod.executeUpdate(Query);
    }

    @Override
    public void deleteRecord(int ID) {

    }

    @Override
    public void deleteAll() {

    }
}