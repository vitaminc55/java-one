package com.itany.shop.dao.impl;

import com.itany.shop.dao.OrderDao;
import com.itany.shop.dao.ProductDao;
import com.itany.shop.entity.Item;
import com.itany.shop.entity.Order;
import com.itany.shop.entity.Product;
import com.itany.shop.entity.User;
import com.itany.shop.exception.DataAccessException;
import com.itany.shop.factory.ObjectFactory;
import com.itany.shop.rowmapper.OrderRowMapper;
import com.itany.shop.util.JDBCTemplate;
import com.itany.shop.util.JDBCUtil;
import com.itany.shop.util.KeyHolder;
import com.itany.shop.util.PreparedStatementCreator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


/**
 * @author 黄鹏程
 * @date 2023年09月21日14:05
 */
public class OrderDaoImpl implements OrderDao {
    JDBCTemplate jdbcTemplate= (JDBCTemplate) ObjectFactory.getObject("jdbc");
    ProductDao productDao= (ProductDao) ObjectFactory.getObject("productDao");
    @Override
    public Long insertOrderReturnPrimaryKey(Order order) {
        KeyHolder keyHolder=new KeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws Exception {
                String sql=new StringBuffer()
                        .append(" insert into ")
                        .append(" t_order")
                        .append("   (no,price,user_id)")
                        .append(" values ")
                        .append("   (?,?,?)")
                        .toString();
                PreparedStatement ps=conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1,order.getNo());
                ps.setDouble(2,order.getPrice());
                ps.setInt(3,order.getUser().getId());
                return ps;
            }
        },keyHolder);
        return (Long) keyHolder.getKey();

    }

    @Override
    public List<Order> selectAllOrder(User user) {
        String sql=new StringBuffer()
                .append(" select id,no,price,user_id ")
                .append(" from t_order ")
                .append(" where user_id = ? ")
                .toString();
        List<Order> orders = jdbcTemplate.query(sql, new OrderRowMapper(),user.getId());
        return orders;
    }

    @Override
    public Order selectByOrderId(Long id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Order order=null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = new StringBuffer()
                    .append(" select u1.username,u1.phone,p1.id,p1.name,i1.num,i1.price,o1.price 'o1.price' ")
                    .append(" from t_order o1 ")
                    .append(" left join t_item i1 ")
                    .append("     on o1.id=i1.order_id ")
                    .append(" left join t_user u1 ")
                    .append("     on o1.user_id=u1.id ")
                    .append(" left join t_product p1 ")
                    .append("     on i1.product_id=p1.id ")
                    .append(" where o1.id= ? ")
                    .toString();
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (order == null) {
                    order = new Order();
                    order.setPrice(rs.getDouble("o1.price"));
                    User user=new User();
                    user.setUsername(rs.getString("username"));
                    user.setPhone(rs.getString("phone"));
                    order.setUser(user);
                }
                // 多方映射
                Item item=new Item();
                item.setNum(rs.getInt("num"));
                item.setPrice(rs.getDouble("price"));
                Product product=new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                item.setProduct(product);
                order.addItem(item);
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw e;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("数据访问失败");
        }
        return order;
    }
}
