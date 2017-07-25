package TestScript.Applicant;

import Pages.Applicant.DraftApplication.ApplicantInfo;
import Pages.Applicant.DraftApplication.AttachDrawing;
import Pages.Applicant.DraftApplication.DUACForm;
import Pages.Applicant.DraftApplication.NMADetails;
import Pages.Applicant.NewApplication;
import Pages.Login;
import Pages.Menu;
import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.read.biff.BiffException;
import jxl.write.*;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static Utilites.AttachFunction.AttachFuntn;
import static Utilites.BeforeWH.BeforeWH;
import static Utilites.LoginFunction.LogFunction;
import static Utilites.OpenBrowser.GetUrl;
import static Utilites.OpenBrowser.openBrowser;
import static jxl.format.Colour.*;

/**
 * Created by akshay.pokley on 6/30/2017.
 */
public class ArchDraftTest {



    static WebDriver driver;
    public Label l4;
    public static WritableCellFormat cellFormat;
    public static WritableCellFormat cellFormat1;
    public static WritableCellFormat cellFormat3;
    public static WritableCellFormat cellFormat4;
    public WritableCellFormat cellFormat2;
    public static WritableCellFormat cellFormat5;
    public  String TestCase;
    public WritableWorkbook writableTempSource;
    public WritableWorkbook copyDocument;
    public WritableSheet sourceSheet;
    public static WritableSheet targetSheet;
    public Workbook sourceDocument;
    public static WritableCellFormat cellFormat6;
    /*****************************************************************/
    private static int n = 2;
    private static int j = 1;
    public static  String Result;
    public static  String k;
    public static String ResultPass1="Username";
    public static String ResultFail1="Password";
    public static String Actual;
    public static String Actual2;
    static int LastRow;
    static int SetBord;
    static  String Value;
    static String AlrMESS="Alert was not open ";
    static ApplicantInfo applicantInfo;
    static DUACForm duacForm;
    static NMADetails nmaDetails;
 static    String FilePath = "E:\\Akshay85\\DDAProject\\DDA_addition CASE.dwg";
    static    String FilePath2 = "E:\\Akshay85\\13.7.png";
    static    String FilePath3 = "E:\\Akshay85\\13.7.png";
    static AttachDrawing attachDrawing;
    static final java.util.regex.Pattern String = java.util.regex.Pattern.compile("^[A-Za-z, ]++$");

    static final java.util.regex.Pattern Alphnu = java.util.regex.Pattern.compile("^[A-Za-z,0-9 ]++$");
    static final java.util.regex.Pattern Num = java.util.regex.Pattern.compile("^[+-]?([0-9]*[.])?[0-9]++$");

    static final java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("^[A-Za-z,0-9  ]++$");
    @BeforeTest
    public  void ExcelWdata() throws IOException, BiffException, WriteException {

        sourceDocument = Workbook.getWorkbook(new File("Excelsheet/TestCaseDemo.xls"));
        writableTempSource = Workbook.createWorkbook(new File("Excelsheet/temp.xls"), sourceDocument);
        copyDocument = Workbook.createWorkbook(new File("Excelsheet/TestReport/DraftTestReport.xls"));
        sourceSheet = writableTempSource.getSheet(4);
        targetSheet = copyDocument.createSheet("sheet 1", 3);

        WritableFont cellFont = new WritableFont(WritableFont.COURIER, 11);
        cellFont.setBoldStyle(WritableFont.BOLD);
/************************************************************************************************/
        WritableFont cellFont2 = new WritableFont(WritableFont.COURIER, 12);
        cellFont2.setColour(BLACK);
        // cellFont2.setBoldStyle(WritableFont.BOLD);
        cellFormat1 = new WritableCellFormat(cellFont2);
        cellFormat1.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
        cellFormat1.setWrap(true);
/*******************************************************************************************************/
/************************************************************************************************/
        WritableFont cellFont3 = new WritableFont(WritableFont.COURIER, 12);
        cellFont3.setColour(RED);
        //  cellFont3.setBoldStyle(WritableFont.BOLD);
        cellFormat3 = new WritableCellFormat(cellFont3);
        cellFormat3.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
        cellFormat3.setWrap(true);

        WritableFont cellFont4 = new WritableFont(WritableFont.COURIER, 12);
        cellFont4.setColour(GREEN);
        // cellFont4.setBoldStyle(WritableFont.BOLD);
        cellFormat4 = new WritableCellFormat(cellFont4);
        cellFormat4.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
        cellFormat4.setWrap(true);


        cellFormat = new WritableCellFormat(cellFont);
        cellFormat.setBackground(LIGHT_BLUE);
        cellFormat.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
        cellFormat.setWrap(true);
        cellFormat2 = new WritableCellFormat(cellFont);
        cellFormat2.setBackground(RED);
        //cellFormat.setAlignment(jxl.format.Alignment.getAlignment(20));
        WritableFont cellFont5 = new WritableFont(WritableFont.COURIER, 18);
        cellFont5.setColour(BLACK);
        cellFont5.setBoldStyle(WritableFont.BOLD);
        cellFormat5 = new WritableCellFormat(cellFont5);
        cellFormat5.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
        cellFormat5.setBackground(LIGHT_BLUE);
        cellFormat5.setAlignment(Alignment.CENTRE);

        //  sheet.addCell(new Label(col, 1, "CCCCC", cellFormat));
        cellFormat6 = new WritableCellFormat(cellFont2);
        cellFormat6.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
        cellFormat6.setWrap(true);
        cellFormat6.setBackground(LIGHT_TURQUOISE);

        for (int row = 0; row < sourceSheet.getRows(); row++) {
            for (int col = 0; col < sourceSheet.getColumns(); col++) {
                WritableCell readCell = sourceSheet.getWritableCell(col, row);
                WritableCell newCell = readCell.copyTo(col, row);
                CellFormat readFormat = readCell.getCellFormat();

                WritableCellFormat newFormat = new WritableCellFormat(readFormat);
                newCell.setCellFormat(newFormat);
                targetSheet.addCell(newCell);


                Label l2=new Label(5,1,"Actual ",cellFormat);

                Label l3=new Label(6,1,"Status",cellFormat);
                //Label l4=new Label(4,row,"",cellFormat);
                int widthInChars = 36;   int widthInChars1 = 16;
                int widthInChars2 = 20;
                targetSheet.setColumnView(4, widthInChars);
                targetSheet.setColumnView(5, widthInChars);
                targetSheet.setColumnView(2, widthInChars1);
                targetSheet.setColumnView(3, widthInChars1);
                targetSheet.setColumnView(1, widthInChars1);
/*-----------------------------------------------------------------------------------------------------------------------*/
                targetSheet.setColumnView(0, widthInChars2);
                targetSheet.mergeCells(0, 0, 6, 0);
                Label lable = new Label (0, 0,
                        "Draft test screen  report",cellFormat5);
                targetSheet.addCell(lable);
                targetSheet.addCell(l2);
                targetSheet.addCell(l3);
                //targetSheet.addCell(l4);

            }
        }

    }
    @AfterTest
    public void f() throws IOException, WriteException

