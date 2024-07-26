package com.seleniumautomationtesting.SeleniumChallenges.VwoHeatMaps;

import org.openqa.selenium.edge.EdgeDriver;
import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
public class Challenge5_heatMaps {
    //https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
    }


    @Test
    public void testPositive() throws InterruptedException {
        driver.get("https://app.vwo.com/#/analyze/osa/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1");
        String mainWindowHandle = driver.getWindowHandle();

        Actions ac = new Actions(driver);
        ac.moveToElement(driver.findElement(By.cssSelector("[data-qa=\"yedexafobi\"]"))).click().build().perform();

        Thread.sleep(5000);

        Set<String> windowHandles = driver.getWindowHandles();
        //System.out.println(windowHandles);

        Iterator<String> iterator = windowHandles.iterator();
        while (iterator.hasNext()) {
            String childWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase((childWindow))) {
                driver.switchTo().window(childWindow);
                System.out.println(driver.getTitle());
                WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(12));
                WebElement clickMap=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-qa=\"refoyekife\"]")));
                Assert.assertTrue(clickMap.isDisplayed(),"ClickMap visible");
                clickMap.click();
            }
        }
    }


    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
