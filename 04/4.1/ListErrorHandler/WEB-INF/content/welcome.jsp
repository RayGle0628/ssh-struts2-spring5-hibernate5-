<%--
��վ: <a href="http://www.crazyit.org">���Java����</a>
author  yeeku.H.lee kongyeeku@163.com
version  1.0
Copyright (C), 2001-2018, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>

<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>ת�����</title>
</head>
<body>
	ת�����!<br/>
	<s:iterator value="users" status="status">
		�û�<s:property value="%{#status.index}"/>���û�����<s:property value="name"/><br/>
		�û�<s:property value="%{#status.index}"/>�����룺<s:property value="pass"/><br/>
	</s:iterator>
</body>
</html>