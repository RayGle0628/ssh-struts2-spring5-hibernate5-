

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
public class PaymentImpl
	implements Payment
{
	// 实现模拟顾客支付费用的方法
	public String pay()
	{
		String food = "快餐";
		System.out.println("你已经向收银员支付了费用，您购买的食物是："
			+ food);
		return food;
	}
}

