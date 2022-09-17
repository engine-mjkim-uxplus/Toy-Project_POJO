<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../../common/common.jsp" %>
    <style>
      @import url("https://fonts.googleapis.com/css2?family=Montserrat&display=swap");
    </style>
</head>
<style>
	.body{
	 box-sizing: border-box;
	}
	.btn{
		margin-top: 10rem;
		width: 15rem;
		height: 3rem;
	}
	
	.specification{
		padding: 2rem;
		margin-top: 10rem;
		background-color: #ddd;
	}
	
	footer{
	position : fixed;
	bottom : 0;
	}
</style>
<body>
<!-- nav -->
<%@ include file="../../component/nav.jsp" %>
<section class="specification">
	<div>
		<h2 class="text-center mt-5"> ${name} <b>님의 주문이 완료 되었습니다</b></h2>
		<h4 class="text-center mt-5"><b>주문 번호 : </b> ${orderNumber}</h4>
	</div>
	<section class="text-center">
		<button class="btn btn-danger" onClick="/">주문내역 조회</button>
		<button class="btn btn-secondary" onClick="location.href='/product/productList.do';">메인으로</button> 
	</section>
</section>
<!-- footer -->
<%@ include file="../../component/footer.jsp" %>
</body>
</html>