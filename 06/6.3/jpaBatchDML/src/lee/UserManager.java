package lee;

import javax.persistence.*;

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
	// ʹ��Persistence����EntityManagerFactory
	private static EntityManagerFactory emf =
		Persistence.createEntityManagerFactory("batch_pu");
	public static void main(String[] args)throws Exception
	{
		final EntityManager em = emf.createEntityManager();
		//��������
		em.getTransaction().begin();
		String hqlUpdate = "update User u set name = :newName";
		// ִ�и���
		int updatedEntities = em.createQuery(hqlUpdate)
			.setParameter("newName", "JPA������")
			.executeUpdate();
		//�ύ����
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}