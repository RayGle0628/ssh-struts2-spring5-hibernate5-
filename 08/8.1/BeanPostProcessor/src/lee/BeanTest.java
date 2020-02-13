package lee;

import org.springframework.core.io.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.crazyit.app.service.*;
import org.crazyit.app.util.*;
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
public class BeanTest
{
	public static void main(String[] args)throws Exception
	{
		// �������·���µ�beans.xml�ļ�������Spring����
//		ApplicationContext ctx = new
//			ClassPathXmlApplicationContext("beans.xml");
//		Person p = (Person)ctx.getBean("chinese");

		// ���������·���µ�beans.xml�ļ�����Resource����
		Resource isr = new ClassPathResource("beans.xml");
		// ����Ĭ�ϵ�BeanFactory����
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		// ��Ĭ�ϵ�BeanFactory��������isr��Ӧ��XML�����ļ�
		new XmlBeanDefinitionReader(beanFactory).loadBeanDefinitions(isr);
		// ��ȡ�����е�Bean������
		BeanPostProcessor bp = (BeanPostProcessor)beanFactory.getBean("bp");
		// ע��Bean������
		beanFactory.addBeanPostProcessor(bp);
		Person p = (Person)beanFactory.getBean("chinese");

		p.useAxe();
	}
}