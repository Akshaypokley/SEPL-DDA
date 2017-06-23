package Pages.Applicant.DraftApplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by akshay.pokley on 6/22/2017.
 */
public class Labour {
    WebDriver driver;

    @FindBy(xpath = ".//*[@id='liLabourDetails']")
    WebElement  LabourDetailsText;




    public Labour(WebDriver driver)
    { this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!LabourDetailsText.isDisplayed())
            throw  new IllegalStateException("This is not login page");
    }

    public WebElement getDrawiText()
    {
        return LabourDetailsText;
    }

    public void ClickLabourDetailsText()
    {
       LabourDetailsText.click();
    }


}
