package customer.controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.contoller.Controller;
import customer.dao.NoticeDao;
import customer.vo.Notice;

public class NoticeEditProcController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("NoticeEditProcController");
		
		request.setCharacterEncoding("utf-8"); 
		String seq = request.getParameter("c"); 
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		  
		Notice n = new Notice(); 
		n.setTitle(title); 
		n.setContent(content);
		n.setSeq(seq);
		
		NoticeDao dao = new NoticeDao(); 
		dao.update2(seq,title,content);
		
		request.setAttribute("n", n);//request에 n이라는 이름으로 n을 저장한다.
		request.getRequestDispatcher("noticeDetail.jsp").forward(request, response);//request에 있는 정보를 noticeDetail.jsp에 보낸다.
		// response.sendRedirect("noticeDetail.jsp?c="+seq);
		
	}
	
}
