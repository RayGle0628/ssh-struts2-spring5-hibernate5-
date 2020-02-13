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
<!-- ����baseNameΪviewResources���µ�baseNameΪloginForm�Ĺ��ʻ���Դ�ļ� -->
<s:i18n name="viewResources.loginForm">
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<!-- ʹ��text��ǩ��������ʻ���Ϣ -->
	<title><s:text name="loginPage"/></title>
</head>
<body>
	<s:form action="login">
		<!-- ����ǩ��ʹ��key������������ʻ���Ϣ -->
		<s:textfield name="username" key="user"/>
		<s:textfield name="password" key="pass"/>
		<s:submit key="login"/>
	</s:form>
</body>
</html>
</s:i18n>
