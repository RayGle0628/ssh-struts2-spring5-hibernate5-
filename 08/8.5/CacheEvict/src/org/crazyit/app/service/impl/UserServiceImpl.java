package org.crazyit.app.service.impl;

import org.crazyit.app.service.UserService;
import org.crazyit.app.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Scope;

/**
 * Description: <br/>
 * ��վ: <a href="http://www.crazyit.org">���Java����</a> <br/>
 * Copyright (C), 2001-2018, Yeeku.H.Lee <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: <br/>
 * Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
@Service("userService")
@Cacheable(value = "users")
public class UserServiceImpl implements UserService
{
	public User getUsersByNameAndAge(String name, int age)
	{
		System.out.println("--����ִ��findUsersByNameAndAge()��ѯ����--");
		return new User(name, age);
	}
	public User getAnotherUser(String name, int age)
	{
		System.out.println("--����ִ��findAnotherUser()��ѯ����--");
		return new User(name, age);
	}
	// ָ������name��age�����������
	@CacheEvict(value = "users")
	public void evictUser(String name, int age)
	{
		System.out.println("--�������"+ name
			+ " , " + age + "��Ӧ�Ļ���--");
	}
	// ָ�����user���������л�������
	@CacheEvict(value = "users" , allEntries=true)
	public void evictAll()
	{
		System.out.println("--���������������--");
	}
}