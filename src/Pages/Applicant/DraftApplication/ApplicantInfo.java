package Pages.Applicant.DraftApplication;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by akshay.pokley on 6/13/2017.
 */
public class ApplicantInfo {

    WebDriver driver;

    @FindBy(id= "divapplication")
    WebElement InfoText;


    @FindBy(xpath = "//*[@id='frmDetails']/div[4]/div/ul/li[2]")
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
      /*  if(!InfoText.isDisplayed())
            throw  new IllegalStateException("This is not login page");*/
    }

    public WebElement getInfoText()
    {
        return InfoText;
    }

    public void setName(String name)
    {
        Name.sendKeys(name);
    }
    public void ClickInfoALink()
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
        Email.sendKeys(email);
    }
    public  void setClickSave()
    {
        ClickSave.click();
    }
    public void setselectStatus(String selectStatus1)
    {
        Select combo=new Select(selectStatus);
        combo.selectByVisibleText(selectStatus1);
    }
}
