package org.crazyit.app.domain;

import java.util.List;
import java.util.ArrayList;

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
@Table(name="person_inf")
public class Person
{
	@Id @Column(name="person_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	// ��ʶ����
	private Integer id;
	private String name;
	private int age;
	// �������ԣ������ö��������ѧУ
	@ElementCollection(targetClass=String.class)
	// ӳ�䱣�漯�����Եı�
	@CollectionTable(name="school_inf", // ָ������Ϊschool_inf
		joinColumns=@JoinColumn(name="person_id" , nullable=false))
	// ָ�����漯��Ԫ�ص���Ϊ school_name
	@Column(name="school_name")
	// ӳ�伯��Ԫ����������
	@OrderColumn(name="array_order")
	private String[] schools;

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

	// age��setter��getter����
	public void setAge(int age)
	{
		this.age = age;
	}
	public int getAge()
	{
		return this.age;
	}

	// schools��setter��getter����
	public void setSchools(String[] schools)
	{
		this.schools = schools;
	}
	public String[] getSchools()
	{
		return this.schools;
	}
}