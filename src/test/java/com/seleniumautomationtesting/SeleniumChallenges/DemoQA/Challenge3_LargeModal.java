package com.seleniumautomationtesting.SeleniumChallenges.DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Challenge3_LargeModal {
    EdgeDriver driver;
    ChromeDriver chromeDriver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
        chromeDriver=new ChromeDriver();
    }


    @Test
    public void test() throws InterruptedException {

        driver.get("https://demoqa.com/modal-dialogs");
        System.out.println(driver.getTitle());

        driver.manage().window().maximize();
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();  // scroll using action class

        // Search Element
         WebElement largeModal=driver.findElement(By.cssSelector("button[id=\"showLargeModal\"]"));
         largeModal.click();
         String verifyModal= largeModal.getText();
         Assert.assertEquals(verifyModal,"Large modal");

         //close
         WebElement closelargeModal=driver.findElement(By.xpath("//div/button[@id=\"closeLargeModal\"]"));
         closelargeModal.click();

    }
    @Test
    public void testChrome() throws InterruptedException {

        chromeDriver.get("https://demoqa.com/modal-dialogs");
        System.out.println(chromeDriver.getTitle());

        chromeDriver.manage().window().maximize();
        Actions actions=new Actions(chromeDriver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();  // scroll using action class

        // Search Element
        WebElement largeModal=chromeDriver.findElement(By.cssSelector("button[id=\"showLargeModal\"]"));
        largeModal.click();
        String verifyModal= largeModal.getText();
        Assert.assertEquals(verifyModal,"Large modal");

        //close
        WebElement closelargeModal=chromeDriver.findElement(By.xpath("//div/button[@id=\"closeLargeModal\"]"));
        closelargeModal.click();

    }

    @AfterTest
    public void closeBrowser() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
        chromeDriver.quit();
    }
}
