package lee;

import org.crazyit.app.domain.*;
import javax.persistence.*;
import javax.persistence.criteria.*;
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
public class GroupByTest
{
	final static EntityManagerFactory emf = Persistence
		.createEntityManagerFactory("query_pu");
	public static void main(String[] args)
	{
		GroupByTest gbt = new GroupByTest();
		gbt.query();
		gbt.queryAndOrder();
		emf.close();
	}

	private void query()
	{
		// ��EntityManager������
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		// ����CriteriaQuery�����Ͳ��������������ѯ���ؽ������Ԫ������
		CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
		// ָ��Ҫ��ѯ�ĸ�ʵ����
		Root<Enrolment> root = criteria.from(Enrolment.class);
		// ִ�й�����ѯ��Enrolment.student��@ManyToOne����
		Join<Enrolment, Student> stuJoin = root.join(Enrolment_.student);
		// ���ø���Enrolment��course���Է���
		criteria.groupBy(root.get(Enrolment_.course)); // ��
		// ����select��������
		criteria.multiselect(builder.count(root),
			builder.greatest(stuJoin.get(Student_.name)),
			root.get(Enrolment_.course));
		List<Object[]> list = em.createQuery(criteria)
			.getResultList();
		for(Object[] objs : list)
		{
			Course c = (Course)objs[2];
			System.out.println("=====<" + c.getName()
				+ ">�γ̵�ѡ��ͳ��=====");
			System.out.println("ѡ������:" + objs[0]);
			System.out.println("ѡ�ε���������ѧ��Ϊ��" + objs[1]);
		}
		em.getTransaction().commit();
		em.close();
	}

	private void queryAndOrder()
	{
		// ��EntityManager������
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		// ����CriteriaQuery�����Ͳ��������������ѯ���ؽ������Ԫ������
		CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
		// ָ��Ҫ��ѯ�ĸ�ʵ����
		Root<Enrolment> root = criteria.from(Enrolment.class);
		// ���ø���Enrolment��course���Է���
		criteria.groupBy(root.get(Enrolment_.course));
		// ����select��������
		criteria.multiselect(root.get(Enrolment_.course),
			builder.count(root));
		// �����������е��������
		Order order = builder.desc(builder.count(root));
		// ��������
		criteria.orderBy(order); // ��
		List<Object[]> list = em.createQuery(criteria)
			.getResultList();
		for(Object[] ele : list)
		{
			System.out.println(java.util.Arrays.toString(ele));
		}
		em.getTransaction().commit();
		em.close();
	}
}