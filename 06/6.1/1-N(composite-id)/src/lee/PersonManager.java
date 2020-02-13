package lee;

import org.hibernate.Transaction;
import org.hibernate.Session;

import java.util.*;
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
		mgr.createAndStorePerson();
		HibernateUtil.sessionFactory.close();
	}
	private void createAndStorePerson()
	{
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// ����Person����
		Person person = new Person();
		person.setAge(29);
		// Ϊ����������������Ա����ֵ
		person.setFirst("crazyit.org");
		person.setLast("���Java����");
		Address a1 = new Address("�������");
		a1.setPerson(person);
		Address a2 = new Address("�Ϻ����");
		a2.setPerson(person);
		// �ȱ�������ʵ��
		session.save(person);
		// �ٱ���ӱ�ʵ��
		session.save(a1);
		session.save(a2);
		tx.commit();
		HibernateUtil.closeSession();
	}
}