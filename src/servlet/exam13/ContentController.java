package servlet.exam13;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import service.BoardService;
import util.Pager;

@WebServlet(name="exam13.ContentController", urlPatterns="/exam13/ContentController")
public class ContentController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//pageNo얻기
		String straPgeNo = request.getParameter("pageNo");
		if(straPgeNo ==null) {
			straPgeNo="1";
		}
		int pageNo=Integer.parseInt(straPgeNo);
		
		//BoardService 객체 얻기
		ServletContext application = request.getServletContext();
		BoardService boardService = (BoardService) application.getAttribute("boardService");
		
		//페이징 대상이되는 전체 행수 얻기
		int tatalBoardNum = boardService.getTotalRows();
		
		//Pager 생성
		Pager pager = new Pager(10,5,tatalBoardNum, pageNo);
		
		//pageNo에 해당하는 게시물 가져오기
		List<Board> pageList = boardService.getPagerList(pager);
		
		//ㅓJSP에서 사용할 수 있도록 request 범위에 저장 
		request.setAttribute("pager", pager);
		request.setAttribute("pageList", pageList);
		
		request.getRequestDispatcher("/WEB-INF/views/exam13/content.jsp").forward(request,response);
	}
	
}
