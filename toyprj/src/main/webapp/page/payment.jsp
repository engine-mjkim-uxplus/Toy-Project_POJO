<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>결제페이지</title>
	<%@ include file="../common/common.jsp" %>
    <style>
      @import url("https://fonts.googleapis.com/css2?family=Montserrat&display=swap");
      * {
        margin: 0;
        padding: 1px;
        box-sizing: border-box;
      }
/*       body {
        background-color: #eee;
      } */
      nav,
      .wrapper {
        padding: 10px 50px;
      }
      nav .logo a {
        color: #000;
        font-size: 1.2rem;
        font-weight: bold;
        text-decoration: none;
      }
      nav div.ml-auto a {
        text-decoration: none;
        font-weight: 600;
        font-size: 0.8rem;
      }
      header {
        padding: 20px 0px;
      }
      header .active {
        font-weight: 700;
        position: relative;
      }
      header .active .fa-check {
        position: absolute;
        left: 50%;
        bottom: -27px;
        background-color: #fff;
        font-size: 0.7rem;
        padding: 5px;
        border: 1px solid #008000;
        border-radius: 50%;
        color: #008000;
      }
      .progress {
        height: 2px;
        background-color: #ccc;
      }
      .progress div {
        display: flex;
        align-items: center;
        justify-content: center;
      }
      .progress .progress-bar {
        width: 40%;
      }
      #details {
        padding: 30px 50px;
        min-height: 300px;
      }
      input {
        border: none;
        outline: none;
      }
      .form-group .d-flex {
        border: 1px solid #ddd;
      }
      .form-group .d-flex input {
        width: 95%;
      }
      .form-group .d-flex:hover {
        color: #000;
        cursor: pointer;
        border: 1px solid #008000;
      }
      select {
        width: 100%;
        padding: 8px 5px;
        border: 1px solid #ddd;
        border-radius: 5px;
      }
      input[type="checkbox"] + label {
        font-size: 0.85rem;
        font-weight: 600;
      }
      #address,
      #cart,
      #summary {
        padding: 20px 50px;
      }
      #address .d-md-flex p.text-justify,
      #register p.text-muted {
        margin: 0;
      }
      #register {
        background-color: #d9ecf2;
      }
      #register a {
        text-decoration: none;
        color: #333;
      }
      #cart,
      #summary {
        max-width: 500px;
      }
      .h6 {
        font-size: 1.2rem;
        font-weight: 700;
      }
      .h6 a {
        text-decoration: none;
        font-size: 1rem;
      }
      .item img {
        object-fit: cover;
        border-radius: 5px;
      }
      .item {
        position: relative;
      }
      .number {
        position: absolute;
        font-weight: 800;
        color: #fff;
        background-color: #828282;
        padding-left: 7px;
        border-radius: 50%;
        border: 1px solid #fff;
        width: 25px;
        height: 25px;
        top: -5px;
        right: -5px;
      }
      .display-5 {
        font-size: 1.2rem;
      }
      #cart ~ p.text-muted {
        margin: 0;
        font-size: 0.9rem;
      }
      tr.text-muted td {
        border: none;
      }
      .fa-minus,
      .fa-plus {
        font-size: 0.7rem;
      }
      .table td {
        padding: 0.3rem;
      }
      .btn.text-uppercase {
        border: 1px solid #333;
        font-weight: 600;
        border-radius: 0px;
      }
      .btn.text-uppercase:hover {
        background-color: #333;
        color: #eee;
      }
      .btn.text-white {
        background-color: #66cdaa;
        border-radius: 0px;
      }
      .btn.text-white:hover {
        background-color: #3cb371;
      }
      .wrapper .row + div.text-muted {
        font-size: 0.9rem;
      }
      .mobile,
      #mobile {
        display: none;
      }
      .buttons {
        vertical-align: text-bottom;
      }
      #register {
        width: 50%;
      }
      @media (min-width: 768px) and (max-width: 991px) {
        .progress .progress-bar {
          width: 33%;
        }
        #cart,
        #summary {
          max-width: 100%;
        }
        .wrapper div.h5.large,
        .wrapper .row + div.text-muted {
          display: none;
        }
        .mobile.h5,
        #mobile {
          display: block;
        }
      }
      @media (min-width: 576px) and (max-width: 767px) {
        .progress .progress-bar {
          width: 29%;
        }
        #cart,
        #summary {
          max-width: 100%;
        }
        .wrapper div.h5.large,
        .wrapper .row + div.text-muted {
          display: none;
        }
        .mobile.h5,
        #mobile {
          display: block;
        }
        .buttons {
          width: 100%;
        }
      }
      @media (max-width: 575px) {
        .progress .progress-bar {
          width: 38%;
        }
        #cart,
        #summary {
          max-width: 100%;
        }
        nav,
        .wrapper {
          padding: 10px 30px;
        }
        #register {
          width: 100%;
        }
      }
      @media (max-width: 424px) {
        body {
          width: fit-content;
        }
      }
      @media (max-width: 375px) {
        .progress .progress-bar {
          width: 35%;
        }
        body {
          width: fit-content;
        }
      }
    </style>
  </head>
  <body>
    <!-- nav start -->
	<%@ include file="../component/nav.jsp" %>
    <!-- nav end -->
    
    <header>
      <div class="d-flex justify-content-center align-items-center pb-3">
        <div class="px-sm-5 px-2 active">
          장바구니
          <span class="fas fa-check"></span>
        </div>
        <div class="px-sm-5 px-2">결제</div>
        <div class="px-sm-5 px-2">결제완료</div>
      </div>
      <div class="progress">
        <div
          class="progress-bar bg-success"
          role="progressbar"
          aria-valuenow="25"
          aria-valuemin="0"
          aria-valuemax="100"
        ></div>
      </div>
    </header>
    <div class="wrapper">
      <div class="h5 large">주문 결제</div>
      <div class="row">
        <div
          class="col-lg-8 col-md-8 col-sm-10 offset-lg-0 offset-md-2 offset-sm-1"
        >
          <div class="mobile h5">Billing Address</div>
          <div id="details" class="bg-white rounded pb-5">
            <form>
              <div class="form-group">
                <label class="text-muted">이름</label>
                <input type="text" value="David Smith" class="form-control" id="order_name" name="order_name"/>
              </div>
              <div class="form-group">
                <label class="text-muted">핸드폰 번호</label>
                <div
                  class="d-flex jusify-content-start align-items-center rounded p-2"
                >
                  <input type="text" value="010123412324" id="order_phone" name="order_phone" />
                </div>
              </div>
              <div class="row">
                <div class="col-lg-9">
                  <div class="form-group">
                    <label class="text-muted">우편번호</label>
                    <div
                      class="d-flex jusify-content-start align-items-center rounded p-2"
                    >
                      <input type="text" value="01001" />
                    </div>
                  </div>
                </div>
                <div class="col-lg-3">
                  <div class="form-group">
                    <label> </label>
                    <div
                      class="d-flex jusify-content-start align-items-center rounded p-2"
                    >
                      <input type="button" value="우편번호 찾기" />
                    </div>
                  </div>
                </div>
              </div>
              <div class="row">
                  <div class="form-group">
                    <label class="text-muted">주소</label>
                    <div
                      class="d-flex jusify-content-start align-items-center rounded p-2"
                    >
                      <input type="text" value="서울시 강남구 역삼동" />
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="text-muted">상세주소</label>
                    <div
                      class="d-flex jusify-content-start align-items-center rounded p-2"
                    >
                      <input type="text" value="kh정보교육원" />
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="text-muted">배송시 요청사항</label>
                    <div
                      class="d-flex jusify-content-start align-items-center rounded p-2"
                    >
                      <input type="text" value="경비실에 맡겨주세요." />
                    </div>
                  </div>
              </div>
              <br><hr>
              <label class="text-muted">쿠폰 적용</label>
              <select name="country" id="country">
              	<option disabled hidden value selected>쿠폰 선택</option>
                <option value="생일 쿠폰 10%">생일 쿠폰 10%</option>
                <option value="신학기 5%">신학기 5%</option>
              </select>
              <div class="row">
              	<div class="col-8">
	              <div class="form-group">
    	            <label class="text-muted">적립금</label>
        	        <input type="text" value="" class="form-control" placeholder="100원 단위로 입력해주세요."/>
            	  </div>
              	</div>
              	<div class="col-4">
              		<div class="form-group">
              		<label class="text-muted"></label>
              		<p>사용가능 : 0p</p>
            	  </div>
              	</div>
              </div>
            </form>
          </div>
        </div>
        <div
          class="col-lg-4 col-md-8 col-sm-10 offset-lg-0 offset-md-2 offset-sm-1 pt-lg-0 pt-3"
        >
          <div id="cart" class="bg-white rounded">
            <div class="d-flex justify-content-between align-items-center">
              <div class="h6">주문 상품(1)</div>
            </div>
            <div
              class="d-flex jusitfy-content-between align-items-center pt-3 pb-2 border-bottom"
            >
              <div class="item pr-2">
                <img
                  src="https://images.unsplash.com/photo-1569488859134-24b2d490f23f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60"
                  alt=""
                  width="80"
                  height="80"
                />
                <div class="number">2</div>
              </div>
              <div class="d-flex flex-column px-3">
                <b class="h5">BattleCreek Coffee</b>
                <a href="#" class="h5 text-primary">C-770</a>
              </div>
              <div class="ml-auto">
                <b class="h5">$80.9</b>
              </div>
            </div>
            <div class="d-flex align-items-center mt-3">
              <div class="display-5">총 상품금액</div>
              <div class="ml-auto font-weight-bold">$80.9</div>
            </div>
            <div class="d-flex align-items-center py-2 border-bottom">
              <div class="display-5">배송비</div>
              <div class="ml-auto font-weight-bold">$12.9</div>
            </div>
            <div class="d-flex align-items-center py-2">
              <div class="display-5">총 결제금액</div>
              <div class="ml-auto d-flex">
                <div class="text-primary text-uppercase px-3">usd</div>
                <div class="font-weight-bold">$92.98</div>
              </div>
            </div>
          </div>
          <div class="row pt-lg-3 pt-2 buttons mb-sm-0 mb-2">
              <div class="btn ml-3 mr-3" style="background-color: #eee;">
                <span class="fas fa-solid fa-credit-card"></span>
                주문하기
              </div>
          </div>
        </div>
      </div>
    </div>
    
    <!-- footer start -->
	<%@ include file="../component/footer.jsp" %>
    <!-- footer end -->
  </body>
</html>
