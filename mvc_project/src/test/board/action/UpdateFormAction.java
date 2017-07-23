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
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		BoardDto dto = new BoardDto();
		dto.setBoard_num(board_num);
		dto.setWriter(writer);
		dto.setTitle(title);
		dto.setContent(content);
		BoardDto resultDto = BoardDao.getInstance().getData(dto);
		request.setAttribute("dto", resultDto);
		return new ActionForward("/views/board/members/update_form.jsp");
	}
}
