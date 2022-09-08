<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />

    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Shop Item - Start Bootstrap Template</title>
    <%@ include file="../../common/common.jsp" %>
  </head>
  <body>
  	<script type="text/javascript">
  		function cartCount(result){
  			let count = document.getElementById('inputQuantity');
  			let countNum = parseInt(count.value);
  			
  			if (result === '+'){
  				count.value = ++countNum;
  			}else {
  				countNum = countNum > 1 ? countNum-1 : countNum;
  				count.value = countNum;
  			}
  		}
		function addLike(no,category){
			alert("좋아요를 눌렀습니다.")
			location.href = "./productInsertLike.do?page=productDetail.do&product_no="+no+"&product_category="+category;
		}  	
  	</script>
    <!-- nav start -->
	<%@ include file="../../component/nav.jsp" %>
    <!-- nav end -->

    <!-- Product section-->
    <section class="py-5 bg-light">
      <div class="container px-4 px-lg-5 my-5">
        <div class="row gx-4 gx-lg-5 align-items-center">
          <div class="col-md-6">
            <img
              class="card-img-top mb-5 mb-md-0"
              src="${product.getProduct_img()}"
              alt="..."
            />
          </div>
          <div class="col-md-6">
            <div class="small mb-1">${product.getProduct_category()}</div>
            <h1 class="display-5 fw-bolder">${product.getProduct_name()}</h1>
            <div class="fs-5 mb-3">
              <!-- <span class="text-decoration-line-through">$45.00</span> -->
              <span>${product.getProduct_price()}\</span>
              <h4><a href="javascript:addLike(${product.getProduct_no()},'${product.getProduct_category()}')" ><i class="fa fa-heart" style="color: red;">${product.getProduct_like()}</i></a></h4>
            </div>
            <p class="lead">
              Lorem ipsum dolor sit amet consectetur adipisicing elit.
              Praesentium at dolorem quidem modi. Nam sequi consequatur
              obcaecati excepturi alias magni, accusamus eius blanditiis
              delectus ipsam minima ea iste laborum vero?
            </p>
            <div class="d-flex mb-2">
              <input
                class="form-control text-center me-3"
                id="inputQuantity"
                type="num"
                value="1"
                style="max-width: 3rem"
              />
              <button onclick="cartCount('+')" class="btn btn-outline-dark me-1" type="button"><i class="fas fa-plus-circle"></i></button>
              <button onclick="cartCount('-')" class="btn btn-outline-dark" type="button"><i class="fas fa-minus-circle"></i></button>
            </div>
            <button onclick="alert('장바구니 담기')" class="btn btn-outline-dark flex-shrink-0" type="button">
              <i class="bi-cart-fill me-1"></i>
              Add to cart
            </button>
          </div>
        </div>
      </div>
    </section>
    <!-- Related items section-->
    <section class="py-5 bg-light">
      <div class="container px-4 px-lg-5 mt-5">
        <h2 class="fw-bolder mb-4">Related products</h2>
        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
        
	        <c:forEach var="item" items="${productList}">
	          <div class="col mb-5">
	            <div class="card h-100">
	            	<c:if test="${ item.getProduct_no() == 101 }">
	            		<!-- Sale badge-->
			            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
					</c:if>

	              <!-- Product image-->
	              <a href="./productDetail.do?product_no=${item.getProduct_no()}&product_category=${item.getProduct_category()}">
	              <img
	                class="card-img-top"
	                src="${item.getProduct_img()}"
	                alt="..."
	              />
	              </a>
	              <!-- Product details-->
	              <div class="card-body p-4">
	                <div class="text-center">
	                  <!-- Product name-->
	                  <h5 class="fw-bolder">${item.getProduct_name()}</h5>
	                  <!-- Product price-->
	                  ${item.getProduct_price()}\
	                </div>
	              </div>
	            </div>
	          </div>
	    	</c:forEach>
	    	
        </div>
      </div>
    </section>
    <!-- footer start -->
	<%@ include file="../../component/footer.jsp" %>
    <!-- footer end -->
  </body>
</html>