package test.customer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.customer.dao.CustomerDao;

public class CheckidAction extends Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("inputId");
		boolean canUse = CustomerDao.getInstance().canUseId(id);
		System.out.println(canUse);
		request.setAttribute("canUse", canUse);
		return new ActionForward("/views/customer/checkid.jsp");
	}
}
