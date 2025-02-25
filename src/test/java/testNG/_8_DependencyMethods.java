package testNG;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(testNG._11_Listener.class)      // with this annotation listener will work without xml
public class _8_DependencyMethods {

    @Test(priority = 1)
    void openApp() {
        Assert.assertTrue(true);
    }

    @Test(priority = 2, dependsOnMethods = {"openApp"})
    void login() {
        Assert.assertTrue(true);
    }

    @Test(priority = 3, dependsOnMethods = "login")
    void search() {
        Assert.assertTrue(false);
    }   // intentional Fail

    @Test(priority = 4, dependsOnMethods = {"login", "search"})
    void advancedSearch() {
        Assert.assertTrue(true);
    }

    @Test(priority = 5, dependsOnMethods = "login")
    void logout() {
        Assert.assertTrue(true);
    }

}
