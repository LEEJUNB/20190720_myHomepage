<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
good evening!
<%
	System.out.print("jspservice()");
%>

<!-- 하단의 표현식은 기존처럼 service메서드(호출)에서 생성되는 것이 아니라 init 혹은 destroy메서드에 코드들이 만들어지게됨  -->
<%!
	public void jspInit(){
	System.out.print("jspInit()");
	}

	public void jspDestroy(){
	System.out.print("jspInit()");
	}
%>
</body>
</html>