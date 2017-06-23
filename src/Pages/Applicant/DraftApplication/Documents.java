package Pages.Applicant.DraftApplication;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by akshay.pokley on 6/21/2017.
 */
public class Documents {

    WebDriver driver;

    @FindBy(xpath = ".//*[@id='liDrawing']")
    WebElement DrawiText;




    public Documents(WebDriver driver)
    { this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!DrawiText.isDisplayed())
            throw  new IllegalStateException("This is not login page");
    }

    public WebElement getDrawiText()
    {
        return DrawiText;
    }


}
