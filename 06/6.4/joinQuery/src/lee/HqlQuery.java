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
		mgr.findPersons();
		// ���õڶ�����ѯ����
		mgr.findPersonsByHappenDate();
		mgr.findPersonsFetchMyEvent();
	}

	//c��һ����ѯ����
	private void findPersons()
	{
		// ���Hibernate Session
		Session sess = HibernateUtil.currentSession();
		// ��ʼ����
		Transaction tx = sess.beginTransaction();
		// ��HQL��䴴��Query����,HQL���ʹ����ʽ����
		List<Person> pl = sess.createQuery("from Person p where p.myEvent.title > :title"
			, Person.class)
			// ִ��setString()����ΪHQL���Ĳ�����ֵ
			.setParameter("title", " ")
			//Query����list()�������ʲ�ѯ��ȫ��ʵ��
			.getResultList();
		// ������ѯ��ȫ�����
		for (Person p : pl)
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
		System.out.println("====��ʼͨ�����ڲ�����====");
		// ��HQL��䴴��Query����,HQL���ʹ����ʽ����
		// ��Ϊû��ʹ��fetch�ؼ��֣����Է���List����Ԫ���Ǳ���ѯʵ��
		List<Person> pl = sess.createQuery("select p from Person p left join "
			+ "p.myEvent event where event.happenDate < :endDate", Person.class)
			.setParameter("endDate",new Date())
			.getResultList();
		// ���������
		for (Person p : pl)
		{
			System.out.println(p.getName());
			// ��Ϊִ��HQLʱû��ʹ��fetch��
			// ����ֻ����Sessionû�йر�ʱ����Person����ʵ�������
			System.out.println(p.getMyEvent().getTitle());
		}
		tx.commit();
		HibernateUtil.closeSession();
	}

	// ��������ѯ����������fetch�ؼ���
	private void findPersonsFetchMyEvent()throws Exception
	{
		// ���Hibernate Session����
		Session sess = HibernateUtil.currentSession();
		Transaction tx = sess.beginTransaction();
		System.out.println("====����fetch��ѯ====");
		// ��HQL��䴴��Query����,HQL���ʹ����ʽ����
		// ��Ϊʹ����fetch�ؼ��֣����Է��ؽ�������а�������ʵ��
		List<Person> pl = sess.createQuery("from Person p left join fetch "
			+ "p.myEvent event where event.happenDate < :endDate", Person.class)
			.setParameter("endDate",new Date())
			.getResultList();
		tx.commit();
		HibernateUtil.closeSession();
		// ���������
		for (Person p : pl)
		{
			System.out.println(p.getName());
			// ��ΪHQL�����ʹ����fecth�ؼ���
			// ���Կ�����Session�رպ����Person����ʵ�������
			System.out.println(p.getMyEvent().getTitle());
		}
	}
}