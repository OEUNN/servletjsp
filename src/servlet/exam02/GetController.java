package servlet.exam02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "exam02.GetController", urlPatterns = "/exam02/GetController")
public class GetController extends HttpServlet {
	
	//client가 GET 방식으로 요철할 때 마다 callback
	//역할 : 요청 처리
	//전달되는 데이터가 시작행에 저장되어 전달
	//문자만 가능하다
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/exam02/get.jsp").forward(request, response);
	}

}
