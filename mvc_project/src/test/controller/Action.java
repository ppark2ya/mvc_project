package test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Action {
	// 추상 메소드
	public abstract ActionForward execute
		(HttpServletRequest request, HttpServletResponse response);
}
