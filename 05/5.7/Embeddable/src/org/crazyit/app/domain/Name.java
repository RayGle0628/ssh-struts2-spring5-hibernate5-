package org.crazyit.app.domain;

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
	@Parent      // ��
	private Person owner;

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

}