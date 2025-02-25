package testNG;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class _4_BeforeTest_1 {

    // All tests must be grouped inside <classes> tag in XML

    @BeforeTest
    void login() {
        System.out.println("before test");
    }

    @Test(priority = 1)
    void search() {
        System.out.println("search 1");
    }

}
