package UI;

import BackEnd.Configuration;
import BackEnd.Tables.*;

import java.sql.Date;
import java.util.ArrayList;

public class InteractMethod {

    static public void locationMethod(){

        location location = new location();

        boolean LocationMenu = true;
        int Location;

        while (LocationMenu){
            InteractText.listInteract();

            Location = ScannerMethod.inputNum();

            switch (Location) {
                case (1) -> {
                    System.out.println("Please insert a street address.");
                    String address = ScannerMethod.inputString();
                    System.out.println("Please insert a postcode.");
                    String postcode = ScannerMethod.inputString();
                    System.out.println("Please insert a city.");
                    String city = ScannerMethod.inputString();
                    System.out.println("Please insert a email.");
                    String email = ScannerMethod.inputString();
                    location.createRecord(address, postcode, city, email);
                }
                case (2) -> {
                    boolean Selecting = true;
                    int select;
                    while (Selecting) {
                        InteractText.selectStatement();

                        select = ScannerMethod.inputNum();

                        switch (select) {
                            case (1) -> {
                                System.out.println("Please give the Location ID");
                                int ID = ScannerMethod.inputNum();
                                location MyRecord = location.getRecord(ID);
                                System.out.println("LID: " + MyRecord.getLID());
                                System.out.println("Address: " + MyRecord.getStreetAddress());
                                System.out.println("Postcode: " + MyRecord.getPostCode());
                                System.out.println("City: " + MyRecord.getCity());
                                System.out.println("Email: " + MyRecord.getEmail());
                            }
                            case (2) -> {
                                System.out.println("Please give the start Location ID");
                                int start = ScannerMethod.inputNum();
                                System.out.println("Please give the finish Location ID");
                                int finish = ScannerMethod.inputNum();
                                if (finish < start) {
                                    for (int Pos = finish; Pos <= start; Pos++) {
                                        location MyRecordOne = location.getRecord(Pos);
                                        System.out.println("LID: " + MyRecordOne.getLID());
                                        System.out.println("Address: " + MyRecordOne.getStreetAddress());
                                        System.out.println("Postcode: " + MyRecordOne.getPostCode());
                                        System.out.println("City: " + MyRecordOne.getCity());
                                        System.out.println("Email: " + MyRecordOne.getEmail());
                                    }
                                } else {
                                    for (int Pos = start; Pos <= finish; Pos++) {
                                        location MyRecordTwo = location.getRecord(Pos);
                                        System.out.println("LID: " + MyRecordTwo.getLID());
                                        System.out.println("Address: " + MyRecordTwo.getStreetAddress());
                                        System.out.println("Postcode: " + MyRecordTwo.getPostCode());
                                        System.out.println("City: " + MyRecordTwo.getCity());
                                        System.out.println("Email: " + MyRecordTwo.getEmail());
                                    }
                                }
                            }
                            case (3) -> {
                                ArrayList<String> All = location.getAll();
                                for (String Record : All) {
                                    System.out.println(Record);
                                }
                            }
                            case (4) -> Selecting = false;
                        }
                    }
                }
                case (3) -> {
                    System.out.println("Is the value you're changing an Int or a String?");
                    System.out.println("[1] Int");
                    System.out.println("[2] String");
                    int Operate = ScannerMethod.inputNum();
                    if (Operate == 1) {
                        System.out.println("Enter the location ID");
                        int IDOne = ScannerMethod.inputNum();
                        System.out.println("Enter the field you want to enter");
                        String FieldOne = ScannerMethod.inputString();
                        System.out.println("Enter the replacement value");
                        int intChange = ScannerMethod.inputNum();
                        location.editTable(IDOne, FieldOne, intChange);

                        location MyRecord = location.getRecord(IDOne);
                        System.out.println("Updated Record");
                        System.out.println("LID: " + MyRecord.getLID());
                        System.out.println("Address: " + MyRecord.getStreetAddress());
                        System.out.println("Postcode: " + MyRecord.getPostCode());
                        System.out.println("City: " + MyRecord.getCity());
                        System.out.println("Email: " + MyRecord.getEmail());
                    } else if (Operate == 2) {
                        System.out.println("Enter the location ID");
                        int IDOne = ScannerMethod.inputNum();
                        System.out.println("Enter the field you want to enter");
                        String FieldOne = ScannerMethod.inputString();
                        System.out.println("Enter the replacement value");
                        String StringChange = ScannerMethod.inputString();
                        location.editTable(IDOne, FieldOne, StringChange);

                        location MyRecord = location.getRecord(IDOne);
                        System.out.println("Updated Record");
                        System.out.println("LID: " + MyRecord.getLID());
                        System.out.println("Address: " + MyRecord.getStreetAddress());
                        System.out.println("Postcode: " + MyRecord.getPostCode());
                        System.out.println("City: " + MyRecord.getCity());
                        System.out.println("Email: " + MyRecord.getEmail());
                    } else {
                        System.out.println("Incorrect value entered. Returning to previous menu.");
                    }
                }
                case (4) -> {
                    System.out.println("Are you identifying a record by an integer value, or a string value.");
                    System.out.println("[1] Int");
                    System.out.println("[2] String");
                    int OperateDelete = ScannerMethod.inputNum();
                    if (OperateDelete == 1) {
                        System.out.println("Enter the field name.");
                        String StringRecord = ScannerMethod.inputString();
                        System.out.println("Enter the record's field value.");
                        int IntIdentifier = ScannerMethod.inputNum();
                        location.deleteRecord(StringRecord, IntIdentifier);
                    } else if (OperateDelete == 2) {
                        System.out.println("Enter the field name.");
                        String StringRecord = ScannerMethod.inputString();
                        System.out.println("Enter the record's field value.");
                        String StringIdentifier = ScannerMethod.inputString();
                        location.deleteRecord(StringRecord, StringIdentifier);
                    } else {
                        System.out.println("Incorrect value entered. Returning to previous menu.");
                    }
                }
                case (5) -> LocationMenu = false;
            }

        }

    }

