package BackEnd.Tables;

import java.util.ArrayList;

public interface CRUDMethod {

    public ArrayList<String> getAll();

    public void editTable(int ID, String FieldToEdit, String FieldAlteration);
    public void editTable(int ID, String FieldToEdit, int FieldAlteration);

    public void deleteRecord(int Idenitifier, String FieldToDelete);
    public void deleteRecord(String Identifier, String FieldToDelete);
    public void deleteAll();

}
