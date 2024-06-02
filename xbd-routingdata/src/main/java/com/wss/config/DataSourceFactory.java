//package com.wss.config;
//
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//
//import javax.sql.DataSource;
//
//public class DataSourceFactory {
//
//    public static DataSource createDataSource(String dbType, String url, String username, String password) {
//        switch (dbType.toLowerCase()) {
//            case "mysql":
//                return createMySQLDataSource(url, username, password);
//            case "postgresql":
//                return createPostgreSQLDataSource(url, username, password);
//            case "oracle":
//                return createOracleDataSource(url, username, password);
//            // 添加其他数据库类型
//            default:
//                throw new IllegalArgumentException("Unsupported database type: " + dbType);
//        }
//    }
//
//    private static DataSource createMySQLDataSource(String url, String username, String password) {
//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl(url);
//        config.setUsername(username);
//        config.setPassword(password);
//        return new HikariDataSource(config);
//    }
//
//    private static DataSource createPostgreSQLDataSource(String url, String username, String password) {
//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl(url);
//        config.setUsername(username);
//        config.setPassword(password);
//        return new HikariDataSource(config);
//    }
//
//    private static DataSource createOracleDataSource(String url, String username, String password) {
//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl(url);
//        config.setUsername(username);
//        config.setPassword(password);
//        return new HikariDataSource(config);
//    }
//}
