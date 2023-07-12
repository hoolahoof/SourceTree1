package customer.controller.notice;

import java.io.FileInputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.contoller.Controller;

public class DownloadController implements Controller {

	// 아래 주석 처리한걸 인터페이스해서 오버라이드 받기
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("DownloadController");

		String path = request.getParameter("p");
		String fname = request.getParameter("f");
		String urlPath = path + fname;
		String realPath = request.getServletContext().getRealPath(urlPath);
		System.out.println(realPath);
		
		response.setHeader("Content-Disposition", "attachment;filename="+new String(fname.getBytes(),"ISO8859_1"));
		
		// 입출력 처리
		FileInputStream fin = new FileInputStream(realPath);
		ServletOutputStream sout = response.getOutputStream();
		
		byte[] buf = new byte[1024];
		int size = 0;
		while((size=fin.read(buf,0,1024))!=-1) {
			sout.write(buf,0,size);
		}
		fin.close();
		sout.close();
	}
}
