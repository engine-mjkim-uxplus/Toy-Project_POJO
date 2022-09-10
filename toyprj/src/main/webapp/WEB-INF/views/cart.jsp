<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>

    <%@ include file="../../common/common.jsp" %>
    <style>
/*       body {
        background: #ddd;
        min-height: 100vh;
        vertical-align: middle;
        display: flex;
        font-family: sans-serif;
        font-size: 0.8rem;
        font-weight: bold;
      } */
      .title {
        margin-bottom: 5vh;
      }
      .card {
        margin: auto;
        max-width: 950px;
        width: 90%;
        box-shadow: 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        border-radius: 1rem;
        border: transparent;
      }
      @media (max-width: 767px) {
        .card {
          margin: 3vh auto;
        }
      }
      .cart {
        background-color: #fff;
        padding: 4vh 5vh;
        border-bottom-left-radius: 1rem;
        border-top-left-radius: 1rem;
      }
      @media (max-width: 767px) {
        .cart {
          padding: 4vh;
          border-bottom-left-radius: unset;
          border-top-right-radius: 1rem;
        }
      }
      .summary {
        background-color: #ddd;
        border-top-right-radius: 1rem;
        border-bottom-right-radius: 1rem;
        padding: 4vh;
        color: rgb(65, 65, 65);
      }
      @media (max-width: 767px) {
        .summary {
          border-top-right-radius: unset;
          border-bottom-left-radius: 1rem;
        }
      }
      .summary .col-2 {
        padding: 0;
      }
      .summary .col-10 {
        padding: 0;
      }
      .row {
        margin: 0;
      }
      .title b {
        font-size: 1.5rem;
      }
      .main {
        margin: 0;
        padding: 2vh 0;
        width: 100%;
      }
      .col-2,
      .col {
        padding: 0 1vh;
      }
      a {
        padding: 0 1vh;
      }
      .close {
        margin-left: auto;
        font-size: 0.7rem;
      }
      img {
        width: 3.5rem;
      }
      .back-to-shop {
        margin-top: 4.5rem;
      }
      h5 {
        margin-top: 4vh;
      }
      hr {
        margin-top: 1.25rem;
      }
      form {
        padding: 2vh 0;
      }
      select {
        border: 1px solid rgba(0, 0, 0, 0.137);
        padding: 1.5vh 1vh;
        margin-bottom: 4vh;
        outline: none;
        width: 100%;
        background-color: rgb(247, 247, 247);
      }
      input {
        border: 1px solid rgba(0, 0, 0, 0.137);
        padding: 1vh;
        margin-bottom: 4vh;
        outline: none;
        width: 100%;
        background-color: rgb(247, 247, 247);
      }
      input:focus::-webkit-input-placeholder {
        color: transparent;
      }
      .btn {
        background-color: #000;
        border-color: #000;
        color: white;
        width: 100%;
        font-size: 0.7rem;
        margin-top: 4vh;
        padding: 1vh;
        border-radius: 0;
      }
      .btn:focus {
        box-shadow: none;
        outline: none;
        box-shadow: none;
        color: white;
        -webkit-box-shadow: none;
        -webkit-user-select: none;
        transition: none;
      }
      .btn:hover {
        color: black;
      }
      a {
        color: black;
      }
      a:hover {
        color: black;
        text-decoration: none;
      }
      #code {
        background-image: linear-gradient(
            to left,
            rgba(255, 255, 255, 0.253),
            rgba(255, 255, 255, 0.185)
          ),
          url("https://img.icons8.com/small/16/000000/long-arrow-right.png");
        background-repeat: no-repeat;
        background-position-x: 95%;
        background-position-y: center;
      }
      button{
        border:none;
      }
    </style>
  </head>
  <body>
  	<!-- nav start -->
	<%@ include file="../../component/nav.jsp" %>
    <!-- nav end -->
    <!-- cart-list start -->
  <div class="card">
      <div class="row">
        <div class="col-md-12 cart">
          <div class="title">
            <div class="row">
              <div class="col">
                <h4><b>장바구니</b></h4>
              </div>
            </div>
          </div>
          <!-- 장바구니 아이템 목록 시작 -->
          <c:forEach var="item" items="${requestScope.cartList}">
	          <section class="cart_table">
	            <div class="row border-top">
	              <div class="row main align-items-center">
	                <div class="col-2">
	                  <img class="img-fluid product_img" src="${item.getProduct_img()}" />
	                </div>
	                <div class="col">
	                  <div class="row text-muted product_category">${item.getProduct_category()}</div>
	                  <div class="row product-name">${item.getProduct_name()}</div>
	                </div>
	                <div class="col d-flex">
	                  <button onClick="cart/cartUpdate.do"><i class="fas fa-minus-circle"></i></button>
	                  <div class="border col-3 text-center product_count">${item.getProduct_count()}</div>
	                  <button class="plust"><i class="fas fa-plus-circle"></i></button>
	                </div>
	                <div class="col product_price">
	                  ${item.getProduct_price()}
	                  <button class="minus"><i class="fas fa-times"></i></butt>
	                </div>
	              </div>
	            </div>
	            </section>
			</c:forEach>
<!--           <section class="cart_table">
            <div class="row border-top">
              <div class="row main align-items-center">
                <div class="col-2">
                  <img class="img-fluid product_img" src="https://image.msscdn.net/images/goods_img/20210906/2112059/2112059_1_500.jpg?t=20210909113606" />
                </div>
                <div class="col">
                  <div class="row text-muted product_category">Shirt</div>
                  <div class="row product-name">Cotton T-shirt</div>
                </div>
                <div class="col d-flex">
                  <button onClick="cart/cartUpdate.do"><i class="fas fa-minus-circle"></i></button>
                  <div class="border col-3 text-center product_count">1</div>
                  <button class="plust"><i class="fas fa-plus-circle"></i></button>
                </div>
                <div class="col product_price">
                  44,000원
                  <button class="minus"><i class="fas fa-times"></i></butt>
                </div>
              </div>
            </div>
            </section> -->
            <!-- 장바구니 아이템 목록 끝 -->
            <div class="col mt-4">총 가격 <span class="ms-5"id="total_price">130,000</span></div>
            <button class="btn">주문하기</button>
          </div>
        </div>
      </div>
    </div>
    <!-- cart-list end -->
    <!-- footer start -->
	<%@ include file="../../component/footer.jsp" %>
    <!-- footer end -->
  </body>
</html>
