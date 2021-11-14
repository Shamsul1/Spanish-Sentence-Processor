package Utils;

import Model.WordData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtils {

    public static final String excel_path = "C:\\Users\\Samsul Karim\\Desktop\\Conjugation Sentence Bank.xlsx";

    public static void main(String[] args) throws IOException {
       getInputWordsFromExcel(excel_path);

    }

    public static List<WordData> getSentencesFromExcel(String excelFilePath) throws IOException {

        List<WordData> wordDatas = new ArrayList<>();

        File file = new File(excelFilePath);   //creating a new file instance
        FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file
        //creating Workbook instance that refers to .xlsx file
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object

        Iterator<Row> itr = sheet.iterator();    //iterating over excel file
        while (itr.hasNext()) {
            Row row = itr.next();
            wordDatas.add(addExcelData(row));
        }

        return wordDatas;

    }
    public static WordData addExcelData(Row row){
        WordData wordData = new WordData();
        wordData.setInfinitive(row.getCell(0).getStringCellValue());
        wordData.setConjugation(row.getCell(1).getStringCellValue());
        wordData.setPerson(row.getCell(2).getStringCellValue());
        wordData.setEnglishSentence(row.getCell(3).getStringCellValue());
        wordData.setSpanishSentence(row.getCell(4).getStringCellValue());

        return wordData;
    }

    public static List<WordData> getInputWordsFromExcel(String excelFilePath) throws IOException {

        List<WordData> wordDataList = new ArrayList<>();
        File file = new File(excelFilePath);   //creating a new file instance
        FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file
        //creating Workbook instance that refers to .xlsx file
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(1);     //creating a Sheet object to retrieve object

        Iterator<Row> itr = sheet.iterator();    //iterating over excel file
        while (itr.hasNext()) {
            Row row = itr.next();

            WordData wordData = new WordData();
            wordData.setConjugation(row.getCell(0).getStringCellValue());
            wordDataList.add(wordData);
        }
        return wordDataList;
    }
    public static void getWord(Row row){

        System.out.println( row.getCell(0).getStringCellValue());

    }
}
