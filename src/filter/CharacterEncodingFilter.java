package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter{
	private String encoding;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		if(filterConfig.getInitParameter("encoding")!=null) {
			encoding=filterConfig.getInitParameter("encoding");
		}else {
			encoding="encoding";
		}
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		//전처리
		//System.out.println("전처리합니다.");
		request.setCharacterEncoding("UTF-8");//서블릿을 작성할 때 dopost에 작성할 필요 없다.
		
		//-----------------------------------------------------------------
		filterChain.doFilter(request, response);	//다음 필터 또는 서블릿으로 이동
		//-----------------------------------------------------------------
		
		//후처리
		//System.out.println("후처리합니다.");
	}
}
