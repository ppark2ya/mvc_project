package test.customer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.customer.dao.CustomerDao;
import test.customer.dto.CustomerDto;

public class ResetPasswordAction extends Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		CustomerDto dto = new CustomerDto();
		dto.setId(id);
		dto.setPwd(pwd);
		CustomerDao.getInstance().modifyPwd(dto);
		return new ActionForward("/customer/signinform.do", true);
	}
}
