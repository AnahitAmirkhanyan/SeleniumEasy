package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pom.BasicFirstForm;

public class SimpleTest{
    WebDriver driver;

    @BeforeClass
    void initDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void firstForm(){
        BasicFirstForm firstForm = new BasicFirstForm(driver, "https://www.seleniumeasy.com/");
        firstForm.get();
        String message = "Hello World!";

        firstForm.setMessage(message);
        firstForm.clickShow();

        Assert.assertEquals(firstForm.getDisplay(), message);

        int a = 3; int b = 4;
        firstForm.setSum1(a);
        firstForm.setSum2(b);
        firstForm.clickGetTotal();

        Assert.assertEquals(a + b, Integer.parseInt(firstForm.getDisplayValue()));
    }
}
