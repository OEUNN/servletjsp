package servlet.exam07;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//세션은 다양한 이름으로 불린다
@WebServlet(name="exam07.SaveSessionController", urlPatterns="/exam07/SaveSessionController")
public class SaveSessionController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/exam07/loginForm.jsp").forward(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		String userId=request.getParameter("userId");
		String userPwd=request.getParameter("userPwd");
		System.out.println(userId);
		System.out.println(userPwd);
		
		if(userId.equals("winter") && userPwd.equals("12345")) {
			//요기서의 세션은서버측에 데이터가 저장되는 저장소
			//클라이언트의 갯수만큼 세션이 만들어진다(자동으로 하나씩 만들어진다.)
			
			//세션 객체 가져오기
			HttpSession session = request.getSession();
			//세션에 데이터(객체)를 저장
			//값의 타입은 Object타입이다.(객체를 저장해야한다.)
			session.setAttribute("loginId", userId);
			session.setAttribute("loginDate", new Date());
			
			List<String> cart=new ArrayList<>();
			session.setAttribute("cart", cart);
			
			response.sendRedirect("ContentController");
		}else {
			request.getRequestDispatcher("/WEB-INF/views/exam07/loginForm.jsp").forward(request,response);
		}
	}
	
}
