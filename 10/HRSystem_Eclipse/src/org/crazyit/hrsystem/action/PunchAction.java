package org.crazyit.hrsystem.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.crazyit.hrsystem.action.base.EmpBaseAction;

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
public class PunchAction extends EmpBaseAction
{
	private static final long serialVersionUID = 48L;
	// 封装处理结果的punchIsValid成员变量
	private int punchIsValid;
	// punchIsValid成员变量的setter和getter方法
	public void setPunchIsValid(int punchIsValid)
	{
		this.punchIsValid = punchIsValid;
	}
	public int getPunchIsValid()
	{
		return this.punchIsValid;
	}
	public String execute()
		throws Exception
	{
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		// 获取HttpSession中的user属性
		String user = (String)ctx.getSession()
			.get(WebConstant.USER);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 格式化当前时间
		String dutyDay = sdf.format(new Date());
		// 调用业务逻辑方法处理用户请求
		int result = mgr.validPunch(user , dutyDay);
		setPunchIsValid(result);
		return SUCCESS;
	}
}