package ru.itsjava.jdbc.HW_415;

import java.sql.*;

public class UserJdbcImpl implements UserJdbcDao {
    private final static String DB_URL = "jdbc:MySql://127.0.0.1:3306/hw412_schema?serverTimezone=UTC";
    private final static String DB_LOGIN = "root";
    private final static String DB_PASSWORD = "1234";

    @Override
    public int getAgeByUserName(String name) throws SQLException {
        Connection connection = DriverManager.getConnection( DB_URL, DB_LOGIN, DB_PASSWORD );
        PreparedStatement preparedStatement = connection.prepareStatement( "SELECT age FROM hw412_schema.users where name = ?" );
        preparedStatement.setString( 1, name );
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt( "age" );

    }

    public static void main(String[] args) throws SQLException {
        UserJdbcDao userJdbcDao = new UserJdbcImpl();
        System.out.println( userJdbcDao.getAgeByUserName( "Mary" ) );
    }
}
