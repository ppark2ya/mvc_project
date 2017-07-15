package test.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.board.dto.BoardDto;
import test.mybatis.SqlMapConfig;

public class BoardDao {
	private static BoardDao dao;
	private static SqlSessionFactory factory;
	private BoardDao(){}
	
	public static BoardDao getInstance(){
		if(dao == null){
			dao = new BoardDao();
			factory = SqlMapConfig.getSqlSession();
		}
		return dao;
	}

	// 게시판 글들을 리턴하는 메소드
	public List<BoardDto> getList(){
		SqlSession session = factory.openSession();
		List<BoardDto> list = session.selectList("board.getList");
		session.close();
		return list;
	}
	
	// 글의 정보를 리턴하는 메소드
	public BoardDto getData(int board_num){
		SqlSession session = factory.openSession();
		BoardDto dto = session.selectOne("board.getData", board_num);
		session.close();
		return dto;
	}
	
	// 글추가 메소드
	public void insert(BoardDto dto){
		SqlSession session = factory.openSession(true);
		session.insert("board.insert", dto);
		session.close();
	}
	
	// 글 수정 메소드
	public void update(BoardDto dto){
		SqlSession session = factory.openSession(true);
		session.update("board.update", dto);
		session.close();
	}
	
	// 글 삭제 메소드
	public void delete(int board_num){
		SqlSession session = factory.openSession(true);
		session.delete("board.delete", board_num);
		session.close();
	}
}
