<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
        .intro-2 {
            background: url("/resources/img/index_back.jpg")no-repeat center center;
            -webkit-background-size: cover;
		  -moz-background-size: cover;
		  -o-background-size: cover;
		  background-size: cover;
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
<title>Insert title here</title>
</head>
<body>
<jsp:include page="nav.jsp" flush="true" />
 <header class="masthead text-white text-center intro-2" >
      <div class="container">
        <img class="img-fluid mb-5 d-block mx-auto" src="/resources/img/keyhole_2.png" alt="">
        <h2 class="text-uppercase">Please Login Before Using My Site :)</h2>
        <!-- <hr class="star-light"> -->
        <!-- <h2 class="font-weight-light mb-0">Web Developer - Graphic Artist - User Experience Designer</h2> -->
      </div>
    </header>
<jsp:include page="footer.jsp" flush="true"/>
</body>
</html>