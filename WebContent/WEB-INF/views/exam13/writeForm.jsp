<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>


<div class="card m-2">
	<div class="card-header">
		게시물 작성
	</div>
	<div class="card-body">
		<form method="post" action="WriteController" enctype="multipart/form-data">
		
         <div class="form-group">
            <label for="btitle">Title</label> 
            <input type="text" class="form-control" id="btitle" name="btitle"> 
         </div>
         
         <div class="form-group">
            <label for="bcontetn">Content</label> 
            <!-- lageA가 50개 -->
            <textarea rows="5" cols="50" id="bcontent" name="bcontent" class="form-control"></textarea>
         </div>
         
         <div class="form-group">
            <label for="bwriter">Writer</label> 
            <!-- lageA가 50개 -->
            <input type="text" class="form-control" id="bwriter" name="bwriter"> 
         </div>
         
         <div class="form-group">
            <label for="battach">Attach</label> 
            <!-- lageA가 50개 -->
            <input type="file" class="form-control" id="battach" name="battach"> 
         </div>
         
         <button type="submit" class="btn btn-primary">게시물 작성</button>
      </form>
	</div>
</div>


<%@ include file="/WEB-INF/views/common/footer.jsp" %>