package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _08_WriteInTheExcel {
    public static void main(String[] args) throws IOException {
        // Var olan bir EXCEL yazma işlemi

        String path="src/test/java/ApachePOI/resource/WriteInTheExcelFile.xlsx";
        FileInputStream inputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(inputStream);
        Sheet sheet=workbook.getSheet("Sheet1");

        // HAFIZADA  oluşturma ve yazma işlemleri yapılıyor
        Row yeniSatir=sheet.createRow(0);// satır oluşturuldu 0.yerde
        Cell yeniHücre=yeniSatir.createCell(0); // yeni satırda ilk hücre oluşturuldu
        yeniHücre.setCellValue("Merhaba Java ve ApachePOI"); // Bilgi yazıldı

        for (int i = 1; i < 10; i++) {
            yeniSatir.createCell(i).setCellValue(i);
        }
        // Sıra kaydetmeye geldi,bütün bilgiler hafızada buraya kadar,her şey WORKBOOK da
        inputStream.close(); // okuma modunu kapattım, çünkü yazma modunda açmam gerekiyor

        // Yazma işlemini YAZMA modunda açıp öyle yapacağız.
        FileOutputStream outputStream=new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        System.out.println("İşlem Tamamlandi");

    }
}
