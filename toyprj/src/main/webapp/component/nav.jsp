<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- nav start -->
<c:set var="loginOutLink" value="${sessionScope.mem_id == null ? '/login/loginForm.do' : '/login/logout.do' }"/>
<c:set var="loginOut" value="${sessionScope.mem_id == null ? '로그인' : '로그아웃' }"/>

<nav
  class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-bottom border-secondary"
>
  <ul class="nav col-md-4 justify-content-start">
    <li class="nav-item">
      <a href="#" class="nav-link px-2 text-muted">응모</a>
    </li>
    <li class="nav-item">
      <a href="#" class="nav-link px-2 text-muted">매장안내</a>
    </li>
  </ul>

  <a
    href="/product/productList.do"
    class="col-md-4 d-flex align-items-center justify-content-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none"
  >
    <h1>WORKSOUT</h1>
  </a>

  <ul class="nav col-md-4 justify-content-end">
    <li class="nav-item">
      <button class="nav-link px-2 text-muted border-0" data-bs-toggle="modal" data-bs-target="#exampleModal">
      	<i class="fa fa-search text-muted "></i> 검색
      </button>
    </li>
    <li class="nav-item">
      <a href="/cart/cartList.do" class="nav-link px-2 text-muted">장바구니(3)</a>
    </li>
    <li class="nav-item">
      <a href="./mypage.jsp" class="nav-link px-2 text-muted">마이페이지</a>
    </li>
    <li class="nav-item">
      <a href="${loginOutLink}" class="nav-link px-2 text-muted">${loginOut}</a>
    </li>
  </ul>
</nav>
<!-- nav end -->

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content border border-secondary rounded-3 border-opacity-50">
      <div class="modal-body">
       <form class="d-flex" role="search" action="productSearch.do" method="post">
          <input name="search" type="search" class="form-control" placeholder="검색어를 입력하세요" aria-label="Search">
          <button type="submit" class="btn btn-warning" style="margin-left: 5px"><i class="fas fa-search"></i></button>
        </form>
      </div>
    </div>
  </div>
</div>
<!-- Modal -->