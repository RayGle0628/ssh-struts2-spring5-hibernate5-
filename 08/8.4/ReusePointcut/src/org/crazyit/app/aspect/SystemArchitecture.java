package org.crazyit.app.aspect;

import org.aspectj.lang.annotation.*;
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
@Aspect
public class SystemArchitecture
{
	@Pointcut("execution(* org.crazyit.app.service.impl.*.*(..))")
	public void myPointcut(){}
}

