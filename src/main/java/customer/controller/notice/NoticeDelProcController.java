package customer.controller.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.contoller.Controller;
import customer.dao.NoticeDao;
import customer.vo.Notice;

public class NoticeDelProcController implements Controller {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("NoticeDelProcController");
		
		String seq = request.getParameter("c");
		
		NoticeDao dao = new NoticeDao();
		int del = dao.delete(seq);
		System.out.println("del : "+del);
		
		if(del>0){
			response.sendRedirect("notice.do");
		}
//		out객체는 jsp객체에 종류인데 java에서 표현이 안 되서 주석처리

	}
}
