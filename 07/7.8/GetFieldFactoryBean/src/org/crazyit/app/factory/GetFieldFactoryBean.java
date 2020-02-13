package org.crazyit.app.factory;

import java.lang.reflect.*;
import org.springframework.beans.factory.FactoryBean;
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
public class GetFieldFactoryBean implements FactoryBean<Object>
{
	private String targetClass;
	private String targetField;
	// targetClass��setter����
	public void setTargetClass(String targetClass)
	{
		this.targetClass = targetClass;
	}

	// targetField��setter����
	public void setTargetField(String targetField)
	{
		this.targetField = targetField;
	}
	// ���ع���Bean�������Ĳ�Ʒ
	public Object getObject() throws Exception
	{
		Class<?> clazz = Class.forName(targetClass);
		Field field = clazz.getField(targetField);
		return field.get(null);
	}
	// ��ȡ����Bean�������Ĳ�Ʒ������
	public Class<? extends Object> getObjectType()
	{
		return Object.class;
	}
	// ���ظù���Bean�����ɵĲ�Ʒ�Ƿ�Ϊ����
	public boolean isSingleton()
	{
		return false;
	}
}