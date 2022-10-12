package Utilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.*;
import java.util.ArrayList;

public class DBUtility {
    protected static Connection connection;
    protected static Statement statement;

    @BeforeTest
    public static void DBConnectionOpen(){
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
    public static void DBConnectionClose(){
        try {
            connection.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) { // TEST İÇİN
        ArrayList<ArrayList<String>>tablo=getListData("select * from actor");
        for (ArrayList<String> satir : tablo ){
            System.out.println("satır = "+ satir);
        }

    }
    public static ArrayList<ArrayList<String>>getListData(String query){
        ArrayList<ArrayList<String>>tablo=new ArrayList<>();
        // db den bütün satırları ve sütunları okuyup bu list e atıcam

        // db bağlantısını aç
        DBConnectionOpen();

        try {
            ResultSet rs=statement.executeQuery(query);
            ResultSetMetaData rsmd=rs.getMetaData();

            while (rs.next()){
                ArrayList<String> satir =new ArrayList<>();
                for (int i = 1; i <= rsmd.getColumnCount() ; i++) {

                    satir.add(rs.getString(i));
                }
                tablo.add(satir);

            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        DBConnectionClose();
        // db bağlantısını kapat
        return tablo;
    }

}
