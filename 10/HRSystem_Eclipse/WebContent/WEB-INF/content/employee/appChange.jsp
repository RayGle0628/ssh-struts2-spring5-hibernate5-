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
   <title>����춯����</title>
   <s:head/>
</head>
<body">
<%@include file="../header.jsp"%>
<%@include file="empheader.jsp"%>
<div class="container">
<div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title">
    <s:property value="#session.user"/>������д�춯����</h3>
  </div>
<form action="processApp" method="post" class="form-horizontal">
<input type="hidden" name="attId" value="${param.attid}"/>
<s:if test="fieldErrors.size()>0">
  <div class="form-group">
    <div class="col-sm-12 text-danger text-center">
    <s:fielderror/>
    </div>
  </div>
</s:if>
  <div class="form-group">
    <label for="type_id" class="col-sm-3 control-label">�������</label>
    <div class="col-sm-9">
      <select type="text" class="form-control" id="type_id"
        name="typeId" placeholder="�û���">
        <s:iterator value="types" var="ty">
          <option value="${ty.id}">${ty.name}</option>
        </s:iterator>
      </select>
    </div>
  </div>
  <div class="form-group">
    <label for="reason" class="col-sm-3 control-label">��������</label>
    <div class="col-sm-9">
      <textarea class="form-control" id="reason" rows="4" col="20"
        name="reason" placeholder="��д��������"></textarea>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-3 col-sm-9">
      <button type="submit" class="btn btn-default">�ύ����</button>
      <button type="reset" class="btn btn-danger">����</button>
    </div>
  </div>
</form>
</div>
</div>
<%@include file="../footer.jsp"%>
</body>
</html>