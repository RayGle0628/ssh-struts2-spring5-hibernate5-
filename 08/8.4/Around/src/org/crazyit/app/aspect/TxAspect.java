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
public class TxAspect
{
	// ƥ��org.crazyit.app.service.impl����������ġ�
	// ���з�����ִ����Ϊ�����
	@Around("execution(* org.crazyit.app.service.impl.*.*(..))")
	public Object processTx(ProceedingJoinPoint jp)
		throws java.lang.Throwable
	{
		System.out.println("ִ��Ŀ�귽��֮ǰ��ģ�⿪ʼ����...");
		// ��ȡĿ�귽��ԭʼ�ĵ��ò���
		Object[] args = jp.getArgs();
		if(args != null && args.length > 1)
		{
			// �޸�Ŀ�귽���ĵ�һ������
			args[0] = "�����ӵ�ǰ׺��" + args[0];
		}
		// �Ըı��Ĳ���ȥִ��Ŀ�귽����������Ŀ�귽��ִ�к�ķ���ֵ
		Object rvt = jp.proceed(args);
		System.out.println("ִ��Ŀ�귽��֮��ģ���������...");
		// ���rvt��������Integer����rvt��Ϊ����ƽ��
		if(rvt != null && rvt instanceof Integer)
			rvt = (Integer)rvt * (Integer)rvt;
		return rvt;
	}
}