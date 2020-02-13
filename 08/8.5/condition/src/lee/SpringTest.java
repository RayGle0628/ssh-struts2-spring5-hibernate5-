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
		// ���÷���ʱage������С��100����˲��Ỻ�棬
		// �����������η������ö�������ִ����Щ������
		User u1 = us.getUsersByNameAndAge("�����", 500);
		User u2 = us.getAnotherUser("�����", 500);
		System.out.println(u1 == u2); // ���false
		// ���÷���ʱage����С��100����˻Ỻ�棬
		// ��������ڶ��η�������ʱ��������ִ�и÷���������ֱ��ʹ�û������ݡ�
		User u3 = us.getUsersByNameAndAge("�����", 50);
		User u4 = us.getAnotherUser("�����", 50);
		System.out.println(u3 == u4); // ���true
	}
}
