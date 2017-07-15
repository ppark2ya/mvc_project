package test.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.board.dao.BoardDao;
import test.controller.Action;
import test.controller.ActionForward;

public class DropoutAction extends Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		BoardDao.getInstance().delete(board_num);
		return new ActionForward("/board/boardmain.do", true);
	}
}
