package lee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.*;
import java.util.*;

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
public class GetBooksTarget implements Runnable
{
	private AsyncContext actx = null;
	public GetBooksTarget(AsyncContext actx)
	{
		this.actx = actx;
	}
	public void run()
	{
		try
		{
			// �ȴ�5���ӣ���ģ��ҵ�񷽷���ִ��
			Thread.sleep(5 * 1000);
			ServletRequest request = actx.getRequest();
			List<String> books = new ArrayList<String>();
			books.add("���Java����");
			books.add("������Java EE��ҵӦ��ʵս");
			books.add("���ǰ�˿�������");
			request.setAttribute("books" , books);
			actx.dispatch("/async.jsp");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
