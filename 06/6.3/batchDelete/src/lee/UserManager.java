package lee;

import org.hibernate.Transaction;
import org.hibernate.Session;

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
public class UserManager
{
	public static void main(String[] args)throws Exception
	{
		UserManager mgr = new UserManager();
		mgr.deleteUsers();
		HibernateUtil.sessionFactory.close();
	}
	private void deleteUsers()throws Exception
	{
		// ��Session
		Session session = HibernateUtil.currentSession();
		// ��ʼ����
		Transaction tx = session.beginTransaction();
		// ��������ɾ����HQL���
		String hqlDelete = "delete User";
		// ִ��ɾ��
		int deletedEntities = session.createQuery( hqlDelete )
			.executeUpdate();
		// �ύ����
		tx.commit();
		HibernateUtil.closeSession();
	}
}