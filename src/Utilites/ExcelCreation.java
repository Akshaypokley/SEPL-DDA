package Utilites;

import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.read.biff.BiffException;
import jxl.write.*;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import static jxl.format.Colour.*;

/**
 * Created by akshay.pokley on 6/5/2017.
 */
public class ExcelCreation {
   WebDriver driver;
    public Label l4;
    public static WritableCellFormat cellFormat;
    public static WritableCellFormat cellFormat1;
    public static WritableCellFormat cellFormat2;
    public static String TestCase;
    public  static WritableWorkbook writableTempSource;
    public static WritableWorkbook copyDocument;
    public static WritableSheet sourceSheet;
    public static WritableSheet targetSheet;
    public static Workbook sourceDocument;
    int LastRow;
    public static void EC(WebDriver driver, String SourcePath, String newEXCELnAME, int cA, int CAP, int RA, int RAP) throws IOException, BiffException, WriteException {

        sourceDocument = Workbook.getWorkbook(new File(SourcePath));
        writableTempSource = Workbook.createWorkbook(new File("Excelsheet/temp.xls"), sourceDocument);
        copyDocument = Workbook.createWorkbook(new File(newEXCELnAME));
        sourceSheet = writableTempSource.getSheet(0);
        targetSheet = copyDocument.createSheet("sheet 1", 0);

        WritableFont cellFont = new WritableFont(WritableFont.COURIER, 10);
        ;
        WritableFont cellFont2 = new WritableFont(WritableFont.COURIER, 10);
        cellFont2.setColour(GREEN);
        cellFormat1 = new WritableCellFormat(cellFont2);
        cellFormat1.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
        cellFormat1.setWrap(true);

        cellFormat = new WritableCellFormat(cellFont);
        cellFormat.setBackground(YELLOW);
        cellFormat.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
        cellFormat.setWrap(true);
        cellFormat2 = new WritableCellFormat(cellFont);
        cellFormat2.setBackground(RED);
        //cellFormat.setAlignment(jxl.format.Alignment.getAlignment(20));


        //  sheet.addCell(new Label(col, 1, "CCCCC", cellFormat));

        for (int row = 0; row < sourceSheet.getRows(); row++) {
            for (int col = 0; col < sourceSheet.getColumns(); col++) {
                WritableCell readCell = sourceSheet.getWritableCell(col, row);
                WritableCell newCell = readCell.copyTo(col, row);
                CellFormat readFormat = readCell.getCellFormat();

                WritableCellFormat newFormat = new WritableCellFormat(readFormat);
                newCell.setCellFormat(newFormat);
                targetSheet.addCell(newCell);


                Label l2=new Label(cA,RA,"Actual Message",cellFormat);

                Label l3=new Label(CAP,RAP,"Result",cellFormat);
                //Label l4=new Label(4,row,"",cellFormat);
                int widthInChars = 26;
                targetSheet.setColumnView(4, widthInChars);
/*-----------------------------------------------------------------------------------------------------------------------*/


                targetSheet.addCell(l2);
                targetSheet.addCell(l3);
                //targetSheet.addCell(l4);

            }
        }
    } public void ClosedSheet(WebDriver driver) throws IOException, WriteException

    {

        copyDocument.write();
        copyDocument.close();
        writableTempSource.close();
        sourceDocument.close();
    }



}
