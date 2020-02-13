package org.crazyit.app.service.impl;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

import org.crazyit.app.dao.*;
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
public class BaseServiceImpl<T> implements BaseService<T>
{
	@Autowired
	private BaseDao<T> dao;
	public void addEntity(T entity)
	{
		System.out.println("����" + dao
			+ "����ʵ�壺" + entity);
	}
}