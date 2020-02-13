package lee;

import javax.persistence.*;

import java.util.*;

import org.crazyit.app.domain.*;
import org.crazyit.app.vo.*;

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
public class NativeSQLTest
{
	final static EntityManagerFactory emf = Persistence
		.createEntityManagerFactory("query_pu");
	public static void main(String[] args)
	{
		NativeSQLTest test = new NativeSQLTest();
//		test.simpleQuery();
//		test.entityQuery();
		test.mappingQuery();
		emf.close();
	}

	public void simpleQuery()
	{
		// ��EntityManager������
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		// ����SQL��䣬����ԭ��SQL��ѯ
		Query query = em.createNativeQuery("select student_id, name "
			+ "from student_inf "
			+ "where student_id > ?");
		// ΪSQL�е�һ����������ֵ��
		List<Object[]> list = query.setParameter(1 , 2)
			// ��ȡ��ѯ���Ľ��
			.getResultList();
		for (Object[] item : list)
		{
			System.out.println(Arrays.toString(item));
		}
		em.getTransaction().commit();
		em.close();
	}

	public void entityQuery()
	{
		// ��EntityManager������
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		// ����SQL��䣬����ԭ��SQL��ѯ���������ӳ���Student����
		Query query = em.createNativeQuery("select *"
			+ " from student_inf"
			+ " where student_id > ?" , Student.class);
		//ΪSQL�е�һ����������ֵ��
		List<Student> list = query.setParameter(1 , 2)
			// ��ȡ��ѯ���Ľ��
			.getResultList();
		for (Student s : list)
		{
			System.out.println(s.getStudentNumber() + "->" +
				s.getName());
		}
		em.getTransaction().commit();
		em.close();
	}

	public void mappingQuery()
	{
		// ��EntityManager������
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		// ����ԭ��SQL��ѯ������SQLӳ�������
		Query query = em.createNativeQuery("select s.* , e.*"
			+ " from student_inf s"
			+ " join enrolment_inf e"
			+ " on s.student_id = e.student_id"
			+ " where s.student_id > ?" , "stu_mapping");
		//ΪSQL�е�һ����������ֵ��
		List<Object[]> list = query.setParameter(1 , 2)
			// ��ȡ��ѯ���Ľ��
			.getResultList();
		for (Object[] row : list)
		{
			System.out.println(Arrays.toString(row));
		}
		em.getTransaction().commit();
		em.close();
	}
}
