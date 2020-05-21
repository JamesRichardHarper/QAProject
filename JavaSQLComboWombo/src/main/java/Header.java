import BackEnd.ConnectMethod;
import BackEnd.Tables.location;
import UI.InteractMethod;
import UI.InteractText;
import UI.ScannerMethod;

import java.sql.SQLException;

public class Header {
    static boolean On = true;
    public static void main(String[] args) throws SQLException {

        ConnectMethod.getConnection();
        while(On){
            int Option = 0;
            InteractText.listDatabaseInteract();

            Option = ScannerMethod.inputNum();

            switch (Option){
                case(1): //Location
                    InteractMethod.locationMethod();
                    break;
                case(2): //Customer
                    InteractMethod.customerMethod();
                    break;
                case(3): //Order
                    InteractMethod.orderMethod();
                    break;
                case(4): //Game
                    InteractMethod.gamesMethod();
                    break;
                case(5): //Order_Game
                    InteractText.listInteract(); //TODO
                    break;
                case(6): //Options
                    InteractMethod.options();
                    break;
                case(9): //Exit
                    On = false;
                    break;
                default:

            }

        }

        ConnectMethod.close();

    }
}

//Location.createRecord("12 Blackfield", "PR24GT", "Newcastle", "aabc@BT.com");
//System.out.println(Location.getAll());
//Location.createRecord("12 Fruittree", "NE83RT", "Preston", "Okay@Cokay.com");
//Location.deleteRecord("city", "Newcastle");
