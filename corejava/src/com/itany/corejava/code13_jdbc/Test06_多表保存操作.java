package com.itany.corejava.code13_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 石小俊
 * @date 2023年09月13日 13:33
 */
public class Test06_多表保存操作 {
    public static void main(String[] args) throws DataAccessException {
        // 添加部门
        Dept dept = new Dept("市场部", "负责开拓市场的");
        Integer id = insertDeptReturnPrimaryKey(dept);
        System.out.println("部门添加成功");

        // 添加员工
        Emp e1 = new Emp("tom", 6000.0, id);
        Emp e2 = new Emp("root", 7000.0, id);
        Emp e3 = new Emp("lily", 8000.0, id);
        insertEmp(e1);
        insertEmp(e2);
        insertEmp(e3);
        System.out.println("员工添加成功");
    }

    public static Integer insertDeptReturnPrimaryKey(Dept dept) throws DataAccessException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer id = null;

        try {
            conn = JDBCUtil.getConnection();
            String sql = new StringBuffer()
                    .append(" insert into ")
                    .append(" t_dept")
                    .append("   (name,remark)")
                    .append(" values ")
                    .append("   (?,?)")
                    .toString();
            ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, dept.getName());
            ps.setString(2, dept.getRemark());
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            while (rs.next()) {
                id = rs.getInt(1);
            }
            return id;
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw e;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("数据访问失败");
        } finally {

            JDBCUtil.close(conn, ps, rs);
        }
    }

    public static void insertEmp(Emp emp) throws DataAccessException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = JDBCUtil.getConnection();
            String sql = new StringBuffer()
                    .append(" insert into ")
                    .append(" t_emp ")
                    .append("   (name,salary,dept_id)")
                    .append(" values ")
                    .append("   (?,?,?)")
                    .toString();
            ps = conn.prepareStatement(sql);
            ps.setString(1, emp.getName());
            ps.setDouble(2, emp.getSalary());
            ps.setInt(3, emp.getDeptId());
            ps.executeUpdate();
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw e;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("数据访问失败");
        } finally {
            JDBCUtil.close(conn, ps, null);
        }
    }
}
