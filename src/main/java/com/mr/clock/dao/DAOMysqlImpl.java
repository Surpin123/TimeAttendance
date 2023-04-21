package com.mr.clock.dao;

import com.mr.clock.pojo.Employee;
import com.mr.clock.pojo.User;
import com.mr.clock.pojo.WorkTime;
import com.mr.clock.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class DAOMysqlImpl implements DAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public Set<Employee> getAllEmp() {
        return null;
    }

    @Override
    public Employee getEmp(int id) {
        try {
            String sql = "select name,code from t_emp where id = ?";
            con = JDBCUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String code = rs.getString("code");
                Employee e = new Employee(id,name,code);
                return e;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs);
        }
        return null;
    }

    @Override
    public Employee getEmp(String code) {
        return null;
    }

    @Override
    public void addEmp(Employee e) {

    }

    @Override
    public void deleteEmp(Integer id) {

    }

    @Override
    public WorkTime getWorkTime() {
        return null;
    }

    @Override
    public void updateWorkTime(WorkTime time) {

    }

    @Override
    public void deleteClockInRecord() {

    }

    @Override
    public String[][] getAllClockInRecord() {
        return new String[0][];
    }

    @Override
    public boolean userLogin(User user) {
        return false;
    }
}
