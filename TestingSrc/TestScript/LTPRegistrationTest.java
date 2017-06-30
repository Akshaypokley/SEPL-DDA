package TestScript;

import Pages.LTPRegistration;
import Pages.Login;
import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.Pattern;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.print.DocFlavor;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.*;

import static Utilites.AttachFunction.AttachFuntn;
import static Utilites.BeforeWH.BeforeWH;
import static Utilites.DateFunction.DateFun;
import static Utilites.OpenBrowser.GetUrl;
import static Utilites.OpenBrowser.openBrowser;
import static Utilites.Windowhander.NewWindow;
import static jxl.format.Colour.*;

/**
 * Created by akshay.pokley on 6/13/2017.
 */
public class LTPRegistrationTest {

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
    static int RowIncr;
    static final java.util.regex.Pattern String = java.util.regex.Pattern.compile("^[A-Za-z, ]++$");
    static final java.util.regex.Pattern Num = java.util.regex.Pattern.compile("^[0-9]++$");
    static final java.util.regex.Pattern Emailval = java.util.regex.Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    static final java.util.regex.Pattern Alphnu = java.util.regex.Pattern.compile("^[A-Za-z,0-9  ]++$");

    @BeforeTest
    public  void ExcelWdata() throws IOException, BiffException, WriteException {

        sourceDocument = Workbook.getWorkbook(new File("Excelsheet/TestCaseDemo.xls"));
        writableTempSource = Workbook.createWorkbook(new File("Excelsheet/temp.xls"), sourceDocument);
        copyDocument = Workbook.createWorkbook(new File("Excelsheet/TestReport/RegistrationReport.xls"));
        sourceSheet = writableTempSource.getSheet(3);
        targetSheet = copyDocument.createSheet("sheet 1", 2);

        WritableFont cellFont = new WritableFont(WritableFont.TIMES, 11);
        cellFont.setBoldStyle(WritableFont.BOLD);
/************************************************************************************************/
        WritableFont cellFont2 = new WritableFont(WritableFont.COURIER, 10);
        cellFont2.setColour(BLACK);
        //cellFont2.setBoldStyle(WritableFont.BOLD);
        cellFormat1 = new WritableCellFormat(cellFont2);
        cellFormat1.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
        cellFormat1.setWrap(true);
/*******************************************************************************************************/
/************************************************************************************************/
        WritableFont cellFont3 = new WritableFont(WritableFont.COURIER, 10);
        cellFont3.setColour(RED);
       // cellFont3.setBoldStyle(WritableFont.BOLD);
        cellFormat3 = new WritableCellFormat(cellFont3);
        cellFormat3.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
        cellFormat3.setWrap(true);

        WritableFont cellFont4 = new WritableFont(WritableFont.COURIER, 10);
        cellFont4.setColour(GREEN);
       // cellFont4.setBoldStyle(WritableFont.BOLD);
        cellFormat4 = new WritableCellFormat(cellFont4);
        cellFormat4.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
        cellFormat4.setWrap(true);


        cellFormat = new WritableCellFormat(cellFont);
        cellFormat.setBackground(SKY_BLUE);
        cellFormat.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
        cellFormat.setWrap(true);
        cellFormat2 = new WritableCellFormat(cellFont);
        cellFormat2.setBackground(RED);
        //cellFormat.setAlignment(jxl.format.Alignment.getAlignment(20));
        WritableFont cellFont5 = new WritableFont(WritableFont.TIMES, 18);
        cellFont5.setColour(BLACK);
        cellFont5.setBoldStyle(WritableFont.BOLD);
        cellFormat5 = new WritableCellFormat(cellFont5);
        cellFormat5.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
        cellFormat5.setBackground(SKY_BLUE);
        cellFormat5.setAlignment(Alignment.CENTRE);

        //  sheet.addCell(new Label(col, 1, "CCCCC", cellFormat));

        for (int row = 0; row < sourceSheet.getRows(); row++) {
            for (int col = 0; col < sourceSheet.getColumns(); col++) {
                WritableCell readCell = sourceSheet.getWritableCell(col, row);
                WritableCell newCell = readCell.copyTo(col, row);
                CellFormat readFormat = readCell.getCellFormat();

                WritableCellFormat newFormat = new WritableCellFormat(readFormat);
                newCell.setCellFormat(newFormat);
                targetSheet.addCell(newCell);


                Label l2=new Label(5,1,"Actual Message",cellFormat);

                Label l3=new Label(6,1,"Result",cellFormat);
                //Label l4=new Label(4,row,"",cellFormat);
                int widthInChars = 36;
                int widthInChars2 = 18;
                targetSheet.setColumnView(4, widthInChars);
                targetSheet.setColumnView(5, widthInChars);
/*-----------------------------------------------------------------------------------------------------------------------*/
                targetSheet.setColumnView(0, widthInChars2);
                targetSheet.setColumnView(2, widthInChars2);

                targetSheet.setColumnView(3, widthInChars2);
                targetSheet.mergeCells(0, 0, 6, 0);
                Label lable = new Label (0, 0,
                        "LTP-Registration window test  report",cellFormat5);
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
    public static void RegistrationData(String testcaseName,String keyword,String objectName,String value,String Expected) throws Exception {

        if (testcaseName != null && testcaseName.length() != 0 ) {

            driver = openBrowser("chrome");
            GetUrl("url");
            Login login = new Login(driver);
            login.setRegistrationLink();
            Thread.sleep(200);
            NewWindow(driver);

            SetBord = j++;
            Label l7 = new Label(5, SetBord, "", cellFormat1);
            targetSheet.addCell(l7);
            Label l8 = new Label(6, SetBord, "", cellFormat1);
            targetSheet.addCell(l8);
        } else {
            SetBord = j++;
        }

        try {
          /*  Thread.sleep(400);
            NewWindow(driver);*/
            LTPRegistration ltpRegistration = new LTPRegistration(driver);

            switch (keyword.toUpperCase()) {

                case "CLICK":
                    String FilePath = "E:\\Akshay85\\select.pdf";
                    String WinHandleBefore1 = driver.getWindowHandle();
                    switch (objectName) {

                        case "Submit":
                            ltpRegistration.ClickSubmit();
                            Actual2 = "Alert message should be display.";
                            // if (driver.findElement(By.xpath("./*//*[@id='lblULBName']")).getText().equals("Delhi Development Authority")) {
                            try {
                                if ((ExpectedConditions.alertIsPresent()) == null) {
                                    System.out.println("alert was not present");
                                   // if (driver.findElement(By.xpath(".*//*//**//*[@id='lblULBName']")).getText().equals("Delhi Development Authority"))
                                        Result = "pass";
                                } else {
                                    Alert alert = driver.switchTo().alert();
                                    Actual = driver.switchTo().alert().getText();
                                    if (Actual.equals(Expected) || Actual2.equals(Expected)) {
                                        Result = "pass";
                                    } else {
                                        Result = "Fail";
                                    }
                                    System.out.println(Actual);
                                    //    Thread.sleep(50);
                                    alert.accept();

                                }

                            } catch (Throwable e) {
                            }

                            break;

                        case "AttachID":
                            driver.findElement(By.id("IdattachIdproof")).click();

                            BeforeWH(driver);
                            WebElement ss = driver.findElement(By.id("RadAsyncUpload1file0"));
                            ss.click();
                            Thread.sleep(6000);
                            AttachFuntn(driver, FilePath);
                            Thread.sleep(700);
                            driver.switchTo().window(WinHandleBefore1);
                            Result="pass";
                            break;
                        case "AttachRC":
                            //driver.switchTo().window(WinHandleBefore1);          // switch back to the original window
                            driver.findElement(By.id("btnAttached")).click();

                            BeforeWH(driver);
                            Thread.sleep(6000);
                            WebElement ss2 = driver.findElement(By.id("RadAsyncUpload1file0"));
                            ss2.click();
                            Thread.sleep(6000);
                            AttachFuntn(driver, FilePath);
                           Thread.sleep(700);
                            driver.switchTo().window(WinHandleBefore1);
                            Result="pass";
                            break;
                        case "AcceptTC":
                            // Thread.sleep(2000);
                            // NewWindow(driver);
                            ltpRegistration.clickAcceptTC();
                            Result="pass";

                    }break;
                case "SETTEXT":

                    switch (objectName) {

                        case "First Name":
                            ltpRegistration.setFirstNm(value);
                            try {

                                if ((ExpectedConditions.alertIsPresent()) == null) {
                                    final String fieldValue = ltpRegistration.getFirstNm().getAttribute("value");
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

                                final String fieldValue = ltpRegistration.getFirstNm().getAttribute("value");
                                if (fieldValue.isEmpty()) {
                                    try {
                                        if ((ExpectedConditions.alertIsPresent()) == null) {

                                        } else {
                                            Alert alert = driver.switchTo().alert();

                                            Actual = driver.switchTo().alert().getText();
                                            Thread.sleep(300);
                                            alert.accept();
                                            if (Actual.equals(Expected)) {
                                                Result = "pass";
                                            } else {
                                                Result = "Fail";
                                            }
                                            System.out.println(Actual);
                                            //    Thread.sleep(50);

                                        }

                                    } catch (Throwable e) {
                                        Actual = "Alert message not display so,user not get Actual result.";
                                        Result = "Fail";
                                    }


                                } else {
                                    if (fieldValue.equals(value)) {
                                        if (!String.matcher(fieldValue).matches()) {
                                            try {
                                                if ((ExpectedConditions.alertIsPresent()) == null) {
                                                    Actual = "Alert message not display so,user not get Actual result.";
                                                    Result = "Fail";
                                                } else {
                                                    Alert alert = driver.switchTo().alert();
                                                    Actual = driver.switchTo().alert().getText();
                                                    if (Actual.equals(Expected)) {
                                                        Result = "pass";
                                                    } else {
                                                        Result = "Fail";
                                                    }
                                                    System.out.println(Actual);
                                                    //    Thread.sleep(50);
                                                    alert.accept();

                                                }

                                            } catch (Throwable e) {
                                                Actual = "Alert message not display so,user not get Actual result.";
                                                Result = "Fail";
                                            }
                                        } else {
                                            Result = "pass";
                                            System.out.println(fieldValue);
                                            System.out.println(Result);
                                        }
                                    } else {
                                        if (Actual.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                    }
                                }
                            } catch (Throwable e) {

                            }
                            break;
                        case "Middle Name":
                            ltpRegistration.setMiddleNM(value);
                            try {

                                if ((ExpectedConditions.alertIsPresent()) == null) {
                                    final String fieldValue1 = ltpRegistration.getMiddleNM().getAttribute("value");
                                    if (fieldValue1.equals(value)) {
                                        Result="pass";
                                    }else {Result="fail";}

                                    } else {
                                    Alert alert = driver.switchTo().alert();

                                    Actual = driver.switchTo().alert().getText();
                                    Thread.sleep(300);
                                    alert.accept();
                                }

                                final String fieldValue1 = ltpRegistration.getMiddleNM().getAttribute("value");
                                if (fieldValue1.isEmpty()) {
                                    try {
                                        if ((ExpectedConditions.alertIsPresent()) == null) {

                                        } else {
                                            Alert alert = driver.switchTo().alert();
                                            Actual = driver.switchTo().alert().getText();
                                            if (Actual.equals(Expected)) {
                                                Result = "pass";
                                            } else {
                                                Result = "Fail";
                                            }
                                            System.out.println(Actual);
                                            //    Thread.sleep(50);
                                            alert.accept();

                                        }

                                    } catch (Throwable e) {
                                        Actual = "Alert message not display so,user not get Actual result.";
                                        Result = "Fail";
                                    }


                                } else {
                                    if (fieldValue1.equals(value)) {
                                        if (!String.matcher(fieldValue1).matches()) {
                                            try {
                                                if ((ExpectedConditions.alertIsPresent()) == null) {
                                                    Actual = "Alert message not display so,user not get Actual result.";
                                                    Result = "Fail";
                                                } else {
                                                    Alert alert = driver.switchTo().alert();
                                                    Actual = driver.switchTo().alert().getText();
                                                    if (Actual.equals(Expected)) {
                                                        Result = "pass";
                                                    } else {
                                                        Result = "Fail";
                                                    }
                                                    System.out.println(Actual);
                                                    //    Thread.sleep(50);
                                                    alert.accept();

                                                }

                                            } catch (Throwable e) {
                                                Actual = "Alert message not display so,user not get Actual result.";
                                                Result = "Fail";
                                            }
                                        } else {
                                            Result = "pass";
                                            System.out.println(fieldValue1);
                                            System.out.println(Result);
                                        }
                                    } else {

                                        if (Actual.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                    }
                                }
                            } catch (Throwable e) {
                             }
                            break;
                        case "Last Name":
                            ltpRegistration.setLastNM(value);
                            try {

                                if ((ExpectedConditions.alertIsPresent()) == null) {
                                    final String fieldValue2 = ltpRegistration.getLastNM().getAttribute("value");
                                    if (fieldValue2.equals(value)) {
                                        Result="pass";
                                    }
                                    else {
                                        Result="fail";
                                    }

                                } else {
                                    Alert alert = driver.switchTo().alert();

                                    Actual = driver.switchTo().alert().getText();
                                    Thread.sleep(300);
                                    alert.accept();
                                }
                                final String fieldValue2 = ltpRegistration.getLastNM().getAttribute("value");
                                if (fieldValue2.isEmpty()) {
                                    try {
                                        if ((ExpectedConditions.alertIsPresent()) == null) {

                                        } else {
                                            Alert alert = driver.switchTo().alert();
                                            Actual = driver.switchTo().alert().getText();
                                            if (Actual.equals(Expected)) {
                                                Result = "pass";
                                            } else {
                                                Result = "Fail";
                                            }
                                            System.out.println(Actual);
                                            //    Thread.sleep(50);
                                            alert.accept();

                                        }

                                    } catch (Throwable e) {
                                        Actual = "Alert message not display so,user not get Actual result.";
                                        Result = "Fail";
                                    }


                                } else {
                                    if (fieldValue2.equals(value)) {
                                        if (!String.matcher(fieldValue2).matches()) {
                                            try {
                                                if ((ExpectedConditions.alertIsPresent()) == null) {
                                                    Actual = "Alert message not display so,user not get Actual result.";
                                                    Result = "Fail";
                                                } else {
                                                    Alert alert = driver.switchTo().alert();
                                                    Actual = driver.switchTo().alert().getText();
                                                    if (Actual.equals(Expected)) {
                                                        Result = "pass";
                                                    } else {
                                                        Result = "Fail";
                                                    }
                                                    System.out.println(Actual);
                                                    //    Thread.sleep(50);
                                                    alert.accept();

                                                }

                                            } catch (Throwable e) {
                                                Actual = "Alert message not display so,user not get Actual result.";
                                                Result = "Fail";
                                            }
                                        } else {
                                            Result = "pass";
                                            System.out.println(fieldValue2);
                                            System.out.println(Result);
                                        }
                                    } else {

                                        if (Actual.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                    }
                                }
                            } catch (Throwable e) {
                             }
                            break;
                        case "Qualification":
                            ltpRegistration.setQlification(value);
                            Result = "pass";
                            break;
                        case "Total Experience":
                            driver.findElement(By.id("txtExperience")).sendKeys(value);
                            Result = "pass";
                            break;
                        case "Short Profile":
                            driver.findElement(By.id("txtShortProfile")).sendKeys(value);
                            Result = "pass";
                            break;
                        case "Firm Name":
                            ltpRegistration.setFirmName(value);
                            Result = "pass";
                            break;
                        case "Postal Address":
                            ltpRegistration.setPostalAddress(value);
                            Result = "pass";
                            break;
                        case "Pin Code":
                            ltpRegistration.setPinCode(value);

                            final String fieldValue3 = ltpRegistration.getPinCode().getAttribute("value");

                            System.out.println(value);
                                if (fieldValue3.isEmpty()) {
                                    try {
                                        if ((ExpectedConditions.alertIsPresent()) == null) {

                                        } else {
                                            Alert alert = driver.switchTo().alert();
                                            Actual = driver.switchTo().alert().getText();
                                            if (Actual.equals(Expected)) {
                                                Result = "pass";
                                            } else {
                                                Result = "Fail";
                                            }
                                            System.out.println(Actual);
                                            //    Thread.sleep(50);
                                            alert.accept();

                                        }

                                    } catch (Throwable e) {
                                        Actual = "Alert message not display so,user not get Actual result.";
                                        Result = "Fail";
                                    }


                                } else {
                                    if (fieldValue3.equals(value)) {
                                        if (!Num.matcher(fieldValue3).matches()) {
                                            try {
                                                if ((ExpectedConditions.alertIsPresent()) == null) {
                                                    Actual = "Alert message not display so,user not get Actual result.";
                                                    Result = "Fail";
                                                } else {
                                                    Alert alert = driver.switchTo().alert();
                                                    Actual = driver.switchTo().alert().getText();
                                                    if (Actual.equals(Expected)) {
                                                        Result = "pass";
                                                    } else {
                                                        Result = "Fail";
                                                    }
                                                    System.out.println(Actual);
                                                    //    Thread.sleep(50);
                                                    alert.accept();

                                                }

                                            } catch (Throwable e) {
                                                Actual = "Alert message not display so,user not get Actual result.";
                                                Result = "Fail";
                                            }
                                        } else {
                                            Result = "pass";
                                            System.out.println(fieldValue3);
                                            System.out.println(Result);
                                        }
                                    } else {

                                        if (Actual.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                    }
                                }
                            break;
                        case "Mobile No":
                            ltpRegistration.setMoileNm(value);
                            //int result = Integer.parseInt(value);
                            System.out.println(value);
                            //System.out.println(result);
                            final String fieldValue4 = ltpRegistration.getMoileNm().getAttribute("value");
                            System.out.println(value);
                            System.out.println(fieldValue4);
                            if (fieldValue4.isEmpty()) {
                                    try {
                                        if ((ExpectedConditions.alertIsPresent()) == null) {

                                        } else {
                                            Alert alert = driver.switchTo().alert();
                                            Actual = driver.switchTo().alert().getText();
                                            if (Actual.equals(Expected)) {
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
                                    if (fieldValue4.equals(value)) {
                                     //   System.out.println(value);
                                        if (!Num.matcher(fieldValue4).matches()) {
                                            try {
                                                if ((ExpectedConditions.alertIsPresent()) == null) {
                                                    Actual = "Alert message not display so,user not get Actual result.";
                                                    Result = "Fail";
                                                } else {
                                                    Alert alert = driver.switchTo().alert();
                                                    Actual = driver.switchTo().alert().getText();
                                                    if (Actual.equals(Expected)) {
                                                        Result = "pass";
                                                    } else {
                                                        Result = "Fail";
                                                    }
                                              //      System.out.println(Actual);
                                                    //    Thread.sleep(50);
                                                    alert.accept();

                                                }

                                            } catch (Throwable e) {
                                                Actual = "Alert message not display so,user not get Actual result.";
                                                Result = "Fail";
                                            }
                                        } else {

                                            Result = "pass";
                                            //System.out.println(fieldValue4);

                                          //  System.out.println(Result);
                                        }
                                    } else {

                                        if (Actual.equals(Expected)) {
                                            System.out.println(fieldValue4);
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                            System.out.println(Actual);
                                        }
                                    }
                                }
                            break;
                        case "Email":
                            ltpRegistration.setEmail(value);

                            final String fieldValue5 = ltpRegistration.getEmail().getAttribute("value");
                            System.out.println(fieldValue5);
                                if (fieldValue5.isEmpty()) {
                                    try {
                                        if ((ExpectedConditions.alertIsPresent()) == null) {

                                        } else {
                                            Alert alert = driver.switchTo().alert();
                                            Actual = driver.switchTo().alert().getText();
                                            if (Actual.equals(Expected)) {
                                                Result = "pass";
                                            } else {
                                                Result = "Fail";
                                            }
                                            System.out.println(Actual);
                                            //    Thread.sleep(50);
                                            alert.accept();

                                        }

                                    } catch (Throwable e) {
                                        Actual = "Alert message not display so,user not get Actual result.";
                                        Result = "Fail";
                                    }


                                } else {
                                    if (fieldValue5.equals(value)) {
                                        if (!Emailval.matcher(fieldValue5).matches()) {
                                            try {
                                                if ((ExpectedConditions.alertIsPresent()) == null) {
                                                    Actual = "Alert message not display so,user not get Actual result.";
                                                    Result = "Fail";
                                                    System.out.println(Actual);
                                                } else {
                                                    Alert alert = driver.switchTo().alert();
                                                    Actual = driver.switchTo().alert().getText();
                                                    if (Actual.equals(Expected)) {
                                                        Result = "pass";
                                                    } else {
                                                        Result = "Fail";
                                                    }
                                                  //  System.out.println(Actual);
                                                    //    Thread.sleep(50);
                                                    alert.accept();

                                                }

                                            } catch (Throwable e) {
                                                Actual = "Alert message not display so,user not get Actual result.";
                                                Result = "Fail";
                                            }
                                        } else {
                                            Result = "pass";
                                            //System.out.println(fieldValue5);
                                           // System.out.println(Result);
                                        }
                                    } else {


                                    }
                                }

                            break;
                        case "Registration no":
                            ltpRegistration.setRegitrationNo(value);
                            Result = "pass";
                            break;
                        case "Aadhar no":
                            break;
                        case "Login Name":
                            ltpRegistration.setLoginNm(value);

                            try {

                                if ((ExpectedConditions.alertIsPresent()) == null) {
                                    final String fieldValue6 = ltpRegistration.getLoginNm().getAttribute("value");
                                    if (fieldValue6.equals(value)) {
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

                                final String fieldValue6 = ltpRegistration.getLoginNm().getAttribute("value");
                                if (fieldValue6.isEmpty()) {
                                    try {
                                        if ((ExpectedConditions.alertIsPresent()) == null) {

                                        } else {
                                            Alert alert = driver.switchTo().alert();
                                            Actual = driver.switchTo().alert().getText();
                                            if (Actual.equals(Expected)) {
                                                Result = "pass";
                                            } else {
                                                Result = "Fail";
                                            }
                                            System.out.println(Actual);
                                            //    Thread.sleep(50);
                                            alert.accept();

                                        }

                                    } catch (Throwable e) {
                                        Actual = "Alert message not display so,user not get Actual result.";
                                        Result = "Fail";
                                    }


                                } else {
                                    if (fieldValue6.equals(value)) {
                                        if (!Alphnu.matcher(fieldValue6).matches()) {
                                            try {
                                                if ((ExpectedConditions.alertIsPresent()) == null) {
                                                    Actual = "Alert message not display so,user not get Actual result.";
                                                    Result = "Fail";
                                                } else {
                                                    Alert alert = driver.switchTo().alert();
                                                    Actual = driver.switchTo().alert().getText();
                                                    if (Actual.equals(Expected)) {
                                                        Result = "pass";
                                                    } else {
                                                        Result = "Fail";
                                                    }
                                                    System.out.println(Actual);
                                                    //    Thread.sleep(50);
                                                    alert.accept();

                                                }

                                            } catch (Throwable e) {
                                                Actual = "Alert message not display so,user not get Actual result.";
                                                Result = "Fail";
                                            }
                                        } else {
                                            Result = "pass";
                                            System.out.println(fieldValue6);
                                            System.out.println(Result);
                                        }
                                    } else {

                                        if (Actual.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                    }
                                }
                            } catch (Throwable e) {
                            }
                                break;
                                case "Password":
                                    ltpRegistration.setPassword(value);
                                    try {

                                        if ((ExpectedConditions.alertIsPresent()) == null) {
                                            final String fieldValue7 = ltpRegistration.getPassword().getAttribute("value");
                                            if (fieldValue7.equals(value)) {
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

                                        final String fieldValue7 = ltpRegistration.getPassword().getAttribute("value");
                                        if (fieldValue7.isEmpty()) {
                                            try {
                                                if ((ExpectedConditions.alertIsPresent()) == null) {

                                                } else {
                                                    Alert alert = driver.switchTo().alert();
                                                    Actual = driver.switchTo().alert().getText();
                                                    if (Actual.equals(Expected)) {
                                                        Result = "pass";
                                                    } else {
                                                        Result = "Fail";
                                                    }
                                                    System.out.println(Actual);
                                                    //    Thread.sleep(50);
                                                    alert.accept();

                                                }

                                            } catch (Throwable e) {
                                                Actual = "Alert message not display so,user not get Actual result.";
                                                Result = "Fail";
                                            }


                                        } else {
                                            if (fieldValue7.equals(value)) {
                                                if (!Alphnu.matcher(fieldValue7).matches()) {
                                                    try {
                                                        if ((ExpectedConditions.alertIsPresent()) == null) {
                                                            Actual = "Alert message not display so,user not get Actual result.";
                                                            Result = "Fail";
                                                        } else {
                                                            Alert alert = driver.switchTo().alert();
                                                            Actual = driver.switchTo().alert().getText();
                                                            if (Actual.equals(Expected)) {
                                                                Result = "pass";
                                                            } else {
                                                                Result = "Fail";
                                                            }
                                                            System.out.println(Actual);
                                                            //    Thread.sleep(50);
                                                            alert.accept();

                                                        }

                                                    } catch (Throwable e) {
                                                        Actual = "Alert message not display so,user not get Actual result.";
                                                        Result = "Fail";
                                                    }
                                                } else {
                                                    Result = "pass";
                                                    System.out.println(fieldValue7);
                                                    System.out.println(Result);
                                                }
                                            } else {

                                                if (Actual.equals(Expected)) {
                                                    Result = "pass";
                                                } else {
                                                    Result = "Fail";
                                                }
                                            }
                                        }
                                    } catch (Throwable e) {
                                    }
                                    break;
                                case "RePassword":
                                    ltpRegistration.setRePass(value);
                                    try {

                                        if ((ExpectedConditions.alertIsPresent()) == null) {

                                            final String fieldValue8 = ltpRegistration.getRePass().getAttribute("value");
                                            if (fieldValue8.equals(value)) {
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
                                        final String fieldValue8 = ltpRegistration.getRePass().getAttribute("value");
                                        if (fieldValue8.isEmpty()) {
                                            try {
                                                if ((ExpectedConditions.alertIsPresent()) == null) {

                                                } else {
                                                    Alert alert = driver.switchTo().alert();
                                                    Actual = driver.switchTo().alert().getText();
                                                    if (Actual.equals(Expected)) {
                                                        Result = "pass";
                                                    } else {
                                                        Result = "Fail";
                                                    }
                                                    System.out.println(Actual);
                                                    //    Thread.sleep(50);
                                                    alert.accept();

                                                }

                                            } catch (Throwable e) {
                                                Actual = "Alert message not display so,user not get Actual result.";
                                                Result = "Fail";
                                            }


                                        } else {
                                            if (fieldValue8.equals(value)) {
                                                if (!Alphnu.matcher(fieldValue8).matches()) {
                                                    try {
                                                        if ((ExpectedConditions.alertIsPresent()) == null) {
                                                            Actual = "Alert message not display so,user not get Actual result.";
                                                            Result = "Fail";
                                                        } else {
                                                            Alert alert = driver.switchTo().alert();
                                                            Actual = driver.switchTo().alert().getText();
                                                            if (Actual.equals(Expected)) {
                                                                Result = "pass";
                                                            } else {
                                                                Result = "Fail";
                                                            }
                                                            System.out.println(Actual);
                                                            //    Thread.sleep(50);
                                                            alert.accept();

                                                        }

                                                    } catch (Throwable e) {
                                                        Actual = "Alert message not display so,user not get Actual result.";
                                                        Result = "Fail";
                                                    }
                                                } else {
                                                    Result = "pass";
                                                    System.out.println(fieldValue8);
                                                    System.out.println(Result);
                                                }
                                            } else {

                                                if (Actual.equals(Expected)) {
                                                    Result = "pass";
                                                } else {
                                                    Result = "Fail";
                                                }
                                            }
                                        }
                                    } catch (Throwable e) {
                                    }
                            }
                            break;
                        case "SELECT":

                            switch (objectName) {

                                case "Prifix":
                                    ltpRegistration.setPriFix(value);
                                    Result="pass";
                                    break;
                                case "Professional Category":
                                    ltpRegistration.setApplicantNm(value);
                                    Result="pass";
                                    break;
                                case "State":
                                    ltpRegistration.setState(value);
                                    Result="pass";
                                    break;
                                case "City":
                                    ltpRegistration.setCity(value);
                                    Result="pass";
                                    break;
                                case "SelectIdProof":
                                    ltpRegistration.setIdProf(value);
                                    Result="pass";
                                    break;
                                case "Date":
                                    DateFun(driver, "30/6/2017");
                                    Result="pass";



                    }  break;
                default:
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
        }catch (NullPointerException e)
        {}

    }


        @DataProvider(name="hybridData")
    public Object[][] getDataFromDataprovider() throws IOException {
        Object[][] object = null;
        FileInputStream fis = new FileInputStream("Excelsheet/TestCaseDemo.xls");
        HSSFWorkbook wb = new HSSFWorkbook(fis);
        HSSFSheet sh = wb.getSheet("Sheet2");
        //  HSSFRow rows = sh.getRow(1);
//Read keyword sheet
//Find number of rows in Expl.excel file
        int rowCount =sh.getLastRowNum()-sh.getFirstRowNum();
        System.out.println(rowCount);
        object = new Object[rowCount][5];
        for (int i = 1; i < rowCount; i++) {

            HSSFRow row = sh.getRow(i+1);


            for (int j = 0; j < row.getLastCellNum(); j++) {
//                System.out.println(row.getCell(j).toString());
                object[i][j] = row.getCell(j).toString();

            }


        }
        return object;
    }

}
