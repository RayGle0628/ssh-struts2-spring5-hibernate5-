package lee;
import org.hibernate.Transaction;
import org.hibernate.Session;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
public class HqlQuery
{
	public static void main(String[] args)
		throws Exception
	{
		HqlQuery mgr = new HqlQuery();
		// ���ò�ѯ����
//		mgr.findPersons();
		// ���õڶ�����ѯ����
		mgr.findPersonsByHappenDate();
		// ���õ�������ѯ����
//		mgr.findPersonProperty();
	}
	// ��һ����ѯ����
	private void findPersons()
	{
		// ���Hibernate Session
		Session sess = HibernateUtil.currentSession();
		// ��ʼ����
		Transaction tx = sess.beginTransaction();
		// ��HQL��䴴��Query����.
		List<Person> pl = sess.createQuery("select distinct p from Person p "
			+ "join p.myEvents where title = :eventTitle", Person.class)
			// ִ��setParameter()����ΪHQL���Ĳ�����ֵ
			.setParameter("eventTitle" , "����ͨ������")
			// Query����getResultList()������ȡ��ѯ��ȫ��ʵ��
			.getResultList();
		// ������ѯ��ȫ�����
		for(Person p : pl)
		{
			System.out.println(p.getName());
		}
		// �ύ����
		tx.commit();
		HibernateUtil.closeSession();
	}
	// �ڶ�����ѯ����
	private void findPersonsByHappenDate()throws Exception
	{
		// ���Hibernate Session����
		Session sess = HibernateUtil.currentSession();
		Transaction tx = sess.beginTransaction();
		// ������Date����
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date start = sdf.parse("2005-01-01");
		System.out.println("ϵͳ��ʼͨ�����ڲ�����" + start);
		// ͨ��Session��createQuery��������Query����
		List<Person> pl = sess.createQuery("select distinct p from Person p "
			+ "inner join p.myEvents event where event.happenDate "
			+ "between :firstDate and :endDate", Person.class)
			// ���ò���
			.setParameter("firstDate" , start)
			.setParameter("endDate" , new Date())
			// ���ؽ����
			.getResultList();
		// ���������
		for (Person p : pl)
		{
			System.out.println(p.getName());
		}
		tx.commit();
		HibernateUtil.closeSession();
	}
	// ��������ѯ��������ѯ����
	private void findPersonProperty()
	{
		// ���Hibernate Session
		Session sess = HibernateUtil.currentSession();
		// ��ʼ����
		Transaction tx = sess.beginTransaction();
		// ��HQL��䴴��Query����.
		List<Object[]> pl = sess.createQuery("select distinct p.id,  p.name , p.age "
			+ "from Person p join p.myEvents", Object[].class)
			// Query����getResultList()�������ʲ�ѯ�õ���ȫ������
			.getResultList();
		// ������ѯ��ȫ�����
		for (Object[] objs : pl)
		{
			System.out.println(java.util.Arrays.toString(objs));
		}
		// �ύ����
		tx.commit();
		HibernateUtil.closeSession();
	}
}