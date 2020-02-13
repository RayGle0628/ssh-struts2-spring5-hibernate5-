package org.crazyit.app.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
@Table(name="order_inf")
public class Order
{
	// �����ʶ����
	@Id @Column(name="order_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer orderId;
	private Date orderDate;
	// �����ĵĶ�����
	@OneToMany(targetEntity=OrderItem.class, mappedBy="order")
	private Set<OrderItem> items
		= new HashSet<>();

	// �޲����Ĺ�����
	public Order(){}

	// ��ʼ��ȫ����Ա�����Ĺ�����
	public Order(Date orderDate)
	{
		this.orderDate = orderDate;
	}

	// orderId��setter��getter����
	public void setOrderId(Integer orderId)
	{
		this.orderId = orderId;
	}
	public Integer getOrderId()
	{
		return this.orderId;
	}

	// orderDate��setter��getter����
	public void setOrderDate(Date orderDate)
	{
		this.orderDate = orderDate;
	}
	public Date getOrderDate()
	{
		return this.orderDate;
	}

	// items��setter��getter����
	public void setItems(Set<OrderItem> items)
	{
		this.items = items;
	}
	public Set<OrderItem> getItems()
	{
		return this.items;
	}
}