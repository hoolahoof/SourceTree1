package customer.controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.contoller.Controller;
import customer.dao.NoticeDao;
import customer.vo.Notice;

public class NoticeEditController implements Controller {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("NoticeEditController");
		
		String seq = request.getParameter("c");
		NoticeDao dao = new NoticeDao();
		Notice n = dao.getNotice(seq);
		
		/* n값을 noticeDetail.jsp로 보내기 위해 forward처리 */
		request.setAttribute("n", n);//request에 n이라는 이름으로 n을 보내겠다
		request.getRequestDispatcher("/WEB-INF/View/Customer/noticeEdit.jsp").forward(request, response);

	}
}
