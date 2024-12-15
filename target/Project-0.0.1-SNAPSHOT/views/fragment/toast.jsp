<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<!-- toast.css và toast.js -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/views/assets/styles/toast.css" />
<script src="<%=request.getContextPath()%>/views/assets/js/toast.js"></script>

</head>
<body>
	<!-- Toast để thông bao  -->
		<div id="custom-toast-container"></div>
		<c:if test="${not empty param.msg}">
			<script>
			const type = '${param.type}';
	        const msg = '${param.msg}';
	        if (type === 'success') {
	            showSuccessToast(msg);
	        } else if (type === 'error') {
	            showErrorToast(msg);
	        } else {
	        	showInformationToast('${msg}');
	        }
		     </script>
		</c:if> 
</body>
</html>