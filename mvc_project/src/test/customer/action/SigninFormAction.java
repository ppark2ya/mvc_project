package test.customer.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;

public class SigninFormAction extends Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String savedId = "";
		Cookie[] cookie = request.getCookies();
		if(cookie != null && cookie.length > 0){
			for(Cookie tmp : cookie){
				if(tmp.getName().equals("savedId")){
					savedId = tmp.getValue();
				}
			}
		}
		request.setAttribute("savedId", savedId);
		return new ActionForward("/views/customer/signin_form.jsp");
	}
}
