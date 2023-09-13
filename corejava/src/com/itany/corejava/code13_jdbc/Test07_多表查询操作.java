package com.itany.corejava.code13_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 石小俊
 * @date 2023年09月13日 13:58
 */
public class Test07_多表查询操作 {

    public static void main(String[] args) throws DataAccessException {
//        List<Emp> emps = selectAll();
//        for (Emp emp : emps) {
//            System.out.println(emp);
//        }
        Dept dept = selectByDeptId(1);
        System.out.println(dept);
    }

    /**
     * 多对一查询
     * 查询所有员工以及员工所属的部门信息
     * @return
     */
    public static List<Emp> selectAll() throws DataAccessException {
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

    /**
     * 一对多
     * 根据部门编号查询部门以及该部门下的所有员工信息
     * @param id
     * @return
     */
    public static Dept selectByDeptId(Integer id) throws DataAccessException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Dept dept = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = new StringBuffer()
                    .append(" select d.id,d.name,d.remark,e.id 'e.id',e.name 'e.name',e.salary,e.dept_id ")
                    .append(" from t_dept d ")
                    .append(" left join t_emp e ")
                    .append(" on d.id = e.dept_id ")
                    .append(" where d.id = ? ")
                    .toString();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            // 在映射时,每一行数据映射一次
            while (rs.next()) {
                // 一对多映射的时候,一方数据只能映射一次,多方数据可以映射多次
                // 如果一方也映射多次,会存在数据覆盖问题

                // 一方映射
                // 当一方数据尚未映射的时候,此时的值为null
                // 当一方数据映射过了之后,其值不再为null
                // 即:当一方数据值为null时进行映射
                if (dept == null) {
                    dept = new Dept();
                    dept.setId(rs.getInt("id"));
                    dept.setName(rs.getString("name"));
                    dept.setRemark(rs.getString("remark"));
                }

                // 多方映射
                Emp emp = new Emp();
                emp.setId(rs.getInt("e.id"));
                emp.setName(rs.getString("e.name"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setDeptId(rs.getInt("dept_id"));

                dept.addEmp(emp);
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw e;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("数据访问失败");
        } finally {
            JDBCUtil.close(conn, ps, rs);
        }
        return dept;
    }

}
