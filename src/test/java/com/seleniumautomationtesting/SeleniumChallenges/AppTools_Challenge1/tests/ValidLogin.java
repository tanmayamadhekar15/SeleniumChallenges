package com.seleniumautomationtesting.SeleniumChallenges.AppTools_Challenge1.tests;

import com.seleniumautomationtesting.SeleniumChallenges.AppTools_Challenge1.base.Common;
import com.seleniumautomationtesting.utils.DynamicDataReaderUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class ValidLogin extends Common {

    @Test
    public void test() throws Exception {
        // Search Element
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(DynamicDataReaderUtil.readAKey("username"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(DynamicDataReaderUtil.readAKey("password"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("log-in"))).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.applitools.com/app.html");

    }

    @Test(dependsOnMethods = {"test"})
    public void spentAmount() {
        double totalSpent = 0;
        double totalEarned = 0;
        ////table/tbody/tr/td/span[contains(text(), 'Today')]
        // Find the table rows
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class=\"table table-padded\"]/tbody/tr"));

       for(WebElement row:rows){
           //System.out.println(row.getText());
           //find table columns
                List<WebElement> col = row.findElements(By.tagName("td"));
                int col_size=col.size();
                        if (col_size > 1) {
                            String amountInString = col.get(4).getText();
                            //System.out.println(amountInString);
                            // Convert the amount in string to double
                            Double amountInDouble=Double.parseDouble(amountInString.replace(",", "").replace("USD", "").replace("+", "").replace("-", "").trim());
                            //System.out.println(amountInDouble);

                            // check spent or earned
                            if (amountInString.contains("-")) {
                            //totalSpent=totalSpent+amountInDouble;
                                  totalSpent += amountInDouble;  //Addition assignment operator
                            } else {
                            //totalEarned=totalEarned+amountInDouble;
                                    totalEarned += amountInDouble;
                            }//if else ends

                 }//if ends
       }
        System.out.println("Total amount spent : " + totalSpent + " USD");
        System.out.println("Total amount earned : " + totalEarned + " USD");
    }

}




