<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="myResource.jsp"></jsp:include>
<link rel="stylesheet" href="${pageContext.request.contextPath }/views/resource/css/header.css?ver=1" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/views/resource/css/main.css?ver=1" />
<title></title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="main.jsp"></jsp:include>
<script src="${pageContext.request.contextPath }/views/resource/js/time.js"></script>
</body>
</html>