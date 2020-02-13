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

@WebServlet(name="upload" , urlPatterns={"/upload"})
@MultipartConfig
public class UploadServlet extends HttpServlet
{
	public void service(HttpServletRequest request ,
		HttpServletResponse response)
		throws IOException , ServletException
	{
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("GBK");
		// ��ȡ��ͨ�������
		String name = request.getParameter("name");
		out.println("��ͨ��name����Ϊ��" + name + "<br/>");
		// ��ȡ�ļ��ϴ���
		Part part = request.getPart("file");
		// ��ȡ�ϴ��ļ����ļ�����
		out.println("�ϴ��ļ�������Ϊ��"
			+ part.getContentType() + "<br/>");
		//��ȡ�ϴ��ļ��Ĵ�С��
		out.println("�ϴ��ļ��Ĵ�СΪ��" + part.getSize()  + "<br/>");
		// ��ȡ���ļ��ϴ����Header Name
		Collection<String> headerNames = part.getHeaderNames();
		// �����ļ��ϴ����Header Name��Value
		for (String headerName : headerNames)
		{
			out.println(headerName + "--->"
				+ part.getHeader(headerName) + "<br/>");
		}
		// ��ȡ����ԭʼ�ļ������ַ���
		String fileNameInfo = part.getHeader("content-disposition");
		// ��ȡ�ϴ��ļ���ԭʼ�ļ���
		String fileName = fileNameInfo.substring(
			fileNameInfo.indexOf("filename=\"") + 10 , fileNameInfo.length() - 1);
		// ���ϴ����ļ�д�������
		part.write(getServletContext().getRealPath("/uploadFiles")
			+ "/" + fileName );               // ��
	}
}