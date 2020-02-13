package lee;

import org.hibernate.Transaction;
import org.hibernate.Session;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;

import org.crazyit.app.domain.*;
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
public class PersonManager
{
	public static void main(String[] args)
	{
		PersonManager mgr = new PersonManager();
		mgr.testPerson();
		HibernateUtil.sessionFactory.close();
	}

	private void testPerson()
	{
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// ����һ��˲̬��Person����
		Person p = new Person();
		// ����Person��nameΪcrazyit�ַ���
		p.setName("crazyit");
		p.setAge(21);
		// ����һ��˲̬��Address����
		Address a = new Address("�������");
		// ����Personʵ��ʹ��@OneToOneע��ʱָ����mappedBy����
		// ���Personʵ�岻�����ڿ��ƹ�����ϵ��ֻ����Addressʵ����ƹ�����ϵ
		a.setPerson(p);
//		p.setAddress(a);
		// �ȳ־û�Person���󣨶�ӦΪ���������¼��
		session.save(p);
		// �ٳ־û�Address���󣨶�ӦΪ����ӱ��¼��
		session.persist(a);
		tx.commit();
		HibernateUtil.closeSession();
	}
}
