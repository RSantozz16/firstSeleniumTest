package com.mitrais.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class EditProfile {

    String name = "Restu Santosa";

    @Test
    public void EditProfile() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Automation Testing\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Reporter.log("Browser opened now <br>");

        driver.navigate().to("http://172.19.14.155:4200/login");
        Reporter.log("Navigate to Login page <br>");

        assertEquals(driver.getTitle(), "Mitrais Carrot");

        driver.findElement(By.xpath("/html//input[@id='username']")).sendKeys("restu");
        Reporter.log("Inputed restu as username <br>");
        Thread.sleep(3000);

        driver.findElement(By.xpath("/html//input[@id='password']")).sendKeys("oke");
        Reporter.log("Inputed oke as password <br>");
        Thread.sleep(3000);

        WebElement login = driver.findElement(By.xpath("//app-root/section/app-login//div[@class='container']/div[@class='row']//form[@role='form']/button"));
        login.click();
        Reporter.log("Click Login button <br>");
        Thread.sleep(3000);

        assertEquals(driver.getCurrentUrl(), "http://172.19.14.155:4200/employees");
        String actualName = driver.findElement(By.xpath("/html//h4[@id='labelEmployeeName']")).getText();
        assertEquals(actualName, name);

        Thread.sleep(3000);
        driver.findElement(By.xpath("/html//a[@id='btnEditProfile']")).click();
        Reporter.log("Click edit profile button <br>");
        Thread.sleep(3000);

        driver.findElement(By.xpath("/html//input[@id='employeeName']")).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html//input[@id='employeeName']")).sendKeys("Restu Ganteng");
        Reporter.log("put Restu Ganteng in name box <br>");
        driver.findElement(By.xpath("/html//input[@id='address']")).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html//input[@id='address']")).sendKeys("Jl. Raya Pemogan");
        Reporter.log("put Jl. Raya Pemogan in address <br>");
        driver.findElement(By.xpath("/html//input[@id='email']")).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html//input[@id='email']")).sendKeys("Restu.Ganteng@mitrais.com");
        Reporter.log("put Restu.Ganteng@mitrais.com in email <br>");
        Thread.sleep(1000);

        WebElement buttonSave = driver.findElement(By.xpath("/html//button[@id='btnSaveProfile']"));
        buttonSave.click();
        Reporter.log("Click save button <br>");
        Thread.sleep(3000);

        WebElement buttonSweet1 = driver.findElement(By.xpath("/html//div[@role='dialog']/div[@class='swal2-actions']/button[2]"));
        buttonSweet1.click();
        Reporter.log("Click Yes button <br>");
        Thread.sleep(3000);

        WebElement buttonSweet2 = driver.findElement(By.xpath("/html//div[@role='dialog']/div[@class='swal2-actions']/button[1]"));
        buttonSweet2.click();
        Reporter.log("Click OK button <br>");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[@id='btnLogout']/i[@class='fa fa-sign-out ml-3']")).click();
        Thread.sleep(3000);
        Reporter.log("Click logut button <br>");

        driver.close();
        Reporter.log("Closing browser <br>");

        driver.quit();
        Reporter.log("Test finished! <br>");
    }
}
