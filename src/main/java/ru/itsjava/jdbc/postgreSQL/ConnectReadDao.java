package ru.itsjava.jdbc.postgreSQL;

import java.sql.SQLException;

public interface ConnectReadDao {
    float getPriceByName (String name) throws SQLException;
}
