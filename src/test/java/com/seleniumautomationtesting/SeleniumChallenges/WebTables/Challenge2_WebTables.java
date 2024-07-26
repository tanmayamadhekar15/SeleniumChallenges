package com.seleniumautomationtesting.SeleniumChallenges.WebTables;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Challenge2_WebTables {
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

        driver.get("https://demoqa.com/webtables");
        System.out.println(driver.getTitle());

        driver.manage().window().maximize();
        /*Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();*/  // scroll using action class
        JavascriptExecutor js=(JavascriptExecutor)driver;
        WebElement editButton1=driver.findElement(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group'][1]/div[@class=\"rt-tr -odd\"]/div[@class='rt-td'][7]/div/span[@id='edit-record-1']/*[name()='svg']"));
        js.executeScript("arguments[0].scrollIntoView(true);",editButton1);

        //Search elements
        WebElement editButton3=driver.findElement(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group'][3]/div[@class=\"rt-tr -odd\"]/div[@class='rt-td'][7]/div/span[@id='edit-record-3']/*[name()='svg']"));
        editButton3.click();
        WebElement editSalary=driver.findElement(By.xpath("//input[@id='salary']"));
        editSalary.clear();
        Thread.sleep(1000);
        editSalary.sendKeys("3000");
        WebElement editAge=driver.findElement(By.xpath("//input[@id='age']"));
        editAge.clear();
        Thread.sleep(1000);
        editAge.sendKeys("30");
        WebElement submitAfterEdit=driver.findElement(By.xpath("//button[@id='submit']"));
        submitAfterEdit.click();

        Thread.sleep(2000);
        WebElement verifyAfterEditAge=driver.findElement(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group'][3]/div[@class=\"rt-tr -odd\"]/div[@class='rt-td'][3]"));
        String verifyAge=verifyAfterEditAge.getText();
        Assert.assertEquals(verifyAge,"30");
        WebElement verifyAfterEdit=driver.findElement(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group'][3]/div[@class=\"rt-tr -odd\"]/div[@class='rt-td'][5]"));
        String verifySalary=verifyAfterEdit.getText();
        Assert.assertEquals(verifySalary,"3000");

    }
    @Test
    public void testChrome() throws InterruptedException {

        chromeDriver.get("https://demoqa.com/webtables");
        System.out.println(chromeDriver.getTitle());

        chromeDriver.manage().window().maximize();
        Actions actions=new Actions(chromeDriver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();  // scroll using action class
        /*JavascriptExecutor js=(JavascriptExecutor)driver;
        WebElement editButton1=driver.findElement(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group'][1]/div[@class=\"rt-tr -odd\"]/div[@class='rt-td'][7]/div/span[@id='edit-record-1']/*[name()='svg']"));
        js.executeScript("arguments[0].scrollIntoView(true);",editButton1);*/

        //Search elements
        WebElement editButton3=chromeDriver.findElement(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group'][3]/div[@class=\"rt-tr -odd\"]/div[@class='rt-td'][7]/div/span[@id='edit-record-3']/*[name()='svg']"));
        editButton3.click();
        WebElement editSalary=chromeDriver.findElement(By.xpath("//input[@id='salary']"));
        editSalary.clear();
        editSalary.sendKeys("3000");

        WebElement editAge=chromeDriver.findElement(By.xpath("//input[@id='age']"));
        editAge.clear();
        editAge.sendKeys("30");
        WebElement submitAfterEdit=chromeDriver.findElement(By.xpath("//button[@id='submit']"));
        submitAfterEdit.click();

        Thread.sleep(2000);
        WebElement verifyAfterEditAge=chromeDriver.findElement(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group'][3]/div[@class=\"rt-tr -odd\"]/div[@class='rt-td'][3]"));
        String verifyAge=verifyAfterEditAge.getText();
        Assert.assertEquals(verifyAge,"30");
        WebElement verifyAfterEdit=chromeDriver.findElement(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group'][3]/div[@class=\"rt-tr -odd\"]/div[@class='rt-td'][5]"));
        String verifySalary=verifyAfterEdit.getText();
        Assert.assertEquals(verifySalary,"3000");
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
