package lee;

import org.hibernate.Transaction;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

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
public class PersonManager
{
	public static void main(String[] args)
	{
		PersonManager mgr = new PersonManager();
		mgr.createAndStorePerson();
		HibernateUtil.sessionFactory.close();
	}
// ����������Person����
private void createAndStorePerson()
{
	// ���̰߳�ȫ��session����
	Session session = HibernateUtil.currentSession();
	// ������
	Transaction tx = session.beginTransaction();
	// ����Person����
	Person person = new Person();
	//ΪPerson������������
	person.setAge(20);
	person.setName("crazyit.org");
	// ��person��schools���������2��Ԫ��
	person.getSchools().add("Сѧ");
	person.getSchools().add("��ѧ");
	session.save(person);
	tx.commit();
	HibernateUtil.closeSession();
}
}