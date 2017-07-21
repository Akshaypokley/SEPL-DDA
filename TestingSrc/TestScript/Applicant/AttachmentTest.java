package TestScript.Applicant;

import Pages.Applicant.DraftApplication.AttachDrawing;
import Pages.Applicant.DraftApplication.Documents;
import Pages.LTPRegistration;
import Pages.Login;
import Pages.Menu;
import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.read.biff.BiffException;
import jxl.write.*;
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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static Utilites.AttachFunction.AttachFuntn;
import static Utilites.BeforeWH.BeforeWH;
import static Utilites.DateFunction.DateFun;
import static Utilites.LoginFunction.LogFunction;
import static Utilites.OpenBrowser.GetUrl;
import static Utilites.OpenBrowser.openBrowser;
import static Utilites.Windowhander.NewWindow;
import static jxl.format.Colour.*;
import static jxl.format.Colour.LIGHT_TURQUOISE;

/**
 * Created by akshay.pokley on 7/18/2017.
 */
public class AttachmentTest {static WebDriver driver;
    public Label l4;
    public static WritableCellFormat cellFormat;
    public static WritableCellFormat cellFormat1;
    public static WritableCellFormat cellFormat3;
    public static WritableCellFormat cellFormat4;
    public WritableCellFormat cellFormat2; public static WritableCellFormat cellFormat6;
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
    static AttachDrawing attachDrawing;
    static Documents documents;
static int i=0;
    @BeforeTest
    public  void ExcelWdata() throws IOException, BiffException, WriteException {

        sourceDocument = Workbook.getWorkbook(new File("Excelsheet/TestCaseDemo.xls"));
        writableTempSource = Workbook.createWorkbook(new File("Excelsheet/temp.xls"), sourceDocument);
        copyDocument = Workbook.createWorkbook(new File("Excelsheet/TestReport/AttchReport.xls"));
        sourceSheet = writableTempSource.getSheet(6);
        targetSheet = copyDocument.createSheet("sheet 1", 5);

        WritableFont cellFont = new WritableFont(WritableFont.COURIER, 11);
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


        cellFormat6 = new WritableCellFormat(cellFont2);
        cellFormat6.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
        cellFormat6.setWrap(true);
        cellFormat6.setBackground(LIGHT_TURQUOISE);
        //  sheet.addCell(new Label(col, 1, "CCCCC", cellFormat));

        for (int row = 0; row < sourceSheet.getRows(); row++) {
            for (int col = 0; col < sourceSheet.getColumns(); col++) {
                WritableCell readCell = sourceSheet.getWritableCell(col, row);
                WritableCell newCell = readCell.copyTo(col, row);
                CellFormat readFormat = readCell.getCellFormat();

                WritableCellFormat newFormat = new WritableCellFormat(readFormat);
                newCell.setCellFormat(newFormat);
                targetSheet.addCell(newCell);


                Label l2=new Label(5,1,"Actual",cellFormat);

                Label l3=new Label(6,1,"Status",cellFormat);
                //Label l4=new Label(4,row,"",cellFormat);
                int widthInChars = 36;
                int widthInChars2 = 18;
                int widthInChars1 = 16;
                targetSheet.setColumnView(2, widthInChars1);
                targetSheet.setColumnView(3, widthInChars1);
                targetSheet.setColumnView(1, widthInChars1);
                targetSheet.setColumnView(4, widthInChars);
                targetSheet.setColumnView(5, widthInChars);

/*-----------------------------------------------------------------------------------------------------------------------*/
                targetSheet.setColumnView(0, widthInChars2);
                targetSheet.setColumnView(2, widthInChars2);

                targetSheet.setColumnView(3, widthInChars2);
                targetSheet.mergeCells(0, 0, 6, 0);
                Label lable = new Label (0, 0,
                        "Drawing Attach screen test  report",cellFormat5);
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
                    String FilePath = "E:\\Akshay85\\DDAProject\\DDA_addition CASE.dwg";
                    String FilePath2 = "E:\\Akshay85\\select.pdf";
                    String WinHandleBefore1 = driver.getWindowHandle();
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
                        case "Submit":
                            break;

                        case "Attach Drawing":
                            attachDrawing=new AttachDrawing(driver);
                            attachDrawing.ClickDrawingALink();

                            driver.switchTo().frame("ifrmDrawings");
                    WebElement data= driver.findElement(By.xpath(".//*[@id='AttachFile']/tbody/tr[3]/td/div/table/tbody/tr/td/div"));
                 String DataString =data.getText();
                 if(DataString.equals("No data found")) {
                     attachDrawing.ClickSelectFile();
                     BeforeWH(driver);
                     Thread.sleep(6000);
                     WebElement ss2 = driver.findElement(By.id("RadAsyncUpload1file0"));
                     ss2.click();
                     Thread.sleep(6000);
                     AttachFuntn(driver, FilePath);
                     Thread.sleep(700);
                     driver.switchTo().window(WinHandleBefore1);
                     try {
                         driver.findElement(By.xpath("//html//body//form//div[1]/table/tbody/tr[2]/td[2]/div/div/div[2]/a/span/span")).click();

                     }catch (Throwable e)
                     {}

                     Result = "pass";
                 }else{
                     attachDrawing.ClickSelectFile();

                     WebElement Webbalert = driver.findElement(By.xpath("//html//body//form//div[1]/table/tbody/tr[2]/td[2]/div/div/div[1]"));
                     String AlertString =Webbalert.getText();
                     if(AlertString.equals(Expected)) {
                         driver.findElement(By.xpath("//html//body//form//div[1]/table/tbody/tr[2]/td[2]/div/div/div[2]/a/span/span")).click();
                         Result = "pass";
                     }  else {
                         Result = "fail";
                         Actual = AlertString;
                         driver.findElement(By.xpath("//html//body//form//div[1]/table/tbody/tr[2]/td[2]/div/div/div[2]/a/span/span")).click();
                     }

                 }
                            break;
                        case "Document category":
                            documents=new Documents(driver);
                            documents.ClickDocumentText();
                            driver.switchTo().frame("ifrmDocuments");

                            try {
                                List<WebElement> cells = driver.findElements(By.xpath(".//*[@id='RadTabStrip1']/div//ul/li/a/span/span"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();
                                    System.out.println(fiels);

                                    if (fiels.equals(value))
                                        cell.click();
                                    Result="pass";
                                }
                            }catch (Throwable e)
                            {}
                            break;


                        case "Document Name":
                            try {
                                List<WebElement> cells = driver.findElements(By.xpath("//html//body//form/div[4]/div/div[2]//div[4]//div/table/tbody/tr[2]/td[2]"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();
                                    System.out.println(fiels);
                                    ++i;
                                    if (fiels.equals(value))


                                        driver.findElement(By.xpath(".//div["+i+"]/div/table/tbody/tr[2]/td[3]/a")).click();
                                    driver.switchTo().window(WinHandleBefore1);

                                    driver.findElement(By.id("btnAttached")).click();

                                    BeforeWH(driver);
                                    Thread.sleep(6000);
                                    WebElement ss2 = driver.findElement(By.id("RadAsyncUpload1file0"));
                                    ss2.click();
                                    Thread.sleep(6000);
                                    AttachFuntn(driver, FilePath2);
                                    Thread.sleep(700);
                                    driver.switchTo().window(WinHandleBefore1);
                                    Result="pass";
                                }
                            }catch (Throwable e)
                            {}
                            break;

                        case "AcceptTC":
                            // Thread.sleep(2000);
                            // NewWindow(driver);

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
        HSSFSheet sh = wb.getSheet("Attachment");
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
