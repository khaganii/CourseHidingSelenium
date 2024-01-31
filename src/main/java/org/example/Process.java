package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;

public class Process {

    public void start() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\kabdullayev\\Documents\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("http://192.168.2.5/login/index.php");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys("khagani.abdullayev");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("loginbtn")).click();
        //-------------------------------
        ReadTxtFile readTxtFile = new ReadTxtFile();
        System.out.println("started! -> " + LocalTime.now());
        for (String s: readTxtFile.getCourses()) {
            try{
                driver.findElement(By.linkText(s)).click();
                driver.findElement(By.linkText("Edit settings")).click();
                Select select = new Select(driver.findElement(By.id("id_visible")));
                select.selectByIndex(0);
                driver.findElement(By.id("id_submitbutton")).click();
                driver.get("http://192.168.2.5");
                System.out.println(s + " ---> already is hidden!");
            }catch (RuntimeException ex){
                System.out.println("Runtime Exception held! ---> " + s);
                driver.get("http://192.168.2.5");
                Thread.sleep(1000);
            }
        }
        System.out.println("Hiding Finished! -> " + LocalDateTime.now());
    }
}
