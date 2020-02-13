package lee;

import org.hibernate.*;
import org.hibernate.transform.*;
import org.hibernate.type.*;

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
	public static void main(String[] args)
	{
		NativeSQLTest test = new NativeSQLTest();
//		test.scalarQuery();
//		test.entityQuery();
//		test.multiEntityQuery();
//		test.beanQuery();
		test.joinQuery();
		HibernateUtil.sessionFactory.close();
	}
	// ִ�б�����ѯ
	public void scalarQuery()
	{
		// ��Session������
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		String sqlString = "select stu.* from student_inf as stu";
		List<Object[]> list = session.createNativeQuery(sqlString)
			// ָ����ѯname��student_id����������
			.addScalar("name" , StandardBasicTypes.STRING)
			.addScalar("student_id" , StandardBasicTypes.INTEGER)
			// ���ر���ֵ�б�
			.getResultList();
		for (Object[] row : list)
		{
			// ÿ������Ԫ�ض���һ�����飬����Ԫ����name��student_id����ֵ
			System.out.println(row[0] + "\t" + row[1]);
		}
		tx.commit();
		HibernateUtil.closeSession();
	}

	// ִ��ʵ��SQL��ѯ
	public void entityQuery()
	{
		// ��Session������
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		String sqlString = "select * from enrolment_inf where year=?1";
		List<Enrolment> list = session.createNativeQuery(sqlString)
			// ָ������ѯ�ļ�¼��ת����Enrolmentʵ��
			.addEntity(Enrolment.class)
			// ΪSQL�ַ����Ĳ�������ֵ
			.setParameter("1" , 2005)
			.getResultList();
		for (Enrolment e : list)
		{
			// ÿ������Ԫ�ض���һ��Enrolment����
			System.out.println(e.getStudent().getName()
				+ "\t" + e.getCourse().getName());
		}
		tx.commit();
		HibernateUtil.closeSession();
	}

	// ִ�з��ض��ʵ���SQL��ѯ
	public void multiEntityQuery()
	{
		// ��Session������
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		String sqlString = "select s.*,e.*,c.* "
			+ "from student_inf s,enrolment_inf e,course_inf c "
			+ "where s.student_id = e.student_id "
			+ "and e.course_code = c.course_code";
		List<Object[]> list = session.createNativeQuery(sqlString)
			// ָ������s���ѯ�õ��ļ�¼��ת����Studentʵ��
			.addEntity("s", Student.class)
			// ָ������e���ѯ�õ��ļ�¼��ת����Enrolmentʵ��
			.addEntity("e", Enrolment.class)
			// ָ������c���ѯ�õ��ļ�¼��ת����Courseʵ��
			.addEntity("c", Course.class)
			.getResultList();
		// �ύ���񣬹ر�Session
		tx.commit();
		HibernateUtil.closeSession();
		// ��Ϊ�����Ѿ�ȫ����ѡ�����ʳ�����Ա����б��е�����
		for (Object[] objs : list)
		{
			// ÿ������Ԫ�ض���Student��Enrolment
			// ��Course����ɵ�����
			Student s = (Student)objs[0];
			Enrolment e = (Enrolment)objs[1];
			Course c = (Course)objs[2];
			System.out.println(s.getName() + "\t"
				+ e.getYear() + "\t" + e.getSemester()
				+ "\t" + c.getName());
		}
	}

	// ִ�з�����ͨJavaBean��SQL��ѯ
	public void beanQuery()
	{
		// ��Session������
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		String sqlString = "select s.name stuName, c.name courseName "
			+ "from student_inf s,enrolment_inf e,course_inf c "
			+ "where s.student_id = e.student_id "
			+ "and e.course_code = c.course_code ";
		List<StudentCourse> list = session.createNativeQuery(sqlString)
			// ָ������ѯ�ļ�¼��ת����StudentCourse����
			.setResultTransformer(Transformers
				.aliasToBean(StudentCourse.class))
			.getResultList();
		// �ύ���񣬹ر�Session
		tx.commit();
		HibernateUtil.closeSession();
		// ��Ϊ�����Ѿ�ȫ����ѡ�����ʳ�����Ա����б��е�����
		for (StudentCourse sc : list)
		{
			// ÿ������Ԫ�ض���StudentCourse����
			System.out.println(sc.getStuName() + "\t"
				+ sc.getCourseName());
		}
	}

	// ʹ�ù�����ԭ��SQL��ѯ
	public void joinQuery()
	{
		// ��Session������
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		String sqlString = "select s.* , e.* from student_inf s , "
			+ "enrolment_inf e where s.student_id=e.student_id";
		List<Object[]> list = session.createNativeQuery(sqlString)
			.addEntity("s", Student.class)
			.addJoin("e" , "s.enrolments")
			.getResultList();
		// �ύ���񣬹ر�Session
		tx.commit();
		HibernateUtil.closeSession();
		// ��Ϊ�����Ѿ�ȫ����ѡ�����ʳ�����Ա����б��е�����
		for (Object[] objs : list)
		{
			// ÿ������Ԫ�ض���Student��Enrolment��ɵ�����
			Student s = (Student)objs[0];
			Enrolment e = (Enrolment)objs[1];
			System.out.println(s.getName() + "\t" + e.getYear());
		}
	}
}
