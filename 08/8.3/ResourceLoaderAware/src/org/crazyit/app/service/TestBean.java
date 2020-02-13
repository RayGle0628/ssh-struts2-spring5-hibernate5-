package org.crazyit.app.service;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

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
public class TestBean implements ResourceLoaderAware
{
	private ResourceLoader rd;
	// ʵ��ResourceLoaderAware�ӿڱ���ʵ�ֵķ���
	// ����Ѹ�Bean������Spring�����У��÷���������Spring�����������
	// Spring�������ø÷���ʱ��Spring�Ὣ������Ϊ���������÷���
	public void setResourceLoader(ResourceLoader resourceLoader)
	{
		System.out.println("--ִ��setResourceLoader ����--");
		this.rd = resourceLoader;
	}
	// ����ResourceLoader���������
	public ResourceLoader getResourceLoader()
	{
		return rd;
	}
}