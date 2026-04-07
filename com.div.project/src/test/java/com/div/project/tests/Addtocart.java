package com.div.project.tests;

import com.div.project.base.BaseClass;
import com.div.project.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Addtocart extends BaseClass {

    @Test
    public void addItemTest() {

        
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        
        Assert.assertTrue(driver.getPageSource().contains("Remove"));
    }
}
