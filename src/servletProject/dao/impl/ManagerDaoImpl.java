package servletProject.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import servletProject.dao.ManagerDao;
import servletProject.enity.Manager;
import servletProject.utils.Dbutils;

import java.sql.SQLException;

public class ManagerDaoImpl implements ManagerDao {
    private QueryRunner queryRunner=new QueryRunner();
    @Override
    public Manager select(String username) {
        try {
            Manager manager=queryRunner.query(Dbutils.getconnection(),"select * from manager where username=?;",new BeanHandler<Manager>(Manager.class),username);
            return manager;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
