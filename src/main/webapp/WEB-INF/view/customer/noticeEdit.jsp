<%@page import="customer.vo.Notice"%>
<%@page import="customer.dao.NoticeDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/nstyle.css" />
</head>
<body>
<h2>noticeEdit</h2>

<form action="noticeEditProc.do" method="post">
<table class="twidth">
	<colgroup>
		<col width="15%" />
		<col width="35%" />
		<col width="15%" />
		<col width="35%" />
	</colgroup>
	<caption>Edit</caption>
		<tbody>
			<tr>
				<th class="left">글번호</th>
				<td>${n.seq}</td>
				<th class="left">조회수</th>
				<td>${n.hit}</td>
			</tr>
			<tr>
				<th class="left">작성자</th>
				<td>${n.writer}</td>
				<th class="left">작성시간</th>
				<td>${n.regdate}</td>
			</tr>
			<tr>
				<th class="left">제목</th>
				<td colspan="3">
				<input type="text" class="inp" name="title" value="${n.title}" />
				</td>
			</tr>
			<tr>
				<th class="left">내용</th>
				<td colspan="3" id="content">
				<textarea name="content" class="txt" >${n.content}</textarea>
				</td>
			</tr>
			<tr>
				<th class="left">첨부</th>
				<td colspan="3">첨부</td>
			</tr>
		</tbody>
</table>
<input type="hidden" name="c" value="${n.seq}" /> <!-- 아래 버튼으로 값을 전달할 수가 없어서 value와 name을 활용하여 보낸다. 화면에 안 보이게 type을 hidden으로  -->
<input type="submit" value="수정하기" />
<a href="noticeDetail.do?c=${n.seq}&h=${n.hit}">취소</a>
</form>
</body>
</html>