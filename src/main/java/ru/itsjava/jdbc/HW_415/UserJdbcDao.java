package ru.itsjava.jdbc.HW_415;

import java.sql.SQLException;

public interface UserJdbcDao {
    int getAgeByUserName(String name) throws SQLException;

}
