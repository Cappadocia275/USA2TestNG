package com.usa.test;

import com.usa.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;



public class AmazonRegister {


    @Test
    public void Register() throws InterruptedException {

        Driver.getDriver().get("https://amazon.com");
        Actions actions = new Actions(Driver.getDriver());
        Thread.sleep(2000);

        WebElement signIn = Driver.getDriver().findElement(By.id("nav-link-accountList"));
        actions.moveToElement(signIn).perform();

        Thread.sleep(2000);
        WebElement startHere = Driver.getDriver().findElement(By.linkText("Start here."));
        startHere.click();

        WebElement yourName = Driver.getDriver().findElement(By.id("ap_customer_name"));
        yourName.sendKeys("Dolphin Silver");

        WebElement yourEmail = Driver.getDriver().findElement(By.id("ap_email"));
        yourEmail.sendKeys("dolphinsilver@gmail.com");

        WebElement yourPassword = Driver.getDriver().findElement(By.id("ap_password"));
        yourPassword.sendKeys("123456");

        WebElement yourRePassword = Driver.getDriver().findElement(By.id("ap_password_check"));
        yourRePassword.sendKeys("123456");

        WebElement CreatAccountButton = Driver.getDriver().findElement(By.id("continue"));
        CreatAccountButton.click();


        WebElement confirmation = Driver.getDriver().findElement(By.xpath("//*[@class=\"a-size-large\"]"));
        String puzzle = confirmation.getText();
        System.out.println(puzzle);
        Assert.assertEquals(puzzle,"Solve this puzzle to protect your account");






    }
}
