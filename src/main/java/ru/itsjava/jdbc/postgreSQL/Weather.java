package ru.itsjava.jdbc.postgreSQL;

import java.sql.*;

public class Weather {
    private final static String DB_URL_1 = "jdbc:postgresql://localhost:5433/store";
    private final static String DB_LOGIN = "postgres";
    private final static String DB_PASSWORD = "1111";

    public static void main(String[] args) throws SQLException {
//        createSchema();
//        createTabWeather();
//        createTabCities();
//        copyTab();
//        copyTabLocation();
//        selectJoin01();
//        selectJoin02();
//        selectMaxTempLo();
//        createView();
        createWindowFunc();
//        updateTabTransactions();
    }

    public static void createSchema() throws SQLException {
        Connection connection = DriverManager.getConnection( DB_URL_1, DB_LOGIN, DB_PASSWORD );
        Statement statement = connection.createStatement();
        statement.executeLargeUpdate( "CREATE SCHEMA weather" );
    }

    public static void createTabWeather() throws SQLException {
        Connection connection = DriverManager.getConnection( DB_URL_1, DB_LOGIN, DB_PASSWORD );
        Statement statement = connection.createStatement();
        statement.executeLargeUpdate( "CREATE TABLE weather.weather (\n" +
                "\tid SERIAL PRIMARY KEY,\n" +
                "\tcity VARCHAR(80) NOT NULL,\n" +
                "\ttemp_hi DOUBLE PRECISION NOT NULL,\n" +
                "\ttemp_lo DOUBLE PRECISION NOT NULL,\n" +
                "\tprcp REAL,\n" +
                "\tdata DATE\n" +
                ")" );
    }

    public static void createTabCities() throws SQLException {
        Connection connection = DriverManager.getConnection( DB_URL_1, DB_LOGIN, DB_PASSWORD );
        Statement statement = connection.createStatement();
        statement.executeLargeUpdate( "CREATE TABLE weather.cities (\n" +
                "\tid SERIAL PRIMARY KEY,\n" +
                "\tname VARCHAR(80) NOT NULL,\n" +
                "\tlocation point\n" +
                ")" );
    }

    public static void copyTab() throws SQLException {
        Connection connection = DriverManager.getConnection( DB_URL_1, DB_LOGIN, DB_PASSWORD );
        Statement statement = connection.createStatement();
        statement.executeLargeUpdate( "COPY weather.weather (city, temp_hi, temp_lo, prcp, data) FROM 'C:/dev/temperatura.csv' DELIMITER ';' CSV HEADER encoding 'windows-1251';" );
    }

    public static void copyTabLocation() throws SQLException {
        Connection connection = DriverManager.getConnection( DB_URL_1, DB_LOGIN, DB_PASSWORD );
        Statement statement = connection.createStatement();
        statement.executeLargeUpdate( "COPY weather.cities (name, location) FROM 'C:/dev/koordinat.csv' DELIMITER ';' CSV HEADER encoding 'windows-1251';" );
    }

