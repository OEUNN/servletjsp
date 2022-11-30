package servlet.exam04;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="exam04.FileResponseController", urlPatterns="/exam04/FileResponseController")
public class FileResponseController2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//시작행과 헤더행에는 한글은 들어가지 않는다
		String fileName ="photo1.jpg";
		String filePath = "C:/Temp/photo1.jpg";
		String contentType ="image/jpeg";
		
		//HTTP 응답에 Content-Type 헤더를 추가
		response.setContentType(contentType);
		//위의 줄과 같다 contnetType많이 써서 생겼다.(=response.setHeader("Content-Type", contentType);)
		
		//브라우저의 종류 얻기(한글사진 변환방법)
		String userAgent=request.getHeader("User-Agent");
		if(userAgent.contains("Trident")||userAgent.contains("MSIE")) {
			//IE(인터넷 익스플로어)일 경우
			fileName=URLEncoder.encode(fileName,"UTF-8");
		}else {
			//chrome, Edge, FireFox, safari
			fileName=new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
		}
		System.out.println(fileName);
		
		//HTTP 응답에 Content-Disposition 헤더를 추가
		//파일다운받기를 만들어주는 줄이다.
		response.setHeader("Content-Disposition", "attachment; filename=\""+fileName+"\"" );
		
		//HTTP 응답 본문에 파일 데이터 출력하기
		ServletOutputStream sos= response.getOutputStream();
		
		//방법1
		/*FileInputStream fis = new FileInputStream(filePath);
		//파일 일때는 이내용을 사용
		byte[] data = new byte[1024];
		while(true) {
			int readByteNum = fis.read(data);
			if(readByteNum==-1) break;
			sos.write(data,0,readByteNum);
		}
		sos.flush();
		fis.close();
		sos.close();*/
		
		//방법2
		Path path=Paths.get(filePath);
		Files.copy(path, sos);
		sos.flush();
		sos.close();
		//파일을 다운받기 위해서는 응답헤드를 만들어야한다. 지금은 이미 바로 보기만 가능하다
	}
	
}
