package University.Management.System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectDb {
    Connection connection;
    Statement statement;
    ConnectDb(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///universitymanagement","root","Hr16p@1076");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
