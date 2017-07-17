package test.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.board.dao.BoardDao;
import test.board.dto.BoardDto;
import test.controller.Action;
import test.controller.ActionForward;

public class UpdateAction extends Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String title = request.getParameter("title");
		String category = request.getParameter("category");
		String content = request.getParameter("content");
		BoardDto dto = new BoardDto();
		dto.setBoard_num(board_num);
		dto.setTitle(title);
		dto.setCategory(category);
		dto.setContent(content);
		BoardDao.getInstance().update(dto);
		return new ActionForward("/board/viewcontent.do?board_num="+board_num, true);
	}
}
