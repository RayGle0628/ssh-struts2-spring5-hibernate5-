package lee;

import javax.persistence.*;

import java.util.*;
import java.text.*;

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
public class JpqlQuery
{
	final static EntityManagerFactory emf = Persistence
		.createEntityManagerFactory("jpql_pu");
	public static void main(String[] args)
		throws Exception
	{
		JpqlQuery mgr = new JpqlQuery();
		// ���ò�ѯ����
		mgr.findPersons();
		// ���õڶ�����ѯ����
		mgr.findPersonsByHappenDate();
		// ���õ�������ѯ����
		mgr.findPersonProperty();
	}
	// ��һ����ѯ����
	private void findPersons()
	{
		// ���EntityManager
		EntityManager em = emf.createEntityManager();
		// ��ʼ����
		em.getTransaction().begin();
		// ��JPQL��䴴��Query����.
		List<Person> pl = em.createQuery("select distinct p from Person p "
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
		em.getTransaction().commit();
		em.close();
	}
	// �ڶ�����ѯ����
	private void findPersonsByHappenDate()throws Exception
	{
		// ���EntityManager
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		// ������Date����
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date start = sdf.parse("2005-01-01");
		System.out.println("ϵͳ��ʼͨ�����ڲ�����" + start);
		// ��JPQL��䴴��Query����.
		List<Person> pl = em.createQuery("select distinct p from Person p "
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
		// �ύ����
		em.getTransaction().commit();
		em.close();
	}
	// ��������ѯ��������ѯ����
	private void findPersonProperty()
	{
		// ���EntityManager
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		// ��HQL��䴴��Query����.
		List<Object[]> pl = em.createQuery("select distinct p.id,  p.name , p.age "
			+ "from Person p join p.myEvents", Object[].class)
			// Query����getResultList()�������ʲ�ѯ�õ���ȫ������
			.getResultList();
		// ������ѯ��ȫ�����
		for (Object[] objs : pl)
		{
			System.out.println(java.util.Arrays.toString(objs));
		}
		// �ύ����
		em.getTransaction().commit();
		em.close();
	}
}