package com.example.snowflakewithspringboot;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SnowflakeService {
    public static  ResultSet executeQuery(String sql) {
        try {
            System.out.println("Executing Snowflake query: " + sql);
//            Connection conn = getSnowflakeConnection();
            Connection conn = DataSource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(sql);
            conn.close();
            System.out.println("Query Executed Successfully");

            return res;
        } catch (SQLException e) {
            throw new RuntimeException(
                    "Couldn't execute query on snowflake for some error, query: " + sql + " error: " + e.getStackTrace());
        }
    }

//    private static Connection getSnowflakeConnection() throws SQLException {
//        java.util.Properties connProperties = new java.util.Properties();
//        connProperties.put("user", "");
//        connProperties.put("password", "");
//        connProperties.put("port", );
//        connProperties.put("warehouse", "");
//        connProperties.put("db", "");
//        connProperties.put("schema", "");
//        //JDBC connection string
//        String jdbcUrl = ;
//        System.out.println("Created JDBC connection");
//        Connection connection = DriverManager.getConnection(jdbcUrl, connProperties);
//        System.out.println("Done creating JDBC connection");
//        return connection;
//    }
}