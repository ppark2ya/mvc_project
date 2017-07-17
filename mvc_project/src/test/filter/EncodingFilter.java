package test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 *  요청을 중간에 가로채서 인코딩 설정을 해줄 Filter 정의하기 
 *  
 *  1. Filter 인터 페이스를 구현해서 클래스를 정의한다.
 *  2. web.xml 혹은 어노테이션을 이용해서 Filter 를 맵핑한다.
 */

public class EncodingFilter implements Filter{
	//인코딩 value 를 담을 맴버필드 정의하기
	private String myEncoding;

	@Override
	public void destroy() {
		
	}
	//필터가 동작 될때 호출되는 메소드 
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("doFilter()");
		
		//1. 요청을 가로 채서 해야할 작업 작성
		if(req.getCharacterEncoding()==null){
			//인코딩 설정하기
			req.setCharacterEncoding(myEncoding);
		}
		//2. 다음 작업 수행하기 
		chain.doFilter(req, res);
	}
	//필터가 최초 동작될때 호출되는 메소드 
	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("init()");
		/*  아래와 같은 web.xml 문서의 내용중에서 utf-8 문자열
		 *  읽어내기 
		 * 	<init-param>
				<param-name>myEncoding</param-name>
				<param-value>utf-8</param-value>
			</init-param>
		 */
		//읽어온 문자열을 맴버필드에 저장한다. 
		myEncoding=config.getInitParameter("myEncoding");
	}
}













