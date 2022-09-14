package com.shopping.toyprj;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.controller.CartController;
import com.controller.LoginController;
import com.controller.MemberController;
import com.controller.OrderController;
import com.controller.ProductController;
import com.controller.RegisterController;
import com.util.ModelAndView;

public class HandlerMapping {
	static Logger logger = Logger.getLogger(HandlerMapping.class);
	/***************************************************************
	 * 
	 * @param upmu(upmu[0]=업무폴더이름, upmu[1]=업무기능이름)
	 * @return String/ModelAndView(유지를 위한 req,res.setAttribute()를 대신)
	 **************************************************************/
	public static Object getController(String[] upmu
			            , HttpServletRequest req, HttpServletResponse res) {
		logger.info(upmu[0]+", "+upmu[1]);
		Controller controller = null;
		Object obj = null;
		String path  = null;
		ModelAndView mav = null;
		// 상품 분기(ProductController)
		if("product".equals(upmu[0])) {
			controller = new ProductController();
			//전체 조회(메인페이지)
			if("productList".equals(upmu[1])) {
				obj = controller.productList(req,res);
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				} else if(obj instanceof String) {
					return (String)obj;
				}
			// 상품상세 조회
			} else if("productDetail".equals(upmu[1])) {
				obj = controller.productDetail(req,res);
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				} else if(obj instanceof String) {
					return (String)obj;
				}
			// 상품 검색	
			}  else if("productSearch".equals(upmu[1])) {
				obj = controller.productSearch(req,res);
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				} else if(obj instanceof String) {
					return (String)obj;
				}
			}
			// 리뷰 등록
			 else if("productInsertReview".equals(upmu[1])) {
					obj = controller.productInsertReview(req,res);
					if(obj instanceof ModelAndView) {
						return (ModelAndView)obj;
					} else if(obj instanceof String) {
						return (String)obj;
					}
				}
			// 리뷰 수정
			 else if("productUpdateReview".equals(upmu[1])) {
					obj = controller.productUpdateReview(req,res);
					if(obj instanceof ModelAndView) {
						return (ModelAndView)obj;
					} else if(obj instanceof String) {
						return (String)obj;
					}
				}
			// 사용자가 구매확정 시 구매횟수 증가
			 else if("productUpdateCount".equals(upmu[1])) {
					obj = controller.productUpdateCount(req,res);
					if(obj instanceof ModelAndView) {
						return (ModelAndView)obj;
					} else if(obj instanceof String) {
						return (String)obj;
					}
				}
			// 좋아요 등록
			 else if("productInsertLike".equals(upmu[1])) {
					obj = controller.productInsertLike(req,res);
					if(obj instanceof ModelAndView) {
						return (ModelAndView)obj;
					} else if(obj instanceof String) {
						return (String)obj;
					}
				}
			// 좋아요 삭제
			 else if("productDeleteLike".equals(upmu[1])) {
					obj = controller.productDeleteLike(req,res);
					if(obj instanceof ModelAndView) {
						return (ModelAndView)obj;
					} else if(obj instanceof String) {
						return (String)obj;
					}
				} 
		} // end of ProductController
		///////////////////////////////////////////
		// 로그인 분기(LoginController)
		else if("login".equals(upmu[0])) {
			controller = new LoginController();
			// 로그인 페이지
			if("loginForm".equals(upmu[1])) {
				obj = controller.loginForm(req,res);
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				} else if(obj instanceof String) {
					return (String)obj;
				}
			}
			// 로그인 요청
			else if("login".equals(upmu[1])) {
				obj = controller.login(req,res);
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				} else if(obj instanceof String) {
					return (String)obj;
				}
			} 
			// 로그아웃 요청
			else if("logout".equals(upmu[1])) {
				obj = controller.logout(req,res);
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				} else if(obj instanceof String) {
					return (String)obj;
				}
			} 
		} // end of LoginController
		///////////////////////////////////////////
		// 회원가입 분기(RegisterController)
		else if("register".equals(upmu[0])) { 
			controller = new RegisterController();
			// 회원가입 페이지
			if("registerForm".equals(upmu[1])) {
				obj = controller.registerForm(req,res);
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				} else if(obj instanceof String) {
					return (String)obj;
				}
			} 
			// id 중복검사
			else if("registerSelect".equals(upmu[1])) {
				obj = controller.registerSelect(req,res);
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				} else if(obj instanceof String) {
					return (String)obj;
				}
			} 
			// 회원가입 요청
			else if("registerInsert".equals(upmu[1])) {
					obj = controller.registerInsert(req,res);
					if(obj instanceof ModelAndView) {
						return (ModelAndView)obj;
					} else if(obj instanceof String) {
						return (String)obj;
					}
				}
		} // end of RegisterController
		///////////////////////////////////////////
		// 멤버 분기(MemberController)
		else if("member".equals(upmu[0])) {
			controller = new MemberController();
			// 구매내역 조회
			if("memberListPayment".equals(upmu[1])) {
				obj = controller.memberListPayment(req,res);
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				} else if(obj instanceof String) {
					return (String)obj;
				}
			}
			// 좋아요 누른 상품 조회
			else if("memberListLike".equals(upmu[1])) {
				obj = controller.memberListLike(req,res);
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				} else if(obj instanceof String) {
					return (String)obj;
				}
			}
			// 구매후기 조회
			else if("memberListReview".equals(upmu[1])) {
				obj = controller.memberListReview(req,res);
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				} else if(obj instanceof String) {
					return (String)obj;
				}
			}
			// 보유쿠폰 조회
			else if("memberListCoupon".equals(upmu[1])) {
				obj = controller.memberListCoupon(req,res);
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				} else if(obj instanceof String) {
					return (String)obj;
				}
			}
			// 개인정보 조회
			else if("memberListP".equals(upmu[1])) {
				obj = controller.memberListP(req,res);
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				} else if(obj instanceof String) {
					return (String)obj;
				}
			}
			// 쿠폰입력
			else if("memberInsertCoupon".equals(upmu[1])) {
				obj = controller.memberInsertCoupon(req,res);
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				} else if(obj instanceof String) {
					return (String)obj;
				}
			}
			// 배송지 등록
			else if("memberInsertAddress".equals(upmu[1])) {
				obj = controller.memberInsertAddress(req,res);
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				} else if(obj instanceof String) {
					return (String)obj;
				}
			}
			// 개인정보 수정
			else if("memberUpdateP".equals(upmu[1])) {
				obj = controller.memberUpdateP(req,res);
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				} else if(obj instanceof String) {
					return (String)obj;
				}
			}
			// 구매상태 수정(환불, 구매확정, 교환)
			else if("memberUpdateState".equals(upmu[1])) {
				obj = controller.memberUpdateState(req,res);
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				} else if(obj instanceof String) {
					return (String)obj;
				}
			}
			// 회원 탈퇴
			else if("memberDelete".equals(upmu[1])) {
				obj = controller.memberDelete(req,res);
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				} else if(obj instanceof String) {
					return (String)obj;
				}
			}
		} // end of MemberController
		///////////////////////////////////////////
		// 주문 분기(OrderController)
		else if("order".equals(upmu[0])) {
			controller = new OrderController();
			// 주문페이지 이동(회원 및 비회원 구분)
			if("orderList".equals(upmu[1])) {
				obj = controller.orderList(req,res);
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				} else if(obj instanceof String) {
					return (String)obj;
				}
			}
			// 결제 정보 저장
			else if("orderInsert".equals(upmu[1])) {
				obj = controller.orderInsert(req,res);
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				} else if(obj instanceof String) {
					return (String)obj;
				}
			}
			// 쿠폰 사용 내역
			else if("orderUpdateCoupon".equals(upmu[1])) {
				obj = controller.orderUpdateCoupon(req,res);
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				} else if(obj instanceof String) {
					return (String)obj;
				}
			}
			// 적립금 차감
			else if("orderUpdatePoint".equals(upmu[1])) {
				obj = controller.orderUpdatePoint(req,res);
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				} else if(obj instanceof String) {
					return (String)obj;
				}
			}
			// 장바구니에서 주문한 상품 제거
			else if("orderDelete".equals(upmu[1])) {
				obj = controller.orderDelete(req,res);
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				} else if(obj instanceof String) {
					return (String)obj;
				}
			}
		} // end of OrderController
		///////////////////////////////////////////
		// 카트 분기(CartController)
		else if("cart".equals(upmu[0])) {
			controller = new CartController();
			// 장바구니 페이지 조회
			if("cartList".equals(upmu[1])) {
				obj = controller.cartList(req,res);
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				} else if(obj instanceof String) {
					return (String)obj;
				}
			}
			// 장바구니 상품추가
			else if("cartInsert".equals(upmu[1])) {
				obj = controller.cartInsert(req,res);
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				} else if(obj instanceof String) {
					return (String)obj;
				}
			}
			// 장바구니 수정
			else if("cartUpdate".equals(upmu[1])) {
				obj = controller.cartUpdate(req,res);
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				} else if(obj instanceof String) {
					return (String)obj;
				}
			}
			// 장바구니 삭제
			else if("cartDelete".equals(upmu[1])) {
				obj = controller.cartDelete(req,res);
				if(obj instanceof ModelAndView) {
					return (ModelAndView)obj;
				} else if(obj instanceof String) {
					return (String)obj;
				}
			}
		} // end of CartController
		return obj;
	}////////////end of getController
}