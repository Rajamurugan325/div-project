package com.div.project.tests;

import com.div.project.base.BaseClass;
import com.div.project.pages.*;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Endtoend extends BaseClass {

    @Test
    public void fullFlow() {

        
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        
        Productpage product = new Productpage(driver);
        product.addProductToCart();
        product.goToCart();

        
        CartPage cart = new CartPage(driver);
        cart.clickCheckout();

        
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.completeCheckout("Raja", "Automation", "600001");

        
        String finalUrl = driver.getCurrentUrl();
        Assert.assertTrue(finalUrl.contains("checkout-complete"),
                "Checkout failed!");

        
        String successMessage = driver.findElement(By.className("complete-header")).getText();
        Assert.assertEquals(successMessage, "Thank you for your order!");

        
        LogoutPage logout = new LogoutPage(driver);
        logout.logout();

        System.out.println("End test reached");
    }
}
