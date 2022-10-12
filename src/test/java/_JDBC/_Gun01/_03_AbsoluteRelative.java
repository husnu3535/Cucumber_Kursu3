package _JDBC._Gun01;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_AbsoluteRelative extends JDBCParent {
    @Test
    private void test1() throws SQLException {
        // next(): bir sonraki row
        // previous() : bir önceki row
        // absolute(4) : baştan itibaren 4.ROW a gider, direkt verine ROW a gider
        // relative(4) : bulunduğu noktadan 4 sonraki ROW a gider.

        ResultSet rs= statement.executeQuery("select * from film");

        rs.absolute(10) ; // 10.satıra git
        String title=rs.getString("title");
        System.out.println("title = " + title);

        rs.absolute(15) ; // 15.satıra git
        title=rs.getString("title");
        System.out.println("title = " + title);

        rs.absolute(-15) ; // (-)sondan 15.satıra git   // WONKA
        title=rs.getString("title");
        System.out.println("title = " + title);

        rs.relative(5) ; // en son bulunduğun yerden 5 satır ileri
        title=rs.getString("title");
        System.out.println("title = " + title);

        rs.relative(-5) ; // en son bulunduğun yerden 5 satır geri
        title=rs.getString("title");
        System.out.println("title = " + title);

    }
    @Test
    private void test2() throws SQLException {
        ResultSet rs=statement.executeQuery("select * from actor");

        rs.absolute(6);
        String First_name=rs.getString(2);
        System.out.println(First_name);

        rs.absolute(7);
        First_name=rs.getString(2);
        System.out.println(First_name);

        rs.absolute(1);
        First_name=rs.getString(2);
        System.out.println(First_name);

        rs.relative(5);
        First_name=rs.getString(2);
        System.out.println(First_name);

        rs.relative(7);
        First_name=rs.getString(2);
        System.out.println(First_name);

        rs.relative(1);
        First_name=rs.getString(2);
        System.out.println(First_name);



    }
}
