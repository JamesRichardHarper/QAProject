package BackEnd;

import java.sql.*;
import java.util.ArrayList;

public class ConnectMethod {

    private static Connection conn;
    private static Statement state;

    public static void getConnection() {
        try {
            conn = DriverManager.getConnection(Configuration.URL, Configuration.USER, Configuration.PASSWORD);
            state = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static PreparedStatement prepareStatement(String Query) {
        PreparedStatement SQLPrepped = null;
        try {
            SQLPrepped = conn.prepareStatement(Query);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return SQLPrepped;
    }

    public static void executeUpdate(String query) {
        try {
            state.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet executeQuery(String Query) {
        ResultSet result = null;
        try {
            result = state.executeQuery(Query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void close(){
        try{
            conn.close();
        }
        catch (SQLException Exception){
            Exception.printStackTrace();
        }
    }
}
