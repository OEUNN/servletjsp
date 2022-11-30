package servlet.exam05;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name="exam05.FileUploadController", urlPatterns="/exam05/FileUploadController")

//requstSize : 요청했을때 전체 사이지를 의미한다.(maxfileSize보다는 커야한다.)
//서버는 클라이언트가 무한정으로 파일을 올릴수 없게 막아야한다.
//fileSizeThreadhold:파일을 올려놓으면 
//location:임시파일 저장소
@MultipartConfig(maxFileSize=1024*1024*10, maxRequestSize=1024*1024*50)
public class FileUploadController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 복원을 위해서 문자셋 지정
		request.setCharacterEncoding("UTF-8");
		
		//문자 파트의 정보 얻기
		String title=request.getParameter("title");
		String desc=request.getParameter("desc");
		
		System.out.println("title: "+title);
		System.out.println("desc: "+desc);
		
		//한 개의 파일 파트 정보 얻기
		/*Part attachPart = request.getPart("attach");
		//파일이 실제로 전송되었는지 확인
		if(!attachPart.getSubmittedFileName().equals("")) {
			String fileName = attachPart.getSubmittedFileName();
			long fileSize = attachPart.getSize();
			String contentType = attachPart.getContentType();
			System.out.println("fileName: "+fileName);
			System.out.println("fileSize: "+fileSize);
			System.out.println("contentType: "+contentType);
		}*/
		
		//두 개 이상의 파일 파트 정보 얻기
		Collection<Part> parts = request.getParts();
		System.out.println(parts.size()); //결과가 5가 나온다->문자파트 + 파일파트 합친 값이다.
		
		for(Part part:parts) {
			/*System.out.println(part.getSubmittedFileName());
			//값이 null이면 문자 파트
			//밑에 빈칸이 세개가 뜨는데 이것이 파일파트이다.*/
			
			//문자파트가 아니면서&& 파일이 실제로 전송되었는지 확인
			//null이면 문자파트이다.
			if(part.getSubmittedFileName()!=null&&!part.getSubmittedFileName().equals("")) {
				//파일 정보 얻기
				String fileName = part.getSubmittedFileName();
				long fileSize = part.getSize();
				String contentType = part.getContentType();
				System.out.println("fileName: "+fileName);
				System.out.println("fileSize: "+fileSize);
				System.out.println("contentType: "+contentType);
				System.out.println();
				
				//파일을 파일 시스템에 저장 
				//다운로드를 위해서 size를 제외한 fileName, contentType은 저장하는게 좋다.
				String savedName=new Date().getTime() +"-"+fileName;//다운받는 파일 이름의 중복을 방지하기 위해 날짜를 넣는다.
				String filePath="C:/Tmep/download/"+savedName;
				part.write(filePath);
			}
		}
		
		
		response.sendRedirect("RequestParamInfoController");
	}
	
}
