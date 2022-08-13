package servletProject.dao;

import servletProject.enity.Admin;

import java.util.List;

public interface AdminDao {
    public int insert(Admin admin);
    public int delete(String username);
    public int update(Admin admin);
    public Admin select(String username);
    public List<Admin> selectall();
}
