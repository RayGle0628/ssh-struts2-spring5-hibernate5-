package org.crazyit.app.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

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

public class LoginAction extends ActionSupport
{
	// Action�������һ���������͵�List���͵ĳ�Ա����
	private List users;

	// users��setter��getter����
	public void setUsers(List users)
	{
		this.users = users;
	}
	public List getUsers()
	{
		return this.users;
	}

	public String execute() throws Exception
	{
		// �ڿ���̨���Struts 2��װ������List����
		System.out.println(getUsers());
		// ��Ϊû��ʹ�÷��ͣ�����Ҫ����ǿ������ת��
		User firstUser = (User)getUsers().get(0);
		// users���Եĵ�һ��Userʵ�������������߼�
		if (firstUser.getName().equals("crazyit.org")
			&& firstUser.getPass().equals("leegang") )
		{
			addActionMessage("��¼�ɹ���");
			return SUCCESS;
		}
		addActionMessage("��¼ʧ�ܣ���");
		return ERROR;
	}
}