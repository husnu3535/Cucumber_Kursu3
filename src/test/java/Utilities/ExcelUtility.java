package Utilities;

import io.cucumber.java.Scenario;
import org.apache.poi.hssf.model.WorkbookRecordList;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ExcelUtility {
    //  kendisine verilen path deki excelin, istenilen, sheetindeki
    //  istenilen kolona kadar sütunları okuyup Arraylist formatında geri döndüren fonksiyonu yazınız.
    //  getListData("src/test/java/ApachePOI/resources/ApacheExcel2.xlsx","testCitizen", 2); 0-2

    public static ArrayList<ArrayList<String>>getListData(String path,String sheetName,int colonCount) {
        ArrayList<ArrayList<String>>tablo=new ArrayList<>();
        Workbook workbook=null;

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(fileInputStream);
        }catch (IOException e){
            throw new RuntimeException(e);
        }

        Sheet sayfa = workbook.getSheet(sheetName);


        for (int i = 0; i < sayfa.getPhysicalNumberOfRows(); i++) {
            ArrayList <String> satirData=new ArrayList<>();

            for (int j = 0; j < colonCount ; j++) {
                satirData.add(sayfa.getRow(i).getCell(j).toString());

            }
            tablo.add(satirData);

        }
            return tablo;


    }

    public static void writeExcel(String path, Scenario scenario,String browserName,String time){

        File file=new File(path);
        if (!file.exists()) { //  ! --> olunca YOKSA demektir

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Sayfa1");
            Row newRow = sheet.createRow(0);

            Cell newCell = newRow.createCell(0);
            newCell.setCellValue(scenario.getName());

            newCell = newRow.createCell(1);
            newCell.setCellValue(scenario.getStatus().toString());

            newCell = newRow.createCell(2);
            newCell.setCellValue(browserName);

            newCell = newRow.createCell(3);
            newCell.setCellValue(time);


            try {
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (IOException e){
                throw new RuntimeException(e);
            }

        }
        else {
                FileInputStream inputStream=null;
                Workbook workbook=null;

                try {
                    inputStream=new FileInputStream(path);
                    workbook=WorkbookFactory.create(inputStream);
                }catch (IOException e){
                    throw new RuntimeException(e);
                }

                Sheet sheet=workbook.getSheet("Sayfa1");

                int rowCount=sheet.getPhysicalNumberOfRows();
                Row newRow=sheet.createRow(rowCount);

                Cell newCell=newRow.createCell(0);
                newCell.setCellValue(scenario.getName());

                newCell=newRow.createCell(1);
                newCell.setCellValue(scenario.getStatus().toString());

                newCell=newRow.createCell(2);
                newCell.setCellValue(browserName);

                newCell=newRow.createCell(3);
                newCell.setCellValue(time);

                try {
                    inputStream.close();
                    FileOutputStream outputStream=new FileOutputStream(path);
                    workbook.write(outputStream);
                    workbook.close();
                    outputStream.close();
                }catch (IOException e){
                    throw new RuntimeException(e);
                }

        }
    }

   public static void writeExcelMySQL(ArrayList<String>tableName,ArrayList<String>columnName){
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("ActorTable");

        Row newRow=sheet.createRow(0);

        for (int i=0;i < columnName.size();i++){
            newRow.createCell(i).setCellValue(columnName.get(i));

        }
            newRow=sheet.createRow(1);

        int x=1;
        for (int i=0,j=0;j < tableName.size(); i++,j++ ){
            newRow.createCell(i).setCellValue(tableName.get(j));
          if (newRow.getPhysicalNumberOfCells() == columnName.size()){
              x++;
              newRow=sheet.createRow(x);
              i=-1;
          }
        }

        try {
            FileOutputStream outputStream = new FileOutputStream("src/test/java/_JDBC/_Gun02/Soru4/Soru42.xlsx");
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

        }catch (IOException e){
            throw new RuntimeException(e);
        }
   }




    public static void main(String[] args) {
       ArrayList<ArrayList<String>>tablo=getListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx","testCitizen",4);

       System.out.println(tablo);
    }
}

