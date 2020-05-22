import BackEnd.ConnectMethod;
import BackEnd.Tables.customer;
import BackEnd.Tables.games;
import BackEnd.Tables.location;
import BackEnd.Tables.orders;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ReadTests {

    @Before
    public void initiateTest(){
        ConnectMethod.getConnection();
    }

    @Test
    public void getAndReadCustomer() {
        customer TestCustomer = new customer();
        String TestName = TestCustomer.getRecord(1).getFirst_name();

        Assert.assertEquals( TestName , "James");
    }


    @Test
    public void deleteCreateReadGame() {
        games Test = new games();
        Test.createRecord("GameyGame", 12, "12.12.2020", "Action", 39.99);
        ArrayList<String> MultiTest = Test.getAll();

        boolean contains = false;

        for(String InnerTest:MultiTest){
            if (InnerTest.contains("GameyGame")) {
                contains = true;
                break;
            }
        }

        Assert.assertTrue(contains);
    }

    @Test
    public void readEdit(){
        orders Test = new orders();
        Test.editTable(3, "orderDate", "1999-12-21");
        String date = Test.getRecord(3).getOrderDate().toString();

        Assert.assertEquals("1999-12-21",date);

    }


    @After
    public void endTest(){
        ConnectMethod.close();
    }
}
