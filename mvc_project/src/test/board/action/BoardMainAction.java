package test.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import test.board.dao.BoardDao;
import test.board.dto.BoardDto;
import test.controller.Action;
import test.controller.ActionForward;

public class BoardMainAction extends Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		List<BoardDto> list = BoardDao.getInstance().getList();
		request.setAttribute("list", list);
		return new ActionForward("/views/board/boardmain.jsp");
	}
}
