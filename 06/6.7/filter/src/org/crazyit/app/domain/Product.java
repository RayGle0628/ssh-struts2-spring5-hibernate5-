package org.crazyit.app.domain;

import javax.persistence.*;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.Filters;


import java.util.*;
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
@FilterDefs({
// ������ΪeffectiveDate�Ĺ��������ù�����֧��1��date���͵Ĳ���
@FilterDef(name="effectiveDate"
	, parameters={@ParamDef(name="asOfDate" , type="date")}),
// ������Ϊcategory�Ĺ��������ù�����֧��1��int���͵Ĳ���
@FilterDef(name="category"
	, parameters={@ParamDef(name="catId" , type="int")})
})
@Entity
@Table(name="product_inf")
// ʹ��effectiveDate��������Productʵ��ʹ�����ݹ���
@Filter(name="effectiveDate"
	, condition=":asOfDate BETWEEN eff_start_date AND eff_end_date")

public class Product
{
	@Id @Column(name="product_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	// �����Ʒ��
	@Column(name="product_name")
	private String name;
	// �����Ʊ�����ԣ������Կɱ�ʶ�ò�Ʒ
	@Column(name="stock_number")
	private int stockNumber;
	// ������Ч��ʼ��ʱ��
	@Column(name="eff_start_date")
	private Date effectiveStartDate;
	// ����ʧЧʱ��
	@Column(name="eff_end_date")
	private Date effectiveEndDate;
	// ����ò�Ʒ����������
	@ManyToMany(targetEntity=Category.class)
	@JoinTable(name="product_category"
		, joinColumns=@JoinColumn(name="product_id")
		, inverseJoinColumns=@JoinColumn(name="category_id"))
	// �Ըù���ʵ���ץȡʹ��effectiveDate��category�������ݹ���
	@Filters({
		@Filter(name="effectiveDate"
			, condition=":asOfDate BETWEEN eff_start_date and eff_end_date"),
		@Filter(name="category"
			, condition="category_id = :catId")
	})
	private Set<Category> categories
		= new HashSet<>();

	// �޲����Ĺ�����
	public Product()
	{
	}
	// ��ʼ��ȫ����Ա�����Ĺ�����
	public Product(String name , int stockNumber
		, Date effectiveStartDate , Date effectiveEndDate)
	{
		this.name = name;
		this.stockNumber = stockNumber;
		this.effectiveStartDate = effectiveStartDate;
		this.effectiveEndDate = effectiveEndDate;
	}

	// id��setter��getter����
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return this.id;
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

	// stockNumber��setter��getter����
	public void setStockNumber(int stockNumber)
	{
		this.stockNumber = stockNumber;
	}
	public int getStockNumber()
	{
		return this.stockNumber;
	}

	// effectiveStartDate��setter��getter����
	public void setEffectiveStartDate(Date effectiveStartDate)
	{
		this.effectiveStartDate = effectiveStartDate;
	}
	public Date getEffectiveStartDate()
	{
		return this.effectiveStartDate;
	}

	// effectiveEndDate��setter��getter����
	public void setEffectiveEndDate(Date effectiveEndDate)
	{
		this.effectiveEndDate = effectiveEndDate;
	}
	public Date getEffectiveEndDate()
	{
		return this.effectiveEndDate;
	}

	// categories��setter��getter����
	public void setCategories(Set<Category> categories)
	{
		this.categories = categories;
	}
	public Set<Category> getCategories()
	{
		return this.categories;
	}

	// ����stockNumber����дhashCode()����
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj != null && obj.getClass() == Product.class)
		{
			Product target = (Product)obj;
			return target.getStockNumber() == stockNumber;
		}
		return false;
	}

	// ����stockNumber����дhashCode()����
	public int hashCode()
	{
		return stockNumber;
	}

	// Ϊ��Ʒ���һ������������
	public void addCategory(Category category)
	{
		if ( category == null )
		{
			return;
		}
		this.categories.add(category);
		category.getProducts().add(this);
	}
}