package org.crazyit.app.service.impl;

import org.crazyit.app.service.*;
import org.crazyit.app.config.*;
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
public class Chinese implements Person
{
	private Axe axe;
	private String name;
	// axe的setter方法
	public void setAxe(Axe axe)
	{
		this.axe = axe;
	}
	// name的setter方法
	public void setName(String name)
	{
		this.name = name;
	}
	// 实现Person接口的useAxe()方法
	public void useAxe()
	{
		// 调用axe的chop()方法，表明Person对象依赖于axe对象
		System.out.println("我是："	+ name
			+ axe.chop());
	}
}