package controller;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import po.Manager;

public class LoginInterceptor implements HandlerInterceptor {
	private static final Pattern resPathRegex = Pattern
			.compile(".+(\\.js|\\.jpg|\\.css|\\.ico)$|.+login.*$|.+isLoginValid.*$");

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 登录页及验证连接放行
		String url = request.getRequestURL().toString();
		if (resPathRegex.matcher(url).matches()) {
			return true;
		}
		// session存在Manager则放行
		Manager manager = (Manager) request.getSession().getAttribute("Manager");
		if (manager != null && manager.getMaintainMajor().getId() > 0) {
			return true;
		}
		// 否则转发到登录页，因为在页面在web-inf里所以重定向会404
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		return false;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView view)
			throws Exception {
	}

}
