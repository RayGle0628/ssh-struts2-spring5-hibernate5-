package lee;

import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import org.crazyit.app.domain.*;
import java.util.*;

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
public class CriteriaTest
{
	public static void main(String[] args)
	{
		CriteriaTest criteriaTest = new CriteriaTest();
		criteriaTest.query();
		criteriaTest.queryWithJoin();
		criteriaTest.queryWithFecth();
		HibernateUtil.sessionFactory.close();
	}
	private void query()
	{
		// ��Session������
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// ʹ��createCriteria��ʼ������ѯ
		List list = session.createCriteria(Student.class)
			// ����Student�����Խ��й�������
			.add( Restrictions.gt("name" , "a"))
			.list();
		System.out.println("=====��������ѯ��ȡ����ѧ����¼=====");
		for(Object obj : list)
		{
			Student s = (Student)obj;
			System.out.println(s.getName());
			Set<Enrolment> enrolments = s.getEnrolments();
			System.out.println("=====��ȡ-" + s.getName()
				+ "-��ѡ�μ�¼=====");
			for(Enrolment e : enrolments)
			{
				System.out.println(e.getCourse().getName());
			}
		}
		tx.commit();
		HibernateUtil.closeSession();
	}
	// ʾ�����ݹ���ʵ������Թ�������
	private void queryWithJoin()
	{
		// ��Session������
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// ʹ��createCriteria��ʼ������ѯ
		List list = session.createCriteria(Student.class)
			// �˴�������������������Studentʵ����ڵ�����
			.add( Restrictions.gt("studentNumber" , 20050231))
			// ���Ҫ���Ӷ�Student�Ĺ���������Ե�����
			// ���������createCriteria()
			// ����˹��������Ǽ��ϣ���ֻҪ����������һ���������������������������
//			.createCriteria("enrolments")
//			.add( Restrictions.gt("semester" , 2))
			.createAlias("enrolments", "en")
			.add( Restrictions.gt("en.semester" , 2))
			.list();
		System.out.println("=====����������ѯ��ȡ����ѧ����¼=====");
		for (Object obj : list)
		{
			Student s = (Student)obj;
			System.out.println(s.getName());
			Set<Enrolment> enrolments = s.getEnrolments();
			System.out.println("=====��ȡ-" + s.getName()
				+ "-��ѡ�μ�¼=====");
			for(Enrolment e : enrolments)
			{
				System.out.println(e.getCourse().getName());
			}
		}
		tx.commit();
		HibernateUtil.closeSession();
	}
	// ʾ��FetchMode���÷�
	private void queryWithFecth()
	{
		// ��Session������
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// ʹ��createCriteria��ʼ������ѯ
		List list = session.createCriteria(Student.class)
			// �˴�������������������Studentʵ����ڵ�����
			.add( Restrictions.gt("studentNumber" , 20050231))
			.setFetchMode("enrolments", FetchMode.JOIN)
			.list();
		tx.commit();
		HibernateUtil.closeSession();      // ��
		System.out.println("=====����Ԥ��ʼ����������ѯ��ȡ����ѧ����¼=====");
		for (Object obj : list)
		{
			Student s = (Student)obj;
			System.out.println(s.getName());
			// Session�رպ����Student�Ĺ���ʵ��
			Set<Enrolment> enrolments = s.getEnrolments();      // ��
			System.out.println(enrolments);
		}
	}
}