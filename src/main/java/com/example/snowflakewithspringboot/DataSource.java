package com.example.snowflakewithspringboot;

import com.zaxxer.hikari.*;
import java.sql.*;

public class DataSource {
    private DataSource() {}

    //snowflake connection
    public static Connection getConnection() throws SQLException {
        java.util.Properties props = new java.util.Properties();
        props.put("user", "");
        props.put("password", "");
        props.put("warehouse", "");
        props.put("db", "");
        props.put("schema", "");

        String jdbcUrl = "jdbc:snowflake://{hostname}:{port}/?db="+props.getProperty("db")
                +"&warehouse="+props.getProperty("warehouse")
                +"&schema="+props.getProperty("schema");
       //set HikariCP configuration.
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(props.getProperty("user"));
        config.setPassword(props.getProperty("password"));
        HikariDataSource ds = new HikariDataSource(config);
        return ds.getConnection();
    }
}