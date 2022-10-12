package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _04_ApachePOIGetAllData {
    public static void main(String[] args) throws IOException {
        String path="src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";

        FileInputStream inputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(inputStream);
        Sheet sheet=workbook.getSheet("Sheet1");

        // Çalısma sayfasındaki toplam satır sayısını veriyor
        int satirSayisi=sheet.getPhysicalNumberOfRows();

        for (int i = 0; i < satirSayisi; i++) {

            Row satir = sheet.getRow(i);
            int hucreSayisi = satir.getPhysicalNumberOfCells();

            for (int j = 0; j < hucreSayisi; j++) {

                Cell hucre=satir.getCell(j);
                System.out.print(hucre+" ");

            }
            System.out.println();
        }
    }
}
