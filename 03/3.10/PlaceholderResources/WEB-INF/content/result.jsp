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
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<s:i18n name="viewResources.result">
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title><s:text name="resultPage"/></title>
</head>
<body>
	<jsp:useBean id="d" class="java.util.Date" scope="page"/>
	${requestScope.tip}<br/>
	<!-- �����ռλ���Ĺ��ʻ���Ϣ -->
	<s:text name="welcomeMsg">
		<s:param><s:property value="username"/></s:param>
		<s:param>${d}</s:param>
	</s:text>
</body>
</html>
</s:i18n>