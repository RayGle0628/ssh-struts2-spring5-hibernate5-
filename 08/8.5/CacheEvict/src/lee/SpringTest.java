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
		// ����us�����2��������ķ�����ϵͳ�Ỻ�������������ص�����
		User u1 = us.getUsersByNameAndAge("�����", 500);
		User u2 = us.getAnotherUser("��˽�", 400);
		//����evictUser()�������������ָ��������
		us.evictUser("��˽�", 400);
		// ����ǰ�����"��˽�", 400����������Ѿ�������ˣ�
		// ���������������ִ�У��������ص����ݽ����ٴλ��档
		User u3 = us.getAnotherUser("��˽�", 400);  // ��
		System.out.println(u2 == u3); // ���false
		// ����ǰ��ǰ���Ѿ������˲���Ϊ"�����", 500�����ݣ�
		// ���������벻������ִ�У�ֱ�����û����е����ݡ�
		User u4 = us.getAnotherUser("�����", 500);   // ��
		System.out.println(u1 == u4); // ���true
		// ����������档
		us.evictAll();
		// �����������涼�Ѿ�����գ�����������д��붼������ִ��
		User u5 = us.getAnotherUser("�����", 500);
		User u6 = us.getAnotherUser("��˽�", 400);
		System.out.println(u1 == u5); // ���false
		System.out.println(u3 == u6); // ���false
	}
}
