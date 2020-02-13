package org.crazyit.hrsystem.action;

import org.crazyit.hrsystem.action.base.EmpBaseAction;

/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2018, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class ProcessAppAction extends EmpBaseAction
{
	private static final long serialVersionUID = 48L;
	// 申请异动的出勤ID
	private int attId;
	// 希望改变到出勤类型
	private int typeId;
	// 申请理由
	private String reason;
	// attId的setter和getter方法
	public void setAttId(int attId)
	{
		this.attId = attId;
	}
	public int getAttId()
	{
		return this.attId;
	}

	// typeId的setter和getter方法
	public void setTypeId(int typeId)
	{
		this.typeId = typeId;
	}
	public int getTypeId()
	{
		return this.typeId;
	}

	// reason的setter和getter方法
	public void setReason(String reason)
	{
		this.reason = reason;
	}
	public String getReason()
	{
		return this.reason;
	}

	// 处理用户请求
	public String execute()
		throws Exception
	{
		// 处理异动申请
		boolean result = mgr.addApplication(attId , typeId , reason);
		// 如果申请成功
		if(result)
		{
			addActionMessage("您已经申请成功，等待经理审阅");
		}
		else
		{
			addActionMessage("申请失败，请注意不要重复申请");
		}
		return SUCCESS;
	}
}