package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class _07_Soru {
    /*
        Bir önceki soruda kulanıcıdan bu sefer sütun numarası isteyiniz
        ve o sütundaki bütün bilgileri yazdırınız
     */
/*
    public static void main(String[] args) {
        System.out.print("İstenen Sutun = ");
        Scanner oku = new Scanner(System.in);
        int sutun = oku.nextInt();

        String donenSonuc = bul(sutun);
        System.out.print("Dönen Sonuc = " + donenSonuc);

    }
*/
    @Test
    public void bul() {

        String path = "src/test/java/ApachePOI/resource/LoginData.xlsx";

        Workbook workbook = null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Sheet sheet = workbook.getSheet("Login"); // veya getSheetAt(0) verilebilir


        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
                Row satir= sheet.getRow(i);
                Cell sutunVerileri=satir.getCell(i);
            for (int j = 0; j < satir.getPhysicalNumberOfCells(); j++) {
                System.out.println(sutunVerileri);
            }

        }
    }
}
