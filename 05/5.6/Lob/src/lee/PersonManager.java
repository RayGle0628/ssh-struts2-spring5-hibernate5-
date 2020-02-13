package lee;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.service.*;
import org.hibernate.boot.registry.*;
import org.crazyit.app.domain.*;
import java.io.*;

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
public class PersonManager
{
	public static void main(String[] args)
		throws Exception
	{
		// ʵ����Configuration��
		Configuration conf = new Configuration()
			.configure();
		// ��Configurationʵ������SessionFactoryʵ��
		SessionFactory sf = conf.buildSessionFactory();
		// ����Session
		Session sess = sf.openSession();
		// ��ʼ����
		Transaction tx = sess.beginTransaction();
		// ����Person����
		Person person = new Person();
		// ΪPerson�������������ֵ
		person.setName("crazyit.org");
		File file = new File("logo.jpg");
		byte[] content = new byte[(int)file.length()];
		new FileInputStream(file).read(content);
		person.setPic(content);
		// ����Person����
		sess.save(person);
//		Person p = sess.load(Person.class, 1);
//		System.out.println(p.getName());
		// �ύ����
		tx.commit();
		// �ر�Session
		sess.close();
		sf.close();
	}
}
