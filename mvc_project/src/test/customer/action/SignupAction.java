package test.customer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.customer.dao.CustomerDao;
import test.customer.dto.CustomerDto;

public class SignupAction extends Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		CustomerDto dto = new CustomerDto();
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setName(name);
		dto.setPhone(phone);
		dto.setEmail(email);
		CustomerDao.getInstance().insert(dto);
		return new ActionForward("/home.do", true);
	}
}
