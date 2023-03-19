package test;

import org.junit.Assert;
import org.testng.annotations.Test;

public class SureFireReportTest {
    @Test
    public void shouldBePassToTestSureFireReportOnly(){
        Assert.assertTrue(1==1);
    }

    @Test
    public void shouldBeFailedToTestSureFireReportOnly(){
        Assert.assertTrue(1==2);
    }
}
