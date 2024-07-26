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

public class Challenge2_WebTables_Row {
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
        WebElement addButton=driver.findElement(By.xpath("//button[@id='addNewRecordButton']"));
        addButton.click();
        WebElement fname=driver.findElement(By.xpath("//input[@id=\"firstName\"]"));
        fname.sendKeys("John");
        WebElement lname=driver.findElement(By.xpath("//input[@id=\"lastName\"]"));
        lname.sendKeys("Ken");
        WebElement email=driver.findElement(By.xpath("//input[@id=\"userEmail\"]"));
        email.sendKeys("johnken@gmail.com");
        WebElement age=driver.findElement(By.xpath("//input[@id=\"age\"]"));
        age.sendKeys("25");
        WebElement salary=driver.findElement(By.xpath("//input[@id=\"salary\"]"));
        salary.sendKeys("1000");
        WebElement department=driver.findElement(By.xpath("//input[@id=\"department\"]"));
        department.sendKeys("CSE");
        Thread.sleep(1000);

        WebElement submitAfterEdit=driver.findElement(By.xpath("//button[@id='submit']"));
        submitAfterEdit.click();

        Thread.sleep(2000);
        WebElement verifyAfterAdd=driver.findElement(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group'][4]/div[@class='rt-tr -even']/div[@class='rt-td'][1]"));
        String verifyFirstName=verifyAfterAdd.getText();
        Assert.assertEquals(verifyFirstName,"John");

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
        WebElement addButton=chromeDriver.findElement(By.xpath("//button[@id='addNewRecordButton']"));
        addButton.click();
        WebElement fname=chromeDriver.findElement(By.xpath("//input[@id=\"firstName\"]"));
        fname.sendKeys("John");
        WebElement lname=chromeDriver.findElement(By.xpath("//input[@id=\"lastName\"]"));
        lname.sendKeys("Ken");
        WebElement email=chromeDriver.findElement(By.xpath("//input[@id=\"userEmail\"]"));
        email.sendKeys("johnken@gmail.com");
        WebElement age=chromeDriver.findElement(By.xpath("//input[@id=\"age\"]"));
        age.sendKeys("25");
        WebElement salary=chromeDriver.findElement(By.xpath("//input[@id=\"salary\"]"));
        salary.sendKeys("1000");
        WebElement department=chromeDriver.findElement(By.xpath("//input[@id=\"department\"]"));
        department.sendKeys("CSE");
        Thread.sleep(1000);

        WebElement submitAfterEdit=chromeDriver.findElement(By.xpath("//button[@id='submit']"));
        submitAfterEdit.click();

        Thread.sleep(2000);
        WebElement verifyAfterAdd=chromeDriver.findElement(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group'][4]/div[@class='rt-tr -even']/div[@class='rt-td'][1]"));
        String verifyFirstName=verifyAfterAdd.getText();
        Assert.assertEquals(verifyFirstName,"John");
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
