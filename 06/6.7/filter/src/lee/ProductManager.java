package lee;

import org.hibernate.Transaction;
import org.hibernate.Session;

import java.util.*;
import java.text.SimpleDateFormat;

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
public class ProductManager
{
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String[] args)
		throws Exception
	{
		ProductManager mgr = new ProductManager();
		mgr.test();
		HibernateUtil.sessionFactory.close();
	}

	private void test() throws Exception
	{
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();

		// ����effectiveDate�������������ò���
		session.enableFilter("effectiveDate")
			.setParameter("asOfDate", new Date());
		// ����category�������������ò���
		session.enableFilter("category")
			.setParameter("catId", 2);
		// ��ѯ����Productʵ�壬�����κ�ɸѡ��������effectiveDate��������������
		List<Product> list = session.createQuery("from Product as p")
			.getResultList();     // ��
		for (Product p : list)
		{
			System.out.println(p.getName());
			// ��ȡProduct���������Category���⣬2���������������á�
			System.out.println("----" + p.getCategories());     // ��
		}
		tx.commit();
		HibernateUtil.closeSession();
	}
}
