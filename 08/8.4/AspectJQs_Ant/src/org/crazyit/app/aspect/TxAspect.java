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
public aspect TxAspect
{
	// ָ����ִ��org.crazyit.app.service����������ġ����ⷽ��ʱִ����������
	Object around():call(* org.crazyit.app.service.*.*(..))
	{
		System.out.println("ģ�⿪������...");
		// �ص�ԭ����Ŀ�귽��
		Object rvt = proceed();
		System.out.println("ģ���������...");
		return rvt;
	}
}