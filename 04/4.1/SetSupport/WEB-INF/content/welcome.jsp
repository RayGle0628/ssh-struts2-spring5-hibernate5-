<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>ת�����</title>
</head>
<body>
	<s:actionmessage/>
	<s:property value="users"/>
<!-- ����users������������������ֵΪcrazyit.org��Ԫ�ص�name����-->
�û�crazyit.org���û���Ϊ��<s:property value="users('crazyit.org').name"/><br/>
<!-- ����users������������������ֵΪcrazyit.org��Ԫ�ص�pass����-->
�û�crazyit.org������Ϊ��<s:property value="users('crazyit.org').pass"/><br/>
<!-- ����users������������������ֵΪfkit��Ԫ�ص�name����-->
�û�fkit���û���Ϊ��<s:property value="users('fkit').name"/><br/>
<!-- ����users������������������ֵΪfkit��Ԫ�ص�pass����-->
�û�fkit������Ϊ��<s:property value="users('fkit').pass"/><br/>
����Ϊ��<s:property value="birth"/><br/>
</body>
</html>
