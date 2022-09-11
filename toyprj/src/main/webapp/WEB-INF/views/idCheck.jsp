<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	Integer result = (Integer) session.getAttribute("result");
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="member_id" value="${param.member_id}" />
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
<body>
<script type="text/javascript">
	let openJoinform = opener.document.userForm;
	if(<%=result%> == 0){ // 아이디가 없을 때
		
	} else if(<%= result%> == 1){ // 아이디가 중복일 때
		
	}
</script>
	<div class="box p-3">
      <h3>아이디 중복검사</h3>
      <hr />
      <br /><br />
      <form action="">
	      <div class="input-group">
    	    <input type="text" class="form-control" id="member_id" name="member_id" value="${member_id}" disabled/>
        	<button class="btn btn-outline-secondary" type="submit">중복검사</button>
      	</div>
      </form>
      <input class="btn btn-outline-secondary" type="button" onclick="sendCheckValue()" value="사용하기" >
    </div>
</body>
</html>