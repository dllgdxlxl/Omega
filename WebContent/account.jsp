<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>account</title>
</head>
<body>
登陆状态：${type}<form action="logout" method="post">
<input type="submit" value="注销" >
</form>
普通用户注册
<form action="registerUser" method="post">
账户:<input name="account" type="text"><br/>
密码:<input name="password" type="password"><br/>
邮箱:<input name="mail" type="text"> <br/>
<input type="submit" value="提交">
</form>
普通用户登录
<form action="loginUser" method="post">
账户:<input type="text" name="account" ><br/>
密码:<input type="text" name="password"><br/>
<input type="submit" value="提交">
</form>
管理员注册
<form action="registerManager" method="post">
账户:<input name="account" type="text"><br/>
密码:<input name="password" type="password"><br/>
邮件:<input name="mail" type="text"> <br/>
<input type="submit" value="提交">
</form>
管理员登录
<form action="loginManager" method="post">
账户:<input type="text" name="account"><br/>
密码:<input type="text" name="password"><br/>
<input type="submit" value="提交">
</form>
<br/>
更改用户信息
<form action="updateUser" method="post">
密码:<input type="text" name="password"><br/>
手机:<input type="text" name="phone"><br/>
地址:<input type="text" name="address"><br/>
邮政:<input type="text" name="postCode"><br/>
<input type="submit" value="提交">
</form>
<br/>
更改管理员信息
<form action="updateManager" method="post">
密码:<input type="text" name="password"><br/>
手机:<input type="text" name="phone"><br/>
名字:<input type="text" name="name"><br/>
<input type="submit" value="提交">
</form>
<br/>
</body>
</html>