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
	// Action�������һ��List���͵ĳ�Ա����
	// List���ϵ�Ԫ��ΪUser����
	private List<User> users;

	// users���Ե�setter��getter����
	public void setUsers(List<User> users)
	{
		this.users = users;
	}
	public List<User> getUsers()
	{
		return this.users;
	}

	public String execute() throws Exception
	{
		// �ڿ���̨���Struts 2��װ������List����
		System.out.println(getUsers());
		// users���Եĵ�һ��Userʵ�������������߼�
		if (getUsers().get(0).getName().equals("crazyit.org")
			&& getUsers().get(0).getPass().equals("leegang") )
		{
			addActionMessage("��¼�ɹ���");
			return SUCCESS;
		}
		addActionMessage("��¼ʧ�ܣ���");
		return ERROR;
	}
}