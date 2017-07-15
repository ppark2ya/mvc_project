package test.customer.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.customer.dto.CustomerDto;
import test.mybatis.SqlMapConfig;

public class CustomerDao {
	private static CustomerDao dao;
	private static SqlSessionFactory factory;
	private CustomerDao(){}
	public static CustomerDao getInstance(){
		if(dao == null){
			dao = new CustomerDao();
			factory = SqlMapConfig.getSqlSession();
		}
		return dao;
	}
	
	// 고객 한 명의 정보를 리턴
	public CustomerDto getData(String id){
		SqlSession session = factory.openSession();
		CustomerDto dto = session.selectOne("customer.getData", id);
		session.close();
		return dto;
	}
	
	// 로그인 하는 아이디 패스워드가 유효한지 판단하는 메소드
	public boolean isValid(CustomerDto dto){
		SqlSession session = factory.openSession();
		CustomerDto dto2 = session.selectOne("customer.isValid", dto);
		session.close();
		if(dto2 == null){
			return false;
		}else{
			return true;
		}
	}
	
	// 회원정보를 추가하는 메소드
	public void insert(CustomerDto dto){
		SqlSession session = factory.openSession(true);
		session.insert("customer.insert", dto);
		session.close();
	}
	
	// 회원정보 삭제하는 메소드
	public void delete(String id){
		SqlSession session = factory.openSession(true);
		session.insert("customer.delete", id);
		session.close();
	}
	
	// 회원정보 수정하는 메소드
	public void update(CustomerDto dto){
		SqlSession session = factory.openSession(true);
		session.update("customer.update", dto);
		session.close();
	}
	
	// 비밀번호 변경하는 메소드
	public void modifyPwd(CustomerDto dto){
		SqlSession session = factory.openSession(true);
		session.update("customer.modifyPwd", dto);
		session.close();
	}
}
