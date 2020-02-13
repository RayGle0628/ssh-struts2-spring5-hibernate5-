package org.crazyit.app.domain;

import javax.persistence.*;
/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2018, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
@Entity
@Table(name="order_item_inf")
public class OrderItem
	implements java.io.Serializable
{
	// ����3�����Խ���Ϊ��������
	// ���������Orderʵ��
	@ManyToOne(targetEntity=Order.class)
	// ӳ����Ϊorder_id������У�����order_inf��order_id������
	@JoinColumn(name="order_id" , referencedColumnName="order_id")
	@Id
	private Order order;
	// ���������Productʵ��
	@ManyToOne(targetEntity=Product.class)
	// ӳ����Ϊproduct_id������У�����product_inf��product_id������
	@JoinColumn(name="product_id" , referencedColumnName="product_id")
	@Id
	private Product product;
	// �ö�������Ĳ�Ʒ����
	@Id
	private int count;

	// �޲����Ĺ�����
	public OrderItem(){ }
	// ��ʼ��ȫ����Ա�����Ĺ�����
	public OrderItem(Order order , Product product , int count)
	{
		this.order = order;
		this.product = product;
		this.count = count;
	}

	// order��setter��getter����
	public void setOrder(Order order)
	{
		this.order = order;
	}
	public Order getOrder()
	{
		return this.order;
	}

	// product��setter��getter����
	public void setProduct(Product product)
	{
		this.product = product;
	}
	public Product getProduct()
	{
		return this.product;
	}

	// count��setter��getter����
	public void setCount(int count)
	{
		this.count = count;
	}
	public int getCount()
	{
		return this.count;
	}
	// ��дequals()����������product��order��count�ж��Ƿ����
	public boolean equals(Object obj)
	{
		if(this == obj)
		{
			return true;
		}
		if(obj != null && obj.getClass() == OrderItem.class)
		{
			OrderItem target = (OrderItem)obj;
			return this.order.equals(target.getOrder())
				&& this.product.equals(target.getProduct())
				&& this.count == target.getCount();
		}
		return false;
	}
	// ��дhashCode()����������product��order��count����hashCodeֵ
	public int hashCode()
	{
		return (this.product == null ? 0 : this.product.hashCode()) * 31 * 31
			+ (this.order == null ? 0 : this.order.hashCode()) * 31
			+ this.count;
	}
}