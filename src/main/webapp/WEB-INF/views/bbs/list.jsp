<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/4.1.0/css/bootstrap.css">
<script src="/webjars/jquery/3.3.1/dist/jquery.js"></script>
<script src="/webjars/bootstrap/4.1.0/js/bootstrap.js"></script>
<title>Insert title here</title>
<!-- <script>
$(function).click(function(){
	self.location
})
</script> -->
</head>
<jsp:include page="/WEB-INF/views/nav.jsp" flush="true" />
<body>
<div class="container">
<p class="h2" align="center"> 글 목록보기 </p>
<body>
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
        <a href="view.do?bNum=${dto.bnum }&currpage=${pc.currpage }">${dto.btitle }</a>
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
			    	<a class="page-link" href="list?currpage=1">◀</a>
			    </li>		  	 
			    <li class="page-item">
			    	<a class="page-link" href="list.do?currpage=${pc.startpage-1}">◁</a>
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
			    	<a class="page-link" href="list?currpage=${pc.makeSearchURL(pc.endpage+1)}">▷</a>
			    </li>
			    <li class="page-item">
			    	<a class="page-link" href="list?currpage=${pc.makeSearchURL(pc.lastpage)}">▶</a>
			    </li>		    
		    </c:if>		    
		  </ul>
		</nav>          
      </td>
		<td colspan="5">
		<a href="write?currpage=${pc.makeSearchURL(pc.currpage) }" class="btn btn-primary" role="button" aria-pressed="true">글쓰기</a>
		</td> 
    </tr>
     <tr>
     	<td>
     	<form action="list.do" method="post">
     		<select name="col" class="form-control-sm">
     			<option value = "제목내용">제목 + 내용</option>
     			<option value = "제목">제목</option>
     			<option value = "내용">내용</option>
     			<option value = "작성자" >작성자</option>
     			<%-- <c:if test="${param.keyword ne null}">검색어 null아님</c:if> --%>
     		</select>
     		<input type="text" name="keyword" class="form-control-sm" value="${keyword }" />
     		<input type="submit" class="btn btn-outline-dark btn-sm" id="searchBtn" value="검색"/>
     	</form>
     	</td>
     </tr>
    </table>
    <!-- table>
    <tr>
      <c:forEach begin="${pc.startpage }" end="${pc.endpage }" var="pageNum">
    	<c:if test="${pc.currpage == pageNum }">
	    <td class="page-item active">		
	      <a class="page-link" href="list.do?currpage=${pageNum}">${pageNum}</a>
  	    </td>
   			 </c:if>   
   			 <c:if test="${pc.currpage != pageNum }">
	 	   <td class="page-item">
	    	<a class="page-link" href="list.do?currpage=${pageNum}">${pageNum}</a>
	 	   </td>
	 	   </c:if>
  		  </c:forEach>
  		  </tr>
  		  <tr>
  		  <td colspan="5" align="right">
     		<a href="write_view.do" class="btn btn-primary" role="button" aria-pressed="true">글쓰기</a>
     		</td>
     		</tr>
  </table-->
</div>
<jsp:include page="/WEB-INF/views/footer.jsp" flush="true"/>
</body>
</html>