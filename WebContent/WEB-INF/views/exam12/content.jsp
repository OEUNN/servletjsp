<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>


<div class="card m-2">
	<div class="card-header">
		content.jsp
	</div>
	<div class="card-body">
		<div class="card m-2">
			<div class="card-header">
				조건 태그
			</div>
			<div class="card-body">
				<%--if문 --%>
				<c:if test="${!empty loginUser.userId}">
					<%--로그인 유저를 찾았는가? --%>
					${loginUser.userId}/${loginUser.userName}
				</c:if>
				<c:if test="${empty loginUser.userId}">
					저장된 User가 없습니다.
				</c:if>
				
				<hr/>
				
				<%--swich문 --%>
				<c:choose>
					<c:when test="${loginUser.userId == 'winter'}">
						겨울 이군요.
					</c:when>
					<c:when test="${loginUser.userId == 'spring'}">
						봄 이네요.
					</c:when>
					<c:when test="${loginUser.userId == 'summer'}">
						여름 이십니까?
					</c:when>
					<%--그 이외에 --%>
					<c:otherwise>가을 이시네요.</c:otherwise>
				</c:choose>
			</div>
		</div>
		
		<%--반복태그 --%>
		
		<div class="card m-2">
			<div class="card-header">
				반복 태그1
			</div>
			<div class="card-body">
				<%-- for문 --%>
				<c:forEach var="i" begin="1" end="5" step="1">
					<img src="${pageContext.request.contextPath}/resources/images/photo${i}.jpg" width="100" height="100"/>
				</c:forEach>
			</div>
		</div>
		
		<hr/>
		
		<div class="card m-2">
			<div class="card-header">
				반복 태그2
			</div>
			<div class="card-body">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>순번</th>
							<th>번호</th>
							<th>제목</th>
							<th>내용</th>
							<th>글쓴이</th>
							<th>날짜</th>
						</tr>
					</thead>
					<tbody>
						<%-- 향상된 for문 --%>
						<%-- items에는 list, 배열 --%>
						<c:forEach var="board" items="${list}" varStatus="status">
						<%-- varStatus - for의 반복 횟수 --%>
							<tr>
								<td>${status.index}</td>
								<%--count는 1부터, index는 	0부터 --%>
								<td>${board.bno}</td>
								<td>${board.btitle}</td>
								<td>${board.bcontent}</td>
								<td>${board.bwriter}</td>
								<td><fmt:formatDate value="${board.bdate}" pattern="yyyy.MM.dd"/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		
		<hr/>
		
		<div class="card m-2">
			<div class="card-header">
				반복 태그2
			</div>
			<div class="card-body">
				<c:forEach var="board" items="${list}" varStatus="status">
					<%--first는 첫번째 반복하느냐? 제일 첫번째 시작할때 추가하겠다. --%>
					<c:if test="${status.first}">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>순번</th>
									<th>번호</th>
									<th>제목</th>
									<th>내용</th>
									<th>글쓴이</th>
									<th>날짜</th>
								</tr>
							</thead>
						<tbody>
					</c:if>
							<tr>
								<td>${status.index}</td>
								<td>${board.bno}</td>
								<td>${board.btitle}</td>
								<td>${board.bcontent}</td>
								<td>${board.bwriter}</td>
								<td><fmt:formatDate value="${board.bdate}" pattern="yyyy.MM.dd"/></td>
							</tr>
						<c:if test="${status.last}">
						</tbody>
					</table>
					</c:if>
				</c:forEach>
			</div>
		</div>
		
	</div>
</div>


<%@ include file="/WEB-INF/views/common/footer.jsp" %>