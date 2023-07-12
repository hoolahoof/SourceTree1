package customer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.controller.member.LoginController;
import customer.controller.member.LoginProcController;
import customer.controller.member.LogoutProcController;
import customer.controller.notice.DownloadController;
import customer.controller.notice.NoticeController;
import customer.controller.notice.NoticeDelProcController;
import customer.controller.notice.NoticeDetailController;
import customer.controller.notice.NoticeEditController;
import customer.controller.notice.NoticeEditProcController;
import customer.controller.notice.NoticeRegController;
import customer.controller.notice.NoticeRegProcController;

public class MyDispatcher extends HttpServlet {// java단에서 jsp를 받으려면 httpservlet을 사용해야한다.
	// 1단계, HTTP 요청 받음
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("http신호");
		String uri = request.getRequestURI();
		System.out.println("uri : " + uri);
		String conPath = request.getContextPath();
		System.out.println("ContextPath : " + conPath);
		String com = uri.substring(conPath.length());
		System.out.println("com : " + com);

		// NoticeDetailController controller1 = new NoticeDetailController();
		// NoticeEditController controller2 = new NoticeEditController();
		Controller controller = null;

		try {// 신호에 따라 생성되는 객체가 달라진다.
			if (com.equals("/customer/noticeDetail.do")) {
				controller = new NoticeDetailController(); // 객체생성
			} else if (com.equals("/customer/noticeEdit.do")) {
				controller = new NoticeEditController(); // 객체생성
			} else if (com.equals("/customer/noticeEditProc.do")) {
				controller = new NoticeEditProcController(); // 객체생성
			} else if (com.equals("/customer/noticeReg.do")) {
				controller = new NoticeRegController(); // 객체생성
			} else if (com.equals("/customer/noticeRegProc.do")) {
				controller = new NoticeRegProcController(); // 객체생성
			} else if (com.equals("/customer/noticeDelProc.do")) {
				controller = new NoticeDelProcController(); // 객체생성
			} else if (com.equals("/customer/notice.do")) {
				controller = new NoticeController(); // 객체생성
			} else if (com.equals("/login/loginForm.do")) {
				controller = new LoginController(); // 객체생성
			} else if (com.equals("/login/logining.do")) {
				controller = new LoginProcController(); // 객체생성
			} else if (com.equals("/login/logouting.do")) {
				controller = new LogoutProcController(); // 객체생성
			} else if (com.equals("/customer/download.do")) {
				controller = new DownloadController(); // 객체생성
			}
			controller.execute(request, response);// 신호에 따라 생긴 객체를 실행한다.
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
