<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p style="color:red;">
<%
if(request.getAttribute("errors")!=null) {
	List <String> errors = (List)request.getAttribute("errors");// getAttribute 요소의 속성값 가져오는것
	for(int i=0; i<errors.size(); i++){
%>
	<%=errors.get(i) %> <br />
<%		
	}
}
%>
</p>
<h2>join</h2>
<form action="joinproc.jsp">
	<label for="id">아이디</label>
		<input type="text" name="id" />
		<input type="button" value="중복확인" />
		<br />
		
		<label for="pwd">비밀번호</label>
		<input type="text" name="pwd" />
		<br />
		
		<label for="pwd2">비밀번호 확인</label>
		<input type="text" name="pwd2" />
		<br />
		
		<label for="name">이름</label>
		<input type="text" name="name" />
		<br />
		
		<label for="gender">성별</label>
		<select name="gender">
			<option value="남성">남성</option>
			<option value="여성">여성</option>
		</select>
		<br />
		
		<label for="year">생년월일</label>
		<input type="text" name="year" size="5"/>년
		<input type="text" name="month" size="5"/>월
		<input type="text" name="day" size="5"/>일
		
		<input type="radio" name="IsLunar" value="Solar" checked />양력
		<input type="radio" name="IsLunar" value="IsLunar" />음력 <br />
		
		<label for="name">핸드폰번호</label>
		<input type="tel" name="cphone" /> 예) 010-1111-1111 <br />
		
		<label for="email">이메일</label>
		<input type="email" name="email" /> <br />
		
		<label for="hobby">취미</label>
		<input type="checkbox" name="hobby" value="music" /> 음악 
		<input type="checkbox" name="hobby" value="movie" /> 영화 
		<input type="checkbox" name="hobby" value="trip" /> 여행 <br />
		
		<input type="submit" value="확인" />
		
</form>
</body>
</html>