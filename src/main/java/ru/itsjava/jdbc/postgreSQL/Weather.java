package ru.itsjava.jdbc.postgreSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Temp {
    private final static String DB_URL_1 = "jdbc:postgresql://localhost:5433/store";
    private final static String DB_LOGIN = "postgres";
    private final static String DB_PASSWORD = "1111";

    public static void main(String[] args) throws SQLException{
//        createSchema();


    }

    public static void createSchema() throws SQLException {
        Connection connection = DriverManager.getConnection( DB_URL_1, DB_LOGIN, DB_PASSWORD );
        Statement statement = connection.createStatement();
        statement.executeLargeUpdate( "CREATE SCHEMA weather" );
    }

    
}
