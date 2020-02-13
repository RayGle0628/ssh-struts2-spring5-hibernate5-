package org.crazyit.app.action;

import com.opensymphony.xwork2.ActionSupport;

import org.crazyit.app.service.*;
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
	// ���������ڷ�װ�û����������������Ա����
	private String username;
	private String password;
	// ϵͳ���õ�ҵ���߼����
	private MyService ms;
	// ��ֵע��ҵ���߼�����������setter����
	public void setMs(MyService ms)
	{
		this.ms = ms;
	}
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

	// �����û������execute����
	public String execute() throws Exception
	{
		// ����ҵ���߼������validLogin()����
		// ��֤�û�������û����������Ƿ���ȷ
		if (ms.validLogin(getUsername(), getPassword()) > 0)
		{
			addActionMessage("���������ϳɹ���");
			return SUCCESS;
		}
		return ERROR;
	}
}
