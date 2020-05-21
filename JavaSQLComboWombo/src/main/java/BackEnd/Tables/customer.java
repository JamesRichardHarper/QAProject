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
    int fk_LID;
    String first_name;
    String last_name;
    int age;
    int loyalty;

    public customer() {
    }

    public customer(int CID,
                    int fk_LID,
                    String first_name,
                    String last_name,
                    int age,
                    int loyalty) {
        this.CID = CID;
        this.fk_LID = fk_LID;
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.loyalty = loyalty;
    }

    public void createCustomer(int fk_LID,
                               String first_name,
                               String last_name,
                               int age,
                               int loyalty){

        Query = "INSERT INTO customer (fk_LID, firstName, lastName, age, loyalty) VALUES ( ? , ? , ? , ? , ?)";
        PreparedStatement SQLState = ConnectMethod.prepareStatement(Query);

        try{
            SQLState.setInt(1, fk_LID);
            SQLState.setString(2, first_name);
            SQLState.setString(3, last_name);
            SQLState.setInt(4, age);
            SQLState.setInt(5, loyalty);
            SQLState.executeUpdate();
        }
        catch(SQLException exception){
            exception.printStackTrace();
        }
    }

    public customer getRecord(int ID){
        Query = "SELECT * FROM customer WHERE CID =?";
        PreparedStatement SQLState = ConnectMethod.prepareStatement(Query);

        int fk_LID = 0;
        String first_name = null;
        String last_name = null;
        int age = 0;
        int loyalty = 0;
        try{
            SQLState.setInt(1, ID);
            ResultSet Results = SQLState.executeQuery();
            while(Results.next()) {
                fk_LID = Results.getInt("fk_LID");
                first_name = Results.getString("firstName");
                last_name = Results.getString("lastName");
                age = Results.getInt("age");
                loyalty = Results.getInt("loyalty");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return new customer(ID, fk_LID, first_name, last_name, age, loyalty);

    }

    public int getCID() {
        return CID;
    }

    public int getFk_LID() {
        return fk_LID;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public int getAge() {
        return age;
    }

    public int getLoyalty() {
        return loyalty;
    }

    @Override
    public ArrayList<String> getAll(){
        ResultSet Results = ConnectMethod.executeQuery("SELECT * FROM customer;");
        String Customer;
        ArrayList<String> CustomerList = new ArrayList<>();
        try{
            while (Results.next()) {
                Customer = "CID : " + Results.getString("CID") + " - " +
                        "fk_LID: " + Results.getString("fk_LID") + " - " +
                        "Name: " + Results.getString("firstName") + " " + Results.getString("lastName") + " - " +
                        "Age: " + Results.getString("age") + " - " +
                        "Loyalty Bonus: " + Results.getString("loyalty");
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

    @Override
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
    public void deleteRecord(String FieldToDeleteFrom, int Identifier) {
        Query = "DELETE FROM customer WHERE " + FieldToDeleteFrom + " =?";
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
    public void deleteRecord(String Identifier, String FieldToDeleteFrom) {
        Query = "DELETE FROM customer WHERE " + FieldToDeleteFrom + " =?";
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
