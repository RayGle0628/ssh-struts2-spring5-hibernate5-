package org.crazyit.app.aspect;
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
public aspect LogAspect
{
	// ����һ��PointCut������ΪlogPointcut��
	// ��Pointcut�����˺���������������ʽ�������ɸ��ø��������ʽ
	pointcut logPointcut()
		:execution(* org.crazyit.app.service.*.*(..));
	after():logPointcut()
	{
		System.out.println("ģ���¼��־...");
	}
}
