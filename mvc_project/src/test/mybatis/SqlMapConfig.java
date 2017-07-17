package test.mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {
	// static 멤버 필드로 SqlSessionFactory type 선언
	private static SqlSessionFactory sqlSession;
	// static 초기화
	static{
		// MyBatis 설정 xml 문서의 위치
		String resource = "test/mybatis/Configuration.xml";
		try{
			Reader reader = Resources.getResourceAsReader(resource);
			//SqlSessionFactory 객체의 참조값을 얻어내서 멤버필드에 저장
			sqlSession = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			System.out.println("SqlSessionFactory 객체 생성 성공!");
		}catch(Exception e){
			System.out.println("SqlSessionFactory 객체 생성 실패!");
		}
	}
	// static 멤버 메소드
	public static SqlSessionFactory getSqlSession(){
		return sqlSession;
	}
}
