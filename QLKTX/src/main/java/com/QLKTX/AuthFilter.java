//package com.QLKTX;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//public class AuthFilter implements Filter {
//
//	@Override
//	public void init(FilterConfig filterConfig) throws ServletException {
//		// TODO Auto-generated method stub
//		Filter.super.init(filterConfig);
//	}
//
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		// TODO Auto-generated method stub
//		 HttpServletRequest httpRequest = (HttpServletRequest) request;
//	        HttpServletResponse httpResponse = (HttpServletResponse) response;
//
//	       
//	        String requestUri = httpRequest.getRequestURI();
//
//	        // Kiểm tra nếu đây không phải là yêu cầu tới tài nguyên tĩnh
//	        if (!requestUri.startsWith("/css/") && !requestUri.startsWith("/js/")) {
//	            // Tiếp tục với filter
//	            chain.doFilter(request, response);
//	        } else {
//	            // Cho phép yêu cầu tới tài nguyên tĩnh
//	            chain.doFilter(request, response);
//	        }
//
//	          
//	        if (requestUri.equals("/logout")) {
//	            // Chuyển tiếp yêu cầu logout mà không cần xác thực
//	            chain.doFilter(request, response);
//	            return;
//	        }
//
//	        // Kiểm tra xác thực cho các yêu cầu khác
//	        boolean isAuthenticated = checkAuthentication(httpRequest);
//	        if (!isAuthenticated) {
//	            // Nếu phản hồi chưa được gửi, tạo session và chuyển hướng đến trang login
//	            if (!httpResponse.isCommitted()) {
//	                // Tạo session nếu cần
//	                httpRequest.getSession(true); // Tạo session mới
//	                httpResponse.sendRedirect("/login"); // Chuyển hướng đến trang login
//	            }
//	            return;
//	        }
//
//	        // Tiếp tục với filter chain nếu đã xác thực
//	        chain.doFilter(request, response);
//	}
//	private boolean checkAuthentication(HttpServletRequest request) {
//        // Logic kiểm tra xác thực (ví dụ: kiểm tra session, token, vv...)
//        // Trả về true nếu đã xác thực, false nếu không
//        return request.getSession().getAttribute("loggedInUser") != null; // Ví dụ đơn giản
//    }
//	@Override
//	public void destroy() {
//		// TODO Auto-generated method stub
//		Filter.super.destroy();
//	}
//
//	
//}
