package com.mitrais.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class EditStaffGroupName {

    @Test
    public void EditStaffGroupName() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Automation Testing\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("http://localhost:4200/login");

//        assertEquals("Mitrais Carrot", driver.getTitle(), "Title check failed!");

        driver.findElement(By.xpath("/html//input[@id='username']")).sendKeys("reni");
        Thread.sleep(3000);

        driver.findElement(By.xpath("/html//input[@id='password']")).sendKeys("kumala");
        Thread.sleep(3000);

        WebElement login = driver.findElement(By.xpath("//app-root/section/app-login//div[@class='container']/div[@class='row']//form[@role='form']/button"));
        login.click();
        Thread.sleep(3000);

//        assertEquals("http://localhost:4200/index-admin", driver.getCurrentUrl(), "Wrong URL");

        driver.findElement(By.xpath("//app-root/section/app-index-admin-first/section[2]//a[@href='/admin/employee-group']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//app-root//app-employee-group/main[@role='main']//div[@role='group']/a[@href='/admin/staff-group/list-group-name']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("/html//app-root/section/app-list-group-name/section//div[@class='row']/div[3]/div/div[2]/table/tbody/tr[2]/td[3]/a[.=' Edit']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("/html//input[@id='groupname']")).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html//input[@id='groupname']")).sendKeys("Jambu Staff");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html//ngb-modal-window[@role='dialog']/div[@role='document']//button[@type='submit']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[@id='btnLogout']/i[@class='fa fa-sign-out ml-3']")).click();
        Thread.sleep(3000);

//        assertEquals("http://localhost:4200/login", driver.getCurrentUrl(), "Wrong URL");

        driver.close();

        driver.quit();
    }
}
