package com.cswu.entity;

/**
 * 订单项目信息
 * 
 *@copyright:邓豪杰 0410190211
 */
public class Item {
	
	private int order_id;
	private int product_id;
	private int buy_num;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getBuy_num() {
		return buy_num;
	}
	public void setBuy_num(int buy_num) {
		this.buy_num = buy_num;
	}

	
}
