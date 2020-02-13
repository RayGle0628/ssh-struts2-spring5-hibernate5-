package org.crazyit.app.domain;

import java.util.*;

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
	implements java.io.Serializable
{
	// ����first��Ա��������Ϊ��ʶ���Եĳ�Ա
	@Id
	private String first;
	// ����last��Ա��������Ϊ��ʶ���Եĳ�Ա
	@Id
	private String last;
	private int age;
	// ��¼��Personʵ�����������Addressʵ��
	@OneToMany(targetEntity=Address.class, mappedBy="person"
		, cascade=CascadeType.ALL)
	private Set<Address> addresses
		= new HashSet<>();

	// first��setter��getter����
	public void setFirst(String first)
	{
		this.first = first;
	}
	public String getFirst()
	{
		return this.first;
	}

	// last��setter��getter����
	public void setLast(String last)
	{
		this.last = last;
	}
	public String getLast()
	{
		return this.last;
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

	// addresses��setter��getter����
	public void setAddresses(Set<Address> addresses)
	{
		this.addresses = addresses;
	}
	public Set<Address> getAddresses()
	{
		return this.addresses;
	}

	// ��дequals()����������first��last�����ж�
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj != null && obj.getClass() == Person.class)
		{
			Person target = (Person)obj;
			return target.getFirst().equals(this.first)
				&& target.getLast().equals(this.last);
		}
		return false;
	}

	// ��дhashCode()����������first��last����hashCodeֵ
	public int hashCode()
	{
		return getFirst().hashCode() * 31
			+ getLast().hashCode();
	}
}