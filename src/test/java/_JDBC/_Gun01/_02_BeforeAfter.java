package _JDBC._Gun01;

import com.mysql.cj.protocol.Resultset;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;

public class _02_BeforeAfter {
    private static Connection connection;
    private static Statement statement;


    @BeforeTest
    public void DBConnectionOpen(){
        String url="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila"; // hostname,port/db adını (user db)
        String username="root"; // username
        String password="'\"-LhCB'.%k[4S]z"; // password

        try {
            connection= DriverManager.getConnection(url,username,password);
            statement=connection.createStatement();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }



    }
    @AfterTest
    public void DBConnectionClose(){
        try {
            connection.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test1() throws SQLException {
        ResultSet rs=statement.executeQuery("select * from language");

        rs.next();
        String DilAdi = rs.getString("name");
        System.out.println("name = "+DilAdi);

        rs.next();// sonraki satır
        DilAdi = rs.getString("name");
        System.out.println("name = "+DilAdi);

        rs.next();// sonraki satır
        DilAdi = rs.getString("name");
        System.out.println("name = "+DilAdi);


    }
    @Test
    public void test2() throws SQLException {
        ResultSet rs=statement.executeQuery("select * from language");

        rs.next();
        String DilAdi=rs.getString(2);
        System.out.println("name = "+DilAdi);

        rs.next();// sonraki satır
        DilAdi=rs.getString(2);
        System.out.println("name = "+DilAdi);

        rs.next();// sonraki satır
        DilAdi=rs.getString(2);
        System.out.println("name = "+DilAdi);


    }
    @Test
    public void test3() throws SQLException {
        ResultSet rs=statement.executeQuery("select * from language");

        rs.next();
        String DilAdi=rs.getString(2);
        System.out.println("name = "+DilAdi);

        rs.next();// sonraki satır
        DilAdi=rs.getString(2);
        System.out.println("name = "+DilAdi);

        rs.next();// sonraki satır
        DilAdi=rs.getString(2);
        System.out.println("name = "+DilAdi);


    }

}
