package lee;

import org.crazyit.app.service.Hello;
import org.crazyit.app.service.World;
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
public class AspectJTest
{
	public static void main(String[] args)
	{
		Hello hello = new Hello();
		hello.addUser("�����" , "7788");
		hello.deleteUser(1);
		World world = new World();
		world.bar();
	}
}
