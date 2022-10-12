package _JDBC._Gun01;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _04_Soru  extends JDBCParent {
        // city tablosundaki tüm kayıtları next ile yazdırınız
        // city tablosundaki tüm kayıtları absolute ile yazdırınız
        // city tablosundaki tüm kayıtları relative ile yazdırınız.
    @Test
    public void test1() throws SQLException {
        ResultSet rs=statement.executeQuery("select * from city");

        while (rs.next()){
            System.out.print(rs.getString(1)+" ");
            System.out.print(rs.getString(2)+" ");
            System.out.println(rs.getString(3)+ " ");
        }
        System.out.println();

    }

    @Test
    public void test2() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from city");

        int row=1;
        while (rs.absolute(row)) {
            System.out.println(rs.getString(2));
            row++;
        }
        System.out.println(row);
    }

    @Test
    public void test3() throws SQLException {
        ResultSet rs=statement.executeQuery("select * from city");

        int row=0;
        while (rs.relative(1)){
            System.out.println("Sehirler " +rs.getString(2));
            row++;
        }
        System.out.println(row);
    }

}
