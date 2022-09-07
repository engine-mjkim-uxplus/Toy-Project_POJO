<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- nav start -->
<c:set var="loginOutLink" value="${sessionScope.mem_id == null ? '/login/loginForm.do' : '/login/logout.do' }"/>
<c:set var="loginOut" value="${sessionScope.mem_id == null ? '로그인' : '로그아웃' }"/>

<nav
  class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-bottom"
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
    href="./home.jsp"
    class="col-md-4 d-flex align-items-center justify-content-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none"
  >
    <h1>WORKSOUT</h1>
  </a>

  <ul class="nav col-md-4 justify-content-end">
    <li class="nav-item">
      <a href="#" class="nav-link px-2 text-muted">
        <i class="fa fa-search text-muted"></i> 검색
      </a>
    </li>
    <li class="nav-item">
      <a href="./cart.jsp" class="nav-link px-2 text-muted">장바구니(3)</a>
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