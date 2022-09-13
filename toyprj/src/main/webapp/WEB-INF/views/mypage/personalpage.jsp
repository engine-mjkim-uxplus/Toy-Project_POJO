<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
	<%@ include file="../../../common/common.jsp" %>
    <style>
    	body {
		  padding: 0;
		  margin: 0;
		}
		div {
		  box-sizing: border-box;
		}
		
		/* alert badge */
		.circle {
		  display: inline-block;
		  width: 5px;
		  height: 5px;
		  border-radius: 2.5px;
		  background-color: #ff0000;
		  position: absolute;
		  top: -5px;
		  left: 110%;
		}
		
		/* 녹색 텍스트 */
		.green {
		  color: #24855b;
		}
		
		.wrap {
		  background-color: #f8f8f8;
		}
		/* 녹색배경 */
		.greenContainer {
		  height: 132px;
/* 		  background-color: #aaa; */
		
		  display: flex;
		  align-items: flex-end;
		  padding: 16px;
		}
		
		.greenContainer .name {
		  font-size: 20px;
		  font-weight: bold;
		  color: #ffffff;
		}
		.greenContainer .modify {
		  margin-left: auto;
		}
		
		/* 단골상점 , 상품후기 , 적립금 박스 */
		.summaryContainer {
		  background-color: white;
		  display: flex;
		  padding: 21px 16px;
		  height: 90px;
		  justify-content: space-around;
/* 		  margin-bottom: 10px; */
		}
		/* 단골상점 , 상품후기 , 적립금 */
		/* .summaryContainer .item {
		  flex-grow: 1;
		} */
		/* 녹색 숫자 */
		.summaryContainer .number {
		  font-size: 19px;
		  font-weight: bold;
		  color: black;
		}
		/* 텍스트 */
		.summaryContainer .item > div:nth-child(2) {
		  font-size: 13px;
		}
		
		/*=================== 주문목록 ~ 찜한상품 리스트 ==================*/
		.listContainer {
		  padding: 0;
		  background-color: #ffffff;
		  /* margin-bottom: 10px; */
		}
		.listContainer .item {
		  display: flex;
		  align-items: center;
		  /* padding: 16px; */
		  color: black;
		  text-decoration: none;
		  /* height: 50px; */
		  box-sizing: border-box;
		}
		
		/*=================== 내지갑의 보유 적립금 들어가는 부분 ================*/
		
		.listContainer .right .blct {
		  font-size: 14px;
		  font-weight: bold;
		  margin-right: 5px;
		}
		
		/* 공지사항 이용안내 고객센터 */
		.infoContainer {
		  background-color: white;
		  display: flex;
		  /* height: 100px; */
		  /* margin-bottom: 10px; */
		}
		
		.infoContainer .item {
		  flex-grow: 1;
		  display: flex;
		  align-items: center;
		  justify-content: center;
		  flex-direction: column;
		  font-size: 13px;
		  text-decoration: none;
		  color: black;
		}
		.infoContainer .item > div:first-child {
		  /* margin-bottom: 2px; */
		}
		
		/*  */
		.listContainer .item:hover {
		  /*   background-color: #f8f8f8; */
		}
		.infoContainer .item:hover {
		  /*   background-color: #f8f8f8; */
		}
		
		/* [[최근 구매내역을 마이페이지의 메인에서 보여주기]] */
		.content {
		  background-color: #ddd;
		}
    </style>
  </head>
  <body>
    <!-- nav start -->
	<%@ include file="../../../component/nav.jsp" %>
    <!-- nav end -->
    
    <%@ include file="./component/head.jsp" %>
    <div class="wrap">
    
      <div class="row d-flex" style="height: 500px;">
		<%@ include file="./component/side.jsp" %>
			<div class="col-md-11 content p-3">
				<h5 class="font-medium hidden md:block">내 정보 수정</h5>
				<hr>
				<h5 class="font-medium mb-4">나의 정보</h5>
				<div class="input-form-backgroud row">
					<div class="input-form col-md-12 mx-auto">
						<form class="validation-form">
							<div class="row">
								<div class="col-md-6 mb-3">
									<label for="name">이름</label> 
									<input type="text" class="form-control" id="name" placeholder="이름" value="" required>
								</div>
								<div class="col-md-6 mt-3 pt-3">
									<label for="nickname">성별</label> 
									<div class="form-check form-check-inline">
			                          <input
			                            type="radio"
			                            id="member_gender"
			                            name="member_gender"
			                            value="여자"
			                            checked
			                          />여자
			                            <input
			                              type="radio"
			                              name="member_gender"
			                              id="member_gender"
			                              value="남자"
			                            />남자
			                        </div>
								</div>
							</div>
	
							<div class="row">
								<div class="col-6 mb-3">
									<label for="email">아이디</label> <input type="text"
										class="form-control" id="email" placeholder="아이디"
										required>
								</div>
								<div class="col-6 mb-3">
									<label for="email">비밀번호</label> <input type="password"
										class="form-control" id="email" placeholder=""
										required>
								</div>
							</div>
							
							<div class="mb-3">
								<label for="address">전화번호</label> <input type="text"
									class="form-control" id="address" placeholder="01012341234"
									required>
							</div>
							
							<hr>
							<h5 class="font-medium mb-4">배송 정보</h5>
							<div class="row">
								<div class="col-9 mb-3">
									<label for="address">우편번호</label> 
									<input type="text" class="form-control" id="address" placeholder="01001" required>
								</div>
								<div class="col-3">
									<label for="address"> </label> 
									<input type="button" class="form-control" id="address" value="주소찾기" required>
								</div>
							</div>

							<div class="mb-3">
								<label for="address">주소</label> 
								<input type="text" class="form-control" id="address" placeholder="서울특별시 강남구" required>
							</div>
							
							<div class="mb-3">
								<label for="address2">상세주소</label> 
								<input type="text" class="form-control" id="address2" placeholder="상세주소를 입력해주세요.">
							</div>

							<div class="mb-4"></div>
							<button class="btn btn-secondary" type="submit">수정하기</button>
						</form>
					</div>
				</div>

			</div>
			<!-- footer start -->
	<%@ include file="../../../component/footer.jsp" %>
    <!-- footer end -->
  </body>
</html>