package customer.controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.controller.Controller;
import customer.dao.NoticeDao;
import customer.vo.Notice;

public class NoticeDetailController implements Controller{
	
	// 아래 주석 처리한걸 인터페이스해서 오버라이드 받기
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			System.out.println("NoticeDetailController");
		  
			// 3단계, 모델을 사용하여 요청한 기능을 수행한다. // 사용자에 요청에 따라 알맞은 코드 
			String seq = request.getParameter("c"); 
			String hit = request.getParameter("h"); 
			NoticeDao dao = new NoticeDao(); 
			Notice n = dao.getNotice(seq,hit);
		  
			// 4단계, request나 session에 처리 결과를 저장 
			request.setAttribute("n", n);//request에 n이라는 이름으로 n을 보내겠다
			// 5단계. RequestDispatcher를 사용하여 알맞은 뷰로 포워딩 n값을 noticeDetail.jsp로 보내기 위해 forward처리 
			request.getRequestDispatcher("/WEB-INF/view/customer/noticeDetail.jsp").forward(request,response);
			
			System.out.println("hit : "+hit);
		 }	
	}
	// 1단계, HTTP 요청 받음
	/*
	 * public void execute(HttpServletRequest request, HttpServletResponse response)
	 * throws Exception { // 2단계, 요청 분석 // request 객체로부터 사용자의 요청을 분석하는 코드
	 * System.out.println("NoticeDetailController");
	 * 
	 * // 3단계, 모델을 사용하여 요청한 기능을 수행한다. // 사용자에 요청에 따라 알맞은 코드 String seq =
	 * request.getParameter("c"); NoticeDao dao = new NoticeDao(); Notice n =
	 * dao.getNotice(seq);
	 * 
	 * // 4단계, request나 session에 처리 결과를 저장 request.setAttribute("n", n);//request에
	 * n이라는 이름으로 n을 보내겠다
	 * 
	 * // 5단계. RequestDispatcher를 사용하여 알맞은 뷰로 포워딩 n값을 noticeDetail.jsp로 보내기 위해
	 * forward처리 request.getRequestDispatcher("noticeDetail.jsp").forward(request,
	 * response); }
	 */

