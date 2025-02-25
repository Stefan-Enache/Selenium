package testNG;

import org.testng.annotations.*;

public class _5_BeforeSuite {

    @AfterSuite
    void logout() {
        System.out.println("after suite");
    }

    @Test(priority = 1)
    void search() {
        System.out.println("search 3");
    }

    @BeforeSuite
    void login() {
        System.out.println("before suite");
    }

}
