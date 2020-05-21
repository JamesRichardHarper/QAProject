import BackEnd.ConnectMethod;
import BackEnd.Tables.customer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReadTests {

    @Before
    public void initiateTest(){
        ConnectMethod.getConnection();
    }

    @Test
    public void createAndRead() {
        customer TestCustomer = new customer();
        String TestName = TestCustomer.getRecord(1).getFirst_name();

        Assert.assertEquals( TestName , "James");
    }


    @After
    public void endTest(){
        ConnectMethod.close();
    }
}
