<%--
��վ: <a href="http://www.crazyit.org">���Java����</a>
author  yeeku.H.lee kongyeeku@163.com
version  1.0
Copyright (C), 2001-2018, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>

<%@ page contentType="text/html; charset=GBK" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>���Ӵ�</title>
</head>
<body>
<%@include file="../header.jsp"%>
<%@include file="mgrheader.jsp"%> 
<div class="container">
<div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title">���Ӵ�ϵͳ</h3>
  </div>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <div class="row">
    <div class="col-sm-offset-5 col-sm-2">
      <s:property value="#session.user"/> ��
    </div>
  </div>
  <div class="row">
    <div class="col-sm-offset-4 col-sm-2">
<!-- ��punchIsValidΪ1��3ʱ�����ϰ�� -->
<s:if test="punchIsValid==1 
	|| punchIsValid==3">
    <a href="${pageContext.request.contextPath}/managerCome"
	  class="btn btn-default">�ϰ��
	</a>
</s:if>
	</div>
	<div class="col-sm-2">
<!-- ��punchIsValidΪ2��3ʱ�����°�� -->	
<s:if test="punchIsValid==2
	|| punchIsValid==3">
    <a href="${pageContext.request.contextPath}/managerLeave"
	  class="btn btn-default">�°��
	</a>
</s:if>
  </div>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
</div>
</div>
<%@include file="../footer.jsp"%> 
</body>
</html>
