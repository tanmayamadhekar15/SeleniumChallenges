package com.seleniumautomationtesting.SeleniumChallenges.VWO;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class Challenge5_LoginWithWait {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
        driver.get("https://app.vwo.com/#/login");
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement email=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-username")));
        driver.findElement(By.xpath("//input[@id=\"js-login-confirm-email\"]"));
        email.sendKeys("vwo@1secmail.com");

        WebElement pass=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-password")));
        pass.sendKeys("Vwo@1234");

        WebElement rememberME=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox-remember")));
        rememberME.isSelected();

        WebElement click_button=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js-login-btn")));
        click_button.click();

        WebElement dashboard=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-qa=\"lufexuloga\"]")));
        String textDashboard=dashboard.getText();
        Assert.assertEquals(textDashboard,"V W");

    }
    @AfterTest
    public void closeBrowser() {

        driver.quit();

    }

}
