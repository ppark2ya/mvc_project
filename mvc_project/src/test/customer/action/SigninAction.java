package test.customer.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.customer.dao.CustomerDao;
import test.customer.dto.CustomerDto;

public class SigninAction extends Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String url = request.getParameter("url");
		CustomerDto dto = new CustomerDto();
		dto.setId(id);
		dto.setPwd(pwd);
		
		boolean isValid = CustomerDao.getInstance().isValid(dto);
		String isSave = request.getParameter("isSave");
		if(isSave != null){
			Cookie cookie = new Cookie("savedId", dto.getId());
			cookie.setMaxAge(60);
			response.addCookie(cookie);
		}
		if(isValid){
			request.getSession().setAttribute("id", id);
			if(url == null){
				return new ActionForward("/home.do", true);
			}else{
				System.out.println("ok redirect!");
				return new ActionForward(url, true);
			}
		}else{
			request.setAttribute("url", url);
			return new ActionForward("/views/customer/signin_error.jsp");
		}
	}
}
