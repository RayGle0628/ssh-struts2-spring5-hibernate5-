<%@ page contentType="text/html; charset=GBK" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Java EE�򵥹�����ϵͳ</title>
<s:head/>
</head>
<body>
<%@include file="header.jsp"%>
<div class="container">
<div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title">�������û�������������¼</h3>
  </div>
<form action="processLogin" method="post" class="form-horizontal">
<s:if test="actionMessages.size()>0">
  <div class="row">
    <div class="col-sm-12 text-info text-center">
    <s:actionmessage/>
    </div>
  </div>
</s:if>
<s:if test="actionErrors.size()>0">
  <div class="row">
  <div class="col-sm-12 text-danger text-center">
    <s:actionerror/>
  </div>
  </div>
</s:if>
<s:if test="fieldErrors.size()>0">
  <div class="form-group">
    <div class="col-sm-12 text-danger text-center">
    <s:fielderror/>
    </div>
  </div>
</s:if>
  <div class="form-group">
    <label for="manager_name" class="col-sm-3 control-label">�û���</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" id="manager_name"
    name="manager.name" placeholder="�û���">
    </div>
  </div>
  <div class="form-group">
    <label for="passwd" class="col-sm-3 control-label">����</label>
    <div class="col-sm-9">
      <input type="password" class="form-control" id="manager_pass"
    name="manager.pass" placeholder="����">
    </div>
  </div>
  <div class="form-group">
    <label for="vercode" class="col-sm-3 control-label">��֤��</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="vercode"
    name="vercode" placeholder="��֤��">
    </div>
  <div class="col-sm-3">
    <img name="d" src="authImg">
  </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-3 col-sm-9">
      <button type="submit" class="btn btn-default">�ύ</button>
      <button type="reset" class="btn btn-danger">����</button>
    </div>
  </div>
</form>
</div>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
