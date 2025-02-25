package testNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class _4_BeforeTest_2 {

    @AfterTest
    void logout() {
        System.out.println("after test");
    }

    // priority is based on XML <class> order, not (priority = 2)
    @Test(priority = 2)
    void search() {
        System.out.println("search 2");
    }

}
