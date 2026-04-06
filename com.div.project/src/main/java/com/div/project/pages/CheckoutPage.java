package com.div.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Locators
    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By zipCode = By.id("postal-code");
    By continueBtn = By.id("continue");
    By finishBtn = By.id("finish");
    By successMsg = By.className("complete-header");

    public void completeCheckout(String fName, String lName, String zip) {

        // Fill user details
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).clear();
        driver.findElement(firstName).sendKeys(fName);

        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(lName);

        driver.findElement(zipCode).clear();
        driver.findElement(zipCode).sendKeys(zip);

        // 🔥 Robust Continue Click
        WebElement continueElement = wait.until(
                ExpectedConditions.elementToBeClickable(continueBtn)
        );

        try {
            continueElement.click();
        } catch (Exception e) {
            // Fallback JS click
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", continueElement);
        }

        // Debug
        System.out.println("URL after Continue: " + driver.getCurrentUrl());

        // Wait for next page
        wait.until(ExpectedConditions.urlContains("checkout-step-two"));

        // Click Finish
        WebElement finishElement = wait.until(
                ExpectedConditions.elementToBeClickable(finishBtn)
        );
        finishElement.click();

        // Wait for completion page
        wait.until(ExpectedConditions.urlContains("checkout-complete"));

        // Debug
        String currentUrl = driver.getCurrentUrl();
        System.out.println("After Finish URL: " + currentUrl);

        // Validate URL
        if (!currentUrl.contains("checkout-complete")) {
            throw new AssertionError("Checkout failed!");
        }

        // Validate success message
        String message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(successMsg)
        ).getText();

        System.out.println("Checkout Message: " + message);
    }
}