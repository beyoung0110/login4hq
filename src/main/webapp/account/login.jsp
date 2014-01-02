<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <base href="<%= request.getScheme() + "://" + request.getServerName() + 
  		":" + request.getServerPort() + request.getContextPath() %>/" />
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>小青青的登录系统</title>
</head>
<body>

<form action="account/logincheck" method="post" onsubmit="return loginCheck();">
	<table cellpadding="4px" id="account" width="95%">
		<tr class="stuspecial">
			<td class="middlesize rightalign" width="85px">用户名</td>
			<td colspan="2">
				<input type="text" name="user" placeholder="用户名"  id="txidcode" class="editline topmargin_5" value=""/>
			</td>
		</tr>
		<tr>
			<td class="middlesize rightalign">密码</td>
			<td colspan="2">
	 		<input type="password" name="passwordMd5" class="editline topmargin_5" value="" id="txpwd" />
			</td>
		</tr>
		<tr>
			<td></td>
			<td class="leftalign">
			<button type="submit" class="button">登录</button>
			</td>
			<td class="leftalign">
				<span class="redletter" id="error"><s:property value="message" /><br /></span>
			</td>
		</tr>
	</table>
</form>

<form action="account/adduser" method="post">
	<table cellpadding="4px" id="account" width="95%">
		<tr class="stuspecial">
			<td class="middlesize rightalign" width="85px">用户名</td>
			<td colspan="2">
				<input type="text" name="newuser" placeholder="用户名" class="editline topmargin_5" value=""/>
			</td>
		</tr>
		<tr>
			<td class="middlesize rightalign">密码</td>
			<td colspan="2">
	 		<input type="password" name="newpassword" class="editline topmargin_5" value="" />
			</td>
		</tr>
		<tr>
			<td></td>
			<td class="leftalign">
			<button type="submit" class="button">注册</button>
			</td>
		</tr>
	</table>
</form>

</body>
</html>