<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/4.1.0/css/bootstrap.css">
<script src="/webjars/jquery/3.3.1/dist/jquery.js"></script>
<script src="/webjars/bootstrap/4.1.0/js/bootstrap.js"></script>
<title>Insert title here</title>
</head>
<jsp:include page="/WEB-INF/views/nav.jsp" flush="true"/>
<body>
<p class="h2" align="center">글쓰기</p>
<table class="table table-hover">
	<form action="/bbs/write" method="post">
		<tr>
			<th></th>
			<td><input type="text" /></td>
			<th></th>
			<td><input type="text" /></td>
			<th></th>
			<td><input type="text" /></td>
			<th></th>
			<td><input type="text" /></td>
		</tr>
	</form>
</table>

</body>
</html>