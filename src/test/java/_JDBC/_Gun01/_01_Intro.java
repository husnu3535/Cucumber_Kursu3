package _JDBC._Gun01;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Intro {
    @Test
    public void test1() throws SQLException {
        String url="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila"; // hostname,port/db adını (user db)
        String username="root"; // username
        String password="'\"-LhCB'.%k[4S]z"; // password

        Connection connection= DriverManager.getConnection(url,username,password); // Connection

        Statement statement=connection.createStatement(); // sorguları çalıştırmak için page açıldı.

        ResultSet rs=statement.executeQuery("select * from actor"); // sorgu sonucu oluştu ama henüz db de bekliyor

        rs.next();
        String firstName=rs.getString("first_name");
        String lastName=rs.getString("last_name");

        System.out.println("firstname = " +firstName);
        System.out.println("lastname = " +lastName);

        // 2.Satır
        rs.next();
        firstName=rs.getString("first_name");
        lastName=rs.getString("last_name");

        System.out.println("firstname = " +firstName);
        System.out.println("lastname = " +lastName);

        connection.close();






    }
       /*   1- connection : önce bağlantı ayarlarını yaptık
            username, password, url(port,db,bağlantı yolu)

            2- Sorgu çalıştırma yolu : sorgularımı çalıştırmak için bir sayfa(yol) açtım.

            3- Sonuçların alınması : sorgunun çalışması sonucu veritabanından gelen bilgiler.
       */
}