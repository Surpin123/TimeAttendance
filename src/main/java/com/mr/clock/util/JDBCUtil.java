package com.mr.clock.util;

import javax.naming.ConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    private static String driver_name;
    private static String username;
    private static String password;
    private static String url;
    private static Connection con = null;
    private static final String CONFIG_FILE = "src/main/java/com/mr/clock/config/jdbc.properties";

    static {
        Properties pro = new Properties();
        File config = new File(CONFIG_FILE);
        try {
            if (!config.exists()) {
                throw new FileNotFoundException("缺少文件：" + config.getAbsolutePath());
            }
            pro.load(new FileInputStream(config));
            driver_name = pro.getProperty("driver_name");
            username = pro.getProperty("username");
            password = pro.getProperty("password");
            url = pro.getProperty("url");
            if (driver_name == null || url == null) {
                throw new ConfigurationException("jdbc.properties 文件缺少配置信息");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ConfigurationException e) {
            System.out.println("配置文件获取的内容:[diver_name=" + driver_name + "],[username =" + username + "],[password=" + password + "],[ur;=" + url + "]");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            if (con == null || con.isClosed()) {
                Class.forName(driver_name);
                con = DriverManager.getConnection(url, username, password);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement stmt, PreparedStatement ps, ResultSet rs) {
        close(rs);
        close(ps);
        close(stmt);
    }

    public static void closeConnection(){
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

