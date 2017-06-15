package Pages.Applicant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


/**
 * Created by akshay.pokley on 5/24/2017.
 */
public class NewApplication {
    WebDriver driver;

    @FindBy(xpath = ".//*[@id='liApplicationForm']")
    WebElement Logo;

    @FindBy(id= "cboCaseType")
    WebElement CaseType;

    @FindBy(xpath = ".//*[@id='cboVillage']")
    WebElement Location;

    @FindBy(xpath = ".//*[@id='rbtnNocReqd_1']")
    WebElement DUACNO;

    @FindBy(xpath = ".//*[@id='rbtnNocReqd_0']")
    WebElement DUACYES;
    @FindBy(xpath = ".//*[@id='SiteAddress_txtAddress1']")
    WebElement BuildingNo;

    @FindBy(xpath = ".//*[@id='SiteAddress_txtAddress2']")
    WebElement PlotNo;

    @FindBy(xpath = ".//*[@id='SiteAddress_txtAddress3']")
    WebElement Pincode;

    @FindBy(xpath = ".//*[@id='SiteAddress_txtAddress4']")
    WebElement BlockNo;

    @FindBy(xpath = ".//*[@id='SiteAddress_txtAddress5']")
    WebElement HouseNo;

    @FindBy(xpath = ".//*[@id='SiteAddress_txtAddress6']")
    WebElement SchmeNo;

    @FindBy(xpath = ".//*[@id='SiteAddress_txtAddress7']")
    WebElement PockectNo;


    @FindBy(xpath = ".//*[@id='SiteAddress_txtAddress8']")
    WebElement SecotorNo;

    @FindBy(xpath = ".//*[@id='SiteAddress_txtAddress9']")
    WebElement Ward;

    @FindBy(xpath = ".//*[@id='SiteAddress_txtAddress10']")
    WebElement Road_Street;

    @FindBy(xpath = ".//*[@id='SiteAddress_txtAddress11']")
    WebElement Situated;


    @FindBy(xpath = ".//*[@id='btnSave']")
    WebElement Save;

    public NewApplication (WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
      /*  if(!Logo.isDisplayed())
            throw new IllegalStateException("This Not Architect Login");*/

    }

    public WebElement getLogo()
    {
        return Logo;
    }

    public void setCaseType(String caseType)
    {
        Select combo1=new Select(CaseType);
        combo1.selectByVisibleText(caseType);
    }

    public void setLocation(String location)
    {
        Select combo=new Select(Location);
        combo.selectByVisibleText(location);
    }

    public void ClickDUACNO()
    {
        DUACNO.click();
    }

    public void setBuildingNo(String buildingNo)
    {
        BuildingNo.sendKeys(buildingNo);
    }
    public void setPlotNo(String plotNo)
    {
        PlotNo.sendKeys(plotNo);
    }

    public void setPincode(String pincode)
    {
        Pincode.sendKeys(pincode);
    }

    public void setBlockNo(String blockNo)
    {
        BlockNo.sendKeys(blockNo);
    }

    public void setHouseNo(String houseNo)
    {
        HouseNo.sendKeys(houseNo);
    }
    public void setSchmeNo(String schmeNo)
    {
        SchmeNo.sendKeys(schmeNo);
    }
    public void setPockectNo(String pockectNo)
    {
        PockectNo.sendKeys(pockectNo);
    }

    public void setSecotorNo(String secotorNo)
    {
        SecotorNo.sendKeys(secotorNo);
    }

    public void setWard(String ward)
    {
        Ward.sendKeys(ward);
    }

    public void setRoad_Street(String road_street)
    {
        Road_Street.sendKeys(road_street);
    }

    public void setSituated(String situated)
    {
        Situated.sendKeys(situated);
    }


    public void setSave()
    {
        Save.click();
    }






}