    static public void customerMethod(){ //Need to go through and change values from location to customer

        customer customer = new customer();

        boolean CustomerMenu = true;
        int Customer;

        while (CustomerMenu){
            InteractText.listInteract();

            Customer = ScannerMethod.inputNum();

            switch (Customer) {
                case (1) -> {
                    System.out.println("Please insert a Location ID.");
                    int fk_LID = ScannerMethod.inputNum();
                    System.out.println("Please insert a first name.");
                    String first_name = ScannerMethod.inputString();
                    System.out.println("Please insert a last name.");
                    String last_name = ScannerMethod.inputString();
                    System.out.println("Please insert a age.");
                    int age = ScannerMethod.inputNum();
                    System.out.println("Please enter a 1 for no loyalty, a 2 to indicate a loyalty bonus");
                    int loyalty = ScannerMethod.inputNum();
                    if (loyalty < 3 && loyalty > 0){
                        customer.createCustomer(fk_LID, first_name, last_name, age, loyalty);
                    }

                }
                case (2) -> {
                    boolean Selecting = true;
                    int select;
                    while (Selecting) {
                        System.out.println("How would you like to view the records?");
                        System.out.println("[1] Single record");
                        System.out.println("[2] Multiple");
                        System.out.println("[3] All");
                        System.out.println("[4] Return");

                        select = ScannerMethod.inputNum();

                        switch (select) {
                            case (1) -> {
                                System.out.println("Please give the Customer ID");
                                int ID = ScannerMethod.inputNum();
                                customer MyRecord = customer.getRecord(ID);
                                System.out.println("CID: " + MyRecord.getCID());
                                System.out.println("fk_LID: " + MyRecord.getFk_LID());
                                System.out.println("First Name: " + MyRecord.getFirst_name());
                                System.out.println("Last Name: " + MyRecord.getLast_name());
                                System.out.println("Age: " + MyRecord.getAge());
                                System.out.println("Has Loyalty: " + MyRecord.getLoyalty());
                            }
                            case (2) -> {
                                System.out.println("Please give the start Customer ID");
                                int start = ScannerMethod.inputNum();
                                System.out.println("Please give the finish Customer ID");
                                int finish = ScannerMethod.inputNum();
                                if (finish < start) {
                                    for (int Pos = finish; Pos <= start; Pos++) {
                                        customer MyRecordOne = customer.getRecord(Pos);
                                        System.out.println("CID: " + MyRecordOne.getCID());
                                        System.out.println("fk_LID: " + MyRecordOne.getFk_LID());
                                        System.out.println("First Name: " + MyRecordOne.getFirst_name());
                                        System.out.println("Last Name: " + MyRecordOne.getLast_name());
                                        System.out.println("Age: " + MyRecordOne.getAge());
                                        System.out.println("Has Loyalty: " + MyRecordOne.getLoyalty());
                                    }
                                } else {
                                    for (int Pos = start; Pos <= finish; Pos++) {
                                        customer MyRecordTwo = customer.getRecord(Pos);
                                        System.out.println("CID: " + MyRecordTwo.getCID());
                                        System.out.println("fk_LID: " + MyRecordTwo.getFk_LID());
                                        System.out.println("First Name: " + MyRecordTwo.getFirst_name());
                                        System.out.println("Last Name: " + MyRecordTwo.getLast_name());
                                        System.out.println("Age: " + MyRecordTwo.getAge());
                                        System.out.println("Has Loyalty: " + MyRecordTwo.getLoyalty());
                                    }
                                }
                            }
                            case (3) -> {
                                ArrayList<String> All = customer.getAll();
                                for (String Record : All) {
                                    System.out.println(Record);
                                }
                            }
                            case (4) -> Selecting = false;
                        }
                    }
                }
                case (3) -> {
                    System.out.println("Is the value you're changing an Int or a String?");
                    System.out.println("[1] Int");
                    System.out.println("[2] String");
                    int Operate = ScannerMethod.inputNum();
                    if (Operate == 1) {
                        System.out.println("Enter the location ID");
                        int IDOne = ScannerMethod.inputNum();
                        System.out.println("Enter the field you want to enter");
                        String FieldOne = ScannerMethod.inputString();
                        System.out.println("Enter the replacement value");
                        int intChange = ScannerMethod.inputNum();
                        customer.editTable(IDOne, FieldOne, intChange);

                        customer MyRecord = customer.getRecord(IDOne);
                        System.out.println("Updated Record");
                        System.out.println("CID: " + MyRecord.getCID());
                        System.out.println("fk_LID: " + MyRecord.getFk_LID());
                        System.out.println("First Name: " + MyRecord.getFirst_name());
                        System.out.println("Last Name: " + MyRecord.getLast_name());
                        System.out.println("Age: " + MyRecord.getAge());
                        System.out.println("Has Loyalty: " + MyRecord.getLoyalty());

                    } else if (Operate == 2) {
                        System.out.println("Enter the location ID");
                        int IDOne = ScannerMethod.inputNum();
                        System.out.println("Enter the field you want to enter");
                        String FieldOne = ScannerMethod.inputString();
                        System.out.println("Enter the replacement value");
                        String StringChange = ScannerMethod.inputString();
                        customer.editTable(IDOne, FieldOne, StringChange);

                        customer MyRecord = customer.getRecord(IDOne);
                        System.out.println("Updated Record");
                        System.out.println("CID: " + MyRecord.getCID());
                        System.out.println("fk_LID: " + MyRecord.getFk_LID());
                        System.out.println("First Name: " + MyRecord.getFirst_name());
                        System.out.println("Last Name: " + MyRecord.getLast_name());
                        System.out.println("Age: " + MyRecord.getAge());
                        System.out.println("Has Loyalty: " + MyRecord.getLoyalty());
                    } else {
                        System.out.println("Incorrect value entered. Returning to previous menu.");
                    }
                }
                case (4) -> {
                    System.out.println("Are you identifying a record by an integer value, or a string value.");
                    System.out.println("[1] Int");
                    System.out.println("[2] String");
                    int OperateDelete = ScannerMethod.inputNum();
                    if (OperateDelete == 1) {
                        System.out.println("Enter the field name.");
                        String StringRecord = ScannerMethod.inputString();
                        System.out.println("Enter the record's field value.");
                        int IntIdentifier = ScannerMethod.inputNum();
                        customer.deleteRecord(StringRecord, IntIdentifier);
                    } else if (OperateDelete == 2) {
                        System.out.println("Enter the field name.");
                        String StringRecord = ScannerMethod.inputString();
                        System.out.println("Enter the record's field value.");
                        String StringIdentifier = ScannerMethod.inputString();
                        customer.deleteRecord(StringRecord, StringIdentifier);
                    } else {
                        System.out.println("Incorrect value entered. Returning to previous menu.");
                    }
                }
                case (5) -> CustomerMenu = false;
            }

        }

    }

