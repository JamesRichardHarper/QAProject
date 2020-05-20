package UI;

import BackEnd.Configuration;
import BackEnd.Tables.customer;
import BackEnd.Tables.location;

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
                    System.out.println("Please enter a 0 for no loyalty, a 1 to indicate a loyalty bonus");
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
                case (5) -> CustomerMenu = false;
            }

        }

    }

    static public void gamesMethod(){ //Need to change from location to game

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

    static public void orderMethod(){ //need to change to order from location

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

    static public void orders_gamesMethod(){ //Need to change from location

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
