<%@page import="customer.vo.Notice"%>
<%@page import="customer.dao.NoticeDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/nstyle.css" />
</head>
<body>
	<h2>noticeDetail</h2>

	<table class="twidth">
		<colgroup>
			<col width="15%" />
			<col width="35%" />
			<col width="15%" />
			<col width="35%" />
		</colgroup>
		<caption>Detail</caption>
		<tbody>
			<tr>
				<th class="left">글번호</th>
				<%-- <td><%=n.getSeq() %></td> --%>
				<!-- EL 태그로 불러오기 -->
				<!-- EL태그를 사용하기위해선 https://tomcat.apache.org/download-taglibs.cgi 의 el태그를 다운받아서 lib폴더에 넣어야 작동한다. -->
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
				<td colspan="3">${n.title}</td>
			</tr>
			<tr>
				<th class="left">내용</th>
				<td colspan="3" id="content">${n.content}</td>
			</tr>
			<tr>
				<th class="left">첨부</th>
				<td colspan="3" id="addfile"><a
					href="download.do?p=customer/upload/&f=${n.filesrc }">${n.filesrc }</a>
				</td>
			</tr>
		</tbody>
	</table>
	<a href="noticeEdit.do?c=${n.seq}&h=${n.hit}">수정하기</a>
	<a href="noticeDelProc.do?c=${n.seq}&h=${n.hit}">삭제</a>
	<a href="notice.do">목록</a>
	<hr />
	
	<c:if test="${n.filesrc ne null }">
		<!-- ne = not equals -->
		<img src="upload/${n.filesrc }" width=300 height=200 alt="" />
	</c:if>
	<hr />
	<c:set value="${n.filesrc }" var="filename" />
	<c:set var="fileNm" value="${fn:toLowerCase(filename) }" />
	<c:forTokens var="token" items="${fileNm }" delims="."
		varStatus="status">
		<c:if test="${status.last }">
			<c:choose>
				<c:when test="${token eq 'jpg'}">
			${filename } :: 그림파일 jpg <br />	
			${status.last }
				</c:when>
				<c:when test="${token eq 'png'}">
			${filename } :: 그림파일 png <br />	
			${status.last }
				</c:when>
				<c:otherwise>
			다른파일
				</c:otherwise>
			</c:choose>
		</c:if>
	</c:forTokens>

</body>
</html>