package lee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

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
@WebServlet(urlPatterns="/async",asyncSupported=true)
public class AsyncServlet extends HttpServlet
{
	public void service(HttpServletRequest request ,
		HttpServletResponse response)
		throws IOException , ServletException
	{
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		out.println("<title>������IOʾ��</title>");
		out.println("����Servlet��ʱ�䣺"
			+ new java.util.Date() + ".<br/>");
		// ����AsyncContext����ʼ�첽����
		AsyncContext context = request.startAsync();
		// �����첽���õĳ�ʱʱ��
		context.setTimeout(60 * 1000);
		ServletInputStream input = request.getInputStream();
		// Ϊ������ע�������
		input.setReadListener(new MyReadListener(input, context));
		out.println("����Servlet��ʱ�䣺"
			+ new java.util.Date() + ".<br/>");
		out.flush();
	}
}