package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/Exam02")
//url로 위의 따음표 안으로 요청을 하면 실행이된다.
//이것이 없다면 url로 찾지를 못한다. ->매핑 정보가 없기 때문에 실행이 안된다.
//설정방법1 : 클래스 선언부에 붙이는 방법
//@WebServlet(name="HomeController", urlPatterns="/HomeController")

//설정방법2 : web.xml에 설정하는 방법 -> app에서는 이 방식으로한다.
public class HomeController extends HttpServlet{
	//클라이언트가 요철할 때 마다 callback(요청 방식과는 상관없다)
	//역할 : 요청처리
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HomeController service() 실행");
		
		//JSP로 이동
		//같은 서버 내에서 이동하는것이기 때문에 경로 이동이 가능하다.
		request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
	}
	
}
