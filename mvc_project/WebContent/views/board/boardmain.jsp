<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String cPath=request.getContextPath(); %>
<% 
	String id = (String)session.getAttribute("id");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
/* 		border : 1px solid #cecece; */
		padding : 2px;
	}
</style>
</head>
<body>
<div class="container">
	<div class="page-header text-center">
       	<a href="<%=cPath%>/index.jsp">
       		<img src="<%=cPath %>/resource/images/reservation.PNG" id="headerlogo">
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
            	<%for(BoardDto tmp:list){%>
            		<tr class="text-center">
            			<td><%=tmp.getNum() %></td>
            			<td><%=tmp.getCategory() %></td>
            			<td>
            				<a <%if(id!=null){%>href="view.jsp?num=<%=tmp.getNum()%>"<%}else{%>href="#" onClick="sendMsg(); return false;"<%} %>><%=tmp.getTitle() %></a>
            			</td>
            			<td><%=tmp.getWriter() %></td>
            			<td><%=tmp.getRegdate() %></td>
            		</tr>
				<%} %>            	
            </tbody>
        </table>
        <div class="col-xs-1 col-xs-offset-11">
        	<a class="btn" <%if(id != null){ %>href="write_form.jsp"<%}else{ %>href="#" onClick="sendMsg(); return false;"<%} %>>
        		<i id="writeBtn" class="glyphicon glyphicon-pencil" style="font-size:15px;">글쓰기</i>
        	</a>
        </div>
</div>
<script>
	var sendMsg = function(){
		alert("로그인 후 이용바랍니다");
		location.href = "../members/signin_form.jsp";
	}
	
</script>
</body>
</html>