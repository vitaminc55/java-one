package com.itany.corejava.code13_jdbc;

import com.itany.corejava.util.ParameterUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 石小俊
 * @date 2023年09月13日 9:12
 */
public class Test04_练习 {

    public static void main(String[] args) throws DataAccessException {
//        Student student = new Student("wbs23071001","admin",18);
//        Student student2 = new Student("wbs23071002","alice",20);
//        Student student3 = new Student("wbs23071003","jack",22);
//        Student student4 = new Student("wbs23071004","tom",26);
//        Student student5 = new Student("wbs23071005","lily",19);
//        Student student6 = new Student("wbs23071006","root",28);
//        Student student7 = new Student("wbs23071007","%",28);
//        Student student8 = new Student("wbs23071008","a%",28);
//        insertStudent(student);
//        insertStudent(student2);
//        insertStudent(student3);
//        insertStudent(student4);
//        insertStudent(student5);
//        insertStudent(student6);
//        insertStudent(student7);
//        insertStudent(student8);

//        List<Student> students = selectAll();
//        List<Student> students = selectByAge(20,26);
//        List<Student> students = selectByName("a%");
//        for(Student student : students){
//            System.out.println(student);
//        }
//        System.out.println("---------------------------");
//        Student student = selectByNo("wbs23071001");
//        System.out.println(student);

//        Student student7 = new Student(7,"wbs23071007","%",25);
//        updateByNo(student7);

        deleteByNo("wbs23071008");
    }

    /**
     * 添加学生信息
     * @param student
     */
    public static void insertStudent(Student student) throws DataAccessException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = new StringBuffer()
                    .append(" insert into ")
                    .append(" t_student ")
                    .append("  (no,name,age)")
                    .append(" values ")
                    .append("  (?,?,?)")
                    .toString();
            ps = conn.prepareStatement(sql);
            ps.setString(1, student.getNo());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getAge());
            ps.executeUpdate();
            System.out.println("添加成功");
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

    /**
     * 根据学号删除指定学生信息
     * @param no
     */
    public static void deleteByNo(String no) throws DataAccessException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = new StringBuffer()
                    .append(" delete from t_student ")
                    .append(" where no = ? ")
                    .toString();
            ps = conn.prepareStatement(sql);
            ps.setString(1, no);
            ps.executeUpdate();
            System.out.println("删除成功");
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

    /**
     * 根据学号修改指定学生信息
     * @param student
     */
    public static void updateByNo(Student student) throws DataAccessException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = new StringBuffer()
                    .append(" update t_student ")
                    .append(" set ")
                    .append("   name = ?, ")
                    .append("   age = ? ")
                    .append(" where no = ? ")
                    .toString();
            ps = conn.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getNo());
            ps.executeUpdate();
            System.out.println("修改成功");
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

    /**
     * 查询所有学生信息
     * @return
     */
    public static List<Student> selectAll() throws DataAccessException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Student> students = new ArrayList<>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = new StringBuffer()
                    .append(" select id,no,name,age ")
                    .append(" from t_student ")
                    .toString();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setNo(rs.getString("no"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                students.add(student);
            }
            return students;
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
     * 根据学号查询指定学生信息
     * @param no
     * @return
     * @throws DataAccessException
     */
    public static Student selectByNo(String no) throws DataAccessException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Student student = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = new StringBuffer()
                    .append(" select id,no,name,age ")
                    .append(" from t_student ")
                    .append(" where no = ? ")
                    .toString();
            ps = conn.prepareStatement(sql);
            ps.setString(1, no);
            rs = ps.executeQuery();
            while (rs.next()) {
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setNo(rs.getString("no"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
            }
            return student;
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
     * 根据姓名进行模糊查询
     * @param name
     * @return
     */
    public static List<Student> selectByName(String name) throws DataAccessException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Student> students = new ArrayList<>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = new StringBuffer()
                    .append(" select id,no,name,age ")
                    .append(" from t_student ")
                    .append(" where name like ? ")
                    .append(" escape '/'")
                    .toString();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + ParameterUtil.escapeString(name) + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setNo(rs.getString("no"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                students.add(student);
            }
            return students;
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
     * 根据年龄范围查询指定学生信息
     * @param minAge
     * @param maxAge
     * @return
     */
    public static List<Student> selectByAge(int minAge, int maxAge) throws DataAccessException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Student> students = new ArrayList<>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = new StringBuffer()
                    .append(" select id,no,name,age ")
                    .append(" from t_student ")
                    .append(" where age between ? and ? ")
                    .toString();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, minAge);
            ps.setInt(2, maxAge);
            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setNo(rs.getString("no"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                students.add(student);
            }
            return students;
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
