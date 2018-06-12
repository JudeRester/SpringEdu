<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/webjars/bootstrap/4.1.0/css/bootstrap.css">
<script src="/webjars/jquery/3.3.1/dist/jquery.js"></script>
<script src="/webjars/bootstrap/4.1.0/js/bootstrap.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="/resources/css/joinin.css" />
<script>
$(function(){
	
	$("input[name=password]").on("keyup",function(){
 		if($("input[name=password]").val() != $("input[name=passwd]").val()){
 			$(".passErr").text('비밀번호가 틀립니다.');
			$(this).focus();
		}else{
			$(".passErr").text('');
		}
	});
	
 	$("#joinBtn").on("click",function(e){
		e.preventDefault();
		$("form").submit();
		
	});
/* 	
	$("#joinClearBtn").on("click",function(e){
		e.preventDefault();		
		  $("form").each(function(){
			    this.reset();
			  });
	});	
	
	$("#joinCancelBtn").on("click",function(e){
		e.preventDefault();		
			location.href="/member/memberList";
	});	 */
	
}); 
</script>
<style>
	.errmsg{color:red;}
	.passErr{color:red;}	

</style>

<title>Insert title here</title>
</head>
<body>
<header>
<jsp:include page="/WEB-INF/views/nav.jsp" />
</header>
<%-- <jsp:include page="/WEB-INF/views/nav.jsp" flush="true"/> --%>
	<div class="container">
		<div class="row main"  style="padding-top:100px">
			<div class="main-login main-center">
			<h5>Join in Our Site</h5>
				<form:form modelAttribute="memberVO" action="/member/memberJoinOK" method="post">
					
					<div class="form-group">
						<label for="name" class="cols-sm-2 control-label">Name</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"></span>
								<form:input type="text" class="form-control" path="name"  placeholder="Enter your Name"/>
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="birth" class="cols-sm-2 control-label">Birth</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"></span>
								<form:input type="text" class="form-control" path="birth"  placeholder="ex)19940307"/>
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<label for="phone" class="cols-sm-2 control-label">Phone</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"></span>
								<form:input type="text" class="form-control" path="phone"  placeholder="Enter your phone number"/>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="id" class="cols-sm-2 control-label">ID</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"></span>
								<form:input type="text" class="form-control" path="id"  placeholder="Enter your Email"/>
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="passwd" class="cols-sm-2 control-label">Password</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"></span>
								<form:input type="password" class="form-control" path="passwd"  placeholder="Enter your Password"/>
								<div class="input-group">
								<form:errors path="passwd" cssClass="errmsg"/>
								</div>
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="confirm" class="cols-sm-2 control-label">Confirm Password</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"></span>
								<input type="password" class="form-control" path="confirm"  placeholder="Confirm your Password"/>
								<span class="passErr"></span>
							</div>
						</div>
					</div>
					
					<div class="form-group ">
						<button type="button" id="joinBtn" class="btn btn-primary btn-lg btn-block login-button">Register</button>
					</div>
					
				</form:form>
			</div>
		</div>
	</div>
<%-- <form:form modelAttribute="memberVO" action="/member/memberJoinOK" method="post">
<table>
	<tr>
		<th>아이디</th>
		<td>
			<form:input path="id" />
		</td>
	</tr>
	<tr>
		<th>&nbsp;</th>
		<td><form:errors path="id" cssClass="errmsg" /></td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td>
			<form:password path="passwd" />
		</td>
	</tr>
	<tr>
		<th>&nbsp;</th>
		<td><form:errors path="passwd" cssClass="errmsg"/></td>
	</tr>	
	<tr>
		<th>비밀번호확인</th>
		<td>
			<input type="password" name="password" />
		</td>
	</tr>
	<tr>
		<th>&nbsp;</th>
		<td><span class="passErr"></span></td>
	</tr>		
	<tr>
		<th>이름</th>
		<td>
			<form:input path="name" />		
		</td>
	</tr>
	<tr>
		<th>&nbsp;</th>
		<td>
			<form:errors path="name" cssClass="errmsg"/>
		</td>
	</tr>		
	<tr>
		<th>생일</th>
		<td>
			<form:input path="birth" />				
		</td>
	</tr>
	<tr>
		<th>&nbsp;</th>
		<td>
			<form:errors path="birth" cssClass="errmsg"/>
		</td>
	</tr>		
	<tr>
		<th>전화번호</th>
		<td>
			<form:input path="phone" />
		</td>
	</tr>
	<tr>
		<th>&nbsp;</th>
		<td>
			<form:errors path="phone" cssClass="errmsg"/>
		</td>
	</tr>		
	<tr>
		<th>성별</th>
		<td>
			남<form:radiobutton path="gender" value="M"/>
			여<form:radiobutton path="gender" value="W"/>
		</td>
	</tr>	
	<tr>
		<th>&nbsp;</th>
		<td>
			<form:errors path="gender" />			
		</td>
	</tr>		
	<tr align = left>
		<th></th>
		<td>
			<button id="joinBtn">가입</button>
			<button id="joinClearBtn">초기화</button>
			<button id="joinCancelBtn">가입취소</button>
		</td>
	</tr>	
</table>

</form:form> --%>
	 <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>