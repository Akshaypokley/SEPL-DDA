package Pages.Applicant.DraftApplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by akshay.pokley on 6/13/2017.
 */
public class ApplicantInfo {

    WebDriver driver;

    @FindBy(xpath = ".//*[@id='liapplication']/a")
    WebElement InfoText;


    @FindBy(xpath = ".//*[@id='liapplication']/a")
    WebElement InfoALink;

    @FindBy(xpath = ".//*[@id='ApplicantControl_txtOwnerName']")
    WebElement Name;

    @FindBy(xpath = ".//*[@id='ApplicantControl_txtOwnerPhoneNO']")
    WebElement MobileNo;

    @FindBy(xpath = ".//*[@id='ApplicantControl_txtOwnerPhoneNO']")
    WebElement PerMentAddress;

    @FindBy(xpath = ".//*[@id='ApplicantControl_txtCorrespondanceAddress']")
    WebElement CorrespondanceAddress;

    @FindBy(xpath = ".//*[@id='ApplicantControl_txtOwnerPin']")
    WebElement PinNo;

    @FindBy(xpath = ".//*[@id='ApplicantControl_txtOwnerEmail']")
    WebElement Email;

    @FindBy(xpath = ".//*[@id='ApplicantControl_ddlStatusOption']")
    WebElement selectStatus;

    @FindBy(xpath = ".//*[@id='ApplicantControl_ddlStatusOption']")
    WebElement ClickSave;


    public ApplicantInfo (WebDriver driver)
    { this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!InfoText.isDisplayed())
            throw  new IllegalStateException("This is not login page");
    }

    public WebElement getInfoText()
    {
        return InfoText;
    }
    public void getName(String name)
    {
        Name.sendKeys(name);
    }
    public void getInfoALink()
    {
        InfoALink.click();
    }
    public void setMobileNo(String mobileNo)
    {
        MobileNo.sendKeys(mobileNo);
    }

    public void  setPerMentAddress(String perMentAddress)
    {
        PerMentAddress.sendKeys(perMentAddress);
    }

    public void  setCorrespondanceAddress(String correspondanceAddress)
    {
        CorrespondanceAddress.sendKeys(correspondanceAddress);
    }

    public void  setPinNo(String pinNo)
    {
       PinNo.sendKeys(pinNo);
    }

    public void  setEmail(String email )
    {
        PinNo.sendKeys(email);
    }
    public  void setClickSave()
    {
        ClickSave.click();
    }
}
