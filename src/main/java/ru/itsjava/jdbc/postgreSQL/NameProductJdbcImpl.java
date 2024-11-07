package ru.itsjava.jdbc.postgreSQL;

import java.sql.*;

public class NameProductJdbcImpl implements ConnectReadDao {

    private final static String DB_URL = "jdbc:postgresql://localhost:5433/postgres";
    private final static String DB_URL_1 = "jdbc:postgresql://localhost:5433/store";
    private final static String DB_LOGIN = "postgres";
    private final static String DB_PASSWORD = "1111";

    @Override
    public float getPriceByName(String name) throws SQLException {
//        Connection connection = DriverManager.getConnection( "jdbc:postgresql://localhost:5433/postgres?user=postgres&password=1111" );
        Connection connection = DriverManager.getConnection( DB_URL, DB_LOGIN, DB_PASSWORD );
        PreparedStatement preparedStatement = connection.prepareStatement( "SELECT price FROM public.products where name = ?" );
        preparedStatement.setString( 1, name );
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getFloat( "price" );
    }

    public static void main(String[] args) throws SQLException {
        System.setProperty( "file.encoding", "UTF-8" );
//        ConnectReadDao userJdbcDao = new NameProductJdbcImpl();
//        System.out.println( userJdbcDao.getPriceByName( "product3" ) );
        selectTab();
//        createTabClient();
//        createPurchasesTab();
//        insertProduct();
        cleverSelectTab();
//        insertClients();
        selectPurchasesTab();
    }

    public static void createDB() throws SQLException {
        Connection connection = DriverManager.getConnection( "jdbc:postgresql://localhost:5433/", DB_LOGIN, DB_PASSWORD );
        Statement statement = connection.createStatement();
        statement.executeLargeUpdate( "CREATE DATABASE store" );
    }

    public static void dropDB() throws SQLException {
        Connection connection = DriverManager.getConnection( "jdbc:postgresql://localhost:5433/", DB_LOGIN, DB_PASSWORD );
        Statement statement = connection.createStatement();
        statement.executeLargeUpdate( "DROP DATABASE store" );
    }

    public static void createTabProduct() throws SQLException {
        Connection connection = DriverManager.getConnection( DB_URL_1, DB_LOGIN, DB_PASSWORD );
        Statement statement = connection.createStatement();
        statement.executeLargeUpdate( "CREATE TABLE products (\n" +
                "\tid SERIAL PRIMARY KEY,\n" +
                "\tname TEXT NOT NULL,\n" +
                "\tprice DOUBLE PRECISION DEFAULT 9.99 CHECK (price > 0) NOT NULL,\n" +
                "\tmax_quantity INTEGER,\n" +
                "\tquantity INTEGER CHECK ( quantity <= max_quantity )\n" +
                ")" );
    }

    public static void createTabClient() throws SQLException {
        Connection connection = DriverManager.getConnection( DB_URL_1, DB_LOGIN, DB_PASSWORD );
        Statement statement = connection.createStatement();
        statement.executeLargeUpdate( "CREATE TABLE clients (\n" +
                "\tid SERIAL PRIMARY KEY,\n" +
                "\tfirst_name TEXT NOT NULL,\n" +
                "\tlast_name TEXT NOT NULL,\n" +
                "\taddress TEXT NOT NULL,\n" +
                "\tphone TEXT,\n" +
                "\temail TEXT\n" +
                ")" );
    }

    public static void createPurchasesTab() throws SQLException {
        Connection connection = DriverManager.getConnection( DB_URL_1, DB_LOGIN, DB_PASSWORD );
        Statement statement = connection.createStatement();
        statement.executeLargeUpdate( "CREATE TABLE purchases (\n" +
                "\tid SERIAL PRIMARY KEY,\n" +
                "\tclient INTEGER REFERENCES clients ON DELETE CASCADE,\n" +
                "\tproduct INTEGER REFERENCES products ON DELETE RESTRICT\n" +
                ")" );
    }

    public static void insertTab() throws SQLException {
        Connection connection = DriverManager.getConnection( DB_URL_1, DB_LOGIN, DB_PASSWORD );
        Statement statement = connection.createStatement();
        statement.executeLargeUpdate( "INSERT INTO products (id, name, quantity) VALUES (1, 'first product', 20);" );
    }

