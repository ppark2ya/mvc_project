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
	public List<BoardDto> getList(BoardDto dto){
		SqlSession session = factory.openSession();
		List<BoardDto> list = session.selectList("board.getList", dto);
		session.close();
		return list;
	}
	
	// 글의 정보를 리턴하는 메소드
	public BoardDto getData(BoardDto dto){
		SqlSession session = factory.openSession();
		BoardDto resultDto = session.selectOne("board.getData", dto);
		session.close();
		return resultDto;
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
	
	// DB 에 저장된 게시글 전체의 갯수를 리턴해주는 메소드
	public int getCount(){
		SqlSession session = factory.openSession();
		int count = session.selectOne("board.getCount");
		session.close();
		return count;
	}
	
	//조회수를 1 증가 시키는 메소드
	public void increaseViewCount(int board_num){
		//auto commit 되는 SqlSession 객체의 참조값 얻어오기 
		SqlSession session = factory.openSession(true);
		try{
			session.update("board.increaseViewCount", board_num);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
}
