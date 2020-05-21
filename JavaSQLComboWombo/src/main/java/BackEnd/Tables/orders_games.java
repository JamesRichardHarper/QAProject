package BackEnd.Tables;

import BackEnd.ConnectMethod;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class orders_games {

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

    public orders_games getRecords(String Sort, int ID){
        Query = "SELECT * FROM orders_games WHERE " + Sort + " =?";
        PreparedStatement SQLState = ConnectMethod.prepareStatement(Query);

        int fk_OID = 0;
        int fk_PID = 0;
        try{
            SQLState.setInt(1, ID);
            ResultSet Results = SQLState.executeQuery();
            while(Results.next()) {
                fk_LID = Results.getInt("fk_LID");
                first_name = Results.getString("firstName");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return new customer(ID, fk_LID, first_name, last_name, age, loyalty);
    }
}
