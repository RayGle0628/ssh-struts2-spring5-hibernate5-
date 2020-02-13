package lee;

import org.crazyit.app.service.UserService;
import org.crazyit.app.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2018, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class SpringTest
{
	public static void main(String[] args)
	{
		ApplicationContext ctx =
			new ClassPathXmlApplicationContext("beans.xml");
		UserService us = ctx.getBean("userService" , UserService.class);
		// ��һ�ε���us����ķ���ʱ��ִ�и÷����������淽���Ľ��
		User u1 = us.getUsersByNameAndAge("�����", 500);
		// �ڶ��ε���us����ķ���ʱֱ�����û�������ݣ���������ִ�и÷���
		User u2 = us.getAnotherUser("�����", 500);
		System.out.println(u1 == u2); // ���true
	}
}
