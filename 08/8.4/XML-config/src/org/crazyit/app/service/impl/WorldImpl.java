package org.crazyit.app.service.impl;

import org.springframework.stereotype.Component;
import org.crazyit.app.service.*;
/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2018, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
@Component("world")
public class WorldImpl implements World
{
	// ����һ���򵥷�����ģ��Ӧ���е�ҵ���߼�����
	public void bar()
	{
		System.out.println("ִ��World�����bar()����");
	}
}
