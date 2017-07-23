package test.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.board.dto.BoardCommentDto;
import test.mybatis.SqlMapConfig;

public class BoardCommentDao {
	private static BoardCommentDao dao;
	private static SqlSessionFactory factory;
	private BoardCommentDao(){}
	
	public static BoardCommentDao getInstance(){
		if(dao == null){
			dao = new BoardCommentDao();
			factory = SqlMapConfig.getSqlSession();
		}
		return dao;
	}
	//새 덧글을 저장하는 메소드
	public void insert(BoardCommentDto dto){
		SqlSession session=factory.openSession(true);
		try{
			session.insert("boardComment.insert", dto);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	//덧글 목록을 리턴하는 메소드
	public List<BoardCommentDto> getList(int ref_group){
		SqlSession session=factory.openSession();
		List<BoardCommentDto> list=null;
		try{
			list=session.selectList("boardComment.getList", ref_group);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
	//새 덧글의 글번호(sequence) 값을 얻어내서 리턴해주는 메소드
	public int getSequence(){
		SqlSession session=factory.openSession();
		int num=0;
		try{
			num=session.selectOne("boardComment.getSequence");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return num;
	}
}
