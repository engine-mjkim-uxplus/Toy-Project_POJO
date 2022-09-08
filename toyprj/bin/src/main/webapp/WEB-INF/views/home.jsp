<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="description" content="" />
    <meta
      name="author"
      content="Mark Otto, Jacob Thornton, and Bootstrap contributors"
    />
    <meta name="generator" content="Hugo 0.101.0" />
    <title>Footers · Bootstrap v5.2</title>
    <link
      rel="canonical"
      href="https://getbootstrap.com/docs/5.2/examples/footers/"
    />
	<%@ include file="../../common/common.jsp" %>
    <meta name="theme-color" content="#712cf9" />
    <style>
      .product-grid {
        font-family: "Poppins", sans-serif;
        text-align: center;
      }
      .product-grid .product-image {
        overflow: hidden;
        position: relative;
        z-index: 1;
      }
      .product-grid .product-image a.image {
        display: block;
      }
      .product-grid .product-image img {
        width: 100%;
        height: auto;
      }
      .product-grid .product-discount-label {
        color: #fff;
        background: lightslategray;
        font-size: 13px;
        font-weight: 600;
        line-height: 25px;
        padding: 0 20px;
        position: absolute;
        top: 10px;
        left: 0;
      }
      .product-grid .product-links {
        padding: 0;
        margin: 0;
        list-style: none;
        position: absolute;
        top: 10px;
        right: -50px;
        transition: all 0.5s ease 0s;
      }
      .product-grid:hover .product-links {
        right: 10px;
      }
      .product-grid .product-links li a {
        color: #333;
        background: transparent;
        font-size: 17px;
        line-height: 38px;
        width: 38px;
        height: 38px;
        border: 1px solid #333;
        border-bottom: none;
        display: block;
        transition: all 0.3s;
      }
      .product-grid .product-links li:last-child a {
        border-bottom: 1px solid #333;
      }
      .product-grid .product-links li a:hover {
        color: #fff;
        background: #333;
      }
      .product-grid .add-to-cart {
        background: lightslategray;
        color: #fff;
        font-size: 16px;
        text-transform: uppercase;
        letter-spacing: 2px;
        width: 100%;
        padding: 10px 26px;
        position: absolute;
        left: 0;
        bottom: -60px;
        transition: all 0.3s ease 0s;
      }
      .product-grid:hover .add-to-cart {
        bottom: 0;
      }
      .product-grid .add-to-cart:hover {
        text-shadow: 4px 4px rgba(0, 0, 0, 0.2);
      }
      .product-grid .product-content {
        background: #fff;
        padding: 15px;
        box-shadow: 0 0 0 5px rgba(0, 0, 0, 0.1) inset;
      }
      .product-grid .title {
        font-size: 16px;
        font-weight: 600;
        text-transform: capitalize;
        margin: 0 0 7px;
      }
      .product-grid .title a {
        color: #777;
        transition: all 0.3s ease 0s;
      }
      .product-grid .title a:hover {
        color: #a5ba8d;
      }
      .product-grid .price {
        color: #0d0d0d;
        font-size: 14px;
        font-weight: 600;
      }
      .product-grid .price span {
        color: #888;
        font-size: 13px;
        font-weight: 400;
        text-decoration: line-through;
      }
      @media screen and (max-width: 990px) {
        .product-grid {
          margin-bottom: 30px;
        }
      }
    </style>
  </head>
  <body>
    <!-- nav start -->
	<%@ include file="../../component/nav.jsp" %>
    <!-- nav end -->

    <!-- 상풍 분류 컨테이너 시작 -->

    <!-- 상풍 분류 컨테이너 끝 -->

    <!-- product content start -->
    <div class="row">
      <div class="col-md-3 col-sm-6" style="width: 20%">
        <div class="product-grid">
          <div class="product-image">
            <a href="./detail.jsp" class="image">
              <img
                src="https://media.worksout.co.kr/uploads/live/VS22FWHEBC10539001/VS22FWHEBC10539001-1.jpg"
              />
            </a>
            <span class="product-discount-label">-23%</span>
            <ul class="product-links">
              <li>
                <a href="#"><i class="fa fa-heart"></i></a>
              </li>
              <li>
                <a href="#"><i class="fas fa-shopping-cart"></i></a>
              </li>
            </ul>
          </div>
        </div>
      </div>
      <div class="col-md-3 col-sm-6" style="width: 20%">
        <div class="product-grid">
          <div class="product-image">
            <a href="./detail.jsp" class="image">
              <img
                src="https://media.worksout.co.kr/uploads/live/AC22SSHECH09904001/AC22SSHECH09904001-1.jpg"
              />
            </a>
            <ul class="product-links">
              <li>
                <a href="#"><i class="fa fa-heart"></i></a>
              </li>
              <li>
                <a href="#"><i class="fas fa-shopping-cart"></i></a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <!-- product content end -->

    <!-- 추가할 기능 컨테이너 시작 -->

    <!-- 추가할 기능 컨테이너 끝 -->

    <!-- footer start -->
	<%@ include file="../../component/footer.jsp" %>
    <!-- footer end -->
  </body>
</html>