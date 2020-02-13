package lee;import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;import java.util.*;
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
		// ʵ����ApplicationContext
		ApplicationContext ctx = new
			ClassPathXmlApplicationContext("beans.xml");
		// ʹ��getMessage()������ȡ���ػ���Ϣ��
		// Locale��getDefault�������ؼ����������Ĭ��Locale
		String hello = ctx.getMessage("hello" , new String[]{"�����"}
			, Locale.getDefault(Locale.Category.FORMAT));
		String now = ctx.getMessage("now" , new Object[]{new Date()}
			, Locale.getDefault(Locale.Category.FORMAT));
		// ��ӡ���������ػ���Ϣ
		System.out.println(hello);
		System.out.println(now);
	}
}