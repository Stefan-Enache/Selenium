package testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class _3_BeforeClass {

// login
// search
// advanced search
// logout

    @BeforeClass
    void login() {
        System.out.println("before class");
    }

    @Test(priority = 1)
    void search() {
        System.out.println("search");
    }

    @Test(priority = 2)
    void advancedSearch() {
        System.out.println("advanced search");
    }

    @AfterClass
    void logout() {
        System.out.println("after class");
    }

}
