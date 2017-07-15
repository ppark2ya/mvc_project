<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../myResource.jsp"></jsp:include>
<title>board/main.jsp</title>
<style>
	.page-header{
		margin-top: 0;
		border-bottom: 0px;
	}
	#headerlogo{
		margin : 50px 0px 0px 0px;
	}
	#myForm .help-block{
		display: none;
	}
	.form-control-feedback{
		display: none;
		padding-right: 15px;
	}
	.center{
		text-align: center;
	}
	#list{
		margin-top: 50px;
	}
	a{
		text-decoration: none !important;
	}
	#writeBtn{
		font-size: 10px;
		padding : 2px;
	}
</style>
</head>
<body>
<div class="container">
	<div class="page-header text-center">
       	<a href="../home.do">
       		<img src="${pageContext.request.contextPath }/views/resource/images/reservation.PNG" id="headerlogo">
       	</a>
    </div>
        <table class="table table-hover" id="list">
            <thead>
                <tr>
                    <th class="center">번호</th>
                    <th class="center">카테고리</th>
                    <th class="center">제목</th>
                    <th class="center">작성자</th>
                    <th class="center">작성일</th>
                </tr>
            </thead>
            <tbody>
            	<c:forEach var="tmp" items="${list}">
            		<tr class="text-center">
            			<td>${tmp.board_num }</td>
            			<td>${tmp.category }</td>
            			<td>
            				<c:if test="${not empty sessionScope.id }">
            					<a href="viewcontent.do?board_num=${tmp.board_num }">${tmp.title }</a>
            				</c:if>
            				<c:if test="${empty sessionScope.id }">
            					<a href="#" onClick="sendMsg(); return false;">${tmp.title }</a>
            				</c:if>
            			</td>
            			<td>${tmp.cust_id }</td>
            			<td>${tmp.regdate }</td>
            		</tr>
            	</c:forEach>
            </tbody>
        </table>
        <div class="col-xs-1 col-xs-offset-11">
        	<c:if test="${not empty sessionScope.id }">
            	<a class="btn" href="writeform.do">
            		<i id="writeBtn" class="glyphicon glyphicon-pencil" style="font-size:15px;">글쓰기</i>
            	</a>
            </c:if>
            <c:if test="${empty sessionScope.id }">
            	<a class="btn" href="#" onClick="sendMsg(); return false;">
            		<i id="writeBtn" class="glyphicon glyphicon-pencil" style="font-size:15px;">글쓰기</i>
            	</a>
            </c:if>
        </div>
</div>
<script>
	var sendMsg = function(){
		alert("로그인 후 이용바랍니다");
		location.href = "${pageContext.request.contextPath }/customer/signinform.do";
	}
	
</script>
</body>
</html>