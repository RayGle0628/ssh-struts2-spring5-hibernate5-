package lee;

import org.crazyit.app.domain.*;
import org.crazyit.app.dto.*;
import javax.persistence.*;
import javax.persistence.criteria.*;
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
public class JoinQueryTest
{
	final static EntityManagerFactory emf = Persistence
		.createEntityManagerFactory("query_pu");
	public static void main(String[] args)
	{
		JoinQueryTest joinTest = new JoinQueryTest();
		joinTest.queryWithJoin();
		joinTest.queryWithFecth();
		emf.close();
	}

	// ʾ�����ݹ���ʵ������Թ�������
	private void queryWithJoin()
	{
		// ��EntityManager������
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		// ����CriteriaQuery�����Ͳ��������������ѯ���ؽ������Ԫ������
		CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
		// ָ��Ҫ��ѯ�ĸ�ʵ����
		Root<Student> root = criteria.from(Student.class);
		// ������䲻�Ǳ���ģ�������ѯĬ�ϻ�ѡ��Ψһ��Rootʵ��
		criteria.select(root);
		// ����������Student.enrolments��@OneToMany����
		SetJoin<Student, Enrolment> enrolJoin = root
			.join(Student_.enrolments, JoinType.LEFT); // ��
		Predicate stuPred = builder.and(
			builder.greaterThan(root.get(Student_.studentNumber), 20050231),
			builder.gt(enrolJoin.get(Enrolment_.semester), 2)
		);
		// ʹ��builer�����ɲ�ѯ����,ʹ��where()������Ӳ�ѯ����
		criteria.where(stuPred);
		List<Student> list = em.createQuery(criteria)
			.getResultList();
		System.out.println("=====����������ѯ��ȡ����ѧ����¼=====");
		for (Student s : list)
		{
			System.out.println(s.getName());
			// ��ȡ��ѧ��������ѡ�μ�¼
			System.out.println(s.getEnrolments());   // ��
		}
		em.getTransaction().commit();
		em.close();
	}
// ʾ��FetchMode���÷�
private void queryWithFecth()
{
	// ��EntityManager������
	EntityManager em = emf.createEntityManager();
	em.getTransaction().begin();
	CriteriaBuilder builder = em.getCriteriaBuilder();
	// ����CriteriaQuery�����Ͳ��������������ѯ���ؽ������Ԫ������
	CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
	// ָ��Ҫ��ѯ�ĸ�ʵ����
	Root<Student> root = criteria.from(Student.class);
	// ������䲻�Ǳ���ģ�������ѯĬ�ϻ�ѡ��Ψһ��Rootʵ��
	criteria.select(root);
	// ����������Student.enrolments��@OneToMany����
	SetJoin<Student, Enrolment> enrolJoin = root
		.join(Student_.enrolments, JoinType.LEFT); // ��
	// ����fetch������Student.enrolments��@OneToMany����
	Fetch<Student, Enrolment> enrolFetch = root
		.fetch(Student_.enrolments, JoinType.LEFT); // ��
	Fetch<Enrolment, Course> courseFetch = enrolFetch
		.fetch(Enrolment_.course); // ��
	Predicate stuPred = builder.and(
		builder.greaterThan(root.get(Student_.studentNumber), 20050231),
		builder.gt(enrolJoin.get(Enrolment_.semester), 2)
	);
	// ʹ��builer�����ɲ�ѯ����,ʹ��where()������Ӳ�ѯ����
	criteria.where(stuPred);
	List<Student> list = em.createQuery(criteria)
		.getResultList();
	em.getTransaction().commit();
	em.close();
	System.out.println("=====����������ѯ��ȡ����ѧ����¼=====");
	for (Student s : list)
	{
		System.out.println(s.getName());
		// ��EntityManager�ر�֮���ȡ��ѧ��������ѡ�μ�¼
		System.out.println(s.getEnrolments());   // ��
	}
}
}
