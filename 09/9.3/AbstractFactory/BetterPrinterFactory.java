
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
public class BetterPrinterFactory
	implements OutputFactory
{
	public Output getOutput()
	{
		// 该工厂只负责产生BetterPrinter对象
		return new BetterPrinter();
	}
}
