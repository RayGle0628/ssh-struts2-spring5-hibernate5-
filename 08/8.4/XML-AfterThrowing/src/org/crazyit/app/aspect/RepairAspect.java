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
public class RepairAspect
{
	// ����һ����ͨ������ΪAdvice����
	// �β�ex���ڷ���Ŀ�귽�����׳����쳣
	public void doRecoveryActions(Throwable ex)
	{
		System.out.println("Ŀ�귽�����׳����쳣:" + ex);
		System.out.println("ģ��Advice���쳣���޸�...");
	}
}


