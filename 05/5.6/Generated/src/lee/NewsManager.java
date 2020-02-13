package lee;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.service.*;
import org.hibernate.boot.registry.*;
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
public class NewsManager
{
	public static void main(String[] args)
		throws Exception
	{
		// ʵ����Configuration��
		Configuration conf = new Configuration()
		// ����������configure()����Ĭ�ϼ���hibernate.cfg.xml�ļ���
		// �������abc.xml��Ϊ���������ټ���hibernate.cfg.xml����Ϊ����abc.xml
			.configure();
		// ��Configurationʵ������SessionFactoryʵ��
		SessionFactory sf = conf.buildSessionFactory();
		// ����Session
		Session sess = sf.openSession();
		// ��ʼ����
		Transaction tx = sess.beginTransaction();
		// ������Ϣ����
		News n = new News();
		// ������Ϣ�������Ϣ����
		n.setTitle("���Java���˳�����");
		n.setContent("���Java���˳����ˣ�"
			+ "��վ��ַhttp://www.crazyit.org");
		// ������Ϣ
		sess.save(n);
		// ���fullContentֵ
		System.out.println(n.getFullContent());
		// �ύ����
		tx.commit();
		// �ر�Session
		sess.close();
		sf.close();
	}
}
