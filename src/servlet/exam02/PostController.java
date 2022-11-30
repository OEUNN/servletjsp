package servlet.exam02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "exam02.PostController", urlPatterns = "/exam02/PostController")
public class PostController extends HttpServlet {
	
	//client가 POST 방식으로 요철할 때 마다 callback
	//역할 : 요청 처리
	//전달되는 데이터가 바디에 저장되어 전달
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/exam02/post.jsp").forward(request, response);
	}

}
