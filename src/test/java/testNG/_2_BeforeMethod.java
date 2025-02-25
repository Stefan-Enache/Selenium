package testNG;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _2_BeforeMethod {

// login
// search
// logout
// login
// advanced search
// logout

    @BeforeMethod (groups = "sanity")
    void login() {
        System.out.println("before method");
    }

    @Test(priority = 1, groups = "regression")
    void search() {
        System.out.println("search");
    }

    @Test(priority = 2, groups = {"sanity", "regression"})
    void advancedSearch() {
        System.out.println("advanced search");
    }

    @AfterMethod(groups = {"sanity", "regression"})
    void logout() {
        System.out.println("after method");
    }

}
