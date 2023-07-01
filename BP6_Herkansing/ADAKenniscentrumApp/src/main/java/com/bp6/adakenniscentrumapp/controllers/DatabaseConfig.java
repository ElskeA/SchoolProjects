package com.bp6.adakenniscentrumapp.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    public static Connection getConnection(){
        Connection connection = null;

        try{
            connection = DriverManager.getConnection("jdbc:mysql://adainforma.tk:3306/projects_adakenniscentrum", "adakenniscentrum", "U5Qq&#Ry+s");
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
