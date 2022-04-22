package com.library.step_definitions.Muhammet;

import com.library.utility.DB_Util;

import java.sql.*;

public class test {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://34.230.35.214:3306/library2" ;
        String username = "library2_client" ;
        String password = "6s2LQQTjBcGFfDhY" ;

        Connection conn = DriverManager.getConnection(url,username,password);
        Statement stmt  = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs    = stmt.executeQuery("SELECT id FROM users") ;
       DB_Util.destroy();
    }
}
