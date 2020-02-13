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

// �˿���̳���Person��
@Entity
// ָ��Customerʵ���Ӧ�ļ�¼�ڱ�����е�ֵΪ"�˿�"
@DiscriminatorValue("�˿�")
@Table(name="customer_inf")
public class Customer extends Person
{
	// �˿͵�������Ϣ
	private String comments;
	// ����͸ù˿ͱ��ֹ�����Employee����ʵ��
	@ManyToOne(cascade=CascadeType.ALL
		,targetEntity=Employee.class)
	@JoinColumn(name="employee_id", nullable=true)
	private Employee employee;
	// �޲����Ĺ�����
	public Customer()
	{
	}
	// ��ʼ��comments��Ա�����Ĺ�����
	public Customer(String comments)
	{
		this.comments = comments;
	}

	// comments��setter��getter����
	public void setComments(String comments)
	{
		this.comments = comments;
	}
	public String getComments()
	{
		return this.comments;
	}

	// employee��setter��getter����
	public void setEmployee(Employee employee)
	{
		this.employee = employee;
	}
	public Employee getEmployee()
	{
		return this.employee;
	}
}