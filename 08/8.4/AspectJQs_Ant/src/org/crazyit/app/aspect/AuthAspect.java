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
public aspect AuthAspect
{
	// ָ����ִ��org.crazyit.app.service����������ġ����ⷽ��֮ǰִ����������
	// ��һ���Ǻű�ʾ����ֵ���ޣ��ڶ����Ǻű�ʾ�������ޣ�
	// �������Ǻű�ʾ���������ޣ�Բ������..����������������Ͳ��޵��β�
	before(): execution(* org.crazyit.app.service.*.*(..))
	{
		System.out.println("ģ�����Ȩ�޼��...");
	}
}
