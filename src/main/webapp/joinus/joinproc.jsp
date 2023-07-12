<%@page import="java.sql.*"%>
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
<h2>joinproc</h2>
<!-- 회원가입처리 -->
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String pwd2 = request.getParameter("pwd2");
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	
	String year = request.getParameter("year");
	String month = request.getParameter("month");
	String day = request.getParameter("day");
	String birth = String.format("%s-%s-%s", year,month,day); // year,month,day를 결합시킨다.
	
	String IsLunar = request.getParameter("IsLunar");
	String cphone = request.getParameter("cphone");
	String email = request.getParameter("email");
	
	String[] hobbys = request.getParameterValues("hobby"); // hobby는 여러개를 선택할 수 있기때문에 배열로 받고 getParameterValues로 받는다.
	String hobby = "";
		
	if(hobbys!=null){// checkbox가 아무것도 선택되지 않을때 null값이 나오는데 null이 아닐때 실행하는 코드를 만든다.
		for(int i=0; i<hobbys.length; i++) {
			hobby+=hobbys[i];
			if(hobbys.length>i+1)
				hobby+=",";
		}
	}
	
	// 에러 메시지 전송 join.jsp로
	/* 아이디없음, 비번불일치 */
	List<String> errors = new ArrayList();
	if(id==null || id.equals("")) {
		errors.add("아이디없음");
	} else if (!pwd.equals(pwd2)) {
		errors.add("비밀번호가 다릅니다.");
	}
	
	/* 에러가 1개라도 있으면 조건으로 분기 */
	if(errors.size()>0) {
		//request에 에러 보관
		request.setAttribute("errors", errors);// errors라는 이름으로 request에 errors의 ArrayList 정보를 저장한다.
		//response.sendRedirect("join.jsp");
		//정보를 담아서 join.jsp로 전송
		request.getRequestDispatcher("join.jsp").forward(request, response);// request에 담긴 정보로 response한다.
	} else {
		String sql = "insert into member values(?,?,?,?,?,?,?,?,?,sysdate)";
		//DB 연결
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="hr";
		String pw="123456";
		Connection con=DriverManager.getConnection(url,user,pw);
		//실행
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		pstmt.setString(3, name);
		pstmt.setString(4, gender);
		pstmt.setString(5, birth);
		pstmt.setString(6, IsLunar);
		pstmt.setString(7, cphone);
		pstmt.setString(8, email);
		pstmt.setString(9, hobby);
		//insert
		pstmt.executeUpdate();
		response.sendRedirect("../index.jsp");
	}
%>

</body>
</html> 