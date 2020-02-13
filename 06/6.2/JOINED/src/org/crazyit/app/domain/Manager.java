package org.crazyit.app.domain;

import javax.persistence.*;

import java.util.Set;
import java.util.HashSet;

/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2018, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
// ������̳�Ա����
@Entity
@Table(name="manager_inf")
public class  Manager extends Employee
{
	// ���徭���Ͻ���ŵ�����
	private String department;
	// ����͸þ����ֹ�����Employee����ʵ��
	@OneToMany(cascade=CascadeType.ALL
		, mappedBy="manager" , targetEntity=Employee.class)
	private Set<Employee> employees
		= new HashSet<>();
	// �޲����Ĺ�����
	public Manager()
	{
	}
	// ��ʼ��ȫ����Ա�����Ĺ�����
	public Manager(String department)
	{
		this.department = department;
	}

	// department��setter��getter����
	public void setDepartment(String department)
	{
		this.department = department;
	}
	public String getDepartment()
	{
		return this.department;
	}

	// employees��setter��getter����
	public void setEmployees(Set<Employee> employees)
	{
		this.employees = employees;
	}
	public Set<Employee> getEmployees()
	{
		return this.employees;
	}
}