//package com.example.tradingplatform.filter;
//
//import com.example.tradingplatform.constant.GlobalConstant;
//import com.example.tradingplatform.pojo.User;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//
//public class UserFilter implements Filter {
//
//    public static User currentUser;
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
//        HttpSession session = httpServletRequest.getSession();
//        //尝试获取当前登陆用户
//        currentUser = (User) session.getAttribute(GlobalConstant.ONE);
//        //如果获取失败，证明当前用户没有登陆，返回用户未登陆的信息
//        if(currentUser == null){
//            PrintWriter out = new HttpServletResponseWrapper((HttpServletResponse) servletResponse).getWriter();
//            out.write("{\n"+
//                    "    \"msg\": \"没有用户登陆\",\n" +
//                    "    \"data\": null\n" +
//                    "}"
//            );
//
//            out.flush();
//            out.close();
//            return;
//        }
//        //如果有用户登陆就可以放行
//        filterChain.doFilter(servletRequest, servletResponse);
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
//}
