package test.customer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.customer.dao.CustomerDao;
import test.customer.dto.CustomerDto;

public class UpdateFormAction extends Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String id = (String)request.getSession().getAttribute("id");
		CustomerDto dto = CustomerDao.getInstance().getData(id);
		request.setAttribute("dto", dto);
		return new ActionForward("/views/customer/private/update_form.jsp");
	}
}
