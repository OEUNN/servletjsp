package servlet.exam07;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="exam07.UseSessionController", urlPatterns="/exam07/UseSessionController")
public class UseSessionController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션 객체 가져오기
		HttpSession session = request.getSession();
		
		//세션에 저장된 데이터(객체) 가져오기
		//object타입인된 String으로 받기위해 강제타입변화을 했음
		//같은브라우저는 공유가 된다.( 하지만, 종류가 다른 브라우저인 edge는 안된다.)
		String loginId = (String)session.getAttribute("loginId");
		System.out.println("loginId: "+loginId);
		
		Date loginDate = (Date)session.getAttribute("loginDate");
		System.out.println("loginDate: "+loginDate);
		
		List<String> cart =(List<String>)session.getAttribute("cart");
		if(cart!=null) {
			for(int i=0;i<cart.size();i++) {
				System.out.println(i+": "+cart.get(i));
			}
		}
		
		response.sendRedirect("ContentController");
	}
	
}
