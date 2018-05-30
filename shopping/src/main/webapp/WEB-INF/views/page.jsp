<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images" value="/resources/images"/>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />    
<%-- For testing only <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping</title>
</head>
<body>
	${contextRoot} says ${greeting}
</body>
</html> --%>




<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Shopping ${title}</title>
	
	<script>
			window.menu =  '${title}';
	</script>
	
	    <!-- Bootstrap core CSS -->
     <link href="${css}/bootstrap.min.css" rel="stylesheet">
		
    <!-- Bootstrap core CSS -->
   <!--  <link href="${css}/bootstraptheme.css" rel="stylesheet"> -->
    
    <!-- Add custom CSS here -->
    <link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>

	<div class="wrapper">

	<!-- Navigation -->
	<%@include file="./shared/navbar.jsp" %>
	
	<!-- page content -->
	<div class="content">
			<!-- home content -->
			<c:if test="${userClickHome==true}">
				<%@include file="./home.jsp"%>
			</c:if>

			<!--  loads only when user click about -->
			<c:if test="${userClickAbout==true}">
				<%@include file="./about.jsp"%>
			</c:if>

			<!--  loads only when user click Contact -->
			<c:if test="${userClickContact==true}">
				<%@include file="./contact.jsp"%>
			</c:if>

			<!--  loads only when user click Contact -->
			<c:if test="${userClickAllProducts==true or userClickCategoryProducts == true}">
				<%@include file="./listProducts.jsp"%>
			</c:if>

		</div>
    <!-- /.container -->
		
	<%@include file="./shared/footer.jsp" %>

    <!-- /.container -->

    <!-- JavaScript -->
    <script src="${js}/jquery.js"></script>
    <script src="${js}/bootstrap.min.js"></script>
    
    <!-- self coded java scirpt -->
	<script src="${js}/myapp.js"></script>
	
	
	</div>
</body>

</html>
