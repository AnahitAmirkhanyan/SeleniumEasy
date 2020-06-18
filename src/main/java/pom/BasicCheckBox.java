package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.How.CSS;

public class BasicCheckBox extends BasePage{

    public BasicCheckBox(WebDriver driver, String serverUrl){
        super(driver, serverUrl, "/test/basic-checkbox-demo.html");
    }

    @FindBy(id = "isAgeSelected")
    private WebElement checkbox;

    @FindBy(id = "txtAge")
    private WebElement success;

    @FindBy(how = CSS, using = "input[class='cb1-element']")
    private List<WebElement> boxes;

    @FindBy(id = "check1")
    private WebElement checkBtn;

    public void clickCheckbox(){
        this.checkbox.click();
    }

    public String getSuccess(){
        waitForVisibilityOfElement(getDriver(), success, 10);
        return this.success.getText();
    }

    public boolean isAllSelected(){
        for(WebElement el : boxes){
            if(!el.isSelected())
                return false;
        }
        return true;
    }

    public boolean isAllUnselected(){
        for(WebElement el : boxes){
            if(el.isSelected())
                return false;
        }
        return true;
    }

    public String getBtnValue(){
        return this.checkBtn.getAttribute("value");
    }

    public void clickButton(){
        this.checkBtn.click();
    }

    public void selectOne(int i){
        this.boxes.get(i).click();
    }

    public List<WebElement> getElements(){
        return this.boxes;
    }





}
