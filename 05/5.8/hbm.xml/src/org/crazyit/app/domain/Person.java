package org.crazyit.app.domain;

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
public class Person
{
	// ʹ��Name�����Ϊ��������
	private Name name;
	// ��ͨ����
	private String email;
	// ������ԣ��������ӵ�еĳ���
	private Cat pet;

	// �޲����Ĺ�����
	public Person()
	{
	}
	// ��ʼ��ȫ����Ա�����Ĺ�����
	public Person(Name name , String email , Cat pet)
	{
		this.name = name;
		this.email = email;
		this.pet = pet;
	}

	// name��setter��getter����
	public void setName(Name name)
	{
		this.name = name;
	}
	public Name getName()
	{
		return this.name;
	}

	// email��setter��getter����
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getEmail()
	{
		return this.email;
	}

	// pet��setter��getter����
	public void setPet(Cat pet)
	{
		this.pet = pet;
	}
	public Cat getPet()
	{
		return this.pet;
	}
}