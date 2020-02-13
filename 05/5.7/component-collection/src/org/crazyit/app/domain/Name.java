package org.crazyit.app.domain;

import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.Parent;
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
@Embeddable
public class Name
{
	// ����first��Ա����
	@Column(name="person_firstname")
	private String first;
	// ����last��Ա����
	@Column(name="person_lastname")
	private String last;
	// ����ӵ�и�Name��Person����
	@Parent
	private Person owner;
	// �������ԣ������ö�������Ŀ��Գɼ�
	@ElementCollection(targetClass=Integer.class)
	@CollectionTable(name="power_inf",
		joinColumns=@JoinColumn(name="person_name_id" , nullable=false))
	@MapKeyColumn(name="name_aspect")
	@Column(name="name_power" , nullable=false)
	@MapKeyClass(String.class)
	private Map<String , Integer> power
		= new HashMap<>();

	// �޲����Ĺ�����
	public Name()
	{
	}
	// ��ʼ��ȫ����Ա�����Ĺ�����
	public Name(String first , String last)
	{
		this.first = first;
		this.last = last;
	}

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

	// owner��setter��getter����
	public void setOwner(Person owner)
	{
		this.owner = owner;
	}
	public Person getOwner()
	{
		return this.owner;
	}

	// power��setter��getter����
	public void setPower(Map<String ,Integer> power)
	{
		this.power = power;
	}
	public Map<String ,Integer> getPower()
	{
		return this.power;
	}
}