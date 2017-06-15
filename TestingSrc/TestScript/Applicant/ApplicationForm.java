package TestScript.Applicant;

import Pages.Applicant.NewApplication;
import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.read.biff.BiffException;
import jxl.write.*;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static Utilites.LoginFunction.LogFunction;
import static Utilites.OpenBrowser.GetUrl;
import static Utilites.OpenBrowser.openBrowser;
import static jxl.format.Colour.*;

/**
 * Created by akshay.pokley on 6/13/2017.
 */
public class ApplicationForm {

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
    @BeforeTest
    public  void ExcelWdata() throws IOException, BiffException, WriteException {

        sourceDocument = Workbook.getWorkbook(new File("Excelsheet/TestCaseDemo.xls"));
        writableTempSource = Workbook.createWorkbook(new File("Excelsheet/temp.xls"), sourceDocument);
        copyDocument = Workbook.createWorkbook(new File("Excelsheet/ProposalReport.xls"));
        sourceSheet = writableTempSource.getSheet(2);
        targetSheet = copyDocument.createSheet("sheet 1", 0);

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
    public static void ProposalData(String testcaseName,String keyword,String objectName,String value,String Expeted) throws Exception {

        if (testcaseName != null && testcaseName.length() != 0) {
            driver = openBrowser("chrome");
            GetUrl("url");
            LogFunction(driver);
            NewApplication newApplication = new NewApplication(driver);

            driver.switchTo().frame("ifrmListing");
            Thread.sleep(1000);//switch to iframe
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            driver.switchTo().frame("IframeAddProposal");
            Thread.sleep(50);//switch to iframe
            SetBord = j++;
            Label l7 = new Label(4, SetBord, "", cellFormat1);
            targetSheet.addCell(l7);
            Label l8 = new Label(5, SetBord, "", cellFormat1);
            targetSheet.addCell(l8);
        } else {
            SetBord = j++;
        }
        NewApplication newApplication=new NewApplication(driver);
        try {
            switch (keyword.toUpperCase()) {

                case "CLICK":

                    switch (objectName) {

                        case "Save&Continue":
                            newApplication.setSave();
                            break;
                        case "DUAC Yes":
                            newApplication.ClickDUACNO();
                            break;

                        case "DUAC No":
                            newApplication.ClickDUACNO();
                            break;
                    }

                case "SETTEXT":

                    switch (objectName) {

                        case "Building No":
                            newApplication.setBuildingNo(value);
                            break;
                        case "Plot No":
                            newApplication.setPlotNo(value);
                            break;
                        case "Pin Code":
                            newApplication.setPincode(value);
                            break;
                        case "Block No":
                            newApplication.setBlockNo(value);
                            break;
                        case "House No":
                            newApplication.setHouseNo(value);
                            break;
                        case "Scheme No":
                            newApplication.setSchmeNo(value);
                            break;
                        case "Pocket No":
                            newApplication.setPockectNo(value);
                            break;
                        case "Sector No":
                            newApplication.setSecotorNo(value);
                            break;
                        case "ward ":
                            newApplication.setWard(value);
                            break;
                        case "Road/Street":
                            newApplication.setRoad_Street(value);
                            break;
                        case "Situated at":
                            newApplication.setSituated(value);
                            break;
                    }

                case "SELECT":

                    switch (objectName) {

                        case "Case Type":
                            newApplication.setCaseType(value);
                            break;
                        case "Case Location":
                            newApplication.setLocation(value);
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
        {

        }
    }

    @DataProvider(name="hybridData")
    public Object[][] getDataFromDataprovider() throws IOException {
        Object[][] object = null;
        FileInputStream fis = new FileInputStream("Excelsheet/TestCaseDemo.xls");
        HSSFWorkbook wb = new HSSFWorkbook(fis);
        HSSFSheet sh = wb.getSheet("Add Applicant");
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