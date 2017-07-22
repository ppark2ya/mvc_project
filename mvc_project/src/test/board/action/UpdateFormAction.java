package test.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.board.dao.BoardDao;
import test.board.dto.BoardDto;
import test.controller.Action;
import test.controller.ActionForward;

public class UpdateFormAction extends Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int board_num = Integer.parseInt(request.getParameter("board_num"));
//		BoardDto dto = BoardDao.getInstance().getData(board_num);
//		request.setAttribute("dto", dto);
		return new ActionForward("/views/board/members/update_form.jsp");
	}
}
