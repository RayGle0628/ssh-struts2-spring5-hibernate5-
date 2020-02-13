package org.crazyit.hrsystem.action;

import org.crazyit.hrsystem.action.base.MgrBaseAction;

import com.opensymphony.xwork2.ActionContext;

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
public class CheckAppAction extends MgrBaseAction
{
	private static final long serialVersionUID = 48L;
	// 需要被处理的申请ID
	private int appid;
	// 封装处理结果
	private String result;
	// appid的setter和getter方法
	public void setAppid(int appid)
	{
		this.appid = appid;
	}
	public int getAppid()
	{
		return this.appid;
	}

	// result的setter和getter方法
	public void setResult(String result)
	{
		this.result = result;
	}
	public String getResult()
	{
		return this.result;
	}

	public String execute()
		throws Exception
	{
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		// 获取HttpSession中的user属性
		String mgrName = (String)ctx.getSession()
			.get(WebConstant.USER);
		// 通过申请
		if (result.equals("pass"))
		{
			mgr.check(appid, mgrName, true);
		}
		// 拒绝申请
		else if (result.equals("deny"))
		{
			mgr.check(appid, mgrName, false);
		}
		else
		{
			throw new Exception("参数丢失");
		}
		return SUCCESS;
	}
}