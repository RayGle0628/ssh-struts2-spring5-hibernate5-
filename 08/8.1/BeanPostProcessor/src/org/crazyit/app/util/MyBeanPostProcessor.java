package org.crazyit.app.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.*;
import org.crazyit.app.service.*;
import org.crazyit.app.service.impl.*;
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
public class MyBeanPostProcessor
	implements BeanPostProcessor
{
	/**
	 * �������е�Beanʵ�����к���
	 * @param bean ��Ҫ���к����ԭBeanʵ��
	 * @param beanName ��Ҫ���к����Bean������id
	 * @return ���غ�����ɺ��Bean
	 */
	public Object postProcessBeforeInitialization
		(Object bean , String beanName)
	{
		System.out.println("Bean�������ڳ�ʼ��֮ǰ��"
			+ beanName + "������ǿ����...");
		// ���صĴ�����Beanʵ������ʵ������������ʵ��ʹ�õ�Bean
		// ��Beanʵ����������ԭBean��Ȼ��ͬ
		return bean;
	}
	public Object postProcessAfterInitialization
		(Object bean , String beanName)
	{
		System.out.println("Bean�������ڳ�ʼ��֮���"
			+ beanName + "������ǿ����...");
		// �����Bean��Chinese���ʵ��
		if (bean instanceof Chinese)
		{
			try
			{
				// ͨ�������޸���name��Ա����
				Class clazz = bean.getClass();
				Field f = clazz.getDeclaredField("name");
				f.setAccessible(true);
				f.set(bean, "FKJAVA:" + f.get(bean));
			}
			catch (Exception ex){ ex.printStackTrace();}
		}
		return bean;
	}
}
