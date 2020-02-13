package lee;

import org.hibernate.*;
import org.hibernate.criterion.*;

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
public class ProjectionTest
{
	public static void main(String[] args)
	{
		ProjectionTest pt = new ProjectionTest();
		pt.query();
		pt.aliasQuery();
		pt.aliasQuery2();
		pt.aliasQuery3();
		pt.queryForProperty();
		pt.queryForProperty2();
		HibernateUtil.sessionFactory.close();
	}

	private void query()
	{
		// ��Session������
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// ʹ��createCriteria��ʼ������ѯ
		List list = session.createCriteria(Enrolment.class)
			.createAlias("student", "s")
			.setProjection(Projections.projectionList()
				// ͳ�Ƽ�¼����
				.add(Projections.rowCount())
				// ͳ��ѡ��ÿγ�������ѧ������
				.add(Projections.max("s.name"))
				// ��course���з���
				.add(Projections.groupProperty("course"))
			).list();
		for(Object ele : list)
		{
			Object[] objs = (Object[])ele;
			Course c = (Course)objs[2];
			System.out.println("=====<" + c.getName()
				+ ">�γ̵�ѡ��ͳ��=====");
			System.out.println("ѡ������:" + objs[0]);
			System.out.println("ѡ�ε���������ѧ��Ϊ��" + objs[1]);
		}
		tx.commit();
		HibernateUtil.closeSession();
	}


	private void aliasQuery()
	{
		// ��Session������
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		List list = session.createCriteria(Enrolment.class)
			.setProjection(Projections.projectionList()
			// ��course���з���
			.add(Projections.groupProperty("course"))
			// ͳ�Ƽ�¼��������Ϊͳ�ƽ��ָ������c
			.add(Projections.alias(Projections.rowCount(), "c")))
			.addOrder(Order.asc("c"))
			.list();
		for(Object ele : list)
		{
			System.out.println(java.util.Arrays.toString((Object[])ele));
		}
		tx.commit();
		HibernateUtil.closeSession();
	}

	private void aliasQuery2()
	{
		// ��Session������
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		List list = session.createCriteria(Enrolment.class)
			.setProjection(Projections.projectionList()
			// ��course���з��飬��Ϊ������ָ������c
			.add(Projections.groupProperty("course").as("c"))
			// ͳ�Ƽ�¼����
			.add(Projections.rowCount()))
			.addOrder(Order.asc("c"))
			.list();
		for(Object ele : list)
		{
			System.out.println(java.util.Arrays.toString((Object[])ele));
		}
		tx.commit();
		HibernateUtil.closeSession();
	}

	private void aliasQuery3()
	{
		// ��Session������
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		List list = session.createCriteria(Enrolment.class)
			.setProjection(Projections.projectionList()
			// ��course���з��飬ָ������Ϊc
			.add(Projections.groupProperty("course") , "c")
			// ͳ��ÿ���¼��������ָ������Ϊrc
			.add(Projections.rowCount(), "rc"))
			.addOrder(Order.asc("rc"))
			.list();
		for (Object ele : list)
		{
			System.out.println(java.util.Arrays.toString((Object[])ele));
		}
		tx.commit();
		HibernateUtil.closeSession();
	}

	private void queryForProperty()
	{
		// ��Session������
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// ʹ��Propertyֻѡ��ָ����
		List list = session.createCriteria(Student.class)
			.setProjection(Property.forName("name"))
			.list();
		for (Object ele : list)
		{
			System.out.println(ele);
		}
		tx.commit();
		HibernateUtil.closeSession();
	}

	private void queryForProperty2()
	{
		// ��Session������
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// ʹ��Propertyѡ��ָ���У�������ָ���й�������
		List list = session.createCriteria(Enrolment.class)
			.createAlias("student", "s")
			.setProjection(Projections.projectionList()
			.add(Property.forName("course"))
			.add(Property.forName("s.name")))
			.add(Property.forName("s.name").eq("�����"))       // ��
			.list();
		for (Object ele : list)
		{
			System.out.println(java.util.Arrays.toString((Object[])ele));
		}
		tx.commit();
		HibernateUtil.closeSession();
	}
}