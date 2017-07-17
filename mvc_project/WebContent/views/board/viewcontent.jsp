<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/board/view.jsp</title>
<jsp:include page="../myResource.jsp"></jsp:include>
<style>
	.page-header{
		margin-top: 0;
	}
	#headerlogo{
		margin : 50px 0px 50px 0px;
	}
	#myForm .help-block{
		display: none;
	}
	#myForm{
		height:500px;
	}
	.form-control-feedback{
		display: none;
		padding-right: 15px;
	}
	.col-md-12{
		padding: 0;
	}
	.box{
		border: 1px solid #808080;
	}
	span{
		display: inline-block;
		border-right: 1px solid #cecece;
	}
	hr{
		margin-top: 0;
	}
	.boardBtn{
		margin-top: 20px;
	}
</style>
</head>
<body>
<article class="container">
	<div class="col-md-12">
		<div class="text-center">
			<a href="${pageContext.request.contextPath }/home.do">
				<img src="${pageContext.request.contextPath }/views/resource/images/reservation.PNG" id="headerlogo">
			</a>
		</div>
		<a href="boardmain.do">
			<div class="col-xs-offset-11">
				목록<i class="fa fa-list" aria-hidden="true"></i>
			</div>
		</a>
	<form action="articleView" method="post" id="myForm" class="box form-horizontal">
		<div class="form-group" style="margin-bottom:0;">
			<div class="padd col-md-12 text-center">
				<span class="col-xs-4">${dto.title }</span>
				<span class="col-xs-2">${dto.category }</span>
				<span class="col-xs-3">${dto.cust_id }</span>
				<span class="col-xs-3" style="border-right:0px;">${dto.regdate }</span>
			</div>
		</div>
		<hr align="center"/>
		<div class="form-group">
			<div style="padding-left:20px;">${dto.content }</div>
		</div>	
	</form> 
		<div class="boardBtn">
	    	<div class="col-sm-12 text-center">
	    		<c:choose>
	    			<c:when test="${not isMine }">
			        	<a class="btn btn-info"  disabled="disabled">Modify</a>
			          	<a class="btn btn-danger" disabled="disabled">Delete</a>
	    			</c:when>
	    			<c:otherwise>
			        	<a class="btn btn-info" href="updateform.do?board_num=${dto.board_num }">Modify</a>
			          	<a class="btn btn-danger" href="#" onclick="dropOut(); return;">Delete</a>
	    			</c:otherwise>
	    		</c:choose>
	    		
	        </div>
		</div>
	</div>
</article>
<script>
	var dropOut = function(){
		var isDelete = confirm("삭제하시겠습니까?");
		if(isDelete){
			location.href = "delete.do?board_num=${dto.board_num}";
		}
	}
</script>
</body>
</html>