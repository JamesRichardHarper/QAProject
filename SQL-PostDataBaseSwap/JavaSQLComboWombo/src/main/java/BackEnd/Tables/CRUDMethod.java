package BackEnd.Tables;

import java.util.ArrayList;

public interface CRUDMethod {

    public ArrayList<String> getAll();

    public void editTable(int ID, String FieldToEdit, String FieldAlteration);
    public void editTable(int ID, String FieldToEdit, int FieldAlteration);

    public void deleteRecord(String FieldToDeleteFrom, int Identifier);
    public void deleteRecord(String FieldToDeleteFrom, String Identifier);
    public void deleteAll();

}
