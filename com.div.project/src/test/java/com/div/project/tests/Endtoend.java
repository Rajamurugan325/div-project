package com.div.project.tests;

import com.div.project.base.BaseClass;
import com.div.project.pages.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Endtoend extends BaseClass {

    @Test
    public void fullFlow() {

        // Login
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        // Add Product
        Productpage product = new Productpage(driver);
        product.addProductToCart();
        product.goToCart();

        // Cart
        CartPage cart = new CartPage(driver);
        cart.clickCheckout();

        // Checkout
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.completeCheckout("Raja", "Automation", "600001");

        // Validation (VERY IMPORTANT)
        String finalUrl = driver.getCurrentUrl();
        Assert.assertTrue(finalUrl.contains("checkout-complete"),
                "Checkout failed!");

        // Logout
        LogoutPage logout = new LogoutPage(driver);
        logout.logout();

        // Final log (correct place ✅)
        System.out.println("End test reached");
    }
}