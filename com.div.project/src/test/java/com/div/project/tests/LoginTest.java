package com.div.project.tests;

import com.div.project.base.BaseClass;
import org.testng.Assert;
import com.div.project.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

    @Test
    public void validLoginTest() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");
    }
}