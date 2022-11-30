package servlet.exam02;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "exam02.ContentController", urlPatterns = "/exam02/ContentController")
public class ContentController extends HttpServlet {
	
	//서블릿 객체가 생성된 후(즉시), 딱 1번 callback
	//역할 : 서블릿 객체 초기화 작업
	@Override
	public void init(ServletConfig config) throws ServletException {
		//서블릿 객체의 초기화 코드
		System.out.println("exam02.ContentController init()실행");
	}
	
	//클라이언트가 요철할 때 마다 callback(요청 방식과는 상관없다)
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/exam02/content.jsp").forward(request, response);
	}
	
	//doGet 과 doPost는 service와 같이 있지 않는다. 같이 있다면 service만 실행된다.
	//destroy는 잘 사용되지 않는다.
}
