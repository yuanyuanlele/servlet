package servletProject.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Dbutils {
    private static DruidDataSource ds;
    private static final ThreadLocal<Connection> THREAD_LOCAL=new ThreadLocal<>();

    static {
        Properties properties=new Properties();
        InputStream is=Dbutils.class.getResourceAsStream("/database.properties");

        try {
            properties.load(is);
            ds=(DruidDataSource)DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getconnection(){
        Connection connection=THREAD_LOCAL.get();
        if(connection==null){
            try {
                connection= ds.getConnection();
                THREAD_LOCAL.set(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void begin(){
        Connection connection=null;
        connection=getconnection();
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void commit(){
        Connection connection=null;
        connection=getconnection();
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeall(connection,null,null);
        }
    }

    public static void rollback(){
        Connection connection=null;
        connection=getconnection();
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeall(connection,null,null);
        }
    }

    public static void closeall(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if(resultSet!=null){
                resultSet.close();
            }
            if (statement!=null){
                statement.close();
            }
            if(connection!=null){
                connection.close();
                THREAD_LOCAL.remove();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
