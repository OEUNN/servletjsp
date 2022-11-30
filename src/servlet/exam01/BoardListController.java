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

@WebServlet(name="exam01.BoardListController", urlPatterns="/exam01/BoardListController")
//name은 무엇인가? web은 이름으로 관리가 된다.
//name을 주지 않으면 class의 name과 같은 객체로 저장된다.(이름이 같은 class가 충돌을 일으킬수 있다.)
public class BoardListController extends HttpServlet {
	
	//서블릿은 객체 하나만 만들어 지고 공유해서 사용된다.
	//서블릿에서는 요청할때마다 만들어지는 것이 아니다. -> 그 후에는 service만 실행된다.
	//최초요청일때 가장 느리다. -> 
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() 실행");
		
		//처리 결과 생성
		List<Board> boards = new ArrayList<>();
		
		for(int i=1;i<10;i++) {
			Board board = new Board();
			board.setBno(i);
			board.setBtitle("제목"+i);
			board.setBcontent("내용"+i);
			board.setBwriter("홍길동");
			board.setBdate(new Date());
			boards.add(board);
		}
		//처리 결과를 JSP에서 사용할 수 있도록 설정
		request.setAttribute("boards", boards);
		
		//JSP로 이동
		request.getRequestDispatcher("/WEB-INF/views/exam01/boardList.jsp").forward(request, response);
	}
	

}