    static public void gamesMethod(){ //Need to change from location to game

        games games = new games();

        boolean GamesMenu = true;
        int Game;

        while (GamesMenu){
            InteractText.listInteract();

            Game = ScannerMethod.inputNum();

            switch (Game) {
                case (1) -> {
                    System.out.println("Please insert a game name.");
                    String gameName = ScannerMethod.inputString();
                    System.out.println("Please insert an age rating.");
                    int ageRating = ScannerMethod.inputNum();

                    System.out.println("Please insert the following values as integers.");
                    System.out.println("Please insert a release day.");
                    String day = ScannerMethod.inputString();
                    System.out.println("Please insert a release month.");
                    String month = ScannerMethod.inputString();
                    System.out.println("Please insert a release year.");
                    String year = ScannerMethod.inputString();
                    String date = year + "-" + month + "-" + day;

                    System.out.println("Please insert a genre.");
                    String genre = ScannerMethod.inputString();
                    System.out.println("Please insert a gamePrice");
                    double price = ScannerMethod.inputDubz();

                    games.createRecord(gameName, ageRating, date, genre, price);
                }
                case (2) -> {
                    boolean Selecting = true;
                    int select;
                    while (Selecting) {
                        InteractText.selectStatement();

                        select = ScannerMethod.inputNum();

                        switch (select) {
                            case (1) -> {
                                System.out.println("Please give the Game ID");
                                int ID = ScannerMethod.inputNum();
                                games MyRecord = games.getRecord(ID);
                                System.out.println("PID: " + MyRecord.getPID());
                                System.out.println("Title: " + MyRecord.getGameName());
                                System.out.println("Rating: " + MyRecord.getAgeRating());
                                System.out.println("Release Date: " + MyRecord.getDateReleased());
                                System.out.println("Genre: " + MyRecord.getGenre());
                                System.out.println("Price: " + MyRecord.getGamePrice());
                            }
                            case (2) -> {
                                System.out.println("Please give the start Game ID");
                                int start = ScannerMethod.inputNum();
                                System.out.println("Please give the finish Game ID");
                                int finish = ScannerMethod.inputNum();
                                if (finish < start) {
                                    for (int Pos = finish; Pos <= start; Pos++) {
                                        games MyRecordOne = games.getRecord(Pos);
                                        System.out.println("PID: " + MyRecordOne.getPID());
                                        System.out.println("Title: " + MyRecordOne.getGameName());
                                        System.out.println("Rating: " + MyRecordOne.getAgeRating());
                                        System.out.println("Release Date: " + MyRecordOne.getDateReleased());
                                        System.out.println("Genre: " + MyRecordOne.getGenre());
                                        System.out.println("Price: " + MyRecordOne.getGamePrice());
                                    }
                                } else {
                                    for (int Pos = start; Pos <= finish; Pos++) {
                                        games MyRecordTwo = games.getRecord(Pos);
                                        System.out.println("PID: " + MyRecordTwo.getPID());
                                        System.out.println("Title: " + MyRecordTwo.getGameName());
                                        System.out.println("Rating: " + MyRecordTwo.getAgeRating());
                                        System.out.println("Release Date: " + MyRecordTwo.getDateReleased());
                                        System.out.println("Genre: " + MyRecordTwo.getGenre());
                                        System.out.println("Price: " + MyRecordTwo.getGamePrice());
                                    }
                                }
                            }
                            case (3) -> {
                                ArrayList<String> All = games.getAll();
                                for (String Record : All) {
                                    System.out.println(Record);
                                }
                            }
                            case (4) -> Selecting = false;
                        }
                    }
                }
                case (3) -> {
                    System.out.println("Is the value you're changing an Int or a String?");
                    System.out.println("[1] Int");
                    System.out.println("[2] String");
                    int Operate = ScannerMethod.inputNum();
                    if (Operate == 1) {
                        System.out.println("Enter the game ID");
                        int IDOne = ScannerMethod.inputNum();
                        System.out.println("Enter the field you want to enter");
                        String FieldOne = ScannerMethod.inputString();
                        System.out.println("Enter the replacement value");
                        int intChange = ScannerMethod.inputNum();
                        games.editTable(IDOne, FieldOne, intChange);

                        games MyRecord = games.getRecord(IDOne);
                        System.out.println("Updated Record");
                        System.out.println("PID: " + MyRecord.getPID());
                        System.out.println("Title: " + MyRecord.getGameName());
                        System.out.println("Rating: " + MyRecord.getAgeRating());
                        System.out.println("Release Date: " + MyRecord.getDateReleased());
                        System.out.println("Genre: " + MyRecord.getGenre());
                        System.out.println("Price: " + MyRecord.getGamePrice());
                    } else if (Operate == 2) {
                        System.out.println("Enter the product ID");
                        int IDOne = ScannerMethod.inputNum();
                        System.out.println("Enter the field you want to enter");
                        String FieldOne = ScannerMethod.inputString();
                        System.out.println("Enter the replacement value");
                        String StringChange = ScannerMethod.inputString();
                        games.editTable(IDOne, FieldOne, StringChange);

                        games MyRecord = games.getRecord(IDOne);
                        System.out.println("Updated Record");
                        System.out.println("PID: " + MyRecord.getPID());
                        System.out.println("Title: " + MyRecord.getGameName());
                        System.out.println("Rating: " + MyRecord.getAgeRating());
                        System.out.println("Release Date: " + MyRecord.getDateReleased());
                        System.out.println("Genre: " + MyRecord.getGenre());
                        System.out.println("Price: " + MyRecord.getGamePrice());
                    } else {
                        System.out.println("Incorrect value entered. Returning to previous menu.");
                    }
                }
                case (4) -> {
                    System.out.println("Are you identifying a record by an integer value, or a string value.");
                    System.out.println("[1] Int");
                    System.out.println("[2] String");
                    int OperateDelete = ScannerMethod.inputNum();
                    if (OperateDelete == 1) {
                        System.out.println("Enter the field name.");
                        String StringRecord = ScannerMethod.inputString();
                        System.out.println("Enter the record's field value.");
                        int IntIdentifier = ScannerMethod.inputNum();
                        games.deleteRecord(StringRecord, IntIdentifier);
                    } else if (OperateDelete == 2) {
                        System.out.println("Enter the field name.");
                        String StringRecord = ScannerMethod.inputString();
                        System.out.println("Enter the record's field value.");
                        String StringIdentifier = ScannerMethod.inputString();
                        games.deleteRecord(StringRecord, StringIdentifier);
                    } else {
                        System.out.println("Incorrect value entered. Returning to previous menu.");
                    }
                }
                case (5) -> GamesMenu = false;
            }

        }

    }

