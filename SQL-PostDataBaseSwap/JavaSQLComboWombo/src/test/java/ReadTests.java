import BackEnd.ConnectMethod;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReadTests {

    @Before
    public void initiateTest(){
        ConnectMethod.getConnection();
    }

    @Test


    @After
    public void endTest(){
        ConnectMethod.close();
    }
}
