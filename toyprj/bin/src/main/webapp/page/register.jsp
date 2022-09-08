<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
	<%@ include file="../common/common.jsp" %>
	<style>
	body {
		box-sizing: border-box;
	}
	@media (min-width: 1025px) {
	  .h-custom {
	    height: 100vh !important;
	  }
	}
	.card-registration .select-input.form-control[readonly]:not([disabled]) {
	  font-size: 1rem;
	  line-height: 2.15;
	  padding-left: 0.75em;
	  padding-right: 0.75em;
	}
	.card-registration .select-arrow {
	  top: 13px;
	}
	
	.gradient-custom-2 {
	  /* fallback for old browsers */
	  background: #a1c4fd;
	
	  /* Chrome 10-25, Safari 5.1-6 */
	  background: -webkit-linear-gradient(
	    to right,
	    rgba(161, 196, 253, 1),
	    rgba(194, 233, 251, 1)
	  );
	
	  /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
	  background: linear-gradient(
	    to right,
	    rgba(161, 196, 253, 1),
	    rgba(194, 233, 251, 1)
	  );
	}
	
	.bg-indigo {
	  background-color: #4835d4;
	}
	@media (min-width: 992px) {
	  .card-registration-2 .bg-indigo {
	    border-top-right-radius: 15px;
	    border-bottom-right-radius: 15px;
	  }
	}
	@media (max-width: 991px) {
	  .card-registration-2 .bg-indigo {
	    border-bottom-left-radius: 15px;
	    border-bottom-right-radius: 15px;
	  }
	}
	</style>
  </head>
  <body>
    <!-- nav start -->
	<%@ include file="../component/nav.jsp" %>
    <!-- nav end -->
    <section class="h-100 h-custom gradient-custom-2">
      <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
          <div class="col-12">
            <div
              class="card card-registration card-registration-2"
              style="border-radius: 15px; border: 1px solid #ddd"
            >
              <div class="card-body p-0">
                <div class="row g-0">
                  <div class="col-lg-6">
                    <div class="p-5">
                      <h3 class="fw-normal mb-5" style="color: #4835d4">
                        회원가입
                      </h3>
                      <!-- [[이름]] -->
                      <div class="mb-4 pb-2">
                        <label class="form-label" for="mem_name">이름: </label>
                        <input
                          type="text"
                          id="mem_name"
                          class="form-control form-control-lg"
                          placeholder="이름을 입력해주세요"
                        />
                      </div>
                      <!-- [[아이디]] -->
                      <div class="row">
                        <div class="col-md-2">
                          <div
                            class="form-outline"
                            style="margin-top: 15px; text-align: right"
                          >
                            아이디:
                          </div>
                        </div>
                        <div class="col-md-6 mb-4 pb-2">
                          <div class="form-outline">
                            <input
                              type="text"
                              id="mem_id"
                              class="form-control form-control-lg"
                              placeholder="아이디를 입력하세요"
                            />
                          </div>
                        </div>
                        <div class="col-md-3 mb-4 pb-2">
                          <div class="form-outline">
                            <button
                              type="button"
                              id="idCheck"
                              class="form-control"
                              style="
                                background-color: rgba(161, 196, 253, 1);
                                margin-top: 5px;
                              "
                            >
                              중복확인
                            </button>
                          </div>
                        </div>
                      </div>
                      <!-- [[비밀번호]] -->
                      <div class="mb-4 pb-2">
                        <label class="form-label" for="mem_password"
                          >비밀번호:
                        </label>
                        <input
                          type="password"
                          id="mem_password"
                          class="form-control form-control-lg"
                          placeholder="비밀번호를 입력해주세요"
                        />
                      </div>
                      <!-- [[전화번호]] -->
                      <div class="mb-4 pb-2">
                        <div class="form-outline">
                          <label class="form-label" for="form3Examplev4"
                            >전화번호:
                          </label>
                          <input
                            type="text"
                            id="mem_phoneNumber"
                            class="form-control form-control-lg"
                            placeholder="전화번호를 입력해주세요"
                          />
                        </div>
                      </div>

                      <!-- [[성별체크]] -->
                      <div class="col-md-12 mb-5 form-outline">
                        <label class="form-label" for="gender">성별 </label>
                        <div class="form-check form-check-inline" id="gender">
                          <input
                            class="form-check-input"
                            type="radio"
                            name="inlineRadioOptions"
                            id="femaleGender"
                            value="여자"
                            checked
                          />
                          <label class="form-check-label" for="femaleGender"
                            >여자</label
                          >
                          <div class="form-check form-check-inline">
                            <input
                              class="form-check-input"
                              type="radio"
                              name="inlineRadioOptions"
                              id="maleGender"
                              value="남자"
                            />
                            <label class="form-check-label" for="maleGender"
                              >남자</label
                            >
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="col-lg-6 bg-indigo text-white">
                    <div class="p-5">
                      <h3 class="fw-normal mb-5">상세주소</h3>

                      <div class="mb-4 pb-2">
                        <div class="form-outline form-white">
                          <label class="form-label" for="zipcode"
                            >우편번호:</label
                          >
                          <input
                            type="text"
                            id="zipcode"
                            class="form-control form-control-lg"
                            placeholder="우편번호"
                          />
                        </div>
                      </div>

                      <div class="row">
                        <div class="col-md-9 mb-4 pb-2">
                          <div class="form-outline form-white">
                            <label class="form-label" for="mem_address"
                              >주소:
                            </label>
                            <input
                              type="text"
                              id="mem_address"
                              class="form-control form-control-lg"
                              placeholder="주소는 검색버튼을 눌러주세요"
                              style="background-color: #ddd"
                              readonly
                            />
                          </div>
                        </div>
                        <div class="col-md-2 mt-3">
                          <div style="margin: 20px"></div>
                          <button
                            type="button"
                            id="btn_address"
                            class="form-control"
                          >
                            검색
                          </button>
                        </div>
                      </div>

                      <div class="mb-4 pb-2">
                        <div class="form-outline form-white">
                          <input
                            type="text"
                            id="mem_address_detail"
                            class="form-control form-control-lg"
                            placeholder="상세주소 입력"
                          />
                        </div>
                      </div>

                      <br /><br /><br /><br />
                      <div class="row">
                        <div class="col-md-9"></div>
                        <div class="col-md-3">
                          <button
                            type="button"
                            class="btn btn-light btn-lg"
                            data-mdb-ripple-color="dark"
                            style="background-color: #cce1ff"
                          >
                            회원가입
                          </button>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  	<!-- footer start -->
	<%@ include file="../component/footer.jsp" %>
    <!-- footer end -->
  </body>
</html>
