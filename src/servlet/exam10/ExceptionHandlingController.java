package servlet.exam10;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿마다 try-catch를 해주어야하는 단점이 있다.
@WebServlet(name="exam10.ExceptionHandlingController", urlPatterns="/exam10/ExceptionHandlingController")
public class ExceptionHandlingController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String data="1oo";
			int num=Integer.parseInt(data);
			
			response.sendRedirect("ContentController");
		}catch(Exception e){
			request.getRequestDispatcher("/WEB-INF/views/exam10/error.jsp").forward(request,response);
		}
		//처리를 하지 않으면 500처리가 발생하게 된다.
	}
	
}
