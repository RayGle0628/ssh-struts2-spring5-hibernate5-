package org.crazyit.app.aspect;

import org.aspectj.lang.annotation.*;
import org.aspectj.lang.*;

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
// ����һ������
@Aspect
public class ReleaseAspect
{
	// ƥ��org.crazyit.app.service�����������
	// ���з�����ִ����Ϊ�����
	@After("execution(* org.crazyit.app.service.*.*(..))")
	public void release()
	{
		System.out.println("ģ�ⷽ����������ͷ���Դ...");
	}
}

