import BackEnd.ConnectMethod;
import BackEnd.Tables.customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class catchAllMethods {



    public static ArrayList<String> getAll(String Table) throws SQLException {

        String Query = null;
        Query = "SELECT * FROM Table=?";

        PreparedStatement SQLState = ConnectMethod.prepareStatement(Query);
        SQLState.setString(1, Table);
        ResultSet Results = SQLState.executeQuery();

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
