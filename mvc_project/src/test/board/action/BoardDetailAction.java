package test.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.board.dao.BoardDao;
import test.board.dto.BoardDto;
import test.controller.Action;
import test.controller.ActionForward;

public class BoardDetailAction extends Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 1. 파라미터로 전달되는 글 번호를 읽어온다.
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		// 검색과 관련된 파라미터를 읽어와본다.
		String keyword = request.getParameter("keyword");
		String condition = request.getParameter("condition");
		//BoardDto 객체를 생성해서
		BoardDto dto=new BoardDto();
		if(keyword != null){ //검색어가 전달된 경우
			if(condition.equals("titlecontent")){ //제목+내용 검색
				dto.setTitle(keyword);
				dto.setContent(keyword);
			}else if(condition.equals("title")){//제목 검색
				dto.setTitle(keyword);
			}else if(condition.equals("writer")){//작성자 검색
				dto.setWriter(keyword);
			}
			// list.jsp 뷰페이지에서 필요한 내용을 request 에 담는다.
			request.setAttribute("condition", condition);
			request.setAttribute("keyword", keyword);
		}
		//글번호도 dto 에 담는다.
		dto.setBoard_num(board_num);
		// 2. Dao 를 이용해서 글 정보를 얻어온다.
		BoardDto resultdto = BoardDao.getInstance().getData(dto);
		// 3. request 에 글 정보를 담고
		request.setAttribute("dto", resultdto);
		// 4. 뷰페이지로 forward 이동
		return new ActionForward("/views/board/detail.jsp");
	}
}
