package lee;

import org.springframework.context.*;
import org.springframework.context.support.*;

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
public class SpringTest
{
	public static void main(String[] args)throws Exception
	{
		ApplicationContext ctx = new
			ClassPathXmlApplicationContext("beans.xml");
		// ����2�д����ȡ��FactoryBean�Ĳ�Ʒ
		System.out.println(ctx.getBean("north"));
		System.out.println(ctx.getBean("theValue"));
		// �������ɻ�ȡ��FactoryBean����
		System.out.println(ctx.getBean("&theValue"));
	}
}