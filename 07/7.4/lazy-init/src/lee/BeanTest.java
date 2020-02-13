package lee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.core.io.*;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

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
public class BeanTest
{
	public static void main(String[] args)throws Exception
	{
		// ����Spring����
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		// ���������·���µ�beans.xml�ļ�����Resource����
		Resource isr = new ClassPathResource("beans.xml");
		// ����Ĭ�ϵ�BeanFactory����
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		// ��Ĭ�ϵ�BeanFactory��������Ĭ�ϵ�
		new XmlBeanDefinitionReader(beanFactory).loadBeanDefinitions(isr);
	}
}