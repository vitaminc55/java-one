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
 * @date 2023年09月14日 9:35
 */
public class Test11_多表练习 {


    public static void main(String[] args) throws SQLException, DataAccessException {
//        ClassBean classBean = new ClassBean("wbs23072","计算机科学与技术");
//        StudentBean student = new StudentBean("wbs23071005","_",22);
//        StudentBean student2 = new StudentBean("wbs23071006","%",21);
//        StudentBean student3 = new StudentBean("wbs23071007","a%",20);
//        StudentBean student4 = new StudentBean("wbs23071008","a_",23);
//        List<StudentBean> students = new ArrayList<>();
//        students.add(student);
//        students.add(student2);
//        students.add(student3);
//        students.add(student4);
//        insertClassAndStudents(classBean,students);

//        ClassBean classBean = selectByClassNo("wbs23071");
//        System.out.println(classBean);

//        List<StudentBean> students = selectAllStudents();
        List<StudentBean> students = selectByName("a_");
        for (StudentBean student : students) {
            System.out.println(student);
        }
    }


    /**
     * 保存班级以及该班中的所有学生信息
     * @param classBean
     * @param students
     */
    public static void insertClassAndStudents(ClassBean classBean, List<StudentBean> students) throws SQLException, DataAccessException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer id = null;

        try {
            conn = JDBCUtil.getConnection();
            // 开启事务
            conn.setAutoCommit(false);
            // 保存班级信息并返回主键
            String sql = new StringBuffer()
                    .append(" insert into ")
                    .append(" t_class ")
                    .append("   (no,major)")
                    .append(" values ")
                    .append("   (?,?)")
                    .toString();
            ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, classBean.getNo());
            ps.setString(2, classBean.getMajor());
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            while (rs.next()) {
                id = rs.getInt(1);
            }

            // 将返回的主键值设置给参数classBean
            classBean.setId(id);

            // 添加学生信息
            sql = new StringBuffer()
                    .append(" insert into ")
                    .append(" t_student ")
                    .append("   (no,name,age,class_id)")
                    .append(" values ")
                    .append("   (?,?,?,?)")
                    .toString();
            // 获取操作学生时的状态集
            ps = conn.prepareStatement(sql);
            for (StudentBean student : students) {
                // 将classBean对象赋值给StudentBean的属性中
                // 外键字段class_id对应的是对象属性的主键值
                // 主键值在上面已经赋值给对应的classBean了
                student.setClassBean(classBean);
                ps.setString(1, student.getNo());
                ps.setString(2, student.getName());
                ps.setInt(3, student.getAge());
                ps.setInt(4, student.getClassBean().getId());
                // 执行DML操作,每执行一次,添加一名学生
                // ps.executeUpdate();
                // 添加到缓冲区进行批量添加
                ps.addBatch();
            }
            ps.executeBatch();
            // 提交事务
            conn.commit();
        } catch (DataAccessException e) {
            e.printStackTrace();
            conn.rollback();
            throw e;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            JDBCUtil.close(conn, ps, rs);
        }
    }

    /**
     * 根据班级号查询指定班级以及该班级中所有学生信息
     * @param no
     * @return
     */
    public static ClassBean selectByClassNo(String no) throws DataAccessException, SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ClassBean classBean = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = new StringBuffer()
                    .append(" select c.id,c.no,c.major,s.id 's.id',s.no 's.no',s.name,s.age ")
                    .append(" from t_class c ")
                    .append(" left join t_student s ")
                    .append(" 	on c.id = s.class_id ")
                    .append(" where c.no = ? ")
                    .toString();
            ps = conn.prepareStatement(sql);
            ps.setString(1, no);
            rs = ps.executeQuery();

            while (rs.next()) {
                if (classBean == null) {
                    classBean = new ClassBean();
                    classBean.setId(rs.getInt("id"));
                    classBean.setNo(rs.getString("no"));
                    classBean.setMajor(rs.getString("major"));
                }

                StudentBean student = new StudentBean();
                student.setId(rs.getInt("s.id"));
                student.setNo(rs.getString("s.no"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                classBean.addStudent(student);
            }
            return classBean;
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw e;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            JDBCUtil.close(conn, ps, rs);
        }
    }

    /**
     * 查询所有学生以及其所属班级信息
     * @return
     */
    public static List<StudentBean> selectAllStudents() throws DataAccessException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<StudentBean> students = new ArrayList<>();

        try {
            conn = JDBCUtil.getConnection();
            String sql = new StringBuffer()
                    .append(" select s.id,s.no,s.name,s.age,c.id 'c.id',c.no 'c.no',c.major ")
                    .append(" from t_student s ")
                    .append(" left join t_class c ")
                    .append(" 	on s.class_id = c.id ")
                    .toString();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                StudentBean student = new StudentBean();
                student.setId(rs.getInt("id"));
                student.setNo(rs.getString("no"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));

                ClassBean classBean = new ClassBean();
                classBean.setId(rs.getInt("c.id"));
                classBean.setNo(rs.getString("c.no"));
                classBean.setMajor(rs.getString("major"));
                student.setClassBean(classBean);

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
     * 根据学生姓名模糊查询学生以及学生所属班级信息
     * @return
     */
    public static List<StudentBean> selectByName(String name) throws DataAccessException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<StudentBean> students = new ArrayList<>();

        try {
            conn = JDBCUtil.getConnection();
            String sql = new StringBuffer()
                    .append(" select s.id,s.no,s.name,s.age,c.id 'c.id',c.no 'c.no',c.major ")
                    .append(" from t_student s ")
                    .append(" left join t_class c ")
                    .append(" 	on s.class_id = c.id ")
                    .append(" where s.name like ? ")
                    .append(" escape '/' ")
                    .toString();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + ParameterUtil.escapeString(name) + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                StudentBean student = new StudentBean();
                student.setId(rs.getInt("id"));
                student.setNo(rs.getString("no"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));

                ClassBean classBean = new ClassBean();
                classBean.setId(rs.getInt("c.id"));
                classBean.setNo(rs.getString("c.no"));
                classBean.setMajor(rs.getString("major"));
                student.setClassBean(classBean);

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
