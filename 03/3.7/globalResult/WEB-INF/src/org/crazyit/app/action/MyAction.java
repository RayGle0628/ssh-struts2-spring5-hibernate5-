package org.crazyit.app.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
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

public class MyAction extends ActionSupport
{
	// ��װ���������target��Ա����
	private String target;

	// target��setter��getter����
	public void setTarget(String target)
	{
		this.target = target;
	}
	public String getTarget()
	{
		return this.target;
	}

	public String execute()
		throws Exception
	{
		addActionMessage("��ϲ��,���Ѿ��ɹ�ת��");
		return SUCCESS;
	}
}