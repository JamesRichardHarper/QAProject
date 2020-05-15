import BackEnd.ConnectMethod;
import BackEnd.Tables.customer;

import java.sql.SQLException;

public class Header {
    public static void main(String[] args) throws SQLException {
        //SQLMethods.readDB();
        CRUDMethods CRUD = new CRUDMethods();
        customer Customer = new customer();

        ConnectMethod.getConnection();
        //BackEnd.ConnectMethod.executeQuery("SELECT * FROM BackEnd.Tables.customer;");
        //System.out.println(Customer.getAll());
        //System.out.println(Customer.getSingle(1).first_name);
        //Customer.createCustomer("Rick", "Moranis", "Space", "IAm@YourFathers", "67", "GH5 23T", "New York");
        Customer.editCustomer(0, "age", 54);

    }
}
