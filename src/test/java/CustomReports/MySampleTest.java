package CustomReports;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MySampleTest {

    @Test
    public void test1(){
        Assert.assertEquals(false, true);
    }

    @Test
    public void test2(){
        Assert.assertEquals(false,true);
    }
}
