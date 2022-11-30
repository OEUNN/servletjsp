<%-- page 지시자 --%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%-- contnetType은 응답데이터의 타입, pageEncoding타입은 네트워크 보낼때의 타입 --%>
<%-- 만약 pageEncoding이 없다면 charset의 값과 같게 입력된다. --%>
<%-- 만약 입력이 없다면 창이뜨면서 default값을 알려준다. --%>
<%-- include 지시자 --%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>


<div class="card m-2">
	<div class="card-header">
		html.jsp
	</div>
	<div class="card-body">
		<a href="#" class="btn btn-info btn-sm">링크1</a>
		<%-- <a href="#" class="btn btn-info btn-sm">링크2</a> --%>
		<!-- <a href="#" class="btn btn-info btn-sm">링크3</a> -->
	</div>
</div>

<%-- include 지시자 --%>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>