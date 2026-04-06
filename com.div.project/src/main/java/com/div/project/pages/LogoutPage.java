package com.div.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class LogoutPage {

    WebDriver driver;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    By menuBtn = By.id("react-burger-menu-btn");
    By logoutBtn = By.id("logout_sidebar_link");

    public void logout() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 🔥 WAIT for menu button
        wait.until(ExpectedConditions.elementToBeClickable(menuBtn)).click();

        // 🔥 WAIT for logout option
        wait.until(ExpectedConditions.elementToBeClickable(logoutBtn)).click();
    }
}