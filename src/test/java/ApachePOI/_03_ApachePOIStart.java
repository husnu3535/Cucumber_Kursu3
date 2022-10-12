package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _03_ApachePOIStart {
    public static void main(String[] args) throws IOException {
        // Dosyanın yolu alındı.
        String path="src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";

        // Java Dosya okuma işlemcisine dosyanın yolunu veriyoruz:
        // Böylece program ile dosya arasında bağlantı

        FileInputStream dosyaOkumaBaglantisi=new FileInputStream(path);
        // Dosya okuma işlemcisi üzerinden Çalısma Kitabinı alıyorum
        // Hafızada WorkBook u alıp oluşturdu

        Workbook calismaKitabi= WorkbookFactory.create(dosyaOkumaBaglantisi);

        // İstediğim isimdeki çalışma sayfasını alıyorum
        Sheet calismaSayfasi=calismaKitabi.getSheet("sheet1");
        // Sheet calısmaSayfasi=calısmaKitabı.getSheetAt(0);

        // İstenen SAtırı alıyorum
        Row satir=calismaSayfasi.getRow(0);

        // İstenen Satırdaki istenen hücre alınıyor
        Cell hucre=satir.getCell(0);

        System.out.println("Hucre = " + hucre);











    }
}
