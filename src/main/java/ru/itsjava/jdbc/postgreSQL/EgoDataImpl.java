package ru.itsjava.jdbc.postgreSQL;

import java.sql.*;

public class EgoData implements EgoName {
    private final static String DB_URL = "jdbc:postgresql://10.194.12.150:5432/ATSXML";
    private final static String DB_LOGIN = "stsbd";
    private final static String DB_PASSWORD = "7362";

    @Override
    public String getEgo() throws SQLException {
        Connection connection = DriverManager.getConnection( DB_URL, DB_LOGIN, DB_PASSWORD );
        PreparedStatement preparedStatement = connection.prepareStatement( "SELECT * FROM ego.ego_name" );
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getString( 1 );

    }
}
