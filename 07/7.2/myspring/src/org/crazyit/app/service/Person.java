package org.crazyit.app.service;

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
public class Person
{
	private Axe axe;
	// 设值注入所需的setter方法
	public void setAxe(Axe axe)
	{
		this.axe = axe;
	}
	public void useAxe()
	{
		System.out.println("我打算去砍点柴火！");
		// 调用axe的chop()方法，
		// 表明Person对象依赖于axe对象
		System.out.println(axe.chop());
	}
}
