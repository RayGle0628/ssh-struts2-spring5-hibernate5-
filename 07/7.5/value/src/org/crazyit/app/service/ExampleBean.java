package org.crazyit.app.service;

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
public class ExampleBean
{
	// ����һ��int�͵ĳ�Ա����
	private int integerField;
	// ����һ��double�͵ĳ�Ա����
	private double doubleField;

	// integerField��setter��getter����
	public void setIntegerField(int integerField)
	{
		this.integerField = integerField;
	}
	public int getIntegerField()
	{
		return this.integerField;
	}

	// doubleField��setter��getter����
	public void setDoubleField(double doubleField)
	{
		this.doubleField = doubleField;
	}
	public double getDoubleField()
	{
		return this.doubleField;
	}
}