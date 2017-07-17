package test.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.board.dao.BoardDao;
import test.board.dto.BoardDto;
import test.controller.Action;
import test.controller.ActionForward;

public class ViewContentAction extends Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		BoardDto dto = BoardDao.getInstance().getData(board_num);
		boolean isMine = false;
		String loginId = (String)request.getSession().getAttribute("id");
		String author = dto.getCust_id();
		
		if(loginId.equals(author)){
			isMine = true;
		}
		
		request.setAttribute("dto", dto);
		request.setAttribute("isMine", isMine);
		return new ActionForward("/views/board/viewcontent.jsp");
	}
}
