package org.crazyit.app.action;

import com.opensymphony.xwork2.ActionSupport;

import org.crazyit.app.exception.*;

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
	// ��װ���������username��password��Ա����
	private String username;
	private String password;

	// username��setter��getter����
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getUsername()
	{
		return this.username;
	}

	// password��setter��getter����
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getPassword()
	{
		return this.password;
	}

	public String execute() throws Exception
	{
		if (getUsername().equalsIgnoreCase("user"))
		{
			throw new MyException("�Զ����쳣");
		}
		if (getUsername().equalsIgnoreCase("sql"))
		{
			throw new java.sql.SQLException("�û�������ΪSQL");
		}
		if (getUsername().equals("crazyit.org")
			&& getPassword().equals("leegang") )
		{
			addActionMessage("��������������ʾ��");
			return SUCCESS;
		}
		return ERROR;
	}
}