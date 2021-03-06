package lee;

import org.springframework.context.*;
import org.springframework.context.support.*;
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
public class BeanTest
{
	public static void main(String[] args)
	{
		// 创建Spring容器
		ApplicationContext ctx = new
			ClassPathXmlApplicationContext("beans.xml");
		// 获取Spring容器中的所有Bean实例的名
		System.out.println(ctx.getBean("person"));
	}
}