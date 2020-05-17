import BackEnd.ConnectMethod;
import BackEnd.Tables.customer;
import BackEnd.Tables.location;

import java.sql.SQLException;

public class Header {
    public static void main(String[] args) throws SQLException {

        location Location = new location();

        ConnectMethod.getConnection();
        //Location.createRecord("12 Blackfield", "PR24GT", "Newcastle", "aabc@BT.com");
        //Location.createRecord("12 Fruittree", "NE83RT", "Preston", "Okay@Cokay.com");
        Location.deleteRecord("city", "Newcastle");
        ConnectMethod.close();

    }
}
