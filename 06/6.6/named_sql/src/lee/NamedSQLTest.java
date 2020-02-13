package lee;

import org.hibernate.*;
import org.hibernate.transform.*;

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
public class NamedSQLTest
{
	public static void main(String[] args)
	{
		NamedSQLTest test = new NamedSQLTest();
//		test.simpleQuery();
//		test.query();
		test.callProcedure();
		HibernateUtil.sessionFactory.close();
	}

	// ִ�м򵥵�����SQL��ѯ
	private void simpleQuery()
	{
		// ��Session������
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// ����������ѯ��ֱ�ӷ��ؽ��
		List<Student> list = session.getNamedQuery("simpleQuery")
			.getResultList();
		tx.commit();
		HibernateUtil.closeSession();
		// ���������
		for(Student s : list)
		{
			// ÿ������Ԫ����Student����
			System.out.println(s.getName() + "\t");  // ��
		}
	}

	// ִ������SQL��ѯ
	private void query()
	{
		// ��Session������
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// ����������ѯ��ֱ�ӷ��ؽ��
		List<Object[]> list = session.getNamedQuery("queryTest")
			.setParameter("targetYear" , 2005)
			.getResultList();
		tx.commit();
		HibernateUtil.closeSession();
		// ���������
		for(Object[] objs : list)
		{
			// ÿ������Ԫ����Student��Enrolment
			// ��stuName����Ԫ�ص�����
			Student s = (Student)objs[0];
			Enrolment e = (Enrolment)objs[1];
			Course c = (Course)objs[2];
			String stuName = (String)objs[3];
			System.out.println(s.getName() + "\t"
				+ e.getYear() + "\t" + e.getSemester()
				+ "\t=" + e.getCourse().getName() + "=\t" + stuName);
		}
	}

	// ���ô洢����
	private void callProcedure()
	{
		// ��Session������
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// ����������ѯ��ֱ�ӷ��ؽ��
		List<Student> list = session.getNamedQuery("callProcedure")
			.getResultList();
		tx.commit();
		HibernateUtil.closeSession();
		// ���������
		for(Student s : list)
		{
			// ÿ������Ԫ����Student����
			System.out.println(s.getName());
		}
	}
}
