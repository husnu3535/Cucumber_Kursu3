package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class _10_Tasks {
            /*  Soru 1:
            *   Çarpım tablosunu excele yazdırınız.
            *   1 x 1 = 1 şeklinde işaretleri de yazdırınız.
            *   sıfırdan excel oluşturarak.
            *   her bir onluktan sonra 1 satır boşluk bırakarak alt alata
            */
    @Test
    public void CarpimTablosu(){
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("Sayfa1");

        int rowCount = 0;
        for (int i = 1; i <= 10; i++) {

            for (int j = 1; j <= 10; j++) {

                Row row = sheet.createRow(rowCount++);
                Cell cell1 = row.createCell(0);
                cell1.setCellValue(i);

                Cell cell2 = row.createCell(1);
                cell2.setCellValue(" x ");

                Cell cell3 = row.createCell(2);
                cell3.setCellValue(j);

                Cell cell4 = row.createCell(3);
                cell4.setCellValue(" = ");

                Cell cell5 = row.createCell(4);
                cell5.setCellValue((i) * (j));

            }
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/test/java/ApachePOI/resource/CarpımTablosu.xlsx");
            workbook.write(fileOutputStream);
            workbook.close();
            fileOutputStream.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
