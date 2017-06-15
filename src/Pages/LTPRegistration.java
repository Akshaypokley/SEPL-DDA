package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by akshay.pokley on 5/24/2017.
 */
public class LTPRegistration {
    WebDriver driver;

    @FindBy(xpath = ".//*[@id='dvwelcomeRegistration']/div/a/h2")
    WebElement RegText;

    @FindBy(xpath =".//*[@id='imgPhoto']")
    WebElement ProfilePhoto;

   /* attachments*/

    @FindBy(xpath =".//*[@id='IdattachIdproof']")
    WebElement AttachIDPrrof;

    @FindBy(id ="RadAsyncUpload1file0")
    WebElement IdDoc;

    @FindBy(xpath = ".//*[@id='btnAttached']")
    WebElement AttachRegistCopy;

    @FindBy(xpath =".//*[@id='RadAsyncUpload1silverlight02']")
    WebElement RegistCopydoc;

    @FindBy(xpath = ".//*[@id='Button1']")
    WebElement UploadImage;
   /* attachments*/




    @FindBy(xpath = ".//*[@id='cboInital']")
    WebElement PriFix ;

    @FindBy(xpath = ".//*[@id='txtFName']")
    WebElement FirstNm;

    @FindBy(xpath = ".//*[@id='txtMName']")
    WebElement MiddleNM;

    @FindBy(xpath = ".//*[@id='txtLastName']")
    WebElement LastNM;

    @FindBy(xpath = ".//*[@id='txtAdd']")
    WebElement PostalAddress;

    @FindBy(xpath = ".//*[@id='cboState']")
    WebElement State;

    @FindBy(xpath = ".//*[@id='txtCity']")
    WebElement City;

    @FindBy(xpath = ".//*[@id='txtZip']")
    WebElement PinCode;

    @FindBy(xpath = ".//*[@id='txtMob']")
    WebElement MoileNm;

    @FindBy(xpath = ".//*[@id='txtEmail']")
    WebElement Email;

    @FindBy(xpath = ".//*[@id='cboIdProofType']")
    WebElement IdProf;

    @FindBy(xpath = ".//*[@id='txtTown']")
    WebElement RegCertifiScannCopy;

    @FindBy(xpath = ".//*[@id='txtRegNo']")
    WebElement RegitrationNo;


    @FindBy(xpath = ".//*[@id='ValidUpTo1']/p/span/button")
    WebElement validDate;


    @FindBy(xpath = ".//*[@id='txtLoginName']")
    WebElement LoginNm;


    @FindBy(xpath = ".//*[@id='txtPass']")
    WebElement Password;


    @FindBy(xpath = ".//*[@id='txtPassR']")
    WebElement RePass;


    @FindBy(xpath = ".//*[@id='chkDeclare']")
    WebElement AcceptTC;


    @FindBy(xpath = ".//*[@id='btnSubmit']")
    WebElement Submit;

    @FindBy(xpath = ".//*[@id='cboArchitechType']")
    WebElement ApplicantNm;

    @FindBy(xpath = ".//*[@id='txtQualification']")
    WebElement Qlification;

    @FindBy(xpath =".//*[@id='txtfirm']")
    WebElement FirmName;


    public LTPRegistration(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);

        if(!RegText.isDisplayed())
            throw new IllegalStateException("This Not Home Page ");
    }


    public void ClickIdDoc()
    {
        IdDoc.click();
    }

    public void ClickRegistCopydoc()
    {
        RegistCopydoc.click();
    }

    public void ClickAttachIDPrrof()
    {
        AttachIDPrrof.click();
    }

    public void ClickAttachRegistCopy()
    {
        AttachRegistCopy.click();
    }


    /*public void setfirmName(String firnm)
    {
        firmName.sendKeys(firnm);
    }*/

    public void setApplicantNm( String applicantNm)
    {
        Select combo=new Select(ApplicantNm);
        combo.selectByVisibleText(applicantNm);
    }

    public void setQlification(String qlification)
    {
        Qlification.sendKeys(qlification);
    }

    public void setFirmName(String firmName)
    {
        FirmName.sendKeys(firmName);
    }

    public void clickAcceptTC()
    {
        AcceptTC.click();
    }

    public void setUploadImage(String pho)
    {
        UploadImage.sendKeys(pho);
    }



    public WebElement getRegText()
    {
        return RegText;
    }

    public void setProfilePhoto( String Photo)
    {
        ProfilePhoto.sendKeys(Photo);
    }
    public void setPriFix( String pr)
    {
        Select combo = new Select (PriFix) ;
        combo.selectByVisibleText(pr);

    }

    public void setFirstNm(String Fname )
    {
        FirstNm.sendKeys(Fname);
    }

    public void setLastNM(String Lname) {
        LastNM.sendKeys(Lname);
    }

    public void setMiddleNM(String Mname)
    {
        MiddleNM.sendKeys(Mname);
    }

    public void setPostalAddress(String PAddress)
    {
        PostalAddress.sendKeys(PAddress);
    }

    public void setState(String States)
    {
        Select combo=new Select(State);
        combo.selectByValue(States);

    }

    public void setCity(String city)
    {
        City.sendKeys(city);
    }

    public void setPinCode(String Pincod)
    {
        PinCode.sendKeys(Pincod);
    }

    public void setMoileNm(String MoboNo)
    {
        MoileNm.sendKeys(MoboNo);
    }

    public void setEmail(String email)
    {
        Email.sendKeys(email);
    }

    public void setIdProf(String ID)
    {
        Select combo=new Select(IdProf);
        combo.selectByVisibleText(ID);
    }

    public void setRegCertifiScannCopy(String RegCopy)
    {
        RegCertifiScannCopy.sendKeys(RegCopy);
    }

    public  void setRegitrationNo(String regitrationNo )
    {
        RegitrationNo.sendKeys(regitrationNo);
    }

    public  void setValidDate(String Date)
    {
        validDate.sendKeys(Date);
    }

    public void setLoginNm(String UserID)
    {
        LoginNm.sendKeys(UserID);
    }

    public void setPassword(String pass)
    {
        Password.sendKeys(pass);

    }

    public void setRePass(String Repss)
    {
        RePass.sendKeys(Repss);
    }

    public void ClickSubmit()
    {
        Submit.click();
    }

}
