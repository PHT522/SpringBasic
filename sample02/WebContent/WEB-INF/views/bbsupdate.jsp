
<%@page import="kh.com.a.model.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bbsupdate.jsp</title>
<style type="text/css">
.center{
	margin: auto;
	width: 60%;
	border: 3px solid #8ac007;
	padding: 10px;
}
</style>
</head>
<body>


<%
int seq = Integer.parseInt(request.getParameter("seq"));
Object ologin = session.getAttribute("login");	// login.jsp에서 setAttribute설정
MemberDto user = null;
if(ologin == null){	// 시간이 지나 session 로그아웃이 되었을떄
%>
	<script type="text/javascript">
	alert("로그인해 주십시오");
	location.href = "index.jsp";
	</script>
<%	
	return;
}
user = (MemberDto)ologin;	
%>


<h3>수정하기</h3>
<div>
<form action="bbsupdateAf.do" method="get">
<input type="hidden" name="seq" value="<%=seq%>">
<table border="2">
<col width="200"><col width="500">
	<tr>
		<td>아이디</td>
		<td>
			<%=user.getId() %>				
		</td>
	</tr>
	<tr>
		<td>제목</td>
		<td>
			<input type="text" name="title" size="50">
		</td>
	</tr>
	<tr>
		<td>내용</td>
		<td>
			<textarea rows="10" cols="50" name="content"></textarea>
		</td>		
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="수정하기">
		</td>
	</tr>

</table>
</form>
</div>






</body>
</html>