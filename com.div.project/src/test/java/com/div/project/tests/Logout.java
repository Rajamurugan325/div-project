package com.div.project.tests;

import com.div.project.base.BaseClass;
import com.div.project.pages.LoginPage;
import com.div.project.pages.LogoutPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Logout extends BaseClass {

    @Test
    public void logoutTest() {

        
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        
        LogoutPage logout = new LogoutPage(driver);
        logout.logout();

        
        boolean loginButtonVisible = driver.findElement(By.id("login-button")).isDisplayed();
        Assert.assertTrue(loginButtonVisible, "Logout failed!");
    }
}
