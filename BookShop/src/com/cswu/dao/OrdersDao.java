package com.cswu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.cswu.entity.Order;
import com.cswu.entity.User;
import com.cswu.utils.C3P0Utils;

/**
 * 订单信息数据操作类
 * @copyright:邓豪杰  0410190211
 *
 */
public class OrdersDao {
	// 插入信息
		public boolean insert(Order order) {
			Connection conn = null;
			Statement stmt = null;

			try {
				conn = C3P0Utils.getConnection();

				stmt = conn.createStatement();
				String sql = "Insert Into  orders (id,user_id,money,pay_state,guest_name,guest_address,guest_phone,order_time,remark) Values("
						+ order.getId()+ "," + order.getUser_id() + "," +order.getMoney()+","+ order.getPay_state()+","+ order.getGuest_name()+","
								+ order.getGuest_address()+","+order.getGuest_phone()+","+ order.getOrder_time()+","+order.getRemark();
				int num = stmt.executeUpdate(sql);

				if (num > 0) {
					return true;
				}
				return false;
			} catch (Exception e) {
				e.printStackTrace();
			}

			return false;
		}

		// 删除信息
		public boolean delete(int id) {
			Connection conn = null;
			Statement stmt = null;

			try {
				conn = C3P0Utils.getConnection();

				stmt = conn.createStatement();
				String sql = "Delete From  orders Where id=" + id;
				int num = stmt.executeUpdate(sql);

				if (num > 0) {
					return true;
				}
				return false;
			} catch (Exception e) {
				e.printStackTrace();
			}

			return false;
			 
		}

		// 更新信息
		public boolean update(Order order) {
			Connection conn = null;
			Statement stmt = null;

			try {
				conn = C3P0Utils.getConnection();

				stmt = conn.createStatement();
				String sql = "Update orders Set id="
						+ order.getId()+ "," + order.getUser_id() + "," +order.getMoney()+","+ order.getPay_state()+","+ order.getGuest_name()+","
						+ order.getGuest_address()+","+order.getGuest_phone()+","+ order.getOrder_time()+","+order.getRemark();
				int num = stmt.executeUpdate(sql);

				if (num > 0) {
					return true;
				}
				return false;
			} catch (Exception e) {
				e.printStackTrace();
			}


			return false;
		}

		// 查询所有信息
		public ArrayList<Order> findAll() {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;

			ArrayList<Order> list = new ArrayList<Order>();
			try {
				conn = C3P0Utils.getConnection();

				stmt = conn.createStatement();
				String sql = "Select * From orders";
				rs = stmt.executeQuery(sql);

				while (rs.next()) {
					Order order = new Order();
					order.setId(rs.getInt("id"));
                    order.setUser_id(rs.getInt("user_id"));
                    order.setMoney(rs.getDouble("money"));
                    order.setPay_state(rs.getString("pay_state"));
                    order.setGuest_name(rs.getString("guest_name"));
                    order.setGuest_address(rs.getString("guest_address"));
                    order.setGuest_phone(rs.getString("guest_phone"));
                    order.setOrder_time(rs.getDate("order_time"));
                    order.setRemark(rs.getString("remark"));
      
					list.add(order);
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}


			return null;
		}

		// 按id查询信息
		public Order find(int id) { 
			
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				conn = C3P0Utils.getConnection();

				stmt = conn.createStatement();
				String sql = "Select * From orders Where id=" + id;
				rs = stmt.executeQuery(sql);

				while (rs.next()) {
					Order order = new Order();
					order.setId(rs.getInt("id"));
                    order.setId(rs.getInt("user_id"));
                    order.setMoney(rs.getInt("money"));
                    order.setPay_state(rs.getString("pay_state"));
                    order.setGuest_name(rs.getString("guest_name"));
                    order.setGuest_address(rs.getString("guest_address"));
                    order.setGuest_phone(rs.getString("guest_phone"));
                    order.setOrder_time(rs.getTime("order_time"));
                    order.setRemark(rs.getString("remark"));

					return order;
				}
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
}
