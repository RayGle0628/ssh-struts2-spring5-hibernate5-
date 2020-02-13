package org.crazyit.app.service;

import org.springframework.context.*;
import org.springframework.beans.BeansException;
import java.util.Locale;
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

public class Person implements ApplicationContextAware
{
	// �ó�Ա�������������ڵ�ApplicationContext����
	private ApplicationContext ctx;

	/* Spring������������������Bean���������ĳ��Beanʵ����ApplicationContextAware�ӿڣ�
	Spring�������ڴ�����Bean֮���Զ����ø÷��������ø÷���ʱ��
	�Ὣ����������Ϊ���������÷�����*/
	public void setApplicationContext(ApplicationContext ctx)
		throws BeansException
	{
		this.ctx = ctx;
	}
	public void sayHi(String name)
	{
		System.out.println(ctx.getMessage("hello" , new String[]{name}
			, Locale.getDefault(Locale.Category.FORMAT)));
	}
}
