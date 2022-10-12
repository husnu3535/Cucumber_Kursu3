package _JDBC;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;
public class JDBCParent {
    protected static Connection connection;
    protected static Statement statement;

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

}
