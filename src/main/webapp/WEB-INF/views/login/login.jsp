<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" 	uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<style>
body, html{
height:100%;
}
        .intro-2 {
            background: url("/resources/img/index_back.jpg")no-repeat center center;
            height:100%;
		  background-size: cover;
        }
        .mobtn {
  /* background-color: rgba( 255, 255, 255, 0 ); */
  border:none;

}

         .mobtn:hover {
         filter:drop-shadow(5px 5px 5px rgba(85,85,85, 0.3));
  /* box-shadow: 0 5px rgba(102,102,102, 0.5); */
  transform: translateY(4px);
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/webjars/bootstrap/4.1.0/css/bootstrap.css">
<script src="/webjars/jquery/3.3.1/dist/jquery.js"></script>
<script src="/webjars/bootstrap/4.1.0/js/bootstrap.js"></script>
 <!-- Plugin CSS -->
 <link href="/resources/vendor/magnific-popup/magnific-popup.css" rel="stylesheet" type="text/css">
 <!-- Custom styles for this template -->
 <link href="/resources/css/freelancer.min.css" rel="stylesheet">
<script>
</script>
<title>J's BBS</title>
</head>
<%-- <sec:authentication var="user" property="principal" scope="session"/> --%>
<body>
<c:url value="login" var="loginUrl"/>
<jsp:include page="/WEB-INF/views/nav.jsp" flush="true" />
<div class="intro-2">
 <header class="masthead text-white text-center">
      <div class="container">
      <a data-toggle="modal" data-target="#loginM">
        <img class="img-fluid mb-5 mx-auto mobtn btn" src="/resources/img/keyhole_2.png" >
      </a>
      
        <h2 class="text-uppercase">Please Login Before Using This Site :)</h2>
        <!-- <hr class="star-light"> -->
        <!-- <h2 class="font-weight-light mb-0">Web Developer - Graphic Artist - User Experience Designer</h2> -->
      </div>
    </header>
</div>
<!-- The Modal -->
    <form class="modal fade" id="loginM" action="${pageContext.request.contextPath }/login" method="post">
	<c:if test="${param.fail != null }">
	<b>로그인 실패</b>
	</c:if>
    <div class="modal-dialog bg-primary">
    
      <div class="modal-content bg-primary">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Login</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="imgcontainter">
    	<img src="/resources/img/Login.png" alt="Avatar" class="avatar" style="padding-left:38%"/>
    </div>
        <!-- Modal body -->
        <div class="modal-body">
        <label for="username"><b>E-mail</b></label>
          <input type="text" class="form-control" placeholder="Type your Email here" name="username" id="username" required/>
          <span class="input-group-addon"></span>
          <div class="cols-sm-10">
			<div class="input-group">
				<span class="input-group-addon"></span>
			</div>
		</div>
          <label for="password"><b>Password</b></label>
          <input type="password" class="form-control" placeholder="Type your Password here" name="password" id="password" required/>
        </div>
        <!-- Modal footer -->
        <div class="modal-footer">
		  <button type="submit" class="btn btn-success">Log in</button>
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        </div>
        
      </div>
    </div>
    <sec:csrfInput />
  </form>

<jsp:include page="/WEB-INF/views/footer.jsp" flush="true"/>
 <script>
 $(document).keypress(function(e) { 
	    if (e.keyCode == 27) { 
	        $("#loginM").modal();
	    } 
	});
 </script>
</body>
</html>