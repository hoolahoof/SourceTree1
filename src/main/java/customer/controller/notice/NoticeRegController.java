package customer.controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.controller.Controller;

public class NoticeRegController implements Controller {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("NoticeRegController");
		
		request.getRequestDispatcher("/WEB-INF/View/Customer/noticeReg.jsp").forward(request,response);

	}
}
