package com.itany.corejava.code13_jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 石小俊
 * @date 2023年09月13日 16:45
 */
public class Test10_元数据 {

    public static void main(String[] args) throws DataAccessException {
//        selectAll();
//        User user = new User("test","123456","13812345678","江苏-南京");
//        insertReturnPrimaryKey(user);
        selectAllEmps();
    }

    public static void selectAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();

            // 通过连接获取数据库的元数据
            DatabaseMetaData dbma = conn.getMetaData();
            System.out.println("数据库产品名:" + dbma.getDatabaseProductName());
            System.out.println("数据库版本号:" + dbma.getDatabaseProductVersion());
            System.out.println("数据库驱动:" + dbma.getDriverName());
            System.out.println("数据库驱动版本:" + dbma.getDriverVersion());
            System.out.println("数据库的用户名:" + dbma.getUserName());
            System.out.println("数据库URL地址:" + dbma.getURL());

            String sql = new StringBuffer()
                    .append(" select id,username,password,phone,address ")
                    .append(" from t_user ")
                    .toString();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            // 通过结果集可以获取到结果集元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            int count = rsmd.getColumnCount();
            System.out.println("结果集中共有:" + count);
            for (int i = 1; i <= count; i++) {
                System.out.println("第" + i + "列的类型:" + rsmd.getColumnTypeName(i));
                System.out.println("第" + i + "列的列名:" + rsmd.getColumnName(i));
                System.out.println("第" + i + "列所在的表:" + rsmd.getTableName(i));
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Integer insertReturnPrimaryKey(User user) throws DataAccessException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer id = null;

        try {
            conn = JDBCUtil.getConnection();
            String sql = new StringBuffer()
                    .append(" insert into ")
                    .append(" t_user ")
                    .append("   (username,password,phone,address)")
                    .append(" values ")
                    .append("   (?,?,?,?)")
                    .toString();
            ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getAddress());
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            ResultSetMetaData rsmd = rs.getMetaData();
            int count = rsmd.getColumnCount();
            for (int i = 1; i <= count; i++) {
                // GENERATED_KEY
                System.out.println("第" + i + "列的列名:" + rsmd.getColumnName(i));
            }
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw e;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("数据访问异常");
        } finally {
            JDBCUtil.close(conn, ps, rs);
        }
        return id;
    }

    public static List<Emp> selectAllEmps() throws DataAccessException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Emp> emps = new ArrayList<>();

        try {
            conn = JDBCUtil.getConnection();
            String sql = new StringBuffer()
                    .append(" select e.id,e.name,e.salary,e.dept_id,d.id 'd.id',d.name 'd.name',d.remark ")
                    .append(" from t_emp e ")
                    .append(" left join t_dept d ")
                    .append("   on e.dept_id = d.id")
                    .toString();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            // 通过结果集可以获取到结果集元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            int count = rsmd.getColumnCount();
            System.out.println("结果集中共有:" + count);
            for (int i = 1; i <= count; i++) {
                System.out.println("第" + i + "列的类型:" + rsmd.getColumnTypeName(i));
                System.out.println("第" + i + "列的列名:" + rsmd.getColumnName(i));
                System.out.println("第" + i + "列所在的表:" + rsmd.getTableName(i));
            }
            while (rs.next()) {
                // 此时结果集中的数据涉及到两个对象
                // 先映射两个对应的对象

                // 映射员工相关数据
                // 在映射过程中,不能存在重名的列,否则映射的永远的前面一个
                Emp emp = new Emp();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setDeptId(rs.getInt("dept_id"));

                // 映射部门相关数据
                Dept dept = new Dept();
                dept.setId(rs.getInt("d.id"));
                dept.setName(rs.getString("d.name"));
                dept.setRemark(rs.getString("remark"));


                // 在员工对象中,存在一个属性,该属性是部门对象类型
                // 可以将映射好的部门对象作为员工对象的属性存在
                emp.setDept(dept);

                emps.add(emp);
            }
            return emps;
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
}
