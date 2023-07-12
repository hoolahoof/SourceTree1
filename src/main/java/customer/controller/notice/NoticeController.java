package customer.controller.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.contoller.Controller;
import customer.dao.NoticeDao;
import customer.vo.Notice;

public class NoticeController implements Controller {

	// 아래 주석 처리한걸 인터페이스해서 오버라이드 받기
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("NoticeController");

		// search 기능 추가
		String field=request.getParameter("f");
		if(field==null || field.equals("")) {	// if문을 통해 index에서 접속할 경우 데이터가 바로 뜸
			field="title";
		}
		String query=request.getParameter("q");
		if(query==null) {
			query="";
		}
		System.out.println("field : "+field);	// f가 title인지 content인지 구분
		System.out.println("query : "+query);
		
		NoticeDao dao = new NoticeDao();
		List<Notice> list = dao.noticeSelAll(field,query);
		
		//forward 처리 - List<Notice>를 request에 저장
		request.setAttribute("list", list);
		request.setAttribute("query", query);
		request.getRequestDispatcher("/WEB-INF/view/customer/notice.jsp").forward(request, response);
		
	}
}
