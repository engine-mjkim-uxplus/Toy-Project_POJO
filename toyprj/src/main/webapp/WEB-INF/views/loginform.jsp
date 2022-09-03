<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Login V8</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    
    <%@ include file="../../common/common.jsp" %>
    
    <style>
      a {
        text-decoration: none;
      }

      input {
        height: 2px;
      }
    </style>
  </head>
  <body>
    <!-- nav start -->
	<%@ include file="../../component/nav.jsp" %>
    <!-- nav end -->
    <section class="vh-100 gradient-custom">
      <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
          <div class="col-12 col-md-8 col-lg-6 col-xl-5">
            <div class="card bg-dark text-white" style="border-radius: 1rem">
              <div class="card-body p-5 text-center">
                <div class="mb-md-5 mt-md-4 pb-5">
                  <h2 class="fw-bold mb-2 text-uppercase">Login</h2>
                  <p class="text-white-50 mb-5">
                    Please enter your login and password!
                  </p>
                  <!-- ==================== Form 태그 시작 ==================== -->
                  <form action="#">
                    <div class="form-outline form-black mb-4">
                      <label class="form-label" for="typeEmailX">ID</label>
                      <input
                        type="ID"
                        id="typeEmailX"
                        class="form-control form-control-lg"
                      />
                    </div>
                    <div class="form-outline form-white mb-4">
                      <label class="form-label" for="typePasswordX"
                        >Password</label
                      >
                      <input
                        type="password"
                        id="typePasswordX"
                        class="form-control form-control-lg"
                      />
                    </div>
                    <button
                      class="btn btn-outline-light btn-lg px-5"
                      type="submit"
                    >
                      Login
                    </button>
                  </form>
                  <!-- ==================== Form 태그 끝 ==================== -->
                </div>
                <div>
                  <a href="#!" class="text-white-50 fw-bold">비회원 주문조회</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
	<!-- footer start -->
	<%@ include file="../../component/footer.jsp" %>
    <!-- footer end -->
  </body>
</html>
