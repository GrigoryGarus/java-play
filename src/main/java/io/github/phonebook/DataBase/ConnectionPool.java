package io.github.phonebook.DataBase;

import org.h2.jdbcx.JdbcConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

public enum  ConnectionPool {
    INSTANCE;

private final Connection conn=connectionPool();

    public Connection getConn() {
        return conn;
    }

    private Connection connectionPool() {

        JdbcConnectionPool cp = JdbcConnectionPool.create(
                "jdbc:h2:tcp://localhost:9092/data", "sa", "");
        Connection conn = null;
        try {
            conn = cp.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
