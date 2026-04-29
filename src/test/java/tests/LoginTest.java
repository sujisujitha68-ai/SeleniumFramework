package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseClass;

@Listeners(listeners.MyListener.class)
public class LoginTest extends BaseClass {

    @Test
    public void loginTest() throws InterruptedException {

        Thread.sleep(3000);

        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("wrongpassword");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
        System.out.println("git test change");

        Thread.sleep(3000);

        String url = driver.getCurrentUrl();

        // This will FAIL → listener triggers
        Assert.assertTrue(url.contains("dashboard"));
    }
}

