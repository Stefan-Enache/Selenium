package testNG;

import org.testng.annotations.*;

public class _6_AllAnnotations {

    @BeforeSuite
    void as() {
        System.out.println("before suite");
    }

    @AfterSuite
    void bs() {
        System.out.println("after suite");
    }



    @BeforeTest
    void bt() {
        System.out.println("before test");
    }

    @AfterTest
    void at() {
        System.out.println("after test");
    }



    @BeforeClass
    void bc() {
        System.out.println("before class");
    }

    @AfterClass
    void ac() {
        System.out.println("after class");
    }



    @BeforeMethod
    void bm() {
        System.out.println("before method");
    }

    @AfterMethod
    void am() {
        System.out.println("after method");
    }



    @Test(priority = 1)
    void search() {
        System.out.println("search");
    }

    @Test(priority = 2)
    void advancedSearch() {
        System.out.println("advancedSearch");
    }

}
