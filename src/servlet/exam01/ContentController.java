package servlet.exam01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;

//방법2
//ulrPaatterns와 xml의 url-pattern의 차이
//s는 배열 이므로 여러가지의 값으로 하나의 경로를 불러올수 있다. -> 하지만 그런일이 잘 없다.
@WebServlet(name="exam01.ContentController", urlPatterns="/exam01/ContentController")
public class ContentController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() 실행");
		
		//JSP로 이동
		request.getRequestDispatcher("/WEB-INF/views/exam01/content.jsp").forward(request, response);
	}

}
