<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
</head>
<body>
<h1>Login Form</h1>
<hr>
<div>
	<form name="frm">
		<input type="text" name="username" placeholder="Input username....."><br>
		<input type="password" name="password" placeholder="Input password...."><br>
		<input type="button" value="login" onclick="submitForm()">
	</form>
</div>

<div id="demo"></div>
<hr>

<div id="demo2"></div>
<div id="demo3"></div>
<script>
loginCheck();
function loginCheck(){
	const token = localStorage.getItem("jwtToken");
	if(token != null){
		location.href="/";
	}
}

function f(){
	alert('f............');
	return false;
}
function submitForm() {
	//event.preventDefault();
	alert("submit....");
	var form = document.forms['frm'];
	var formData = $(form).serialize();
	$.ajax({
		type : "POST",
		url : "http://localhost:8888/login",
		contentType: 'application/x-www-form-urlencoded',
		data : formData,
		//dataType : 'json',
		success : function(data, status, xhr) {
			console.log("success : ", data);
			var headers = xhr.getAllResponseHeaders();
			console.log("headers : " + headers);
			
			var token = xhr.getResponseHeader("Authorization");
			console.log("JWT Token: " + token.split(" ")[1]);
			document.getElementById("demo").innerHTML = token.split(" ")[1];
			
			localStorage.setItem("jwtToken", token.split(" ")[1]);
			// 헤더 값 읽기
			let role = xhr.getResponseHeader("Role");
			console.log("role : " + role);
			if(role == 'ROLE_REPORTER'){
				document.getElementById("demo2").innerHTML = "<button onclick='writeArticle()'>기사쓰기</button>";
			}else if(role == 'ROLE_MANAGER'){
				document.getElementById("demo2").innerHTML = "<button onclick='requestManager()'>관리자페이지</button>";
			}
		},
		error : function(error) {
			console.log("error 발생");
		}
	});
}

function writeArticle(){
	alert("기사쓰기 페이지로 이동합니다.");
	location.href="/regArticle";
}

function requestManager(){
	alert("관리자 페이지로 이동할건가....");
	
	const token = localStorage.getItem("jwtToken");

	$.ajax({
	    type: "GET",
	    url: "http://localhost:8888/manager/main",
	    headers: {
	        "Authorization": "Bearer " + token // Bearer 토큰 형식을 사용하여 토큰을 포함
	    },
	    success: function(data) {
	        console.log("Success:", data);
	        // 사용자 프로필 등을 처리
	        document.getElementById("demo3").innerHTML = data;
	        moveManagerPage();
	    },
	    error: function() {
	        console.log("Error가 났어요");
	        // 인증 실패 등의 오류 처리
	    }
	});
}

function moveManagerPage(){
	location.href="/manager/main";
}

</script>
</body>
</html>