<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/webjars/bootstrap/4.1.0/css/bootstrap.css">
<script src="/webjars/jquery/3.3.1/dist/jquery.js"></script>
<script src="/webjars/bootstrap/4.1.0/js/bootstrap.js"></script>
<title>Insert title here</title>
<script>
	$(function() {
		//회원가입 페이지로 이동
		$("#join").on("click",function(e){
			e.preventDefault();		
			$(location).attr("href",$(this).attr("data-url"));			
		});	 
		
		//로그인
	 	$("#loginBtn").on("click",function(e){
			e.preventDefault();
			$("form").submit();
			
		});
	 	
/* 		$("form").submit(function(){
			if($("#id").val() == "") {
				alert("아이디를 입력해주세요!");
				$("#id").focus();
				return false;
			}else if($("#passwd").val() == ""){
				alert("비밀번호를 입력해주세요!");
				$("#passwd").focus();	
				return false;
			}
		}); */
	});	
</script>
</head>
<body>
<hr />
<h2>로그인</h2>
<hr />
<c:url value="j_spring_security_check" var="loginUrl"/>
<c:if test="${param.fail != null }">
	<b>로그인 실패</b>
	</c:if>
<form:form modelAttribute="login" action="${pageContext.request.contextPath }/${loginUrl }" method="post">
<table>
	<tr>
		<th>아이디</th>
		<td>
			<form:input path="username"/><%-- <form:errors path="username" /> --%>
		</td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td>
			<form:password path="password"/><%-- <form:errors path="password"/> --%>
		</td>
	</tr>
	<tr>
		<td>
			<button id="loginBtn" >로그인</button>
		</td>
		<td>
			<button id="join" data-url="/member/memberJoin">회원가입</button>
		</td>	
</table>
</form:form>
</body>
</html>










