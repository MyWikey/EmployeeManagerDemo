package cn.qdgr.employee.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ResourceFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("销毁");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		HttpSession session = request.getSession();
		System.out.println(request.getRequestURI());
		
		//如果是index.jsp的话，不用过滤，直接放行
		if(request.getRequestURI().indexOf("index.jsp") != -1){
			arg2.doFilter(arg0, arg1);
			return;
		}
		
		//防止未登录访问资源
		if(session.getAttribute("existEmployee") != null){
			arg2.doFilter(arg0, arg1);
		}else{
			response.sendRedirect("index.jsp");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("初始化");
	}

}