    {

        copyDocument.write();
        copyDocument.close();
        writableTempSource.close();
        sourceDocument.close();

    }


    @Test(dataProvider="hybridData")
    public static void E(String testcaseName,String keyword,String objectName,String value,String Expeted) throws Exception {

        //   RowIncr=LastRow;
        if (testcaseName != null && testcaseName.length() != 0 ) {

            driver = openBrowser("chrome");
            GetUrl("url");
            LogFunction(driver);

            Menu menu=new Menu(driver);
            menu.ClickDraftlink();
            driver.switchTo().frame("ifrmListing");
            Thread.sleep(1000);//switch to iframe
            SetBord = j++;
            Label l7 = new Label(5, SetBord, "", cellFormat6);
            targetSheet.addCell(l7);
            Label l8 = new Label(6, SetBord, "", cellFormat6);
            targetSheet.addCell(l8);
        } else {
            SetBord = j++;


        }
        try {

            switch (keyword.toUpperCase()) {
                case "CLICK":
                    String WinHandleBefore1 = driver.getWindowHandle();
                    String WinHandleBefore2 = driver.getWindowHandle();

                    switch (objectName) {
                        case "FileNo":
                            try {
                                List<WebElement> cells = driver.findElements(By.xpath("./*//*[@id='ListProposalGrid']/tbody/tr[2]/td[2]/div/div[1]/table/tbody/tr/td/span"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();
                                    // System.out.println(fiels);

                                    if (fiels.equals(value))
                                        cell.click();
                                    Result="pass";
                                }
                            }catch (Throwable e)
                            {}
                            break;
                        case "DucForm":
                            duacForm =new DUACForm(driver);
                            duacForm.ClickDUACText();
                            driver.switchTo().frame("IframeDUACForm");
                            Result="pass";
                            break;

                        case "Submit":

                            duacForm.SaveDuacFormDetails();
                            Result="pass";
                            break;
                            /***************************NMA Script********************************/
                        case "NMA details":
                             nmaDetails=new NMADetails(driver);
                            nmaDetails.ClickNMADetailsText();
                            driver.switchTo().frame("IframeNMADetails");
                            Result="pass";
                            break;
                        case "NMA submit":
                      driver.findElement(By.id("Button1")).click();
                            Result="pass";
                            break;
                        case "Signature Documents":
                            driver.findElement(By.xpath(".//*[@id='Button3']")).click();
                            BeforeWH(driver);
                            driver.findElement(By.xpath(".//*[@id='btnAttached']")).click();
                            BeforeWH(driver);
                            Thread.sleep(6000);
                            WebElement ss = driver.findElement(By.id("RadAsyncUpload1file0"));
                            ss.click();
                            Thread.sleep(6000);
                            AttachFuntn(driver, FilePath2);
                            Thread.sleep(700);
                           driver.switchTo().window(WinHandleBefore2);
                       //     System.out.println(driver.switchTo().window(WinHandleBefore1).getTitle());
                            System.out.println(driver.switchTo().defaultContent().getTitle());

                            break;
                        case "Modern Constrution Images":
                            driver.findElement(By.xpath(".//*[@id='btnDWGPDFAttach1']")).click();
                            BeforeWH(driver);
                            driver.findElement(By.xpath(".//*[@id='btnAttached']")).click();
                            BeforeWH(driver);
                            Thread.sleep(6000);
                            WebElement ss4 = driver.findElement(By.id("RadAsyncUpload1file0"));
                            ss4.click();
                            Thread.sleep(6000);
                            AttachFuntn(driver, FilePath2);
                            Thread.sleep(700);
                            System.out.println(driver.switchTo().window(WinHandleBefore1).getTitle());

                            break;
                        case "Google Earth Images":
                            driver.findElement(By.xpath(".//*[@id='btnDWGPDFAttach2']")).click();
                            BeforeWH(driver);
                            driver.findElement(By.xpath(".//*[@id='btnAttached']")).click();
                            BeforeWH(driver);
                            Thread.sleep(6000);
                            WebElement ss5 = driver.findElement(By.id("RadAsyncUpload1file0"));
                            ss5.click();
                            Thread.sleep(6000);
                            AttachFuntn(driver, FilePath3);
                            Thread.sleep(700);
                            System.out.println(driver.switchTo().window(WinHandleBefore1).getTitle());
                            break;
                        /***************************NMA Script********************************/

                            case "AlertOK":

                            WebElement d  =      driver.findElement(By.xpath("//td[@class='rwWindowContent']/div/div/div[2]/a"));
                            String f=  d.getText();
                            d.click();
                            System.out.println(f);
                            break;
                        case "Attach Drawing":
                            attachDrawing=new AttachDrawing(driver);
                            attachDrawing.ClickDrawingALink();

                            driver.switchTo().frame("ifrmDrawings");

                            attachDrawing.ClickSelectFile();
                     BeforeWH(driver);
                            Thread.sleep(6000);
                           WebElement ss2 = driver.findElement(By.id("RadAsyncUpload1file0"));
                            ss2.click();
                            Thread.sleep(6000);
                            AttachFuntn(driver, FilePath);
                           Thread.sleep(700);


                            driver.switchTo().parentFrame();
                          Result="pass";

                            break;


                        case "ApplicantInfo":



                            driver.findElement(By.xpath("//html//body//form//div[4]"));
                    }
                    break;
                case "SELECT":
                    switch (objectName) {
                        case "MasterPlan":
                            String h= duacForm.getSELCTMasterPlan().getText();
                            System.out.println(h);
                            if(h.equals(value))
                                Result = "pass";
                            else
                                Result = "Fail";
                            Actual=" Master Plan Not be avilable in dropdown";
                            break;

                            case "ZonalApprovalMasterPlan":
                            try{
                            duacForm.setSELCTZonalMasterPlan(value);
                            Result="pass";
                    }catch ( Throwable r)
                {Result = "Fail";

                    Actual="Zonal Approval Master Plan Not be avilable in dropdown";}
                    }
                    break;

                case "SETTEXT":
                    switch (objectName) {
                        /***************************NMA Script********************************/
                        case "Monument Name":
                           nmaDetails.setMonumentName(value);
                            try {

                               /* if ((ExpectedConditions.alertIsPresent()) == null) {
                                    final String fieldValue2 =nmaDetails.getMonumentName().getAttribute("value");
                                    if (fieldValue2.equals(value))

                                        if(!Alphnu.matcher(fieldValue2).matches()){
                                            System.out.println(fieldValue2);
                                            Result = "pass";
                                        } else {
                                            Result = "fail";
                                        }
                                } else {
                                    Alert alert = driver.switchTo().alert();

                                    Actual = driver.switchTo().alert().getText();
                                    Thread.sleep(300);
                                    alert.accept();
                                }*/

                                final String fieldValue2 =nmaDetails.getMonumentName().getAttribute("value");
                                if (fieldValue2.isEmpty()) {
                                    try {
                                        if ((ExpectedConditions.alertIsPresent()) == null) {

                                        } else {
                                            Alert alert = driver.switchTo().alert();

                                            Actual = driver.switchTo().alert().getText();
                                            Thread.sleep(300);
                                            alert.accept();
                                            if (Actual.equals(Expeted)) {
                                                Result = "pass";
                                            } else {
                                                Result = "Fail";
                                            }
                                            System.out.println(Actual);
                                            //    Thread.sleep(50);

                                        }

                                    } catch (Throwable e) {
                                        Actual = "Alert message not display.";
                                        Result = "Fail";
                                    }


                                } else {
                                    if (fieldValue2.equals(value)) {
                                        if (!Alphnu.matcher(fieldValue2).matches()) {
                                            System.out.println(fieldValue2);
                                            try {
                                                if ((ExpectedConditions.alertIsPresent()) == null) {
                                                    Actual = "Alert message not display.";
                                                    Result = "Fail";
                                                    System.out.println("5");
                                                } else {
                                                    Alert alert = driver.switchTo().alert();
                                                    Actual = driver.switchTo().alert().getText();
                                                    if (Actual.equals(Expeted)) {
                                                        Result = "pass";
                                                    } else {
                                                        Result = "Fail";
                                                    }
                                                    System.out.println(Actual);
                                                    //    Thread.sleep(50);
                                                    alert.accept();

                                                }

                                            } catch (Throwable e) {
                                                Actual = "Alert message not display .";
                                                Result = "Fail";
                                            }
                                        } else {
                                            Result = "pass";
                                            System.out.println(fieldValue2);
                                            System.out.println(Result);
                                        }
                                    } else {
                                        if (Actual.equals(Expeted)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                    }
                                }
                            } catch (Throwable e) {

                            }
                            break;

                        case "District":
                            nmaDetails.setDistrict(value);
                            try {

                               /* if ((ExpectedConditions.alertIsPresent()) == null) {
                                    final String fieldValue = nmaDetails.getDistrict().getAttribute("value");
                                    if (fieldValue.equals(value))
                                        if(!String.matcher(fieldValue).matches()){

                                            Result = "pass";
                                        } else {
                                            Result = "fail";
                                        }
                                } else {
                                    Alert alert = driver.switchTo().alert();

                                    Actual = driver.switchTo().alert().getText();
                                    Thread.sleep(300);
                                    alert.accept();
                                }
*/
                                final String fieldValue = nmaDetails.getDistrict().getAttribute("value");
                                if (fieldValue.isEmpty()) {
                                    try {
                                        if ((ExpectedConditions.alertIsPresent()) == null) {

                                        } else {
                                            Alert alert = driver.switchTo().alert();

                                            Actual = driver.switchTo().alert().getText();
                                            Thread.sleep(300);
                                            alert.accept();
                                            if (Actual.equals(Expeted)) {
                                                Result = "pass";
                                            } else {
                                                Result = "Fail";
                                            }
                                            System.out.println(Actual);
                                            //    Thread.sleep(50);

                                        }

                                    } catch (Throwable e) {
                                        Actual = "Alert message not display.";
                                        Result = "Fail";
                                    }


                                } else {
                                    if (fieldValue.equals(value)) {
                                        if (!String.matcher(fieldValue).matches()) {
                                            try {
                                                if ((ExpectedConditions.alertIsPresent()) == null) {
                                                    Actual = "Alert message not display.";
                                                    Result = "Fail";
                                                } else {
                                                    Alert alert = driver.switchTo().alert();
                                                    Actual = driver.switchTo().alert().getText();
                                                    if (Actual.equals(Expeted)) {
                                                        Result = "pass";
                                                    } else {
                                                        Result = "Fail";
                                                    }
                                                    System.out.println(Actual);
                                                    //    Thread.sleep(50);
                                                    alert.accept();

                                                }

                                            } catch (Throwable e) {
                                                Actual = "Alert message not display .";
                                                Result = "Fail";
                                            }
                                        } else {
                                            Result = "pass";
                                            System.out.println(fieldValue);
                                            System.out.println(Result);
                                        }
                                    } else {
                                        if (Actual.equals(Expeted)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                    }
                                }
                            } catch (Throwable e) {

                            }
                            break;

                        case "Taluka":
                            nmaDetails.setTaluka(value);

                            try {

                             /* if ((ExpectedConditions.alertIsPresent()) == null) {

                                } else {
                                    Alert alert = driver.switchTo().alert();

                                    Actual = driver.switchTo().alert().getText();
                                    Thread.sleep(300);
                                    alert.accept();
                                }
*/
                                final String fieldValue = nmaDetails.getDistrict().getAttribute("value");
                                if (fieldValue.isEmpty()) {
                                    try {
                                        if ((ExpectedConditions.alertIsPresent()) == null) {

                                        } else {
                                            Alert alert = driver.switchTo().alert();

                                            Actual = driver.switchTo().alert().getText();
                                            Thread.sleep(300);
                                            alert.accept();
                                            if (Actual.equals(Expeted)) {
                                                Result = "pass";
                                            } else {
                                                Result = "Fail";
                                            }
                                            System.out.println(Actual);
                                            //    Thread.sleep(50);

                                        }

                                    } catch (Throwable e) {
                                        Actual = "Alert message not display.";
                                        Result = "Fail";
                                    }


                                } else {
                                    if (fieldValue.equals(value)) {
                                        if (!String.matcher(fieldValue).matches()) {
                                            try {
                                                if ((ExpectedConditions.alertIsPresent()) == null) {
                                                    Actual = "Alert message not display.";
                                                    Result = "Fail";
                                                } else {
                                                    Alert alert = driver.switchTo().alert();
                                                    Actual = driver.switchTo().alert().getText();
                                                    if (Actual.equals(Expeted)) {
                                                        Result = "pass";
                                                    } else {
                                                        Result = "Fail";
                                                    }
                                                    System.out.println(Actual);
                                                    //    Thread.sleep(50);
                                                    alert.accept();

                                                }

                                            } catch (Throwable e) {
                                                Actual = "Alert message not display .";
                                                Result = "Fail";
                                            }
                                        } else {
                                            Result = "pass";
                                            System.out.println(fieldValue);
                                            System.out.println(Result);
                                        }
                                    } else {
                                        if (Actual.equals(Expeted)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                    }
                                }
                            } catch (Throwable e) {


                            }

                            break;
                        case "Distance from Protected boundery Wall":
                            nmaDetails.setDistanceProtectedbouewall(value);
                            final String fieldValue4 = nmaDetails.getDistanceProtectedbouewall().getAttribute("value");
                            System.out.println(value);
                            System.out.println(fieldValue4);
                            if (fieldValue4.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();
                                        Actual = driver.switchTo().alert().getText();
                                        if (Actual.equals(Expeted)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }//System.out.println(Actual);
                                        //    Thread.sleep(50);
                                        alert.accept();

                                    }

                                } catch (Throwable e) {
                                }

                            } else {
                                if (fieldValue4.equals(value)||fieldValue4.equals(+0+value)) {
                                    //   System.out.println(value);
                                    if (!Num.matcher(fieldValue4).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display .";
                                                Result = "Fail";
                                            } else {
                                                Alert alert = driver.switchTo().alert();
                                                Actual = driver.switchTo().alert().getText();
                                                if (Actual.equals(Expeted)) {
                                                    Result = "pass";
                                                } else {
                                                    Result = "Fail";
                                                }
                                                //      System.out.println(Actual);
                                                //    Thread.sleep(50);
                                                alert.accept();

                                            }

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {

                                        Result = "pass";
                                        //System.out.println(fieldValue4);

                                        //  System.out.println(Result);
                                    }
                                } else {

                                    if (Actual.equals(Expeted)) {
                                        System.out.println(fieldValue4);
                                        Result = "pass";
                                    } else {
                                        Result = "Fail";
                                        System.out.println(Actual);
                                    }
                                }
                            }
                            break;
                        case "Locality":
                            nmaDetails.setLocalityt(value);
                            try {

                                if ((ExpectedConditions.alertIsPresent()) == null) {
                                    final String fieldValue = nmaDetails.getLocality().getAttribute("value");
                                    if (fieldValue.equals(value))
                                        if(!String.matcher(fieldValue).matches()){

                                            Result = "Pass";
                                        } else {
                                            Result = "fail";
                                        }
                                } else {
                                    Alert alert = driver.switchTo().alert();

                                    Actual = driver.switchTo().alert().getText();
                                    Thread.sleep(300);
                                    alert.accept();
                                }

                                final String fieldValue = nmaDetails.getLocality().getAttribute("value");
                                if (fieldValue.isEmpty()) {
                                    try {
                                        if ((ExpectedConditions.alertIsPresent()) == null) {

                                        } else {
                                            Alert alert = driver.switchTo().alert();

                                            Actual = driver.switchTo().alert().getText();
                                            Thread.sleep(300);
                                            alert.accept();
                                            if (Actual.equals(Expeted)) {
                                                Result = "pass";
                                            } else {
                                                Result = "Fail";
                                            }
                                            System.out.println(Actual);
                                            //    Thread.sleep(50);

                                        }

                                    } catch (Throwable e) {
                                        Actual = "Alert message not display.";
                                        Result = "Fail";
                                    }


                                } else {
                                    if (fieldValue.equals(value)) {
                                        if (!String.matcher(fieldValue).matches()) {
                                            try {
                                                if ((ExpectedConditions.alertIsPresent()) == null) {
                                                    Actual = "Alert message not display.";
                                                    Result = "Fail";
                                                } else {
                                                    Alert alert = driver.switchTo().alert();
                                                    Actual = driver.switchTo().alert().getText();
                                                    if (Actual.equals(Expeted)) {
                                                        Result = "pass";
                                                    } else {
                                                        Result = "Fail";
                                                    }
                                                    System.out.println(Actual);
                                                    //    Thread.sleep(50);
                                                    alert.accept();

                                                }

                                            } catch (Throwable e) {
                                                Actual = "Alert message not display .";
                                                Result = "Fail";
                                            }
                                        } else {
                                            Result = "pass";
                                            System.out.println(fieldValue);
                                            System.out.println(Result);
                                        }
                                    } else {
                                        if (Actual.equals(Expeted)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                    }
                                }
                            } catch (Throwable e) {

                            }
                            break;

                        case "Distance from Monument(Mtr.)":
                            nmaDetails.setDistancMonumen(value);
                            final String fieldValue6 = nmaDetails.getDistancMonumen().getAttribute("value");
                            System.out.println(value);
                            System.out.println(fieldValue6);
                            if (fieldValue6.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();
                                        Actual = driver.switchTo().alert().getText();
                                        if (Actual.equals(Expeted)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }//System.out.println(Actual);
                                        //    Thread.sleep(50);
                                        alert.accept();

                                    }

                                } catch (Throwable e) {
                                }

                            } else {
                                if (fieldValue6.equals(value)||fieldValue6.equals(+0+value)) {
                                    //   System.out.println(value);
                                    if (!Num.matcher(fieldValue6).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display .";
                                                Result = "Fail";
                                            } else {
                                                Alert alert = driver.switchTo().alert();
                                                Actual = driver.switchTo().alert().getText();
                                                if (Actual.equals(Expeted)) {
                                                    Result = "pass";
                                                } else {
                                                    Result = "Fail";
                                                }
                                                //      System.out.println(Actual);
                                                //    Thread.sleep(50);
                                                alert.accept();

                                            }

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {

                                        Result = "pass";
                                        //System.out.println(fieldValue4);

                                        //  System.out.println(Result);
                                    }
                                } else {

                                    if (Actual.equals(Expeted)) {
                                        System.out.println(fieldValue6);
                                        Result = "pass";
                                    } else {
                                        Result = "Fail";
                                        System.out.println(Actual);
                                    }
                                }
                            }
                            break;

                        case "Maximum height of Existing Builindg":
                            nmaDetails.setMaximumheightBuilindg(value);
                            final String fieldValue5 = nmaDetails.getMaximumheightBuilindg().getAttribute("value");
                            System.out.println(value);
                            System.out.println(fieldValue5);
                            if (fieldValue5.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();
                                        Actual = driver.switchTo().alert().getText();
                                        if (Actual.equals(Expeted)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }//System.out.println(Actual);
                                        //    Thread.sleep(50);
                                        alert.accept();

                                    }

                                } catch (Throwable e) {
                                }

                            } else {
                                if (fieldValue5.equals(+0+value)||fieldValue5.equals(value)) {
                                    //   System.out.println(value);
                                    if (!Num.matcher(fieldValue5).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display .";
                                                Result = "Fail";
                                            } else {
                                                Alert alert = driver.switchTo().alert();
                                                Actual = driver.switchTo().alert().getText();
                                                if (Actual.equals(Expeted)) {
                                                    Result = "pass";
                                                } else {
                                                    Result = "Fail";
                                                }
                                                //      System.out.println(Actual);
                                                //    Thread.sleep(50);
                                                alert.accept();

                                            }

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {

                                        Result = "pass";
                                        //System.out.println(fieldValue4);

                                        //  System.out.println(Result);
                                    }
                                } else {

                                    if (Actual.equals(Expeted)) {
                                        System.out.println(fieldValue5);
                                        Result = "pass";
                                    } else {
                                        Result = "Fail";
                                        System.out.println(Actual);
                                    }
                                }
                            }
                            break;

                        case "Monument in Limit":
                            nmaDetails.setMonumentinLimitof(value);
                            Result="pass";
                            break;
                        case "Status of Construction of Modern Building":
                            nmaDetails.setStatusModernBuilding(value);
                            try {
/*
                                if ((ExpectedConditions.alertIsPresent()) == null) {
                                    final String fieldValue =nmaDetails.getStatusModernBuilding().getAttribute("value");
                                    if (fieldValue.equals(value))
                                        if(!Alphnu.matcher(fieldValue).matches()){

                                            Result = "Pass";
                                        } else {
                                            Result = "fail";
                                        }
                                } else {
                                    Alert alert = driver.switchTo().alert();

                                    Actual = driver.switchTo().alert().getText();
                                    Thread.sleep(300);
                                    alert.accept();
                                }*/

                                final String fieldValue = nmaDetails.getStatusModernBuilding().getAttribute("value");
                                if (fieldValue.isEmpty()) {
                                    try {
                                        if ((ExpectedConditions.alertIsPresent()) == null) {

                                        } else {
                                            Alert alert = driver.switchTo().alert();

                                            Actual = driver.switchTo().alert().getText();
                                            Thread.sleep(300);
                                            alert.accept();
                                            if (Actual.equals(Expeted)) {
                                                Result = "pass";
                                            } else {
                                                Result = "Fail";
                                            }
                                            System.out.println(Actual);
                                            //    Thread.sleep(50);

                                        }

                                    } catch (Throwable e) {
                                        Actual = "Alert message not display.";
                                        Result = "Fail";
                                    }


                                } else {
                                    if (fieldValue.equals(value)) {
                                        if (!Alphnu.matcher(fieldValue).matches()) {
                                            try {
                                                if ((ExpectedConditions.alertIsPresent()) == null) {
                                                    Actual = "Alert message not display.";
                                                    Result = "Fail";
                                                } else {
                                                    Alert alert = driver.switchTo().alert();
                                                    Actual = driver.switchTo().alert().getText();
                                                    if (Actual.equals(Expeted)) {
                                                        Result = "pass";
                                                    } else {
                                                        Result = "Fail";
                                                    }
                                                    System.out.println(Actual);
                                                    //    Thread.sleep(50);
                                                    alert.accept();

                                                }

                                            } catch (Throwable e) {
                                                Actual = "Alert message not display .";
                                                Result = "Fail";
                                            }
                                        } else {
                                            Result = "pass";
                                            System.out.println(fieldValue);
                                            System.out.println(Result);
                                        }
                                    } else {
                                        if (Actual.equals(Expeted)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                    }
                                }
                            } catch (Throwable e) {

                            }

                            break;

                        case "pen Space or Parking area":
                            nmaDetails.setOpenSpace(value);
                            final String fieldValue8 = nmaDetails.getOpenSpace().getAttribute("value");
                            System.out.println(value);
                            System.out.println(fieldValue8);
                            if (fieldValue8.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();
                                        Actual = driver.switchTo().alert().getText();
                                        if (Actual.equals(Expeted)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }//System.out.println(Actual);
                                        //    Thread.sleep(50);
                                        alert.accept();

                                    }

                                } catch (Throwable e) {
                                }

                            } else {
                                if (fieldValue8.equals(value)||fieldValue8.equals(+0+value)) {
                                    //   System.out.println(value);
                                    if (!Num.matcher(fieldValue8).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display .";
                                                Result = "Fail";
                                            } else {
                                                Alert alert = driver.switchTo().alert();
                                                Actual = driver.switchTo().alert().getText();
                                                if (Actual.equals(Expeted)) {
                                                    Result = "pass";
                                                } else {
                                                    Result = "Fail";
                                                }
                                                //      System.out.println(Actual);
                                                //    Thread.sleep(50);
                                                alert.accept();

                                            }

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {

                                        Result = "pass";
                                        //System.out.println(fieldValue4);

                                        //  System.out.println(Result);
                                    }
                                } else {

                                    if (Actual.equals(Expeted)) {
                                        System.out.println(fieldValue8);
                                        Result = "pass";
                                    } else {
                                        Result = "Fail";
                                        System.out.println(Actual);
                                    }
                                }
                            }
                            break;

                        case "Road details":
                            nmaDetails.setRoaddetails(value);
                            Result="pass";
                            break;

                        case "Number Of Storeys":
                            nmaDetails.setNumberOfStoreys(value);
                            final String fieldValue9 = nmaDetails.getNumberOfStoreys().getAttribute("value");
                            System.out.println(value);
                            System.out.println(fieldValue9);
                            if (fieldValue9.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();
                                        Actual = driver.switchTo().alert().getText();
                                        if (Actual.equals(Expeted)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }//System.out.println(Actual);
                                        //    Thread.sleep(50);
                                        alert.accept();

                                    }

                                } catch (Throwable e) {
                                }

                            } else {
                                if (fieldValue9.equals(value)||fieldValue9.equals(+0+value)) {
                                    //   System.out.println(value);
                                    if (!Num.matcher(fieldValue9).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display .";
                                                Result = "Fail";
                                            } else {
                                                Alert alert = driver.switchTo().alert();
                                                Actual = driver.switchTo().alert().getText();
                                                if (Actual.equals(Expeted)) {
                                                    Result = "pass";
                                                } else {
                                                    Result = "Fail";
                                                }
                                                //      System.out.println(Actual);
                                                //    Thread.sleep(50);
                                                alert.accept();

                                            }

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {

                                        Result = "pass";
                                        //System.out.println(fieldValue4);

                                        //  System.out.println(Result);
                                    }
                                } else {

                                    if (Actual.equals(Expeted)) {
                                        System.out.println(fieldValue9);
                                        Result = "pass";
                                    } else {
                                        Result = "Fail";
                                        System.out.println(Actual);
                                    }
                                }
                            }
                            break;
                        case "Basement Details":
                            nmaDetails.setBasementDetails(value);
                            Result="pass";
                            break;

