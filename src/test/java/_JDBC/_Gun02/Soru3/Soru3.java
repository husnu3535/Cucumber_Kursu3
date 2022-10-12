package _JDBC._Gun02.Soru3;

import _JDBC.JDBCParent;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Soru3 extends JDBCParent {
    @Test
    @Parameters("sorgu")
    public void soru3(String sorgu) throws SQLException {
        ResultSet rs=statement.executeQuery(sorgu);
        ResultSetMetaData rsmd=rs.getMetaData();

        for (int i = 1; i <= rsmd.getColumnCount() ; i++) {
            System.out.printf("%-20s",rsmd.getColumnName(i));

        }
        System.out.println();
        while (rs.next()){
            for (int i=1 ; i<= rsmd.getColumnCount();i++){
                System.out.printf("%-20s",rs.getString(i));
            }
            System.out.println();
        }
    }
}
