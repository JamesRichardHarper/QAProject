package BackEnd.Tables;

import BackEnd.ConnectMethod;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * James Harper
 * Start: 12.05.2020
 */

public class customer implements CRUDMethod{

    String Query = null;

    int CID;
    String first_name;
    String last_name;
    String address;
    String email;
    int age;
    String post_code;
    String city;

    public customer() {
    }

    public customer(int CID,
                    String first_name,
                    String last_name,
                    String address,
                    String email,
                    int age,
                    String post_code,
                    String city) {
        this.CID = CID;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.email = email;
        this.age = age;
        this.post_code = post_code;
        this.city = city;
    }

    public void createCustomer(int CID,
                               String first_name,
                               String last_name,
                               String address,
                               String email,
                               int age,
                               String post_code,
                               String city){

        Query = "INSERT INTO customer (CID,first_name,last_name,address,email,age,post_code,city) VALUES ( ? , ? , ? , ? , ?, ? , ? , ? )";
        PreparedStatement SQLState = ConnectMethod.prepareStatement(Query);

        try{
            SQLState.setInt(1, CID);
            SQLState.setString(2, first_name);
            SQLState.setString(3, last_name);
            SQLState.setString(4, address);
            SQLState.setString(5, email);
            SQLState.setInt(6, age);
            SQLState.setString(7, post_code);
            SQLState.setString(8, city);
            SQLState.executeUpdate();
        }
        catch(SQLException exception){
            exception.printStackTrace();
        }
    }

    public customer getRecord(int ID){
        Query = "SELECT * FROM customer WHERE CID =?";
        PreparedStatement SQLState = ConnectMethod.prepareStatement(Query);

        String first_name = null;
        String last_name = null;
        String address = null;
        String email = null;
        int age = 0;
        String post_code = null;
        String city = null;
        try{
            SQLState.setInt(1, ID);
            ResultSet Results = SQLState.executeQuery();
            while(Results.next()){
                first_name = Results.getString("first_name");
                last_name = Results.getString("last_name");
                address = Results.getString("address");
                email = Results.getString("email");
                age = Results.getInt("age");
                post_code = Results.getString("post_code");
                city = Results.getString("city");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return new customer(ID, first_name, last_name, address, email, age, post_code, city);

    }

    @Override
    public ArrayList<String> getAll(){
        ResultSet Results = ConnectMethod.executeQuery("SELECT * FROM customer;");
        String Customer;
        ArrayList<String> CustomerList = new ArrayList<>();
        try{
            while (Results.next()) {
                Customer = Results.getString("CID") + " - " +
                        Results.getString("first_name") + " " +
                        Results.getString("last_name") + " - " +
                        Results.getString("address") + " - " +
                        Results.getString("email") + " - " +
                        Results.getString("age") + " - " +
                        Results.getString("post_code") + " - " +
                        Results.getString("city")
                ;
                CustomerList.add(Customer);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return CustomerList;
    }

    public void editTable(int ID, String FieldToEdit, String FieldAlteration) {
        Query = "UPDATE customer SET " + FieldToEdit + " =? WHERE CID =?";
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

    public void editTable(int ID, String FieldToEdit, int FieldAlteration) {
        Query = "UPDATE customer SET " + FieldToEdit + " =? WHERE CID =?";
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
    public void deleteRecord(int Identifier, String FieldToDelete) {
        Query = "DELETE FROM customer WHERE " + FieldToDelete + " =?";
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
    public void deleteRecord(String Identifier, String FieldToDelete) {
        Query = "DELETE FROM customer WHERE " + FieldToDelete + " =?";
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
