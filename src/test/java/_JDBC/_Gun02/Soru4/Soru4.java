package _JDBC._Gun02.Soru4;

import Utilities.ExcelUtility;
import _JDBC.JDBCParent;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class Soru4  extends JDBCParent {

    @Test
    @Parameters("query")
    public void soru4(String query) throws SQLException {
        ResultSet rs = statement.executeQuery(query);
        ResultSetMetaData rsmd = rs.getMetaData();

        ArrayList<String>table=new ArrayList<>();
        ArrayList<String>column=new ArrayList<>();


        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            System.out.printf("%-20s",rsmd.getColumnName(i));
            column.add(rsmd.getColumnName(i));
        }
        System.out.println();

        while (rs.next()){
            for (int i = 1; i <= rsmd.getColumnCount(); i++ ) {
                System.out.printf("%-20s",rs.getString(i));
                table.add(rs.getString(i));
            }
            System.out.println();
        }

        ExcelUtility.writeExcelMySQL(table,column); // -> MySQL deki verileri Yeni Excel'e ekleme


    }
}
