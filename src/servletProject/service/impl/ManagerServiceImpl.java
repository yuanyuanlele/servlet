package servletProject.service.impl;

import servletProject.dao.ManagerDao;
import servletProject.dao.impl.ManagerDaoImpl;
import servletProject.enity.Manager;
import servletProject.service.ManagerService;
import servletProject.utils.Dbutils;

public class ManagerServiceImpl implements ManagerService {
    private ManagerDao managerDao=new ManagerDaoImpl();
    @Override
    public Manager login(String username, String password) {
        Manager manager= null;
        try {
            manager = null;
            Dbutils.begin();
            Manager temp=managerDao.select(username);
            if (temp!=null){
                if (temp.getPassword().equals(password)){
                    manager=temp;
                }
            }
            Dbutils.commit();
        } catch (Exception e) {
            Dbutils.rollback();
            e.printStackTrace();
        }
        return manager;
    }
}
