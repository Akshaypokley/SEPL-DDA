package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by akshay.pokley on 6/15/2017.
 */
public class Menu {

    WebDriver driver;


    @FindBy(xpath = ".//*[@id='lblULBName']")
    WebElement Logo;

/*Application Submission*/
    @FindBy(xpath = ".//*[@id='a_157']/span")
    WebElement NewAppALink;

    @FindBy(xpath = ".//*[@id='a_158']/span")
    WebElement Draftlink;

    @FindBy(xpath = ".//*[@id='a_159']/span")
    WebElement SubmittLink;



    public Menu (WebDriver driver)
    { this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!Logo.isDisplayed())
            throw  new IllegalStateException("This is not login page");
    }



    public WebElement getInfoText()
    {
        return Logo;
    }

    /*Application Submission*/
    public void ClickNewAppALink()
    {
        NewAppALink.click();
    }
    public void ClickDraftlink()
    {
        Draftlink.click();
    }
    public void ClickSubmittLink()
    {
        SubmittLink.click();
    }



}
