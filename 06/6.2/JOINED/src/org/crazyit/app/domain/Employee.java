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

// Ա����̳���Person��
@Entity
@Table(name="employee_inf")
public class Employee extends Person
{
	// �����Ա��ְλ�ĳ�Ա����
	private String title;
	// �����Ա�����ʵĳ�Ա����
	private double salary;
	// ����͸�Ա�����ֹ�����Customer����ʵ��
	@OneToMany(cascade=CascadeType.ALL
		, mappedBy="employee" , targetEntity=Customer.class)
	private Set<Customer> customers
		= new HashSet<>();
	// ����͸�Ա�����ֹ�����Manager����ʵ��
	@ManyToOne(cascade=CascadeType.ALL
		,targetEntity=Manager.class)
	@JoinColumn(name="manager_id", nullable=true)
	private Manager manager;

	// �޲����Ĺ�����
	public Employee()
	{
	}
	// ��ʼ��ȫ����Ա�����Ĺ�����
	public Employee(String title , double salary)
	{
		this.title = title;
		this.salary = salary;
	}

	// title��setter��getter����
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getTitle()
	{
		return this.title;
	}

	// salary��setter��getter����
	public void setSalary(double salary)
	{
		this.salary = salary;
	}
	public double getSalary()
	{
		return this.salary;
	}

	// customers��setter��getter����
	public void setCustomers(Set<Customer> customers)
	{
		this.customers = customers;
	}
	public Set<Customer> getCustomers()
	{
		return this.customers;
	}

	// manager��setter��getter����
	public void setManager(Manager manager)
	{
		this.manager = manager;
	}
	public Manager getManager()
	{
		return this.manager;
	}
}