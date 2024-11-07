package ru.itsjava.jdbc.postgreSQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EgoDataImpl implements EgoName, Ego {
    private final static String DB_URL = "jdbc:postgresql://10.194.12.150:5432/ATSXML";
    private final static String DB_LOGIN = "stsbd";
    private final static String DB_PASSWORD = "7362";

    @Override
    public void getEgo() throws SQLException {
        Connection connection = DriverManager.getConnection( DB_URL, DB_LOGIN, DB_PASSWORD );
//        PreparedStatement preparedStatement = connection.prepareStatement( "SELECT * FROM ego.ego_name" );
        Statement preparedStatement = connection.createStatement();
        ResultSet resultSet = preparedStatement.executeQuery( "SELECT * FROM trade.gtp ORDER BY id" );
        while (resultSet.next()) {
//        List<String> ego = new ArrayList<>();
//        for (int i = 1; i < 5; i++) {
//            ego.add( resultSet.getString( i ) );
//        }
//        System.out.println( ego );
            System.out.print( resultSet.getString( "id" ) + "\t" );
//            System.out.print( resultSet.getString( "code" ) + "\t\t" );
            System.out.print( resultSet.getString( "name" ) + "\t" );
//            System.out.println( resultSet.getString( "gtp" ) );
            System.out.println( resultSet.getString( "fullname" ) );
        }
    }

    public static void main(String[] args) throws SQLException {
        EgoName egoName = new EgoDataImpl();
        egoName.getEgo();
        Ego ego = new EgoDataImpl();
        ego.getEgoData();
    }

    @Override
    public void getEgoData() throws SQLException {
        Connection connection = DriverManager.getConnection( DB_URL, DB_LOGIN, DB_PASSWORD );
//        PreparedStatement preparedStatement = connection.prepareStatement( "SELECT * FROM ego.ego_name" );
        Statement preparedStatement = connection.createStatement();
        ResultSet resultSet = preparedStatement.executeQuery( "SELECT * FROM trade.buy_main where years='2024' and months='9' and gtp='47' ORDER BY days, hours" );
        while (resultSet.next()) {
//        List<String> ego = new ArrayList<>();
//        for (int i = 1; i < 30; i++) {
//            ego.add( resultSet.getString( i ) );
//        }
//        System.out.println( ego );
            System.out.print( resultSet.getString( "days" ) + "\t\t");
            System.out.print( resultSet.getString( "hours" ) + "\t\t");
            System.out.print( resultSet.getString( "step2_p" ) + "\t\t");
            System.out.println( resultSet.getString( "step2_v" ) );

        }
    }
}
