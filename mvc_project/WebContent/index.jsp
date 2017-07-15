<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 컨트롤러를 거치도록 리다이렉트 시켜준다.
	String cPath = request.getContextPath();
	response.sendRedirect(cPath + "/home.do");
%>
