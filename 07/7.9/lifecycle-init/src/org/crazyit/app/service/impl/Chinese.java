package org.crazyit.app.service.impl;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.*;
import org.springframework.context.*;
import org.crazyit.app.service.*;
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
public class Chinese implements Person , InitializingBean
	, BeanNameAware, ApplicationContextAware
{
	private Axe axe;
	public void setBeanName(String beanName)
	{
		System.out.println("===setBeanName===");
	}
	public void setApplicationContext(ApplicationContext ctx)
	{
		System.out.println("===setApplicationContext===");
	}
	public Chinese()
	{
		System.out.println("Springʵ��������bean��Chineseʵ��...");
	}
	// axe��setter����
	public void setAxe(Axe axe)
	{
		System.out.println("Spring����setAxe()ִ������ע��...");
		this.axe = axe;
	}
	public void useAxe()
	{
		System.out.println(axe.chop());
	}
	// �����õĳ�ʼ������
	public void init()
	{
		System.out.println("����ִ�г�ʼ������ init...");
	}
	// ʵ��InitializingBean�ӿڱ���ʵ�ֵķ���
	public void afterPropertiesSet() throws Exception
	{
		System.out.println("����ִ�г�ʼ������ afterPropertiesSet...");
	}
}