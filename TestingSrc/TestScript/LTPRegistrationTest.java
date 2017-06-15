package TestScript;

import Pages.LTPRegistration;
import Pages.Login;
import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.read.biff.BiffException;
import jxl.write.*;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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
    private static int j = 2;
    public static  String Result;
    public static  String k;
    public static String ResultPass1="Username";
    public static String ResultFail1="Password";
    public static String Actual;
    public static String Actual2;
    static int LastRow;
    static int SetBord;
    static int RowIncr;



    @BeforeTest
    public  void ExcelWdata() throws IOException, BiffException, WriteException {

        sourceDocument = Workbook.getWorkbook(new File("Excelsheet/TestCaseDemo.xls"));
        writableTempSource = Workbook.createWorkbook(new File("Excelsheet/temp.xls"), sourceDocument);
        copyDocument = Workbook.createWorkbook(new File("Excelsheet/RegisReport.xls"));
        sourceSheet = writableTempSource.getSheet(3);
        targetSheet = copyDocument.createSheet("sheet 1", 2);

        WritableFont cellFont = new WritableFont(WritableFont.TIMES, 11);
        cellFont.setBoldStyle(WritableFont.BOLD);
/************************************************************************************************/
        WritableFont cellFont2 = new WritableFont(WritableFont.COURIER, 10);
        cellFont2.setColour(BLACK);
        cellFont2.setBoldStyle(WritableFont.BOLD);
        cellFormat1 = new WritableCellFormat(cellFont2);
        cellFormat1.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
        cellFormat1.setWrap(true);
/*******************************************************************************************************/
/************************************************************************************************/
        WritableFont cellFont3 = new WritableFont(WritableFont.COURIER, 10);
        cellFont3.setColour(RED);
        cellFont3.setBoldStyle(WritableFont.BOLD);
        cellFormat3 = new WritableCellFormat(cellFont3);
        cellFormat3.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
        cellFormat3.setWrap(true);

        WritableFont cellFont4 = new WritableFont(WritableFont.COURIER, 10);
        cellFont4.setColour(GREEN);
        cellFont4.setBoldStyle(WritableFont.BOLD);
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
                        "Applicant window test  report",cellFormat5);
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

        if (testcaseName != null && testcaseName.length() != 0) {
            driver = openBrowser("chrome");
            GetUrl("url");

            Login login = new Login(driver);
            login.setRegistrationLink();
      Thread.sleep(200);
            NewWindow(driver);

            Label l7 = new Label(4, SetBord, "", cellFormat1);
            targetSheet.addCell(l7);
            Label l8 = new Label(5, SetBord, "", cellFormat1);
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
                            break;
                        case "AcceptTC":
                            // Thread.sleep(2000);
                            // NewWindow(driver);
                            ltpRegistration.clickAcceptTC();
                            break;
                    }
                case "SETTEXT":

                    switch (objectName) {

                        case "First Name":
                            ltpRegistration.setFirstNm(value);
                            break;
                        case "Middle Name":
                            ltpRegistration.setMiddleNM(value);
                            break;
                        case "Last Name":
                            ltpRegistration.setLastNM(value);
                            break;
                        case "Qualification":
                            ltpRegistration.setQlification(value);
                            break;
                        case " Total Experience":
                            break;
                        case "Firm Name":
                            ltpRegistration.setFirmName(value);
                            break;
                        case "Postal Address":
                            ltpRegistration.setPostalAddress(value);
                            break;
                        case "Pin Code":
                            ltpRegistration.setPinCode(value);
                            break;
                        case "Mobile No":

                            ltpRegistration.setMoileNm(value);
                            break;
                        case "Email":
                            ltpRegistration.setEmail(value);
                            break;
                        case "Registration no":
                            ltpRegistration.setRegitrationNo(value);
                            break;
                        case "Aadhar no":
                            break;
                        case "Login Name":
                            ltpRegistration.setLoginNm(value);
                            break;
                        case "Password":
                            ltpRegistration.setPassword(value);
                            break;
                        case "RePassword":
                            ltpRegistration.setRePass(value);
                            break;
                    }

                        case "SELECT":

                            switch (objectName) {

                                case "Prifix":
                                    ltpRegistration.setPriFix(value);
                                    break;
                                case "Professional Category":
                                    ltpRegistration.setApplicantNm(value);
                                    break;
                                case "State":
                                    ltpRegistration.setState(value);
                                    break;
                                case "City":
                                    ltpRegistration.setCity(value);
                                    break;
                                case "SelectIdProof":
                                    ltpRegistration.setIdProf(value);
                                    break;
                                case "Date":
                                    DateFun(driver, value);
                                    break;


                    }
                default:
                    break;
            }


            if (testcaseName.isEmpty()) {
                LastRow = n++;
                if (Result.equals("pass")) {
                    Label l5 = new Label(4, LastRow, "Same As Exptected", cellFormat1);
                    targetSheet.addCell(l5);
                    Label l6 = new Label(5, LastRow, "PASS", cellFormat1);
                    targetSheet.addCell(l6);
                } else {
                    Label l5 = new Label(4, LastRow, "Not Same As Exptected-->" + Actual, cellFormat1);
                    targetSheet.addCell(l5);
                    Label l6 = new Label(5, LastRow, "FAIL", cellFormat1);
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
                System.out.println(row.getCell(j).toString());
                object[i][j] = row.getCell(j).toString();

            }


        }
        return object;
    }

}
