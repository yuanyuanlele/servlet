package servletProject.dao;

import servletProject.enity.Manager;

public interface ManagerDao {
    public Manager select(String username);
}
