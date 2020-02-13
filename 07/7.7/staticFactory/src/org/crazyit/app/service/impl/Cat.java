package org.crazyit.app.service.impl;

import org.crazyit.app.service.*;
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
public class Cat implements Being
{
	private String msg;
	// msg的setter方法
	public void setMsg(String msg)
	{
		this.msg = msg;
	}
	// 实现接口必须实现的testBeing方法
	public void testBeing()
	{
		System.out.println(msg +
			"，猫喜欢吃老鼠");
	}
}
