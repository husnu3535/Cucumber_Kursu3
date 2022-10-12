package _JDBC._Gun02.Soru5;

import _JDBC.JDBCParent;
import org.apache.poi.hssf.model.WorkbookRecordList;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Soru5 extends JDBCParent {
    @Test
    public void Soru5() throws SQLException {
        Workbook workbook;
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/java/_JDBC/_Gun02/Soru5/Kitap1.xlsx");
            workbook = WorkbookFactory.create(fileInputStream);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        Sheet sheet=workbook.getSheetAt(0);
        ArrayList<String> data=new ArrayList<>();

        String veri="";
        int columnCount=0;
        for (int i = 1; i < sheet.getPhysicalNumberOfRows();i++){
            Row row=sheet.getRow(i);

            for (int j = 0; j < row.getPhysicalNumberOfCells() ; j++){
                Cell cell=row.getCell(j);
                veri+=cell.toString()+" ";
            }
            data.add(veri);
            veri="";
            columnCount=row.getPhysicalNumberOfCells();
        }

        String [] split=new String[columnCount];
        for (int i = 0; i < data.size(); i++) {
            split=data.get(i).split(" ");
            String query=("INSERT INTO genelVeriTablosu (no,Ad,Soyad,Telefon) VALUES(?,?,?,?)");
            PreparedStatement ps= connection.prepareStatement(query);

            for (int j = 1, x=0; x < split.length; j++ ,x++) {
                ps.setString(j,split[x]);

            }
            ps.addBatch();
            ps.executeBatch();
        }


        // MySQL'ye Diğer bir ekleme işlemi aşağıdaki gibi yapılabilir;

        // ps.setString(1,split[0]);
        // ps.setString(2,split[1]);
        // ps.setString(3,split[2]);
        // ps.setString(4,split[3]);

        // ps.addBatch();
        // ps.executeBatch();

    }
}
