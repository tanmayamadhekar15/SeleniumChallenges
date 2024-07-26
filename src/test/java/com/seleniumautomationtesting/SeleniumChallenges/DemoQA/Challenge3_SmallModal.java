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

public class Challenge3_SmallModal {
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
        WebElement smallModal=driver.findElement(By.xpath("//button[@id=\"showSmallModal\"]"));
        smallModal.click();
        String verifyModal= smallModal.getText();
        Assert.assertEquals(verifyModal,"Small modal");
        WebElement content=driver.findElement(By.xpath("//div[@class=\"modal-body\"]"));
        String smallContent=content.getText();
        Assert.assertEquals(smallContent,"This is a small modal. It has very less content");
        //close
        WebElement closeSmallModal=driver.findElement(By.xpath("//div/button[@id=\"closeSmallModal\"]"));
        closeSmallModal.click();

    }
    @Test
    public void testChrome() throws InterruptedException {

        driver.get("https://demoqa.com/modal-dialogs");
        System.out.println(driver.getTitle());

        driver.manage().window().maximize();
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();  // scroll using action class

        // Search Element
        WebElement smallModal=driver.findElement(By.xpath("//button[@id=\"showSmallModal\"]"));
        smallModal.click();
        String verifyModal= smallModal.getText();
        Assert.assertEquals(verifyModal,"Small modal");
        WebElement content=driver.findElement(By.xpath("//div[@class=\"modal-body\"]"));
        String smallContent=content.getText();
        Assert.assertEquals(smallContent,"This is a small modal. It has very less content");
        //close
        WebElement closeSmallModal=driver.findElement(By.xpath("//div/button[@id=\"closeSmallModal\"]"));
        closeSmallModal.click();

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
