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
@Table(name = "person_inf")
public class Person
{
	// �����ʶ����
	@Id @Column(name = "person_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	// ����Personʵ����name��Ա����
	private String name;
	// ����Personʵ����age��Ա����
	private int age;
	// �����Personʵ�������MyEventʵ��
	@ManyToOne(targetEntity=MyEvent.class)
	@JoinColumn(name="event_id" , referencedColumnName="event_id")
	private MyEvent myEvent;
	// ����һ����������
	// �������ԣ������ö��������ѧУ
	@ElementCollection(targetClass=String.class)
	@CollectionTable(name="person_email",
		joinColumns=@JoinColumn(name="person_id" , nullable=false))
	@Column(name="email_detail" , nullable=false)
	private Set<String> emails
		= new HashSet<>();

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

	// myEvent��setter��getter����
	public void setMyEvent(MyEvent myEvent)
	{
		this.myEvent = myEvent;
	}
	public MyEvent getMyEvent()
	{
		return this.myEvent;
	}

	// emails��setter��getter����
	public void setEmails(Set<String> emails)
	{
		this.emails = emails;
	}
	public Set<String> getEmails()
	{
		return this.emails;
	}

}