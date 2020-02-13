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
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>������Ա��</title>
<s:head/>
</head>
<body>
<%@include file="../header.jsp"%> 
<%@include file="mgrheader.jsp"%>
<div class="container">
<div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title">
    ����������Ա��������</h3>
  </div>
<form action="processAdd" method="post" class="form-horizontal">
<s:if test="fieldErrors.size()>0">
  <div class="form-group">
    <div class="col-sm-12 text-danger text-center">
    <s:fielderror/>
    </div>
  </div>
</s:if>
<s:token/>
  <div class="form-group">
    <label for="emp_name" class="col-sm-3 control-label">Ա���û���</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" id="emp_name"
        name="emp.name" placeholder="Ա���û���">
    </div>
  </div>
  <div class="form-group">
    <label for="emp_pass" class="col-sm-3 control-label">Ա������</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" id="emp_pass"
        name="emp.pass" placeholder="Ա������">
    </div>
  </div>
  <div class="form-group">
    <label for="emp_salary" class="col-sm-3 control-label">Ա����н</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" id="emp_salary"
        name="emp.salary" placeholder="Ա����н">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-3 col-sm-9">
	  <button type="submit" class="btn btn-default">�����Ա��</button>
      <button type="reset" class="btn btn-danger">��������</button>
    </div>
  </div>
</form>
</div>
</div>
<%@include file="../footer.jsp"%> 
</body>
</html>
