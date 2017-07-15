package test.customer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.customer.dao.CustomerDao;
import test.customer.dto.CustomerDto;

public class UpdateAction extends Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String id = (String)request.getSession().getAttribute("id");
		String pwd = request.getParameter("pwd");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		CustomerDto dto = new CustomerDto();
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setPhone(phone);
		dto.setEmail(email);
		CustomerDao.getInstance().update(dto);
		return new ActionForward("/customer/myPage.do", true);
	}
}
