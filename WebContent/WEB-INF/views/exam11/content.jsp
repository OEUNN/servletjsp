<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>


<div class="card m-2">
	<div class="card-header">
		content.jsp
	</div>
	<div class="card-body">
		1.	${5}<br/>
		2.	${"홍길동"}<br/>
		3.	${2+5}<hr/>
		
		<%-- 나머지 --%>
		<h6 class="mt-3">**산술 연산자</h6>
		4.	${7 mod 3}, ${7 % 3}<hr/>
		
		<%-- 논리 연산자 --%>
		<h6 class="mt-3">**논리 연산자</h6>
		5.	${true && false}, ${true and false}<br/>
		6.	${true || false}, ${true or false}<hr/>
		
		<%-- Not --%>
		7.	${!true}, ${not true}<hr/>
		
		<%-- 비교 연산자 --%>
		<h6 class="mt-3">**비교 연산자</h6>
		8.	${2 < 5}, ${2 lt 5}<br/>
		9.	${2 > 5}, ${2 gt 5}<br/>
		10.	${2 <= 5}, ${2 le 5}<br/>
		11.	${2 >= 5}, ${2 ge 5}<br/>
		12.	${2 != 5}<hr/>
		
		<%-- empty --%>
		<%-- null이거나 공백일때 true --%>
		13.	${empty null}<br/>
		14.	${empty ""}<hr/>
		
		<%-- 내장 객체 --%>
		<%-- JSP가 실행화는 환경 --%>
		<%-- request, response, sessiony --%>
		<h6 class="mt-3">**pagConext를 이용해서 request, respons, session의 Getter 리턴값 얻기</h6>
		15.	${pageContext.request.contextPath}<hr/>
		
		<%-- 처음 request 범위에서 찾고 그다음 session 다음 application에서 찾는다. --%>
		<h6 class="mt-3">**request 범위 -> session 범위 -> application 범위 순으로 저장된 이름의 값을 출력</h6>
		16.	${user.userId}, ${user.userName}<br/>
		17.	${board.bno}, ${board.btitle}, ${board.bcontent}<br/>
		22.	${info}<br/>
	</div>
</div>


<%@ include file="/WEB-INF/views/common/footer.jsp" %>