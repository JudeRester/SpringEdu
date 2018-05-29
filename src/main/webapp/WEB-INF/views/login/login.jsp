<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/webjars/bootstrap/4.1.0/css/bootstrap.css">
<script src="/webjars/jquery/3.3.1/dist/jquery.js"></script>
<script src="/webjars/bootstrap/4.1.0/js/bootstrap.js"></script>

<script>
	$(function(){
		$("#join").on("Click",function(e){
			e.preventDefault();
			location.href="/member/memberJoin";
		});
		$("#login").on("Click",function(e){
			e.preventDefault();
			$("form").submit();
		});
	});
</script>

<title>Insert title here</title>

</head>
<body>
<hr />
<h2>로그인 화면</h2>
<hr />
<form:form modelAttribute="user" action="/login/memLoginOk.jsp" method="post">
<table>
<tr>
	<th>아이디</th>
	<td><form:input type="text" path='id' /></td>
	<th>비밀번호</th>
	<td><input type="password" path='passwd' /></td>
	<td><button id="login">로그인</button></td>
	<td><button id="join" data-url="/member/memberJoin"></button></td>
</tr></table></form>
</body>
</html>