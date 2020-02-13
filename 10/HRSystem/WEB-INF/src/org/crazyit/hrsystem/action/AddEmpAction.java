package org.crazyit.hrsystem.action;

import org.crazyit.hrsystem.action.base.MgrBaseAction;
import org.crazyit.hrsystem.domain.Employee;

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
public class AddEmpAction extends MgrBaseAction
{
	private static final long serialVersionUID = 48L;
	// 代表新增员工的成员变量
	private Employee emp;

	// emp的setter和getter方法
	public void setEmp(Employee emp)
	{
		this.emp = emp;
	}
	public Employee getEmp()
	{
		return this.emp;
	}

	public String execute()
		throws Exception
	{
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		// 获取HttpSession中的user属性
		String mgrName = (String)ctx.getSession()
			.get(WebConstant.USER);
		// 添加新用户
		mgr.addEmp(emp , mgrName);
		clearMessages();
		addActionMessage("新增员工成功");
		return SUCCESS;
	}
}