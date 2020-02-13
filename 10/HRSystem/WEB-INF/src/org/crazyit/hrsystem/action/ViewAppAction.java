package org.crazyit.hrsystem.action;

import java.util.List;

import org.crazyit.hrsystem.action.base.MgrBaseAction;
import org.crazyit.hrsystem.vo.AppBean;

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

public class ViewAppAction extends MgrBaseAction
{
	private static final long serialVersionUID = 48L;
	private List<AppBean> apps;
	// apps的setter和getter方法
	public void setApps(List<AppBean> apps)
	{
		this.apps = apps;
	}
	public List<AppBean> getApps()
	{
		return this.apps;
	}
	public String execute()
		throws Exception
	{
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		// 获取HttpSession中的user属性
		String mgrName = (String)ctx.getSession()
			.get(WebConstant.USER);
		// 获取需要被当前经理处理的全部申请
		setApps(mgr.getAppsByMgr(mgrName));
		return SUCCESS;
	}
}