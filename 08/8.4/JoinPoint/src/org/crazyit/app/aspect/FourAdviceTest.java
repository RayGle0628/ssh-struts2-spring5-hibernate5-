package org.crazyit.app.aspect;

import org.aspectj.lang.annotation.*;
import org.aspectj.lang.*;

import java.util.Arrays;
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
public class FourAdviceTest
{
	// ����Around��ǿ����
	@Around("execution(* org.crazyit.app.service.impl.*.*(..))")
	public Object processTx(ProceedingJoinPoint jp)
		throws java.lang.Throwable
	{
		System.out.println("Around��ǿ��ִ��Ŀ�귽��֮ǰ��ģ�⿪ʼ����...");
		// ����ִ��Ŀ�귽���Ĳ���
		Object[] args = jp.getArgs();
		// ��ִ��Ŀ�귽���Ĳ������ڣ�
		// �ҵ�һ���������ַ�������
		if (args != null && args.length > 0
			&& args[0].getClass() == String.class)
		{
			// �޸�Ŀ�귽�����ò����ĵ�һ������
			args[0] = "�����ӵ�ǰ׺��" + args[0];
		}
		//ִ��Ŀ�귽����������Ŀ�귽��ִ�к�ķ���ֵ
		Object rvt = jp.proceed(args);
		System.out.println("Around��ǿ��ִ��Ŀ�귽��֮��ģ���������...");
		// ���rvt��������Integer����rvt��Ϊ����ƽ��
		if(rvt != null && rvt instanceof Integer)
			rvt = (Integer)rvt * (Integer)rvt;
		return rvt;
	}
	// ����Before��ǿ����
	@Before("execution(* org.crazyit.app.service.impl.*.*(..))")
	public void authority(JoinPoint jp)
	{
		System.out.println("Before��ǿ��ģ��ִ��Ȩ�޼��");
		// ���ر�֯����ǿ�����Ŀ�귽��
		System.out.println("Before��ǿ����֯����ǿ�����Ŀ�귽��Ϊ��"
			+ jp.getSignature().getName());
		// ����ִ��Ŀ�귽���Ĳ���
		System.out.println("Before��ǿ��Ŀ�귽���Ĳ���Ϊ��"
			+ Arrays.toString(jp.getArgs()));
		// ���ʱ���ǿ�����Ŀ�����
		System.out.println("Before��ǿ����֯����ǿ�����Ŀ�����Ϊ��"
			+ jp.getTarget());
	}
	//����AfterReturning��ǿ����
	@AfterReturning(pointcut="execution(* org.crazyit.app.service.impl.*.*(..))"
		, returning="rvt")
	public void log(JoinPoint jp , Object rvt)
	{
		System.out.println("AfterReturning��ǿ����ȡĿ�귽������ֵ:"
			+ rvt);
		System.out.println("AfterReturning��ǿ��ģ���¼��־����...");
		// ���ر�֯����ǿ�����Ŀ�귽��
		System.out.println("AfterReturning��ǿ����֯����ǿ�����Ŀ�귽��Ϊ��"
			+ jp.getSignature().getName());
		// ����ִ��Ŀ�귽���Ĳ���
		System.out.println("AfterReturning��ǿ��Ŀ�귽���Ĳ���Ϊ��"
			+ Arrays.toString(jp.getArgs()));
		// ���ʱ���ǿ�����Ŀ�����
		System.out.println("AfterReturning��ǿ����֯����ǿ�����Ŀ�����Ϊ��"
			+ jp.getTarget());
	}

	// ����After��ǿ����
	@After("execution(* org.crazyit.app.service.impl.*.*(..))")
	public void release(JoinPoint jp)
	{
		System.out.println("After��ǿ��ģ�ⷽ����������ͷ���Դ...");
		// ���ر�֯����ǿ�����Ŀ�귽��
		System.out.println("After��ǿ����֯����ǿ�����Ŀ�귽��Ϊ��"
			+ jp.getSignature().getName());
		// ����ִ��Ŀ�귽���Ĳ���
		System.out.println("After��ǿ��Ŀ�귽���Ĳ���Ϊ��"
			+ Arrays.toString(jp.getArgs()));
		// ���ʱ���ǿ�����Ŀ�����
		System.out.println("After��ǿ����֯����ǿ�����Ŀ�����Ϊ��"
			+ jp.getTarget());
	}
}
