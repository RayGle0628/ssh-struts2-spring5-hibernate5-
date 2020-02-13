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

public class Name
	implements java.io.Serializable
{
	private String first;
	private String last;
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

	// ��дequals()����������first��last�����ж�
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj != null && obj.getClass() == Name.class)
		{
			Name target = (Name)obj;
			return target.getFirst().equals(first)
				&& target.getLast().equals(last);
		}
		return false;
	}

	// ��дhashCode()����������first��last����hashCodeֵ
	public int hashCode()
	{
		return first.hashCode() + last.hashCode() * 31;
	}
}