    public static void selectJoin01() throws SQLException {
        Connection connection = DriverManager.getConnection( DB_URL_1, DB_LOGIN, DB_PASSWORD );
        PreparedStatement ps = connection.prepareStatement( "SELECT * FROM weather.weather JOIN weather.cities ON city = name;" );
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            System.out.print( resultSet.getString( 2 ) + "\t" );
            System.out.print( resultSet.getDouble( 3 ) + "\t" );
            System.out.print( resultSet.getDouble( 4 ) + "\t" );
            System.out.print( resultSet.getDouble( 5 ) + "\t" );
            System.out.print( resultSet.getDate( 6 ) + "\t" );
            System.out.print( resultSet.getString( 8 ) + "\t" );
            System.out.println( resultSet.getObject( 9 ) );
        }
    }

    public static void selectJoin02() throws SQLException {
        Connection connection = DriverManager.getConnection( DB_URL_1, DB_LOGIN, DB_PASSWORD );
        PreparedStatement ps = connection.prepareStatement( "SELECT * FROM weather.weather LEFT OUTER JOIN weather.cities ON weather.city = cities.name;" );
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            System.out.print( resultSet.getString( 2 ) + "\t" );
            System.out.print( resultSet.getObject( 3 ) + "\t" );
            System.out.print( resultSet.getObject( 4 ) + "\t" );
            System.out.print( resultSet.getObject( 5 ) + "\t" );
            System.out.print( resultSet.getDate( 6 ) + "\t" );
            System.out.print( resultSet.getString( 8 ) + "\t" );
            System.out.println( resultSet.getObject( 9 ) );
        }
    }

    public static void selectMaxTempLo() throws SQLException {
        Connection connection = DriverManager.getConnection( DB_URL_1, DB_LOGIN, DB_PASSWORD );

        PreparedStatement ps = connection.prepareStatement( "SELECT max(temp_lo) FROM weather.weather" );
        ResultSet resultSet = ps.executeQuery();
        resultSet.next();
        System.out.println( resultSet.getString( 1 ) );
        System.out.println();

        PreparedStatement ps01 = connection.prepareStatement( "SELECT city FROM weather.weather WHERE temp_lo = (SELECT min(temp_lo) FROM weather.weather);" );
        ResultSet resultSet01 = ps01.executeQuery();
        resultSet01.next();
        System.out.println( resultSet01.getString( 1 ) );
        System.out.println();

        PreparedStatement ps02 = connection.prepareStatement( "SELECT city, count(*), max(temp_lo) FROM weather.weather GROUP BY city" );
        ResultSet resultSet02 = ps02.executeQuery();
        while (resultSet02.next()) {
            System.out.print( resultSet02.getString( 1 ) + "\t\t" );
            System.out.print( resultSet02.getDouble( 2 ) + "\t" );
            System.out.println( resultSet02.getDouble( 3 ) + "\t" );

        }
        System.out.println();

        PreparedStatement ps03 = connection.prepareStatement( "SELECT city, count(*), max(temp_lo) FROM weather.weather GROUP BY city HAVING max(temp_lo) < 16;" );
        ResultSet resultSet03 = ps03.executeQuery();
        while (resultSet03.next()) {
            System.out.print( resultSet03.getString( 1 ) + "\t\t" );
            System.out.print( resultSet03.getDouble( 2 ) + "\t" );
            System.out.println( resultSet03.getDouble( 3 ) + "\t" );
        }
        System.out.println();

        PreparedStatement ps04 = connection.prepareStatement( "SELECT city, count(*), max(temp_hi) FROM weather.weather WHERE city ILIKE 'Б%' GROUP BY city;" );
        ResultSet resultSet04 = ps04.executeQuery();
        while (resultSet04.next()) {
            System.out.print( resultSet04.getString( 1 ) + "\t\t" );
            System.out.print( resultSet04.getDouble( 2 ) + "\t" );
            System.out.println( resultSet04.getDouble( 3 ) + "\t" );
        }
        System.out.println();

        PreparedStatement ps05 = connection.prepareStatement( "SELECT city, count(*) FILTER (WHERE temp_lo < 5 and temp_hi>10) FROM weather.weather GROUP BY city" );
        ResultSet resultSet05 = ps05.executeQuery();
        while (resultSet05.next()) {
            System.out.print( resultSet05.getString( 1 ) + "\t\t" );
            System.out.println( resultSet05.getDouble( 2 ) );
        }
    }

    public static void createView() throws SQLException {
        Connection connection = DriverManager.getConnection( DB_URL_1, DB_LOGIN, DB_PASSWORD );
//        Statement statement = connection.createStatement();
//        statement.executeLargeUpdate( "CREATE OR REPLACE VIEW weather.myvies\n" +
//                " AS\n" +
//                " SELECT cities.name,\n" +
//                "    weather.temp_lo,\n" +
//                "    weather.temp_hi,\n" +
//                "    weather.prcp,\n" +
//                "    weather.data,\n" +
//                "    cities.location\n" +
//                "   FROM weather.weather,\n" +
//                "    weather.cities\n" +
//                "  WHERE weather.city = cities.name;" );
        PreparedStatement preparedStatement = connection.prepareStatement( "SELECT * FROM weather.myvies" );
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.print( resultSet.getString( 1 ) + "\t" );
            System.out.print( resultSet.getDouble( 2 ) + "\t" );
            System.out.print( resultSet.getDouble( 3 ) + "\t" );
            System.out.print( resultSet.getDouble( 4 ) + "\t" );
            System.out.print( resultSet.getDate( 5 ) + "\t" );
            System.out.println( resultSet.getObject( 6 ) );
        }
    }

    public static void createWindowFunc() throws SQLException {
        Connection connection = DriverManager.getConnection( DB_URL_1, DB_LOGIN, DB_PASSWORD );
        PreparedStatement preparedStatement = connection.prepareStatement( "SELECT city, temp_hi, data, avg(temp_hi) OVER (PARTITION BY city ORDER BY city) FROM weather.weather ORDER BY  city, data" );
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.print( resultSet.getString( 1 ) + "\t" );
            System.out.print( resultSet.getDouble( 2 ) + "\t" );
            System.out.print( resultSet.getDate( 3 ) + "\t" );
            System.out.println( resultSet.getDouble( 4 ) );
        }
    }

    public static void updateTabTransactions() throws SQLException {
        Connection connection = DriverManager.getConnection( DB_URL_1, DB_LOGIN, DB_PASSWORD );
        Statement statement = connection.createStatement();
        statement.executeLargeUpdate( """
                BEGIN;
                SAVEPOINT my_savepoint;
                UPDATE weather.weather SET temp_lo=temp_lo-4 WHERE city = 'бангладеш';
                -- ошибочное действие... забыть его
                ROLLBACK TO my_savepoint;
                COMMIT;
                """ );
    }


}
