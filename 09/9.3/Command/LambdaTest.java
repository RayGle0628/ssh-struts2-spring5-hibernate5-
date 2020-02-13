

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
public class LambdaTest
{
	public static void main(String[] args)
	{
		ProcessArray pa = new ProcessArray();
		int[] target = {3, -4, 6, 4};
		// ��һ�δ������飬���崦����Ϊȡ����Lambda���ʽ
		pa.each(target , array -> {
			for (int tmp : array )
			{
				System.out.println("�������Ŀ�������Ԫ��:" + tmp);
			}
		});
		System.out.println("------------------");
		// �ڶ��δ������飬���崦����Ϊȡ����Lambda���ʽ
		pa.each(target , array -> {
			int sum = 0;
			for (int tmp : array )
			{
				sum += tmp;
			}
			System.out.println("����Ԫ�ص��ܺ���:" + sum);
		});
	}
}
