<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
 <meta name="_csrf" content="${_csrf.token}"/>
 <meta name="_csrf_header" content="${_csrf.headerName}"/>
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



<form action="/bbs/reply" method="post">
<table class="table table-hover">
<tr>
			<th scope="col" class="w-25 p-3">제목</th>
			<td scope="col"><input type="text" name="btitle" class="form-control" id="" value="${preinfo.btitle }"></td>
		</tr>
		<tr>
			<th scope="col">내용</th>
			<td scope="col"><textarea class="form-control" name="bcontent" id="" >${preinfo.bcontent }
---------------------</textarea></td>
		<td>
		<input type="hidden" name="bnum" value="${preinfo.bnum }" />
		<input type="hidden" name="bid" value="${user.username }" />
		<input type="hidden" name="bname" value="${user.name }" />
		<input type="hidden" name="bgroup" value="${preinfo.bnum}"/>
		<input type="hidden" name="bindent" value="${preinfo.bindent }"/>
		</td>
		</tr>
	
		<tr>
			<td colspan=2>
			<input type="submit" class="btn btn-primary" value="작성" />
		 	<a href="list" class="btn btn-primary" role="button" aria-pressed="true" aria-describedby="inputGroup-sizing-sm"> 목록으로</a>
		</tr>
		
		</table>
		<sec:csrfInput/>
		
</form>
	

</div>
<jsp:include page="/WEB-INF/views/footer.jsp" />
</body>
</html>