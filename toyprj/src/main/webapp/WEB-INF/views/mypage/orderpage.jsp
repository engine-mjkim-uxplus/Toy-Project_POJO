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
    	table {
	      width: 100%;
	      border-top: 1px solid #444444;
	      border-collapse: collapse;
	      text-align: center;
	    }
	    th, td {
	      border-bottom: 1px solid #444444;
	      padding: 10px;
	      vertical-align: middle;
	    }
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
    
      <div class="row d-flex" style="height: 1000px;">
		<%@ include file="./component/side.jsp" %>
        <div class="col-md-10 content">
        
			<ol class="list-group d-flex flex-row justify-content-center mt-5">
			  <li class="list-group-item d-flex justify-content-center align-items-start col-3">
			    <div class="d-flex justify-content-center align-items-center flex-column">
			      <div class="fw-bold border border-secondary rounded-circle d-flex justify-content-center align-items-center mb-2" style="width: 100px; height: 100px;">
			      	<i class="fas fa-truck fs-1"></i>
			      </div>
			      <div class="fs-5 mb-2">배송중</div>
			      <div class="badge bg-primary rounded-pill fs-5">0</div>
			    </div>
			  </li>
			  <li class="list-group-item d-flex justify-content-center align-items-start col-3">
			    <div class="d-flex justify-content-center align-items-center flex-column">
			      <div class="fw-bold border border-secondary rounded-circle d-flex justify-content-center align-items-center mb-2" style="width: 100px; height: 100px;">
			      	<i class="fas fa-box fs-1"></i>
			      </div>
			      <div class="fs-5 mb-2">배송완료</div>
			      <div class="badge bg-primary rounded-pill fs-5">0</div>
			    </div>
			  </li>
			  <li class="list-group-item d-flex justify-content-center align-items-start col-3">
			    <div class="d-flex justify-content-center align-items-center flex-column">
			      <div class="fw-bold border border-secondary rounded-circle d-flex justify-content-center align-items-center mb-2" style="width: 100px; height: 100px;">
			      	<i class="fas fa-undo-alt fs-1"></i>
			      </div>
			      <div class="fs-5 mb-2">취소/반품/교환</div>
			      <div class="badge bg-primary rounded-pill fs-5">0</div>
			    </div>
			  </li>
			</ol>
			
			<section class="bg-light d-flex justify-content-center mt-5">
			    <div class="container px-4 px-lg-5">
				    <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
					    <table class="table">
						  <thead class="table-dark">
						    <tr>
						      <th class="col-1" scope="col">구매날짜</th>
						      <th class="col-1" scope="col">주문번호</th>
						      <th class="col-1" scope="col">상품이미지</th>
						      <th class="col-1" scope="col">상품이름</th>
						      <th class="col-1" scope="col">상품가격</th>
						      <th class="col-1" scope="col">수령인주소</th>
						      <th class="col-1" scope="col">배송메모</th>
						      <th class="col-1" scope="col"></th>
						    </tr>
						  </thead>
						  <tbody>
							  	<tr>
							      <td scope="row">예</td>
							      <td>예</td>
							      <td>예</td>
								  <td>예</td>
							      <td>예</td>
							      <td>예</td>
							      <td>예</td>
							      <td class="d-flex flex-column">
							      	<button type="button" class="btn btn-primary mb-2">교환요청</button>
							      	<button type="button" class="btn btn-primary mb-2">구매확정</button>
							      	<button type="button" class="btn btn-primary mb-2">반품요청</button>
							      </td>
							    </tr>
							  	<tr>
							      <td scope="row">예</td>
							      <td>예</td>
							      <td>예</td>
								  <td>예</td>
							      <td>예</td>
							      <td>예</td>
							      <td>예</td>
							      <td class="d-flex flex-column">
							      	<button type="button" class="btn btn-primary mb-2">교환요청</button>
							      	<button type="button" class="btn btn-primary mb-2">구매확정</button>
							      	<button type="button" class="btn btn-primary mb-2">반품요청</button>
							      </td>
							    </tr>
							  	<tr>
							      <td scope="row">예</td>
							      <td>예</td>
							      <td>예</td>
								  <td>예</td>
							      <td>예</td>
							      <td>예</td>
							      <td>예</td>
							      <td class="d-flex flex-column">
							      	<button type="button" class="btn btn-primary mb-2">교환요청</button>
							      	<button type="button" class="btn btn-primary mb-2">구매확정</button>
							      	<button type="button" class="btn btn-primary mb-2">반품요청</button>
							      </td>
							    </tr>
						  </tbody>
						</table>
					</div>
				</div>
			</section>
			
        </div>
      </div>
    </div>
    
    <!-- footer start -->
	<%@ include file="../../../component/footer.jsp" %>
    <!-- footer end -->
  </body>
</html>
