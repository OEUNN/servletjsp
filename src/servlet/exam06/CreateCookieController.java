package servlet.exam06;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="exam06.CreateCookieController", urlPatterns="/exam06/CreateCookieController")
public class CreateCookieController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//쿠키 생성(쿠키이름, 쿠키값)
		Cookie cookie1=new Cookie("useremail","winter@mycompany.com");
		
		cookie1.setDomain("localhost");	//해당 도메인으로 갈때만 Cookie전달
		cookie1.setPath("/");	//해당 경로로 요철할 때만 Cookie 전달
		cookie1.setMaxAge(30*60);//30분동안 저장한다. //유지 기간을 설정(파일 시스템에 저장)
		//없으면 메모리에 저장한다.(브라우저를 끄면 없어진다.)
		cookie1.setHttpOnly(true);	//JavaScript에서 쿠키를 읽지 못하도록 설정
		cookie1.setSecure(true);	//https에서만 Cookie를 전달
		
		//쿠키를 응답 헤더에 추가하기(쿠키는 헤더에 실려서 전달된다)
		response.addCookie(cookie1);
		
		Cookie cookie2=new Cookie("userid","winter");
		response.addCookie(cookie2);
		
		response.sendRedirect("ContentController");
	}
	
}
//쿠키는 도메인에 똑같이 응답이 되어야만 응답이된다.
//localhost:8080에서와 192.168.0.29에서 보는 쿠키는 서로 다르다. -> 도메인의 이름이 다르기 때문이다.
