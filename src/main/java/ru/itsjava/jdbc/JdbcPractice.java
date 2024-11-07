package ru.itsjava.jdbc;

import ru.itsjava.jdbc.dao.EmployerDao;
import ru.itsjava.jdbc.dao.EmployerJdbcImpl;

import java.sql.*;

public class JdbcPractice {
    public static final String DB_URL = "jdbc:MySql://localhost:3306/hw412_schema?serverTimezone=UTC";
    public static final String DB_LOGIN = "root";
    public static final String DB_PASSWORD = "1234";

    public static void main(String[] args) {
//        try (Connection connection = DriverManager.getConnection( DB_URL, DB_LOGIN, DB_PASSWORD );
//             Statement statement = connection.createStatement()
//        ) {
//            ResultSet resultSet = statement.executeQuery( "SELECT name, email, age, id FROM hw412_schema.users;" );
//            while (resultSet.next()) {
//                System.out.println( resultSet.getInt( "id" ) + ":" + resultSet.getString( "name" ) + ":" + resultSet.getInt( "age" ) + ":" + resultSet.getString( "email" ) );
//            }
//        } catch (
//                SQLException throwables) {
//            throwables.printStackTrace();
//        }

        EmployerDao dao = new EmployerJdbcImpl();
        System.out.println("dao.findAgeByName(\"tanya\") = " + dao.findAgeByName("Tanya"));


    }
}


//1. Url, login и password к БД  +
// 2. Драйвер в зависимостях     +
// 3. JDBC (встроен внутрь JDK)  +
// 4. Написать свой DAO