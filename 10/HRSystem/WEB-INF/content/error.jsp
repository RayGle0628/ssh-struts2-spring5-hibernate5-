<%@ page contentType="text/html; charset=GBK" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>������ʾ</title>
</head>
<body>
<%@include file="header.jsp"%>
<div class="container">
<div class="panel panel-danger text-center">
  <div class="panel-heading">
    <h4>ϵͳ��������з�����һ��������Ϣ���£�</h4>
  </div>
  <p>&nbsp;</p>
  <s:property value="exception.message"/>
  <p>&nbsp;</p>
  <div class="panel-footer">
�����Ⱥ˶����룬����ٴγ��ָô���<br>
���¼<a href="http://www.crazyit.org">http://www.crazyit.org</a>Ѱ��𰸣�лл��
   </div>
</div>
</div>
<%@include file="footer.jsp"%> 
</body>
</html>

