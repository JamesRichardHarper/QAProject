package BackEnd.Tables;

import BackEnd.ConnectMethod;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * James Harper
 * Start: 12.05.2020
 */

public class customer {

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

    public void createCustomer(String first_name,
                          String last_name,
                          String address,
                          String email,
                          String age,
                          String post_code,
                          String city){

        Query = "INSERT INTO BackEnd.Tables.customer VALUES ( 0 , '" + first_name + "' , '" + last_name + "' , '" + address + "' , '" + email + "' , " + age + " , '" + post_code + "' , '" + city + "');";
        ConnectMethod.executeUpdate(Query);
    }

    public customer getSingle(int ID){

        Query = "SELECT * FROM BackEnd.Tables.customer WHERE CID = " + ID + ";";
        String first_name = null;
        String last_name = null;
        String address = null;
        String email = null;
        int age = 0;
        String post_code = null;
        String city = null;
        try{
            ResultSet Results = ConnectMethod.executeQuery(Query);
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

    public void editCustomer(int CID, String FieldToEdit, String FieldAlteration) {

        Query = "UPDATE BackEnd.Tables.customer SET " + FieldToEdit + " = " + FieldAlteration + " WHERE CID =" + CID + " ;";
        ConnectMethod.executeUpdate(Query);
    }

    public void editCustomer(int CID, String FieldToEdit, int FieldAlteration) {

        Query = "UPDATE BackEnd.Tables.customer SET " + FieldToEdit + " = " + FieldAlteration + " WHERE CID =" + CID + " ;";
        ConnectMethod.executeUpdate(Query);
    }

    public ArrayList<String> getAll(){
        ResultSet Results = ConnectMethod.executeQuery("SELECT * FROM BackEnd.Tables.customer;");
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

}
