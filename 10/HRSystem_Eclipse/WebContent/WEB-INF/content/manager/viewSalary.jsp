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
   <title>����鿴�Լ��Ĺ���</title>
</head>
<body>
<%@include file="../header.jsp"%>
<%@include file="mgrheader.jsp"%>
<div class="container">
<div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title">
    ��ǰ�û���<s:property value="#session.user"/></h3>
  </div>
  <div class="panel-body">
    <table class="table table-striped table-hover">
      <thead>
        <tr>
          <th>��н�·�</th>
          <th>нˮ</th>
        </tr>
      </thead>
      <tbody>
        <s:iterator value="salarys">  
        <tr>
          <td><s:property value="payMonth"/></td>
          <td><s:property value="amount"/></td>
        </tr>
        </s:iterator>
      </tbody>
    </table>
  </div>
</div>
<%@include file="../footer.jsp"%>
</body>
</html>