package Pages.Applicant.DraftApplication;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by akshay.pokley on 6/22/2017.
 */
public class DUACForm {
    WebDriver driver;

    @FindBy(xpath = ".//*[@id='liDUACForm']")
    WebElement DUACText;

    @FindBy(xpath = ".//*[@id='txtProposalName']")
    WebElement  Nameoftheproposal;

    @FindBy(xpath = ".//*[@id='txtareaAddress']")
    WebElement  Address;

    @FindBy(xpath = " .//*[@id='txtEmail']")
    WebElement Email;

    @FindBy(xpath = " .//*[@id='ddlMasterPlan']")
    WebElement SELCTMasterPlan;

    @FindBy(xpath = "//select[@id='ddlZonalMasterPlan']")
    WebElement SELCTZonalMasterPlan;

    @FindBy(xpath = ".//*[@id='btnSave']")
    WebElement SaveDuacFormDetails;

    @FindBy(id = "txtOwnerContactNo")
    WebElement LandLine;

    @FindBy(id = "txtArchitectlandlineNo")
    WebElement ArchiteLandLine;
    public DUACForm(WebDriver driver)
    { this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!DUACText.isDisplayed())
            throw  new IllegalStateException("This is not login page");
    }
    public void SaveDuacFormDetails()
    {
        SaveDuacFormDetails.click();
    }

    public void setSELCTZonalMasterPlan(String selctZonalMasterPlan)  {
        Select combo=new Select(SELCTZonalMasterPlan);
        combo.selectByVisibleText(selctZonalMasterPlan);
    }

    public void setSELCTMasterPlan(String selctMasterPlan)
    {
        Select combo=new Select(SELCTMasterPlan);
        combo.selectByVisibleText(selctMasterPlan);
    }

    public WebElement getSELCTMasterPlan()
    {
      return SELCTMasterPlan;
    }
    public void setEmail(String email)
    {
        Email.sendKeys(email);

    }

    public void setLandLine(String landLine)
    {
        LandLine.sendKeys(landLine);

    }

    public void setArchiteLandLine(String architeLandLine)
    {
        ArchiteLandLine.sendKeys(architeLandLine);

    }
    public void  setAddress(String address)
    {
        Address.sendKeys(address);
    }
    public WebElement getDrawiText()
    {
        return DUACText;
    }

    public void ClickDUACText()
    {
        DUACText.click();
    }
    public void setNameoftheproposal(String nameoftheproposal)
    {
        Nameoftheproposal.sendKeys(nameoftheproposal);
    }
}
