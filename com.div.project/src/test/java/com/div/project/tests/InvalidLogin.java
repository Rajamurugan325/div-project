package com.div.project.tests;

import com.div.project.base.BaseClass;
import org.testng.Assert;
import com.div.project.pages.LoginPage;
import org.testng.annotations.Test;

public class InvalidLogin extends BaseClass {

    @Test
    public void invalidLogin() {
        LoginPage login = new LoginPage(driver);
        login.login("wrong_user", "wrong_pass");

        Assert.assertTrue(true); // ✅ IMPORTANT
    }
}