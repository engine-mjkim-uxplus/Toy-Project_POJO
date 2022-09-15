<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="greenContainer bg-primary bg-opacity-50">
  <div>
    <div class="grade">COMMON</div>
    <div class="name">${member.getMember_id()}</div>
  </div>
  <div class="modify">
	<button class="btn btn-secondary btn-sm" type="button">프로필 수정</button>
  </div>
</div>


<div class="summaryContainer border-bottom border-secondary">
  <div class="item">
    <div class="number">${member.getMember_name()}</div>
    <div>회원이름</div>
  </div>
  <div class="item">
    <div class="number">${member.getMember_point()}</div>
    <div>적립금(KRW)</div>
  </div>
  <div class="item">
    <div class="number">${member.getMember_coupon()}</div>
    <div>보유 쿠폰</div>
  </div>
</div>