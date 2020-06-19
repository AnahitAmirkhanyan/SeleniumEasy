package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BasicDropdownPage extends BasePage{

    private Select select;

    public BasicDropdownPage(WebDriver driver, String serverUrl){
        super(driver, serverUrl, "/test/basic-select-dropdown-demo.html");
    }

    @FindBy(id = "select-demo")
    private WebElement dropdown;

/*
    private final Select select = new Select(dropdown);
    private List<WebElement> list = select.getOptions();

*/

    @FindBy(css = "p[class='selected-value']")
    private WebElement message;

    public void selectByValue(String value){
        select = new Select(this.dropdown);
       select.selectByValue(value);
    }

    public String getSelected(){
        select = new Select(this.dropdown);
        return select.getFirstSelectedOption().getText();
    }

    public String getMessage(){
        return this.message.getText();
    }

}
