package BackEnd.Tables;

import BackEnd.ConnectMethod;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class orders implements CRUDMethod{

    int OID;
    int fk_CID;
    Date orderDate;
    String Query;

    public orders() {
    }

    public orders(int OID, int fk_CID, Date orderDate) {
        this.OID = OID;
        this.fk_CID = fk_CID;
        this.orderDate = orderDate;
    }

    public void createRecord(int fk_CID, String orderDate){

        Query = "INSERT INTO orders (fk_CID, orderDate) VALUES ( ? , ?)";
        PreparedStatement SQLState = ConnectMethod.prepareStatement(Query);

        try{
            SQLState.setInt(1, fk_CID);
            SQLState.setString(2, orderDate);
            SQLState.executeUpdate();
        }
        catch(SQLException exception){
            exception.printStackTrace();
        }
    }

    public orders getRecord(int ID){
        Query = "SELECT * FROM orders WHERE OID =?";
        PreparedStatement SQLState = ConnectMethod.prepareStatement(Query);

        int fk_CID = 0;
        Date orderDate = null;
        try{
            SQLState.setInt(1, ID);
            ResultSet Results = SQLState.executeQuery();
            while(Results.next()) {
                fk_CID = Results.getInt("fk_CID");
                orderDate = Results.getDate("orderDate");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return new orders(ID, fk_CID, orderDate);

    }

    public int getOID() {
        return OID;
    }

    public int getFk_CID() {
        return fk_CID;
    }

    public Date getOrderDate() {
        return orderDate;
    }


    @Override
    public ArrayList<String> getAll() {
        ResultSet Results = ConnectMethod.executeQuery("SELECT * FROM orders;");
        String Order;
        ArrayList<String> CustomerList = new ArrayList<>();
        try{
            while (Results.next()) {
                Order = "OID: " + Results.getString("OID") + " - " +
                        "fk_CID: " + Results.getString("fk_CID") + " - " +
                        "Date of Order " + Results.getString("orderDate");
                CustomerList.add(Order);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return CustomerList;
    }

    @Override
    public void editTable(int ID, String FieldToEdit, String FieldAlteration) {
        Query = "UPDATE orders SET " + FieldToEdit + " =? WHERE OID =?";
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
        Query = "UPDATE orders SET " + FieldToEdit + " =? WHERE OID =?";
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
    public void deleteRecord(String FieldToDeleteFrom, String Identifier) {
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

    }
}
