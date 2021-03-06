package org.crazyit.app.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.*;

/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2018, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class RegistAction extends ActionSupport
{
	private String name;
	private String pass;
	private int age;
	private Date birth;

	// name的setter和getter方法
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}

	// pass的setter和getter方法
	public void setPass(String pass)
	{
		this.pass = pass;
	}
	public String getPass()
	{
		return this.pass;
	}

	// age的setter和getter方法
	public void setAge(int age)
	{
		this.age = age;
	}
	public int getAge()
	{
		return this.age;
	}

	// birth的setter和getter方法
	public void setBirth(Date birth)
	{
		this.birth = birth;
	}
	public Date getBirth()
	{
		return this.birth;
	}

	public String regist()
	{
		return SUCCESS;
	}

	public void validate()
	{
		System.out.println("进入validate()方法进行校验" + name);
		// 要求用户名必须包含crazyit子串
		if(!name.contains("crazyit"))
		{
			addFieldError("user" , "您的用户名必须包含crazyit！");
		}
	}
	public void validateRegist()
	{
		System.out.println("进入validateRegist()方法进行校验" + name);
		// 要求用户名必须包含.org子串
		if(!name.contains(".org"))
		{
			addFieldError("user" , "您的用户名必须包含.org！");
		}
	}
}