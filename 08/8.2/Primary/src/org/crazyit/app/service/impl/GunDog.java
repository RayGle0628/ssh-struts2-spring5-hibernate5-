package org.crazyit.app.service.impl;

import org.crazyit.app.service.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

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
@Component
public class GunDog implements Dog
{
	@Value("����")
	private String name;
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	public String run()
	{
		return "����һֻ��" + getName()
			+ "����Ȯ������Ѹ��..." ;
	}
}
