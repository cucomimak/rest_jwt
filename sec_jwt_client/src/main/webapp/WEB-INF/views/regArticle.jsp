<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
<h1>Article Regist Form</h1>
<hr>
<div>
	<form name="frm">
		<input type="text" name="title" placeholder="Input title...."><br>
		<input type="text" name="content" placeholder="Input content...."><br>
		<input type="text" name="writer" placeholder="Input writer...."><br>
		<input type="button" value="기사 등록" onclick="regArticle()"><br>
	</form>
</div>

<script>
	//let token = localStorage.getItem("jwtToken");
	
	function regArticle(){
		const token = localStorage.getItem("jwtToken");
		alert("submit...." + token);
		
		var form = document.forms['frm'];
		var formData = $(form).serialize();
		$.ajax({
			type : "POST",
			url : "http://localhost:8888/reporter/article",
			headers: {
			      "Authorization": "Bearer " + token // Bearer 토큰 형식을 사용하여 토큰을 포함
			},
			contentType: 'application/x-www-form-urlencoded',
			data : formData,
			//dataType : 'json',
			success : function(data, status, xhr) {
				console.log("success : ", data);
			},
			error : function(error) {
				console.log("error 발생");
			}
		});
	}
</script>
</body>
</html>