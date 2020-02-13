package org.crazyit.app.factory;

import org.crazyit.app.service.impl.*;
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
public class BeingFactory
{
	// ����Beingʵ���ľ�̬��������
	// arg�������������ĸ�Being���ʵ��
	public static Being getBeing(String arg)
	{
		// ���ô˾�̬�����Ĳ���Ϊdog���򷵻�Dogʵ��
		if (arg.equalsIgnoreCase("dog"))
		{
			return new Dog();
		}
		// ���򷵻�Catʵ��
		else
		{
			return new Cat();
		}
	}
}
