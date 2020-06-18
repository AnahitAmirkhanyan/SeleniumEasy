package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasicRadioButton extends BasePage{

    public BasicRadioButton(WebDriver driver, String serverUrl){
        super(driver, serverUrl, "/test/basic-radiobutton-demo.html");
    }

    @FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/label[1]/input")
    private WebElement radioMale;

    @FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/label[2]/input")
    private WebElement radioFemale;

    @FindBy(id = "buttoncheck")
    private WebElement buttonCheck;

    @FindBy(css = "p[class='radiobutton']")
    private WebElement message;

    public void clickMale(){
        this.radioMale.click();
    }

    public void clickFemale(){
        this.radioFemale.click();
    }

    public void clickButton(){
        this.buttonCheck.click();
    }

    public boolean isMaleSelected(){
        return this.radioMale.isSelected();
    }

    public boolean isFemaleSelected(){
        return this.radioFemale.isSelected();
    }

    public String getMessage(){
        waitForVisibilityOfElement(getDriver(), this.message, 10);
        return this.message.getText();
    }


}
