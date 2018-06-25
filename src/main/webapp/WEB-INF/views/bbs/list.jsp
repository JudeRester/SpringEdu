<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style>
html, body{
height:100%;}
</style>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/4.1.0/css/bootstrap.css">
<script src="/webjars/jquery/3.3.1/dist/jquery.js"></script>
<script src="/webjars/bootstrap/4.1.0/js/bootstrap.js"></script>
<title>Insert title here</title>
<script>
$(function(){
	$('#searchBtn').click(function(){
		self.location = 'list?currpage=1'+'&option='
						+$("select[name=option]").val()
						+'&keyword='
						+$("input[name=keyword]").val();
		console.log(self.location.toString());
	});
});
</script>
</head>
<jsp:include page="/WEB-INF/views/nav.jsp" flush="true" />
<body>
<div style="height:100%; margin-top:8%; margin-left:8%; margin-right:8%">
<p class="h2" align="center"> 글 목록보기 </p>
	<div class="container">
	  <table class="table table-hover">
   		 <thead class ="thead-light">
      <tr>
        <th scope="col">글번호</th>
        <th scope="col">제목</th>
        <th scope="col">작성자</th>
        <th scope="col">조회수</th>
      </tr>
    </thead>
    <tbody>
   		<c:forEach items="${list }" var="dto">
      <tr>
      	<th scope="row">${dto.bnum }</th>
        <td>
        <c:forEach begin="1" end="${dto.bindent }">┗</c:forEach>
        <a href="/bbs/view?bnum=${dto.bnum }&${pc.makeSearchURL(pc.currpage) }">${dto.btitle }</a>
        </td>
        <td>${dto.bname }</td>
        <td>${dto.bhit }</td>
      </tr>
      </c:forEach>
      </tbody>
      </table>
      <table>
      <tr>
      <td colspan="4">
		<nav aria-label="Page navigation example">
		  <ul class="pagination" >
		  	 <c:if test="${pc.pre }"> 
			    <li class="page-item">
			    	<a class="page-link" href="list?${pc.makeSearchURL(1)}">◀</a>
			    </li>		  	 
			    <li class="page-item">
			    	<a class="page-link" href="list?${pc.makeSearchURL(pc.startpage-1)}">◁</a>
			    </li>
		    </c:if>
		    <c:forEach begin="${pc.startpage }" end="${pc.endpage }" var="pageNum">
		    	<c:if test="${pc.currpage == pageNum }">
			    <li class="page-item active">		
			      <a class="page-link" href="list?${pc.makeSearchURL(pageNum) }">${pageNum}</a>
			    </li>
	    		 </c:if>   
	    		 <c:if test="${pc.currpage != pageNum }">
			    <li class="page-item">
			    	<a class="page-link" href="list?${pc.makeSearchURL(pageNum)}">${pageNum}</a>
			    </li>
			    </c:if>
		    </c:forEach>
		    <c:if test="${pc.next }">
			    <li class="page-item">
			    	<a class="page-link" href="list?${pc.makeSearchURL(pc.endpage+1)}">▷</a>
			    </li>
			    <li class="page-item">
			    	<a class="page-link" href="list?${pc.makeSearchURL(pc.lastpage)}">▶</a>
			    </li>		    
		    </c:if>		    
		  </ul>
		</nav>          
      </td>
		<td colspan="5">
		<a href="write?${pc.makeSearchURL(pc.currpage) }" class="btn btn-primary" role="button" aria-pressed="true">글쓰기</a>
		</td> 
    </tr>
     <tr>
     	<td>
     		<select name="option" class="form-control-sm">
     			<option value="TC" 
		    	<c:out value="${findCriteria.option == 'TC' ? 'selected' : '' }"/>>
		    	제목 + 내용</option>
		    <option value="T"
		  		<c:out value="${findCriteria.option == 'T' ? 'selected' : '' }"/>>		    
		    	제목</option>
		    <option value="C"
			  	<c:out value="${findCriteria.option == 'C' ? 'selected' : '' }"/>>	
		    	내용</option>
		    <option value="W"
		  		<c:out value="${findCriteria.option == 'W' ? 'selected' : '' }"/>>
		    	작성자</option>
     		</select>
     		<input type="text" name="keyword" class="form-control-sm" value="${findCriteria.keyword }" />
     		<input type="button" class="btn btn-outline-dark btn-sm" id="searchBtn" value="검색"/>
     	</td>
     </tr>
    </table>
   
</div>
</div>

</body>
<jsp:include page="/WEB-INF/views/footer.jsp" flush="true"/>
</html>