    static public void orderMethod(){

        orders order = new orders();

        boolean OrdersMenu = true;
        int Orders;

        while (OrdersMenu){
            InteractText.listInteract();

            Orders = ScannerMethod.inputNum();

            switch (Orders) {
                case (1) -> {
                    System.out.println("Please insert a customer ID.");
                    int fk_CID = ScannerMethod.inputNum();

                    System.out.println("Please insert the following values as integers.");
                    System.out.println("Please insert a purchase day.");
                    String day = ScannerMethod.inputString();
                    System.out.println("Please insert a purchase month.");
                    String month = ScannerMethod.inputString();
                    System.out.println("Please insert a purchase year.");
                    String year = ScannerMethod.inputString();
                    String date = year + "-" + month + "-" + day;

                    order.createRecord(fk_CID, date);
                }
                case (2) -> {
                    boolean Selecting = true;
                    int select;
                    while (Selecting) {
                        InteractText.selectStatement();

                        select = ScannerMethod.inputNum();

                        switch (select) {
                            case (1) -> {
                                System.out.println("Please give the Orders ID");
                                int ID = ScannerMethod.inputNum();
                                orders MyRecord = order.getRecord(ID);
                                System.out.println("OID: " + MyRecord.getOID());
                                System.out.println("fk_CID: " + MyRecord.getFk_CID());
                                System.out.println("Order Date: " + MyRecord.getOrderDate().toString());
                            }
                            case (2) -> {
                                System.out.println("Please give the start Orders ID");
                                int start = ScannerMethod.inputNum();
                                System.out.println("Please give the finish Orders ID");
                                int finish = ScannerMethod.inputNum();
                                if (finish < start) {
                                    for (int Pos = finish; Pos <= start; Pos++) {
                                        orders MyRecordOne = order.getRecord(Pos);
                                        System.out.println("OID: " + MyRecordOne.getOID());
                                        System.out.println("fk_CID: " + MyRecordOne.getFk_CID());
                                        System.out.println("Order Date: " + MyRecordOne.getOrderDate().toString());
                                    }
                                } else {
                                    for (int Pos = start; Pos <= finish; Pos++) {
                                        orders MyRecordTwo = order.getRecord(Pos);
                                        System.out.println("OID: " + MyRecordTwo.getOID());
                                        System.out.println("fk_CID: " + MyRecordTwo.getFk_CID());
                                        System.out.println("Order Date: " + MyRecordTwo.getOrderDate().toString());
                                    }
                                }
                            }
                            case (3) -> {
                                ArrayList<String> All = order.getAll();
                                for (String Record : All) {
                                    System.out.println(Record);
                                }
                            }
                            case (4) -> Selecting = false;
                        }
                    }
                }
                case (3) -> {
                    System.out.println("Is the value you're changing an Int or a String?");
                    System.out.println("[1] Int");
                    System.out.println("[2] String");
                    int Operate = ScannerMethod.inputNum();
                    if (Operate == 1) {
                        System.out.println("Enter the order ID");
                        int IDOne = ScannerMethod.inputNum();
                        System.out.println("Enter the field you want to enter");
                        String FieldOne = ScannerMethod.inputString();
                        System.out.println("Enter the replacement value");
                        int intChange = ScannerMethod.inputNum();
                        order.editTable(IDOne, FieldOne, intChange);

                        orders MyRecord = order.getRecord(IDOne);
                        System.out.println("Updated Record");
                        System.out.println("OID: " + MyRecord.getOID());
                        System.out.println("fk_CID: " + MyRecord.getFk_CID());
                        System.out.println("Order Date: " + MyRecord.getOrderDate());
                    } else if (Operate == 2) {
                        System.out.println("Enter the order ID");
                        int IDOne = ScannerMethod.inputNum();
                        System.out.println("Enter the field you want to enter");
                        String FieldOne = ScannerMethod.inputString();
                        System.out.println("Enter the replacement value");
                        String StringChange = ScannerMethod.inputString();
                        order.editTable(IDOne, FieldOne, StringChange);

                        orders MyRecord = order.getRecord(IDOne);
                        System.out.println("Updated Record");
                        System.out.println("OID: " + MyRecord.getOID());
                        System.out.println("fk_CID: " + MyRecord.getFk_CID());
                        System.out.println("Order Date: " + MyRecord.getOrderDate());
                    } else {
                        System.out.println("Incorrect value entered. Returning to previous menu.");
                    }
                }
                case (4) -> {
                    System.out.println("Are you identifying a record by an integer value, or a string value.");
                    System.out.println("[1] Int");
                    System.out.println("[2] String");
                    int OperateDelete = ScannerMethod.inputNum();
                    if (OperateDelete == 1) {
                        System.out.println("Enter the field name.");
                        String StringRecord = ScannerMethod.inputString();
                        System.out.println("Enter the record's field value.");
                        int IntIdentifier = ScannerMethod.inputNum();
                        order.deleteRecord(StringRecord, IntIdentifier);
                    } else if (OperateDelete == 2) {
                        System.out.println("Enter the field name.");
                        String StringRecord = ScannerMethod.inputString();
                        System.out.println("Enter the record's field value.");
                        String StringIdentifier = ScannerMethod.inputString();
                        order.deleteRecord(StringRecord, StringIdentifier);
                    } else {
                        System.out.println("Incorrect value entered. Returning to previous menu.");
                    }
                }
                case (5) -> OrdersMenu = false;
            }

        }

    }

