package com.div.project.tests;

import com.div.project.base.BaseClass;
import com.div.project.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

    @Test
    public void validLoginTest() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");
        Assert.assertTrue(driver.getTitle().contains("Swag Labs"));
    }
}
