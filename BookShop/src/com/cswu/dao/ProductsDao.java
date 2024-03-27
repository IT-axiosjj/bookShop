package com.cswu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.cswu.entity.Item;
import com.cswu.entity.Product;
import com.cswu.entity.User;
import com.cswu.utils.C3P0Utils;

import sun.security.action.GetIntegerAction;

/**
 * 商品信息数据操作类
 * @copyright:邓豪杰  0410190211
 *
 */
public class ProductsDao {
	// 插入信息
		public boolean insert(Product product) {
			Connection conn = null;
			Statement stmt = null;

			try {
				conn = C3P0Utils.getConnection();

				stmt = conn.createStatement();
				String sql = "Insert Into  products (name,price,category,pnum,description) Values('"
				+product.getName()+"','"+product.getPrice()+"','"+product.getCategory()+"','"+product.getPnum()+"','"
				+product.getDescription()+"')";
				
						
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
				String sql = "Delete From  products Where id=" + id;
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
		public boolean update(Product product) {
			Connection conn = null;
			Statement stmt = null;

			try {
				conn = C3P0Utils.getConnection();

				stmt = conn.createStatement();
				String sql = "Update products Set name = '"+product.getName()+"',price='"+product.getPrice()+"',category='"+product.getCategory()
				+"',pnum='"+product.getPnum()+"',imgurl='"+product.getImgurl()+"',description='"+product.getDescription()+"',remark='"
				+product.getRemark()+"' Where id =" +product.getId();
						 
						
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
		public ArrayList<Product> findAll() {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;

			ArrayList<Product> list = new ArrayList<Product>();
			try {
				conn = C3P0Utils.getConnection();

				stmt = conn.createStatement();
				String sql = "Select * From products";
				rs = stmt.executeQuery(sql);

				while (rs.next()) {
					Product product  = new Product();
					product.setId(rs.getInt("id"));
					product.setName(rs.getString("name"));
					product.setPrice(rs.getInt("price"));
					product.setCategory(rs.getString("category"));
					product.setPnum(rs.getInt("pnum"));
					product.setImgurl(rs.getString("imgurl"));
					product.setDescription(rs.getString("description"));
					product.setRemark(rs.getString("remark"));
					
					list.add(product);
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}

			return null;
		}

		// 按id查询信息
		public Product find(int id) {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				conn = C3P0Utils.getConnection();

				stmt = conn.createStatement();
				String sql = "Select * From products Where id="  + id;
				rs = stmt.executeQuery(sql);

				while (rs.next()) {
					Product product  = new Product();
					product.setId(rs.getInt("id"));
					product.setName(rs.getString("name"));
					product.setPrice(rs.getInt("price")); 
					product.setCategory(rs.getString("category"));
					product.setPnum(rs.getInt("pnum"));
					product.setImgurl(rs.getString("imgurl"));
					product.setDescription(rs.getString("description"));
					product.setRemark(rs.getString("remark"));
					return product;
				}
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			}

			 

			return null;
		}
		public Product findByName(String name) {

			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				conn = C3P0Utils.getConnection();

				stmt = conn.createStatement();
				String sql = "Select * From products Where name='" + name+"'";
				rs = stmt.executeQuery(sql);

				while (rs.next()) {
					Product product = new Product();
					product.setId(rs.getInt("id"));
					product.setName(rs.getString("name"));
					product.setPrice(rs.getInt("price"));
					product.setCategory(rs.getString("category"));
					product.setPnum(rs.getInt("pnum"));
					product.setImgurl(rs.getString("imgurl"));
					product.setDescription(rs.getString("description"));
					product.setRemark(rs.getString("remark"));
					return product;
				}
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			}

			return null;
		}

}
