package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by akshay.pokley on 5/24/2017.
 */
public class Login {


    WebDriver driver;
    @FindBy(xpath = ".//*[@id='imgApprovalLayout']/div/a/img")
    WebElement RegistrationLink;

    @FindBy(xpath = ".//*[@id='form1']/div[3]/div[2]/div/div[1]/div/img[1]")
    WebElement Logo;

    @FindBy(xpath = ".//*[@id='txtUsername']")
    WebElement LoginF;

    @FindBy(xpath = ".//*[@id='txtPassword']")
    WebElement passF;

    @FindBy(xpath = ".//*[@id='btnLogin']")
    WebElement loginBtn;

    @FindBy(xpath = ".//*[@id='lblUsername']")
    WebElement LoginFLabel;

    @FindBy(xpath = ".//*[@id='lblPasswd']")
    WebElement passFLabel;




    public Login (WebDriver driver)
    { this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!Logo.isDisplayed())
            throw  new IllegalStateException("This is not login page");
    }
    public void setRegistrationLink()
    {
        RegistrationLink.click();
    }
    public WebElement getLogo()
    {
        return Logo;
    }
    public WebElement getLoginFLabel()
    {
        return LoginFLabel;
    }
    public WebElement getpassFLabel()
    {
        return passFLabel;
    }
    public void setLoginF(String UserNm)
    {
        LoginF.sendKeys(UserNm);
    }

    public void  setpassF(String passF1)
    {
        passF.sendKeys(passF1);
    }

    public  void ClickLoginBtn()
    {
        loginBtn.click();
    }

    public  WebElement getLoginF()
    {
        return LoginF;
    }
    public  WebElement getPassF() {
        return passF;
    }
    }
