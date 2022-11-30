package servlet.exam04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="exam04.HtmlResponseController", urlPatterns="/exam04/HtmlResponseController")
public class HtmlResponseController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//응답 http파일에 들어가는 데이터 타입이 무엇이냐?
		//Content -> body부분
		//괄호안에는 대분류/소분류
		/*response.setContentType("text/htmle");
		
		//문자만 보낸다.
		PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<h4>Title</h4>");
		pw.println("<hr/>");
		pw.println("</body>");
		pw.println("</html>");
		pw.flush();
		pw.close();*/
		request.getRequestDispatcher("/WEB-INF/views/exam04/html.jsp").forward(request, response);
	
	}
	
}
