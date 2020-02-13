package org.crazyit.app.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

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
	// Action�������һ��Map���͵ĳ�Ա����
	// Map��value����ΪUser����
	private Map<String , User> users;

	// users��setter��getter����
	public void setUsers(Map<String , User> users)
	{
		this.users = users;
	}
	public Map<String , User> getUsers()
	{
		return this.users;
	}

	public String execute() throws Exception
	{
		// �ڿ���̨���Struts 2��װ������Map����
		System.out.println(getUsers());
		// ����Map������keyΪone��Userʵ�������������߼�
		if (getUsers().get("one").getName().equals("crazyit.org")
			&& getUsers().get("one").getPass().equals("leegang") )
		{
			addActionMessage("��¼�ɹ���");
			return SUCCESS;
		}
		addActionMessage("��¼ʧ�ܣ���");
		return ERROR;
	}
}