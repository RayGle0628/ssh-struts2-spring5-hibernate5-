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
		// ѭ��100000�Σ�����100000����¼
		for (int i = 0 ; i < 100000 ; i++ )
		{
			// ����Userʵ��
			User u1 = new User();
			u1.setName("xxxxx" + i);
			u1.setAge(i);
			u1.setNationality("china");
			// ��EntityManager���𻺴�Userʵ��
			em.persist(u1);
			// ÿ���ۼ�����20�ı���ʱ����EntityManager������ˢ�����ݿ⣬
			// �����Session���档
			if (i % 20 == 0)
			{
				em.flush();
				em.clear();
			}
		}
		//�ύ����
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}