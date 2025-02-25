package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _7_Assertions {

    @Test
    void testTitle() {

        String expectedTitle = "OpenCart";
        String actualTitle = "OpenShop";

        // Hard Assertions  -> statements after Fail will not execute
//        if(expectedTitle.equals(actualTitle)) {
//            System.out.println("Test passed");
//            Assert.assertTrue(true);
//        } else {
//            System.out.println("Test failed");
//            Assert.assertFalse(true);  // fail
//        }

//        Assert.assertEquals(expectedTitle, actualTitle);
//        Assert.assertEquals("123", 123);                    // false
//        Assert.assertEquals("123", String.valueOf(123));    // true
//        Assert.assertNotEquals("aaa", "gdsgsdgdsg");
//        Assert.fail();



        // Soft Assertions  -> statements after Fail will execute anyway
        System.out.println("testing");
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(1==2);
        System.out.println("Testing after Fail");

        sa.assertAll(); // mandatory -> without this it will pass even when it's supposed to fail

    }
}
