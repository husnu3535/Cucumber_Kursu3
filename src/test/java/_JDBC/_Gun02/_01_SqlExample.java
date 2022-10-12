package _JDBC._Gun02;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _01_SqlExample extends JDBCParent {
        // last, first, getRow, getInt, getDouble //
    @Test
    public void test1() throws SQLException {
        ResultSet rs=statement.executeQuery("select city_id,city,country_id from city;");

        rs.absolute(5); // Sonuncu row a gider.

        String id=rs.getString(1); // city_id
        System.out.println("id = " +id);

        int idInt=rs.getInt(1); // city_id
        System.out.println("idInt = " +idInt);

        String name=rs.getString(2); // city
        System.out.println("name = "+name);


       // int nameInt=rs.getInt(2);  // --> Bu hatalıdır.
       // System.out.println("nameInt = " + nameInt);
        // tipi uygun olan dönüşümle , mesala hepsini String olarak alabilirsin.
        // ancak tipi uygun olmayan mesala isimleri , int olarak zaten alınmaz

        int kacinciSatir=rs.getRow();
        System.out.println("SatırSayisi= "+kacinciSatir);
        // dolayısıyla bir sorgunun sonucunda kaç satır geldiğini
        // rs.last() dedikten sonra rs.getRow() ile alabilirim.

    }
}
