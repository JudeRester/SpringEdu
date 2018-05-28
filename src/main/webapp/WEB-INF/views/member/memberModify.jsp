<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/webjars/bootstrap/4.1.0/css/bootstrap.css">
<script src="/webjars/jquery/3.3.1/dist/jquery.js"></script>
<script src="/webjars/bootstrap/4.1.0/js/bootstrap.js"></script>
<script>
	$(function() {
		$("input[name=password]").on("keyup", function(){
				if($("input[name=password]").val() != $("input[name=passwd]").val()){
					$(".passErr").text('비밀번호가 일치하지 않습니다.');
					$(this).focus();
				}else{
					$(".passErr").text('');
				}
			});
		$("#joinBtn").on("click", function(e) {
			e.preventDefault();
			$("form").submit();

		});
		$("#joinClearBtn").on("click", function(e) {
			e.preventDefault();
			$("form").each(function() {
				this.reset();
			});
		});

		$("#joinCancelBtn").on("click", function(e) {
			e.preventDefault();
			location.href = "/";
		});
	});
</script>
<style>
	.errmsg{color:red;}
	.passErr{color:red;}
</style>
<title>회원가입</title>
</head>
<body>
	<form:form modelAttribute="memberVO" action="/member/memberJoinOK" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<td><form:input path="id" /> 
				<form:errors path="id" cssClass="errmsg"/></td>
			</tr>
			<tr>
				<th>password</th>
				<td>
				<form:password path="passwd" /> 
				<form:errors path="passwd" cssClass="errmsg"/>
				</td>
			</tr>
			<tr>
				<th>password check</th>
				<td><input type="password" name="confirm" /> 
				</td>
			</tr>
			<tr>
				<th>&nbsp;</th>
				<td><span class="passErr"></span></td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
				<form:input path="name" type="text" /> 
				<form:errors path="name" type="text" cssClass="errmsg"/>
				</td>
			</tr>
			<tr>
				<th>생일</th>
				<td>
				<form:input path="birth" /> 
				<form:errors path="birth" cssClass="errmsg"/>
				</td>
			</tr>
			<tr>
				<th>phone</th>
				<td>
				<form:input path="phone" /> 
				<form:errors path="phone" cssClass="errmsg"/>
				</td>
			</tr>
			<tr>
				<th>gender</th>
				<td>남<form:radiobutton path="gender" value="M" /> 
				여<form:radiobutton	path="gender" value="W" /> 
				<form:errors path="gender" cssClass="errmsg"/>
				</td>
			</tr>
			<tr align=right>
				<td colspan=2>
					<button id="joinBtn">가입</button>
					<button id="joinClearBtn">초기화</button>
					<button id="joinCancelBtn">가입취소</button>
			</tr>
		</table>
	</form:form>
	<%-- <hr width=500 size=1>
<h2>회원가입</h2>
<hr width=500 size=1>
<form action="memberJoinOk.jsp" method="post" name="join_frm">
아이디 : <input type="email" name="id" id='id'/><br>
비밀번호 : <input type="password" name="passwd" id='passwd' /><br>
비밀번호 확인 : <input type="password" name="passwd_chk" id='passwd_chk' /><br>
이름 : <input type="text" name="name" /><br>
생년월일 : <select name="year" id="">
			<option value="2000">2000</option>
			<option value="2001">2001</option>
			<option value="2002">2002</option>
			</select>년
		<select name="month" id="">
			<option value="01">1</option>
			<option value="02">2</option>
			<option value="03">3</option>
		</select>월
		<select name="day" id="">
			<option value="01">1</option>
			<option value="02">2</option>
			<option value="03">3</option>
		</select>일<br>
휴대전화 : <input type="tel" name="phone" id=phone /><br>
<input type="button" value="회원가입" onClick="mem_check()"/><input type="reset" value="취소" />

</form> --%>
</body>
</html>