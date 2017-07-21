package Pages.Applicant.DraftApplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by akshay.pokley on 6/22/2017.
 */
public class NMADetails {
    WebDriver driver;

    @FindBy(xpath = ".//*[@id='liNMADetails']")
    WebElement NMADetailsText;

    @FindBy(xpath = ".//*[@id='tstMonumentName']")
    WebElement MonumentName ;

    @FindBy(xpath = ".//*[@id='txtDistrict']")
    WebElement District;

    @FindBy(xpath = ".//*[@id='txtTaluka']")
    WebElement Taluka;

    @FindBy(xpath = ".//*[@id='txtLocality']")
    WebElement Locality;

    @FindBy(xpath = ".//*[@id='txtDistancefromMonumentMTR']")
    WebElement DistancMonumen ;

    @FindBy(xpath = ".//*[@id='txtWallofMonumentMtr']")
    WebElement DistanceProtectedbouewall ;

    @FindBy(xpath = ".//*[@id='txtBuilindgtoMonumentVicinityMtr']")
    WebElement MaximumheightBuilindg;

    @FindBy(xpath = ".//*[@id='cboMonumentinLimitof']")
    WebElement  MonumentinLimitof ;

    @FindBy(xpath = ".//*[@id='txtStatusofConstruction']")
    WebElement StatusModernBuilding;

    @FindBy(xpath = ".//*[@id='txtOpenSpaceorParking']")
    WebElement OpenSpace;

    @FindBy(xpath = ".//*[@id='txtRoaddetails']")
    WebElement Roaddetails;

    @FindBy(xpath = ".//*[@id='txtNumberOfStoreys']")
    WebElement NumberOfStoreys ;

    @FindBy(xpath = ".//*[@id='txtBasement']")
    WebElement BasementDetails;

    @FindBy(xpath = ".//*[@id='txtApproximateDuration']")
    WebElement ApproximateDuration;

    @FindBy(xpath = ".//*[@id='txtApproximateDate']")
    WebElement ApproximateDate;

    @FindBy(xpath = ".//*[@id='txtIncludingMumty']")
    WebElement HeightMumty;

    @FindBy(xpath = ".//*[@id='txtExcludingMumty']")
    WebElement HeightInExcludingMumty;

    @FindBy(xpath = ".//*[@id='txtRemark']")
    WebElement Remark;


    public NMADetails(WebDriver driver)
    { this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!NMADetailsText.isDisplayed())
            throw  new IllegalStateException("This is not login page");
    }

    public void setDistrict(String district) {
        District.sendKeys(district);
    }

    public WebElement getDistrict()
    {
        return District;
    }

    public void setMonumentName(String monumentName) {
        MonumentName.sendKeys(monumentName);
    }

    public WebElement getMonumentName()
    {
       return MonumentName;

    }

    public void setRemark(String remark) {
        Remark.sendKeys(remark);
    }
    public void setHeightInExcludingMumty(String heightInExcludingMumty) {
        HeightInExcludingMumty.sendKeys(heightInExcludingMumty);

    }

    public WebElement getHeightInExcludingMumty()
    {
        return  HeightInExcludingMumty;
    }
    public void setHeightMumty(String heightMumty) {
        HeightMumty.sendKeys(heightMumty);
    }

    public WebElement getHeightMumty()
    {
        return HeightMumty;
    }

    public void setApproximateDate(String approximateDate) {
        ApproximateDate.sendKeys(approximateDate);
    }
    public void setApproximateDuration(String approximateDuration) {
        ApproximateDuration.sendKeys(approximateDuration);
    }


    public WebElement getApproximateDuration()
    {
    return     ApproximateDuration;
    }
    public void setBasementDetails(String basementDetails) {
        BasementDetails.sendKeys(basementDetails);
    }

    public void setNumberOfStoreys(String numberOfStoreys) {
        NumberOfStoreys.sendKeys(numberOfStoreys);
    }

    public WebElement getNumberOfStoreys()
    {return NumberOfStoreys;}
    public void setRoaddetails(String roaddetails) {
        Roaddetails.sendKeys(roaddetails);
    }
    public void setOpenSpace(String openSpace) {
        OpenSpace.sendKeys(openSpace);
    }

    public WebElement getOpenSpace()
    {return OpenSpace;}
    public void setStatusModernBuilding(String statusModernBuilding) {
        StatusModernBuilding.sendKeys(statusModernBuilding);
    }

    public WebElement getStatusModernBuilding()
    {return StatusModernBuilding;}

    public void setMonumentinLimitof(String monumentinLimitof) {
        Select combo=new Select(MonumentinLimitof);
        combo.selectByVisibleText(monumentinLimitof);
    }

    public void setMaximumheightBuilindg(String maximumheightBuilindg) {
        MaximumheightBuilindg.sendKeys(maximumheightBuilindg);
    }

    public WebElement getMaximumheightBuilindg()
    {
        return MaximumheightBuilindg;
    }

    public void setDistanceProtectedbouewall(String distanceProtectedbouewall) {
        DistanceProtectedbouewall.sendKeys(distanceProtectedbouewall);
    }

    public WebElement getDistanceProtectedbouewall()
    {
        return DistanceProtectedbouewall;
    }
    public void setDistancMonumen(String distancMonumen) {
        DistancMonumen.sendKeys(distancMonumen);
    }

    public WebElement getDistancMonumen()
    {
        return DistancMonumen;
    }

    public void setLocalityt(String localityt) {
        Locality.sendKeys(localityt);
    }

    public WebElement getLocality()
    {return Locality;}
    public void setTaluka(String taluka) {
        Taluka.sendKeys(taluka);
    }

    public WebElement getDrawiText()
    {
        return NMADetailsText;
    }

    public void ClickNMADetailsText()
    {
        NMADetailsText.click();
    }
}
