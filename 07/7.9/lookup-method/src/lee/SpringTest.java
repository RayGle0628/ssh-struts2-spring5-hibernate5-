package lee;

import org.springframework.context.*;
import org.springframework.context.support.*;

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
public class SpringTest
{
	public static void main(String[] args)
	{
		// �������·���µ�beans.xml��Ϊ�����ļ�������Spring����
		ApplicationContext ctx = new
			ClassPathXmlApplicationContext("beans.xml");
		Person p1 = ctx.getBean("chinese" , Person.class);
		Person p2 = ctx.getBean("chinese" , Person.class);
		// ����chinese Bean��singleton��Ϊ��
		// ��˳������λ�ȡ��chinese Bean��ͬһ��ʵ����
		System.out.println(p1 == p2);
		p1.hunt();
		p2.hunt();
	}
}