<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/webjars/bootstrap/4.1.0/css/bootstrap.css">
<script src="/webjars/jquery/3.3.1/dist/jquery.js"></script>
<script src="/webjars/bootstrap/4.1.0/js/bootstrap.js"></script>	
<title>회원목록</title>
<script>
$(function(){
	$("#modi, #del, #list").on("click",function(){
		$(location).attr('href',$(this).attr('data-url'));
	});
});
</script>
</head>
<body>
회원목록
<table border=1>
<tr>
	<th>#</th>
	<th>아이디</th>
	<th>이름</th>
	<th>생년월일</th>
	<th>전화번호</th>
	<th>성별</th>
	<th>수정</th>
	<th>삭제</th>
</tr>
<c:forEach items="${memberVOS }" var="memberVO">
<tr>
	<td>#</td>
	<td>${memberVO.id }</td>
	<td>${memberVO.name }</td>
	<td>${memberVO.birth }</td>
	<td>${memberVO.phone }</td>
	<td>
		<c:if test="${memberVO.gender == 'm'}" >남자</c:if>
		<c:if test="${memberVO.gender == 'w'}" >여자</c:if>
	</td>
	<td><button id="modi" data-url="/member/memberModify/${memberVO.id }">수정</button></td>
	<td><button id="del" data-url="/member/memberDelete/${memberVO.id }">삭제</button></td>
</tr>	
</c:forEach>
<tr>
	<td colspan="8" align="center">
		<button id="list" data-url="/member/memberJoin">회원가입</button>
	</td>
</tr>
</table>

</body>
</html>





