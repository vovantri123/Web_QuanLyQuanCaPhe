<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="/views/fragment/head.html"%>
<style>
</style>
<meta charset="UTF-8">
</head>
<body>
	<!-- Header -->
	<jsp:include page="/views/fragment/header.jsp">
		<jsp:param name="HoTen" value="${nguoiDung.tenND}" />
		<jsp:param name="Anh" value="${nguoiDung.anhND}" />
	</jsp:include>

	

	<!-- Toast để thông bao  -->
	<jsp:include page="/views/fragment/toast.jsp">
		<jsp:param name="msg" value="${msg}" />
		<jsp:param name="type" value="${typeMess}" />
	</jsp:include>
	<!-- Footer -->
	<jsp:include page="/views/fragment/footer.jsp" />
</body>
</html>