package lee;

import javax.servlet.*;
import java.io.*;

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
public class MyReadListener implements ReadListener
{
	private ServletInputStream input;
	private AsyncContext context;
	public MyReadListener(ServletInputStream input , AsyncContext context)
	{
		this.input = input;
		this.context = context;
	}

	@Override
	public void onDataAvailable()
	{
		System.out.println("���ݿ��ã���");
		try
		{
			// ��ͣ5�룬ģ���ȡ������һ����ʱ������
			Thread.sleep(5000);
			StringBuilder sb = new StringBuilder();
			int len = -1;
			byte[] buff = new byte[1024];
			// ����ԭʼIO��ʽ��ȡ�������Servlet�ύ������
			while (input.isReady() && (len = input.read(buff)) > 0)
			{
				String data = new String(buff , 0 , len);
				sb.append(data);
			}
			System.out.println(sb);
			// ����������Ϊrequest��Χ������
			context.getRequest().setAttribute("info" , sb.toString());
			// ת������ͼҳ��
			context.dispatch("/async.jsp");
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	@Override
	public void onAllDataRead()
	{
		System.out.println("���ݶ�ȡ���");
	}
	@Override
	public void onError(Throwable t)
	{
		t.printStackTrace();
	}
}