                        case "Approximate Duration":
                            nmaDetails.setApproximateDuration(value);
                            try {

                                if ((ExpectedConditions.alertIsPresent()) == null) {
                                    final String fieldValue =nmaDetails.getApproximateDuration().getAttribute("value");
                                    if (fieldValue.equals(value))
                                        if(!Alphnu.matcher(fieldValue).matches()){

                                            Result = "Pass";
                                        } else {
                                            Result = "fail";
                                        }
                                } else {
                                    Alert alert = driver.switchTo().alert();

                                    Actual = driver.switchTo().alert().getText();
                                    Thread.sleep(300);
                                    alert.accept();
                                }

                                final String fieldValue = duacForm.getNameoftheproposal().getAttribute("value");
                                if (fieldValue.isEmpty()) {
                                    try {
                                        if ((ExpectedConditions.alertIsPresent()) == null) {

                                        } else {
                                            Alert alert = driver.switchTo().alert();

                                            Actual = driver.switchTo().alert().getText();
                                            Thread.sleep(300);
                                            alert.accept();
                                            if (Actual.equals(Expeted)) {
                                                Result = "pass";
                                            } else {
                                                Result = "Fail";
                                            }
                                            System.out.println(Actual);
                                            //    Thread.sleep(50);

                                        }

                                    } catch (Throwable e) {
                                        Actual = "Alert message not display.";
                                        Result = "Fail";
                                    }


                                } else {
                                    if (fieldValue.equals(value)) {
                                        if (!Alphnu.matcher(fieldValue).matches()) {
                                            try {
                                                if ((ExpectedConditions.alertIsPresent()) == null) {
                                                    Actual = "Alert message not display.";
                                                    Result = "Fail";
                                                } else {
                                                    Alert alert = driver.switchTo().alert();
                                                    Actual = driver.switchTo().alert().getText();
                                                    if (Actual.equals(Expeted)) {
                                                        Result = "pass";
                                                    } else {
                                                        Result = "Fail";
                                                    }
                                                    System.out.println(Actual);
                                                    //    Thread.sleep(50);
                                                    alert.accept();

                                                }

                                            } catch (Throwable e) {
                                                Actual = "Alert message not display .";
                                                Result = "Fail";
                                            }
                                        } else {
                                            Result = "pass";
                                            System.out.println(fieldValue);
                                            System.out.println(Result);
                                        }
                                    } else {
                                        if (Actual.equals(Expeted)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                    }
                                }
                            } catch (Throwable e) {

                            }

                            break;

                        case "Approximate Date":
                            nmaDetails.setApproximateDate(value);
                            Result="pass";
                            break;

                        case "Height In Metres Including Mumty Parapet Water Storage Tank":

                            nmaDetails.setHeightMumty(value);
                            final String fieldValue10 = nmaDetails.getHeightMumty().getAttribute("value");
                            System.out.println(value);
                            System.out.println(fieldValue10);
                            if (fieldValue10.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();
                                        Actual = driver.switchTo().alert().getText();
                                        if (Actual.equals(Expeted)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }//System.out.println(Actual);
                                        //    Thread.sleep(50);
                                        alert.accept();

                                    }

                                } catch (Throwable e) {
                                }

                            } else {
                                if (fieldValue10.equals(value)||fieldValue10.equals(+0+value)) {
                                    //   System.out.println(value);
                                    if (!Num.matcher(fieldValue10).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display .";
                                                Result = "Fail";
                                            } else {
                                                Alert alert = driver.switchTo().alert();
                                                Actual = driver.switchTo().alert().getText();
                                                if (Actual.equals(Expeted)) {
                                                    Result = "pass";
                                                } else {
                                                    Result = "Fail";
                                                }
                                                //      System.out.println(Actual);
                                                //    Thread.sleep(50);
                                                alert.accept();

                                            }

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {

                                        Result = "pass";
                                        //System.out.println(fieldValue4);

                                        //  System.out.println(Result);
                                    }
                                } else {

                                    if (Actual.equals(Expeted)) {
                                        System.out.println(fieldValue10);
                                        Result = "pass";
                                    } else {
                                        Result = "Fail";
                                        System.out.println(Actual);
                                    }
                                }
                            }
                            break;

                        case "HeightIn Metres Excluding Mumty Parapet Water Storage Tank":
                            nmaDetails.setHeightInExcludingMumty(value);
                            final String fieldValue11 = nmaDetails.getHeightInExcludingMumty().getAttribute("value");
                            System.out.println(value);
                            System.out.println(fieldValue11);
                            if (fieldValue11.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();
                                        Actual = driver.switchTo().alert().getText();
                                        if (Actual.equals(Expeted)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }//System.out.println(Actual);
                                        //    Thread.sleep(50);
                                        alert.accept();

                                    }

                                } catch (Throwable e) {
                                }

                            } else {
                                if (fieldValue11.equals(value)||fieldValue11.equals(+0+value)) {
                                    //   System.out.println(value);
                                    if (!Num.matcher(fieldValue11).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display .";
                                                Result = "Fail";
                                            } else {
                                                Alert alert = driver.switchTo().alert();
                                                Actual = driver.switchTo().alert().getText();
                                                if (Actual.equals(Expeted)) {
                                                    Result = "pass";
                                                } else {
                                                    Result = "Fail";
                                                }
                                                //      System.out.println(Actual);
                                                //    Thread.sleep(50);
                                                alert.accept();

                                            }

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {

                                        Result = "pass";
                                        //System.out.println(fieldValue4);

                                        //  System.out.println(Result);
                                    }
                                } else {

                                    if (Actual.equals(Expeted)) {
                                        System.out.println(fieldValue11);
                                        Result = "pass";
                                    } else {
                                        Result = "Fail";
                                        System.out.println(Actual);
                                    }
                                }
                            }
                            break;

                        case "Remark":
                            nmaDetails.setRemark(value);
                            Result="Pass";
                            break;
                        /*************************** END NMA Script********************************/
                        case "Name":
                            duacForm.setNameText(value);
                            try {

                                if ((ExpectedConditions.alertIsPresent()) == null) {
                                    final String fieldValue = duacForm.getNameText().getAttribute("value");
                                    if (fieldValue.equals(value))
                                        if(!String.matcher(fieldValue).matches()){

                                            Result = "Pass";
                                        } else {
                                            Result = "fail";
                                        }
                                } else {
                                    Alert alert = driver.switchTo().alert();

                                    Actual = driver.switchTo().alert().getText();
                                    Thread.sleep(300);
                                    alert.accept();
                                }

                                final String fieldValue = duacForm.getNameText().getAttribute("value");
                                if (fieldValue.isEmpty()) {
                                    try {
                                        if ((ExpectedConditions.alertIsPresent()) == null) {

                                        } else {
                                            Alert alert = driver.switchTo().alert();

                                            Actual = driver.switchTo().alert().getText();
                                            Thread.sleep(300);
                                            alert.accept();
                                            if (Actual.equals(Expeted)) {
                                                Result = "pass";
                                            } else {
                                                Result = "Fail";
                                            }
                                            System.out.println(Actual);
                                            //    Thread.sleep(50);

                                        }

                                    } catch (Throwable e) {
                                        Actual = "Alert message not display.";
                                        Result = "Fail";
                                    }


                                } else {
                                    if (fieldValue.equals(value)) {
                                        if (!String.matcher(fieldValue).matches()) {
                                            try {
                                                if ((ExpectedConditions.alertIsPresent()) == null) {
                                                    Actual = "Alert message not display.";
                                                    Result = "Fail";
                                                } else {
                                                    Alert alert = driver.switchTo().alert();
                                                    Actual = driver.switchTo().alert().getText();
                                                    if (Actual.equals(Expeted)) {
                                                        Result = "pass";
                                                    } else {
                                                        Result = "Fail";
                                                    }
                                                    System.out.println(Actual);
                                                    //    Thread.sleep(50);
                                                    alert.accept();

                                                }

                                            } catch (Throwable e) {
                                                Actual = "Alert message not display .";
                                                Result = "Fail";
                                            }
                                        } else {
                                            Result = "pass";
                                            System.out.println(fieldValue);
                                            System.out.println(Result);
                                        }
                                    } else {
                                        if (Actual.equals(Expeted)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                    }
                                }
                            } catch (Throwable e) {

                            }

                            break;

                        case "Address":
                           duacForm.setAddress(value);
                           Result="pass";
                            break;
                        case "Name of proposal":
                            duacForm.setNameoftheproposal(value);
                            try {

                                if ((ExpectedConditions.alertIsPresent()) == null) {
                                    final String fieldValue =duacForm.getNameoftheproposal().getAttribute("value");
                                    if (fieldValue.equals(value))
                                        if(!Alphnu.matcher(fieldValue).matches()){

                                            Result = "Pass";
                                        } else {
                                            Result = "fail";
                                        }
                                } else {
                                    Alert alert = driver.switchTo().alert();

                                    Actual = driver.switchTo().alert().getText();
                                    Thread.sleep(300);
                                    alert.accept();
                                }

                                final String fieldValue = duacForm.getNameoftheproposal().getAttribute("value");
                                if (fieldValue.isEmpty()) {
                                    try {
                                        if ((ExpectedConditions.alertIsPresent()) == null) {

                                        } else {
                                            Alert alert = driver.switchTo().alert();

                                            Actual = driver.switchTo().alert().getText();
                                            Thread.sleep(300);
                                            alert.accept();
                                            if (Actual.equals(Expeted)) {
                                                Result = "pass";
                                            } else {
                                                Result = "Fail";
                                            }
                                            System.out.println(Actual);
                                            //    Thread.sleep(50);

                                        }

                                    } catch (Throwable e) {
                                        Actual = "Alert message not display.";
                                        Result = "Fail";
                                    }


                                } else {
                                    if (fieldValue.equals(value)) {
                                        if (!Alphnu.matcher(fieldValue).matches()) {
                                            try {
                                                if ((ExpectedConditions.alertIsPresent()) == null) {
                                                    Actual = "Alert message not display.";
                                                    Result = "Fail";
                                                } else {
                                                    Alert alert = driver.switchTo().alert();
                                                    Actual = driver.switchTo().alert().getText();
                                                    if (Actual.equals(Expeted)) {
                                                        Result = "pass";
                                                    } else {
                                                        Result = "Fail";
                                                    }
                                                    System.out.println(Actual);
                                                    //    Thread.sleep(50);
                                                    alert.accept();

                                                }

                                            } catch (Throwable e) {
                                                Actual = "Alert message not display .";
                                                Result = "Fail";
                                            }
                                        } else {
                                            Result = "pass";
                                            System.out.println(fieldValue);
                                            System.out.println(Result);
                                        }
                                    } else {
                                        if (Actual.equals(Expeted)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                    }
                                }
                            } catch (Throwable e) {

                            }

                            break;
                        case "Landline No":
                            duacForm.setLandLine(value);
                           /* final String fieldValue12 = duacForm.getLandLine().getAttribute("value");
                            System.out.println(value);
                            System.out.println(fieldValue12);
                            if (fieldValue11.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();
                                        Actual = driver.switchTo().alert().getText();
                                        if (Actual.equals(Expeted)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }//System.out.println(Actual);
                                        //    Thread.sleep(50);
                                        alert.accept();

                                    }

                                } catch (Throwable e) {
                                }

                            } else {
                                if (fieldValue12.equals(value)) {
                                    //   System.out.println(value);
                                    if (!Num.matcher(fieldValue12).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display .";
                                                Result = "Fail";
                                            } else {
                                                Alert alert = driver.switchTo().alert();
                                                Actual = driver.switchTo().alert().getText();
                                                if (Actual.equals(Expeted)) {
                                                    Result = "pass";
                                                } else {
                                                    Result = "Fail";
                                                }
                                                //      System.out.println(Actual);
                                                //    Thread.sleep(50);
                                                alert.accept();

                                            }

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {

                                        Result = "pass";
                                        //System.out.println(fieldValue4);

                                        //  System.out.println(Result);
                                    }
                                } else {

                                    if (Actual.equals(Expeted)) {
                                        System.out.println(fieldValue12);
                                        Result = "pass";
                                    } else {
                                        Result = "Fail";
                                        System.out.println(Actual);
                                    }
                                }*/

                            break;
                        case "Architect Landline No":
                            duacForm.setArchiteLandLine(value);
                            final String fieldValue13 = duacForm.getArchiteLandLine().getAttribute("value");
                            System.out.println(value);
                            System.out.println(fieldValue13);
                            if (fieldValue13.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();
                                        Actual = driver.switchTo().alert().getText();
                                        if (Actual.equals(Expeted)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }//System.out.println(Actual);
                                        //    Thread.sleep(50);
                                        alert.accept();

                                    }

                                } catch (Throwable e) {
                                }

                            } else {
                                if (fieldValue13.equals(value)) {
                                    //   System.out.println(value);
                                    if (!Num.matcher(fieldValue13).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display .";
                                                Result = "Fail";
                                            } else {
                                                Alert alert = driver.switchTo().alert();
                                                Actual = driver.switchTo().alert().getText();
                                                if (Actual.equals(Expeted)) {
                                                    Result = "pass";
                                                } else {
                                                    Result = "Fail";
                                                }
                                                //      System.out.println(Actual);
                                                //    Thread.sleep(50);
                                                alert.accept();

                                            }

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {

                                        Result = "pass";
                                        //System.out.println(fieldValue4);

                                        //  System.out.println(Result);
                                    }
                                } else {

                                    if (Actual.equals(Expeted)) {
                                        System.out.println(fieldValue13);
                                        Result = "pass";
                                    } else {
                                        Result = "Fail";
                                        System.out.println(Actual);
                                    }
                                }
                            }


                    }
                    break;
                default:
                    System.out.println("default");
                    break;
            }


            if (testcaseName.isEmpty()) {
                LastRow = n++;
                if (Result.equals("pass")) {
                    Label l5 = new Label(5, LastRow, "As Exptected", cellFormat1);
                    targetSheet.addCell(l5);
                    Label l6 = new Label(6, LastRow, "PASS", cellFormat4);
                    targetSheet.addCell(l6);
                } else {

                    Label l5 = new Label(5, LastRow, Actual, cellFormat1);
                    targetSheet.addCell(l5);
                    Label l6 = new Label(6, LastRow, "FAIL", cellFormat3);
                    targetSheet.addCell(l6);
                }
            } else {
                LastRow = n++;

            }


        }catch (NullPointerException e){}

    }

    @DataProvider(name="hybridData")
    public Object[][] getDataFromDataprovider() throws IOException {
        Object[][] object = null;
        FileInputStream fis = new FileInputStream("Excelsheet/TestCaseDemo.xls");
        HSSFWorkbook wb = new HSSFWorkbook(fis);
        HSSFSheet sh = wb.getSheet("Draft window test  Case");
        //  HSSFRow rows = sh.getRow(1);
//Read keyword sheet
//Find number of rows in Expl.excel file
        int rowCount =sh.getLastRowNum()-sh.getFirstRowNum();
        System.out.println(rowCount);
        object = new Object[rowCount][5];
        for (int i = 1; i < rowCount; i++) {

            HSSFRow row = sh.getRow(i+1);


            for (int j = 0; j < row.getLastCellNum(); j++) {
                //  System.out.println(row.getCell(j).toString());
                object[i][j] = row.getCell(j).toString();

            }


        }
        return object;
    }
}