    static public void orders_gamesMethod(){ //Need to change from location

        orders_games OrderGame = new orders_games();

        boolean OrdGameMenu = true;
        int OrdGame;

        while (OrdGameMenu){
            System.out.println("How would you like to interact with the table?"); //Need to change so edit is gone
            System.out.println("[1] Create");
            System.out.println("[2] Read");
            System.out.println("[3] Delete");
            System.out.println("[4] Total cost for an order");
            System.out.println("[5] Return");

            OrdGame = ScannerMethod.inputNum();

            switch (OrdGame) {
                case (1) -> {
                    System.out.println("Please insert an order ID.");
                    int OID = ScannerMethod.inputNum();
                    System.out.println("Please insert a product ID.");
                    int PID = ScannerMethod.inputNum();
                    OrderGame.createRecord(OID, PID);
                }
                case (2) -> {
                    boolean Selecting = true;
                    int select;
                    while (Selecting) {
                        System.out.println("How would you like to select");
                        System.out.println("[1] Specifying ID Type");
                        System.out.println("[2] All Records");
                        System.out.println("[3] Return");

                        select = ScannerMethod.inputNum();

                        switch (select) {
                            case (1) -> {
                                System.out.println("Please give the Field you're searching by");
                                String Field = ScannerMethod.inputString();
                                System.out.println("Please give the ID");
                                int ID = ScannerMethod.inputNum();
                                ArrayList<orders_games> Selected = OrderGame.getRecords(Field, ID);
                                for (orders_games Record: Selected) {
                                    System.out.println("fk_OID: " + Record.getFk_OID() + " - " + "fk_PID: " + Record.getFk_PID());
                                }
                            }
                            case (2) -> {
                                ArrayList<String> All = OrderGame.getAll();
                                for (String Record : All) {
                                    System.out.println(Record);
                                }
                            }
                            case (3) -> Selecting = false;
                        }
                    }
                }
                case (3) -> {

                    System.out.println("Enter the field name.");
                    String StringRecord = ScannerMethod.inputString();
                    System.out.println("Enter the record's field value.");
                    System.out.println("Be warned, this will delete all records with the value selected.");
                    System.out.println("E.g if you select 'fk_PID' and to delete ID 2, it will delete all records with a value of 2");
                    int IntIdentifier = ScannerMethod.inputNum();
                    OrderGame.deleteRecord(StringRecord, IntIdentifier);

                }
                case (4) -> {
                    System.out.println("Enter the OID you want tallied.");
                    int OID = ScannerMethod.inputNum();
                    System.out.println("£" + OrderGame.tallyCost(OID));
                }
                case (5) -> OrdGameMenu = false;
            }

        }

    }

    static public void options(){

        boolean optionsMenu = true;
        int Option;

        System.out.println("Please enter your password");
        String PasswordGuess;
        PasswordGuess = ScannerMethod.inputString();

        if(PasswordGuess.equals(Configuration.PASSWORD)){

            System.out.println("Password correct.");

            while (optionsMenu){
                InteractText.options();

                Option = ScannerMethod.inputNum();

                switch (Option) {
                    case (1) -> System.out.println(Configuration.URL);
                    case (2) -> System.out.println(Configuration.USER);
                    case (3) -> System.out.println(Configuration.PASSWORD);
                    case (4) -> {
                        System.out.println("James Harper");
                        System.out.println("https://github.com/JamesRichardHarper/QAProject");
                    }
                    case (5) -> optionsMenu = false;
                }

            }

        }
        else {
            System.out.println("Incorrect. Returning to menu.");
        }
    }
}
