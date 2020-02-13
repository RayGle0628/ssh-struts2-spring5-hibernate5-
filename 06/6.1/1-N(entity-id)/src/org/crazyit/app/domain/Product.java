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
@Table(name="product_inf")
public class Product
{
	// �����ʶ����
	@Id @Column(name="product_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer productId;
	private String name;

	// �޲����Ĺ�����
	public Product(){}
	// ��ʼ��ȫ�����ԵĹ�����
	public Product(String name)
	{
		this.name = name;
	}

	// productId��setter��getter����
	public void setProductId(Integer productId)
	{
		this.productId = productId;
	}
	public Integer getProductId()
	{
		return this.productId;
	}

	// name��setter��getter����
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
}