    public static void selectPurchasesTab() throws SQLException {
        Connection connection = DriverManager.getConnection( DB_URL_1, DB_LOGIN, DB_PASSWORD );
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery( "SELECT * FROM purchases" );
        while (resultSet.next()) {
            System.out.print( resultSet.getString( 1 ) + "\t\t" );
            System.out.print( resultSet.getString( 2 ) + "\t\t" );
            System.out.println( resultSet.getString( 3 ) );
        }
    }

    public static void selectTab() throws SQLException {
        Connection connection = DriverManager.getConnection( DB_URL_1, DB_LOGIN, DB_PASSWORD );
        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery( "SELECT id, name, quantity FROM products" );
        ResultSet resultSet = statement.executeQuery( "SELECT * FROM products" );
//        ResultSet resultSetClient = statement.executeQuery( "SELECT * FROM clients" );
        while (resultSet.next()) {
            System.out.print( resultSet.getString( 1 ) + "\t\t" );
            System.out.print( resultSet.getString( 2 ) + "\t\t" );
            System.out.print( resultSet.getDouble( 3 ) + "\t\t" );
            System.out.print( resultSet.getDouble( 4 ) + "\t\t" );
            System.out.println( resultSet.getString( 5 ) );
        }
//        while (resultSetClient.next()) {
//            System.out.print( resultSet.getString( 1 ) + "\t\t" );
//            System.out.print( resultSet.getString( 2 ) + "\t\t" );
//            System.out.print( resultSet.getString( 3 ) + "\t\t" );
//            System.out.println( resultSet.getString( 4 ) );
//        }
    }

    public static void cleverSelectTab() throws SQLException {
        Connection connection = DriverManager.getConnection( DB_URL_1, DB_LOGIN, DB_PASSWORD );
        PreparedStatement ps = connection.prepareStatement( "SELECT name, max_quantity - quantity FROM products WHERE id>0 ORDER BY price ASC" );
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            System.out.print( resultSet.getString( 1 ) + "\t" );
            System.out.println( resultSet.getString( 2 ) );
        }
    }

    public static void updateTab() throws SQLException {
        Connection connection = DriverManager.getConnection( DB_URL_1, DB_LOGIN, DB_PASSWORD );
        Statement statement = connection.createStatement();
//        statement.executeLargeUpdate( "UPDATE products SET quantity=49 WHERE id=1" );
        statement.executeLargeUpdate( "UPDATE products SET name='батон', quantity=48 WHERE id=1" );
    }

    public static void deleteTabData() throws SQLException {
        Connection connection = DriverManager.getConnection( DB_URL_1, DB_LOGIN, DB_PASSWORD );
        Statement statement = connection.createStatement();
        statement.executeLargeUpdate( "DELETE FROM products WHERE id=1" );
    }

    public static void deleteTab() throws SQLException {
        Connection connection = DriverManager.getConnection( DB_URL_1, DB_LOGIN, DB_PASSWORD );
        Statement statement = connection.createStatement();
        statement.executeLargeUpdate( "DROP TABLE products" );
    }

    public static void createRoleForDB() throws SQLException {
        Connection connection = DriverManager.getConnection( DB_URL_1, DB_LOGIN, DB_PASSWORD );
        Statement statement = connection.createStatement();
        statement.executeLargeUpdate( "CREATE ROLE manager LOGIN CREATEDB PASSWORD '0123456789'" );
    }

    public static void insertProduct() throws SQLException {
        Connection connection = DriverManager.getConnection( DB_URL_1, DB_LOGIN, DB_PASSWORD );
        Statement statement = connection.createStatement();
        statement.executeLargeUpdate( "INSERT INTO products (name, price, quantity, max_quantity) VALUES \n" +
                "('product1', 15.50, 50, 50),\n" +
                "('product2', 9.99, 30, 40),\n" +
                "('product3', 4.99, 80, 100);" );
    }

    public static void insertClients() throws SQLException {
        Connection connection = DriverManager.getConnection( DB_URL_1, DB_LOGIN, DB_PASSWORD );
        Statement statement = connection.createStatement();
        statement.executeLargeUpdate( "INSERT INTO clients (first_name, last_name, address, phone, email) VALUES \n" +
                "('Петя', 'Петров', '5-я Северная 321, 1', '+79118899901', '50@mail.ru'),\n" +
                "('Леня', 'Зайцев', '5-я Северная 321, 2', '+79118899902', '60@mail.ru'),\n" +
                "('Шура', 'Седнев', '5-я Северная 321, 3', '+79118899903', '70@mail.ru'); " );
    }

}
