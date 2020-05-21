package BackEnd.Tables;

import BackEnd.ConnectMethod;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class orders_games{

    int fk_OID;
    int fk_PID;
    String Query;

    public orders_games() {
    }

    public orders_games(int fk_OID, int fk_PID) {
        this.fk_OID = fk_OID;
        this.fk_PID = fk_PID;
    }

    public void createRecord(int fk_OID, int fk_PID){
        Query = "INSERT INTO orders_games (fk_OID, fk_PID) VALUES ( ? , ?)";
        PreparedStatement SQLState = ConnectMethod.prepareStatement(Query);

        try{
            SQLState.setInt(1, fk_OID);
            SQLState.setInt(2, fk_PID);
            SQLState.executeUpdate();
        }
        catch(SQLException exception){
            exception.printStackTrace();
        }
    }

    public int getFk_OID() {
        return fk_OID;
    }

    public int getFk_PID() {
        return fk_PID;
    }

    public ArrayList<orders_games> getRecords(String Sort, int ID){
        Query = "SELECT * FROM orders_games WHERE " + Sort + " =?";
        PreparedStatement SQLState = ConnectMethod.prepareStatement(Query);

        int fk_OID;
        int fk_PID;

        ArrayList<orders_games> OrderList = new ArrayList<>();

        try{
            SQLState.setInt(1, ID);
            ResultSet Results = SQLState.executeQuery();
            while(Results.next()) {
                fk_OID = Results.getInt("fk_OID");
                fk_PID = Results.getInt("fk_PID");
                orders_games MyRecord = new orders_games(fk_OID,fk_PID);
                OrderList.add(MyRecord);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return OrderList;
    }
    public ArrayList<String> getAll() {
        Query = "SELECT * FROM orders_games";
        PreparedStatement SQLState = ConnectMethod.prepareStatement(Query);
        ArrayList<String> OrderList = new ArrayList<>();
        String Order;
        try{
            ResultSet Results = SQLState.executeQuery();
            while(Results.next()) {
                Order = "fk_OID: " + Results.getString("fk_OID") + " - " +
                        "fk_PID: " + Results.getString("fk_PID");
                OrderList.add(Order);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return OrderList;
    }

    public void deleteRecord(String FieldToDeleteFrom, int Identifier) {
        Query = "DELETE FROM orders_games WHERE " + FieldToDeleteFrom + " =?";
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

    public double tallyCost(int ID){
        ArrayList<orders_games> Tally = getRecords("fk_OID", ID);
        double TotalCost = 0;

        games games = new games();

        for(orders_games TotalOrder:Tally){
            int ProductID = TotalOrder.getFk_PID();
            games Product = games.getRecord(ProductID);
            double Cost = Product.getGamePrice();
            TotalCost += Cost;
        }
        return TotalCost;
    }

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
