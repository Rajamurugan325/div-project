package com.div.project.tests;

import com.div.project.base.BaseClass;
import com.div.project.pages.LoginPage;
import com.div.project.pages.Productpage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Cartvalidation extends BaseClass {

    @Test
    public void validateCart() {

        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        Productpage products = new Productpage(driver);
        products.addProductToCart();
        products.goToCart();

        boolean itemPresent = driver.findElement(By.className("inventory_item_name")).isDisplayed();
        Assert.assertTrue(itemPresent);
    }
}