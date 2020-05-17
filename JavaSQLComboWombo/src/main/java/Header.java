import BackEnd.ConnectMethod;
import BackEnd.Tables.customer;

import java.sql.SQLException;

public class Header {
    public static void main(String[] args) throws SQLException {

        customer Customer = new customer();

        ConnectMethod.getConnection();
        //BackEnd.ConnectMethod.executeQuery("SELECT * FROM BackEnd.Tables.customer;");
        //System.out.println(catchAllMethods.getAll("customer"));
        //System.out.println(Customer.getSingle(1));
        //Customer.createCustomer(5,"Rick", "Astley", "Downtown", "NeverGunn@give.com", 54, "LE5 2PE", "New York");
        Customer.editTable(2, "city", "London");


        ConnectMethod.close();

    }
}
