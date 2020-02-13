package lee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.crazyit.app.service.*;
import org.crazyit.app.domain.*;
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
public class BeanTest
{
	public static void main(String[] args)throws Exception
	{
		// ����Spring����
		ApplicationContext ctx = new
			ClassPathXmlApplicationContext("beans.xml");
		UserService us = ctx.getBean("userService", UserService.class);
		us.addEntity(new User());
		ItemService is = ctx.getBean("itemService", ItemService.class);
		is.addEntity(new Item());
	}
}