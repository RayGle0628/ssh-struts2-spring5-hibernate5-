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
		mgr.testCascase();
		HibernateUtil.sessionFactory.close();
	}

	private void testCascase()
	{
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// ����һ��Person����
		Person p = new Person();
		// ����һ��˲̬��Address����
		Address a = new Address("�������");          // ��
		// ����Person��nameΪcrazyit.org�ַ���
		p.setName("crazyit.org");
		p.setAge(21);
		// ����Person��Address֮��Ĺ�����ϵ
		p.setAddress(a);
		// �־û�Person����
		session.persist(p);
		session.save(a);
		// ����һ��˲̬��Address����
		Address a2 = new Address("�Ϻ����");         // ��
		// �޸ĳ־û�״̬��Person����
		p.setAddress(a2);                             // ��
		tx.commit();
		HibernateUtil.closeSession();
	}


	private void testPerson()
	{
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// ����һ��Person����
		Person p = new Person();
		// ����Person��nameΪcrazyit�ַ���
		p.setName("crazyit");
		p.setAge(21);
		// �־û�Person����(��Ӧ�ڲ���ӱ��¼)
		session.save(p);
		// ����һ��˲̬��Address����
		Address a = new Address("�������");        // ��
		// ������Person��Address֮��Ĺ�����ϵ
		p.setAddress(a);
		// �ٳ־û�Address����(��Ӧ�ڲ��������¼)
		session.persist(a);
		// ����һ��˲̬��Address����
		Address a2 = new Address("�Ϻ����");      // ��
		// ������Person��Address֮��Ĺ�����ϵ
		p.setAddress(a2);
		// �ٳ־û�Address����(��Ӧ�ڲ��������¼)
		session.persist(a2);                       // ��
		tx.commit();
		HibernateUtil.closeSession();
	}
}
