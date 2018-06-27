<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/4.1.0/css/bootstrap.css">
<script src="/webjars/jquery/3.3.1/dist/jquery.js"></script>
<script src="/webjars/bootstrap/4.1.0/js/bootstrap.js"></script>
<title>Insert title here</title>
<style>
body, html{
height:100%;
}
</style>

</head>
<body>
<jsp:include page="/WEB-INF/views/nav.jsp" />
<div style="height:100%; margin:10%">
<div style= "border: 1px solid #ced4da; border-radius: 0.25rem;
		  width: 97%;
		  padding-up: 200px;
		  padding-down: 20px;
		  padding-right: 20px;
		  padding-left: 20px;
		  margin: 10px;">
	<br />
		<div class="media">
	  <h2 class="media-heading">${view.btitle }</h2><br>
	  <p class="media-body"></p>
	  <p align="right" class="media-right">작성일 : ${view.bcdate }<br>최종수정일 : ${view.budate }
	  <br>조회수 : ${view.bhit }</p>
	  </div>
	  <hr style="margin:0px;padding-up:0px; padding-down:0px;" />
	  <div class="media">
	    <div class="media-body">
	    <p align="left" style="margin-bottom:0px;padding-up:2px;padding-down:2px">작성자 :${view.bname }</p>
	    <hr style="margin-top:0px;padding-up:0px;" />
	    <div>
	    <pre>
${view.bcontent }
		</pre>
		<hr />
		</div>
		</div>
	</div>
	</div>
	<div align="right" style="padding-right:20px;">
	<table>
	<tr>
		<td colspan=2 align="right">
		<c:if test="${user.username eq view.bid }">
		<a href="mopage?bnum=${view.bnum }" class="btn btn-primary" role="button" aria-pressed="true">수정</a>
		<a href="delete?bnum=${view.bnum }" class="btn btn-primary" role="button" aria-pressed="true">삭제</a>
		</c:if>
		<a href="replyView?bnum=${view.bnum }" class="btn btn-primary" role="button" aria-pressed="true">답글</a>
	 	<a href="list?currPage=${currpage }" class="btn btn-primary" role="button" aria-pressed="true" aria-describedby="inputGroup-sizing-sm"> 목록으로</a>
	 	<a class="btn btn-primary" role="button" aria-pressed="true" href="view?bnum=${view.ppage }">◀</a>
	 	<a class="btn btn-primary" role="button" aria-pressed="true" href="view?bnum=${view.npage }">▶</a>
	 	</td>
	</tr>
	</table>
	</div>
	</div>
<jsp:include page="/WEB-INF/views/footer.jsp" />
</body>
</html>