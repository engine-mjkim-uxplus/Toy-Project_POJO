<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="description" content="" />
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors" />
<meta name="generator" content="Hugo 0.101.0" />
<title>아이디 중복체크</title>
<style type="text/css">
.box {
	margin: -150px 0 0 -200px;
	position: absolute;
	text-align: center;
	top: 50%;
	left: 50%;
	width: 400px;
	height: 300px;
	border: 1px solid #999;
	border-radius: 1rem;
}

h3 {
	color: #888;
}
</style>
</head>
<body onload="getID()">
<script type="text/javascript">
	function getID(){
		document.getElementById("member_id").value = opener.document.userInfo.member_id.value;
	}
</script>
	<div class="box p-3">
      <h3>아이디 중복검사</h3>
      <hr />
      <br /><br />
      <div class="input-group">
        <input type="text" class="form-control" />
        <button class="btn btn-outline-secondary">중복검사</button>
      </div>
    </div>
</body>
</html>