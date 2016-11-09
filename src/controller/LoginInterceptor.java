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
		// ��¼ҳ����֤���ӷ���
		String url = request.getRequestURL().toString();
		if (resPathRegex.matcher(url).matches()) {
			return true;
		}
		// session����Manager�����
		Manager manager = (Manager) request.getSession().getAttribute("Manager");
		if (manager != null && manager.getMaintainMajor().getId() > 0) {
			return true;
		}
		// ����ת������¼ҳ����Ϊ��ҳ����web-inf�������ض����404
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
