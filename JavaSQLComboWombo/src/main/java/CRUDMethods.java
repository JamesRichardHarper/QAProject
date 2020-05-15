import BackEnd.ConnectMethod;
import BackEnd.Tables.customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CRUDMethods {

    ConnectMethod Connect = new ConnectMethod();
    String Query = null;

    public customer getCustomer(int ID){
        Query = "SELECT * FROM BackEnd.Tables.customer WHERE CID = " + ID + ";";
        ResultSet Results = Connect.executeQuery(Query);
        String first_name = null;
        String last_name = null;
        String address = null;
        String email = null;
        int age = 0;
        String post_code = null;
        String city = null;
        try{
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

    public ArrayList<String> getAll(String TableSelection){
        ResultSet Results = Connect.executeQuery("SELECT * FROM " + TableSelection + ";");
        String Customer = "";
        ArrayList<String> CustomerList = new ArrayList<>();
        try{
            switch (TableSelection) {
                case("BackEnd.Tables.customer"):
                    while (Results.next()) {
                        Customer = Results.getString("CID") + " - " +
                                Results.getString("first_name");
                        CustomerList.add(Customer);
                    }
                case("products"):
                    while (Results.next()) {
                        Customer = Results.getString("PID") + " - " +
                                Results.getString("game_name") + " - " +
                                Results.getString("age_rating") + " - ";
                        CustomerList.add(Customer);
                    }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return CustomerList;
    }
}
