package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class BasePage extends LoadableComponent<BasePage>{

    private WebDriver driver;
    private String serverUrl;
    private String pagePath;

    public BasePage(WebDriver driver, String serverUrl, String pagePath){
        this.driver = driver;
        this.serverUrl = serverUrl;
        this.pagePath = pagePath;

        PageFactory.initElements(driver, this);
    }

    protected void load(){
        driver.get(serverUrl + pagePath);
    }

    protected void isLoaded() throws Error{
        assert driver.getCurrentUrl().equals(serverUrl + pagePath);
    }
}
