package com.div.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Productpage {

    WebDriver driver;

    public Productpage(WebDriver driver) {
        this.driver = driver;
    }

    By firstProduct = By.xpath("(//button[text()='Add to cart'])[1]");
    By cartIcon = By.className("shopping_cart_link");

    public void addProductToCart() {
        driver.findElement(firstProduct).click();
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }
}