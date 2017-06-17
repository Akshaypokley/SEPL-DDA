package Pages.Applicant.DraftApplication;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by akshay.pokley on 6/15/2017.
 */
public class AttachDrawing {

    WebDriver driver;

    @FindBy(xpath = ".//*[@id='liDrawing']")
    WebElement DrawiText;


    @FindBy(xpath = ".//*[@id='liDrawing']")
    WebElement DrawingALink;

    @FindBy(xpath = ".//*[@id='btnAttached']")
    WebElement SelectFile;

    @FindBy(xpath = ".//*[@id='RadAsyncUpload1file0']")
    WebElement NWSelect;

    @FindBy(xpath = "//div/div[1]/table/tbody/tr[2]/td[3]")
    WebElement Download;

    @FindBy(xpath = "//div/div[1]/table/tbody/tr[2]/td[4]")
    WebElement Remove;

    @FindBy(xpath = "//td[@class='rwWindowContent']/div/div/div[2]/a/span/span")
    WebElement ClickOk;

    public AttachDrawing (WebDriver driver)
    { this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!DrawiText.isDisplayed())
            throw  new IllegalStateException("This is not login page");
    }

    public WebElement getDrawiText()
    {
        return DrawiText;
    }

    public void ClickDrawingALink()
    {
        DrawingALink.click();
    }

    public void clickOk()
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", ClickOk);
    }

    public void ClickSelectFile()
    {
        SelectFile.click();
    }

    public void ClickNWSelect()
    {
        NWSelect.click();
    }

    public void ClickDownload()
    {
        NWSelect.click();
    }

    public void ClickRemove()
    {
        Remove.click();
    }

}
