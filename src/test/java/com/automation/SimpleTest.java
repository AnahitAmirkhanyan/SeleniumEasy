package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pom.BasicCheckBox;
import pom.BasicFirstForm;
import pom.BasicRadioButton;

public class SimpleTest{
    WebDriver driver;

    @BeforeClass
    void initDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void firstForm(){

        BasicFirstForm firstForm = new BasicFirstForm(driver, "https://www.seleniumeasy.com/");
        firstForm.get();
        String message = "a";

        firstForm.setMessage(message);
        firstForm.clickShow();

        Assert.assertEquals(firstForm.getDisplay(), message);

        int a = 3; int b = 4;
        firstForm.setSum1(a);
        firstForm.setSum2(b);
        firstForm.clickGetTotal();

        Assert.assertEquals(a + b, Integer.parseInt(firstForm.getDisplayValue()));
        // test SOMETIMES fails because of a popup ad... not sure what to do about that

    }

    @Test(priority = 1)
    public void checkBoxes(){
        BasicCheckBox checkBoxPage = new BasicCheckBox(driver, "https://www.seleniumeasy.com");
        checkBoxPage.get();

        checkBoxPage.clickCheckbox();
        Assert.assertEquals(checkBoxPage.getSuccess(), "Success - Check box is checked");
        checkBoxPage.clickCheckbox();

        // check that button says "Check All"
        Assert.assertEquals(checkBoxPage.getBtnValue(), "Check All");
        // click all four checkBoxes
        for(int i = 0; i < checkBoxPage.getElements().size(); i++){
            checkBoxPage.selectOne(i);
        }

        // check that button says "Uncheck All"
        Assert.assertEquals(checkBoxPage.getBtnValue(), "Uncheck All");

        // click the button to uncheck all
        checkBoxPage.clickButton();

        // check the button says "Check All" again
        Assert.assertEquals(checkBoxPage.getBtnValue(), "Check All");
        // check that the boxes are all indeed unchecked
        Assert.assertTrue(checkBoxPage.isAllUnselected());

        // click the button to check all, check that all are selected
        checkBoxPage.clickButton();
        Assert.assertTrue(checkBoxPage.isAllSelected());
    }

    @Test(priority = 2)
    public void radioButtons(){
        BasicRadioButton radioButtonPage = new BasicRadioButton(driver, "https://www.seleniumeasy.com");
        radioButtonPage.get();

        // click Male and check that it was indeed selected
        radioButtonPage.clickMale();
        Assert.assertTrue(radioButtonPage.isMaleSelected());

        // click Female, check it's selected, and that male has been unselected
        radioButtonPage.clickFemale();
        Assert.assertTrue(radioButtonPage.isFemaleSelected());
        Assert.assertFalse(radioButtonPage.isMaleSelected());

        // click the Button and check that the message contains "female"
        radioButtonPage.clickButton();
        Assert.assertTrue(radioButtonPage.getMessage().contains("Female"));

        // click male, then the button then check the message
        radioButtonPage.clickMale();
        radioButtonPage.clickButton();
        Assert.assertTrue(radioButtonPage.getMessage().contains("Male"));
    }

    @AfterClass
    public void over(){
        driver.quit();
    }

}
