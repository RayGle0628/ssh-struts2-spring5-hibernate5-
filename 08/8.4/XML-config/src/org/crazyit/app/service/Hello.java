package org.crazyit.app.service;

/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2018, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public interface Hello
{
	// ����һ��deleteUser������ģ��Ӧ����ɾ���û��ķ���
	void deleteUser(Integer id);
	// ����һ��addUser()������ģ��Ӧ��������û��ķ���
	int addUser(String name , String pass);
}
