package org.crazyit.app.service.impl;

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
public abstract class Chinese implements Person
{
	private Dog dog;
	// ������󷽷����÷������ڻ�ȡ������Bean
	public abstract Dog getDog();
	public void hunt()
	{
		System.out.println("�Ҵ��ţ�" + getDog() + "��ȥ����");
		System.out.println(getDog().run());
	}
}
