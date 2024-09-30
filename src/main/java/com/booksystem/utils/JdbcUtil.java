package com.booksystem.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class JdbcUtil {
    private static DataSource ds;
    private static String driver = "com.mysql.jdbc.Driver";
    static {
        System.out.println("static");
        Properties prop = new Properties();
        try {
            InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            prop.load(in);
            ds= DruidDataSourceFactory.createDataSource(prop);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static DataSource getDataSource(){
        return ds;
    }

}
