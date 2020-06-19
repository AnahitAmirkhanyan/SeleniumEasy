package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasicFirstFormPage extends BasePage{

    public BasicFirstFormPage(WebDriver driver, String serverUrl){
        super(driver, serverUrl, "/test/basic-first-form-demo.html");
    }

    @FindBy(id = "user-message")
    private WebElement message;

    @FindBy(xpath = "//*[@id=\"get-input\"]/button")
    private WebElement showMessage;

    @FindBy(id = "display")
    private WebElement display;

    @FindBy(id = "sum1")
    private WebElement sum1;

    @FindBy(id = "sum2")
    private WebElement sum2;

    @FindBy(xpath = "//*[@id=\"gettotal\"]/button")
    private WebElement getTotal;

    @FindBy(id = "displayvalue")
    private WebElement displayValue;

    public void setMessage(String message){
        this.message.sendKeys(message);
    }

    public void clickShow(){
        this.showMessage.click();
    }

    public String getDisplay(){
        waitForVisibilityOfElement(getDriver(), display, 10);
        return this.display.getText();
    }

    public void setSum1(int sum1){
        this.sum1.sendKeys(String.valueOf(sum1));
    }

    public void setSum2(int sum2){
        this.sum2.sendKeys(String.valueOf(sum2));
    }

    public void clickGetTotal(){
        this.getTotal.click();
    }

    public String getDisplayValue(){
        waitForVisibilityOfElement(getDriver(), displayValue, 10);
        return this.displayValue.getText();
    }





}
