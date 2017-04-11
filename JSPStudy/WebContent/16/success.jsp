<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录成功</title>
</head>
<body>
登录成功
用户名：<%=request.getParameter("uname")%><br/>
密码  ：<%=request.getParameter("pwd")%><br/>
<a href="/JSPStudy/16/login.jsp">返回登录界面</a>
</body>
</html>