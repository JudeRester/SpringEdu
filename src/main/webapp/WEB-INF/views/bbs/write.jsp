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
<style>
body,html{
height:100%}
</style>
</head>
<jsp:include page="/WEB-INF/views/nav.jsp" flush="true"/>
<body>
<div style="height:100%;margin-top:8%; margin-left:8%; margin-right:8%;">
<p class="h2" align="center">글쓰기</p>
<form action="/bbs/write" method="post">
<table class="table table-hover">
	
		<tr>
			<th scope="col" class="w-25 p-3">제목</th>
			<td scope="col"><input type="text" name="btitle" class="form-control" id="" placeholder="insert title"/></td>
		</tr>
		<tr>
			<th scope="col">작성자</th>
			<td scope="col"><input type="text" name="bname" class="form-control" id="" placeholder="insert your name"/></td>
		</tr>
		<tr>
			<th scope="col">내용</th>
			<td scope="col"><textarea class="form-control" name="bcontent" id="" ></textarea></td>
		</tr>
		<tr>
			<td colspan=2>
			<input type="submit" class="btn btn-primary" value="등록" />
		 	<a href="list" class="btn btn-primary" role="button" aria-pressed="true" aria-describedby="inputGroup-sizing-sm"> 목록으로</a>
		</tr>
	
</table>
</form>
</div>
<jsp:include page="/WEB-INF/views/footer.jsp" />
</body>
</html>