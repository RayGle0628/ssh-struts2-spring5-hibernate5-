package lee;
import org.hibernate.Transaction;
import org.hibernate.Session;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.*;

import org.crazyit.app.domain.*;
/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
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
		// 调用查询方法
//		mgr.findPersons();
		// 调用第二个查询方法
		mgr.findPersonsByHappenDate();
		// 调用第三个查询方法
//		mgr.findPersonProperty();
	}
	// 第一个查询方法
	private void findPersons()
	{
		// 获得Hibernate Session
		Session sess = HibernateUtil.currentSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();
		// 以HQL语句创建Query对象.
		List<Person> pl = sess.createQuery("select distinct p from Person p "
			+ "join p.myEvents where title = :eventTitle", Person.class)
			// 执行setParameter()方法为HQL语句的参数赋值
			.setParameter("eventTitle" , "很普通的事情")
			// Query调用getResultList()方法获取查询的全部实例
			.getResultList();
		// 遍历查询的全部结果
		for(Person p : pl)
		{
			System.out.println(p.getName());
		}
		// 提交事务
		tx.commit();
		HibernateUtil.closeSession();
	}
	// 第二个查询方法
	private void findPersonsByHappenDate()throws Exception
	{
		// 获得Hibernate Session对象
		Session sess = HibernateUtil.currentSession();
		Transaction tx = sess.beginTransaction();
		// 解析出Date对象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date start = sdf.parse("2005-01-01");
		System.out.println("系统开始通过日期查找人" + start);
		// 通过Session的createQuery方法创建Query对象
		List<Person> pl = sess.createQuery("select distinct p from Person p "
			+ "inner join p.myEvents event where event.happenDate "
			+ "between :firstDate and :endDate", Person.class)
			// 设置参数
			.setParameter("firstDate" , start)
			.setParameter("endDate" , new Date())
			// 返回结果集
			.getResultList();
		// 遍历结果集
		for (Person p : pl)
		{
			System.out.println(p.getName());
		}
		tx.commit();
		HibernateUtil.closeSession();
	}
	// 第三个查询方法：查询属性
	private void findPersonProperty()
	{
		// 获得Hibernate Session
		Session sess = HibernateUtil.currentSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();
		// 以HQL语句创建Query对象.
		List<Object[]> pl = sess.createQuery("select distinct p.id,  p.name , p.age "
			+ "from Person p join p.myEvents", Object[].class)
			// Query调用getResultList()方法访问查询得到的全部属性
			.getResultList();
		// 遍历查询的全部结果
		for (Object[] objs : pl)
		{
			System.out.println(java.util.Arrays.toString(objs));
		}
		// 提交事务
		tx.commit();
		HibernateUtil.closeSession();
	}
}