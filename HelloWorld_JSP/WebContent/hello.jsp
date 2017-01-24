<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.test.helloworld.HelloWorld" %>
<%! public int multiply(int a, int b) { return a*b; } %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello World</title>
<script type="text/javascript">
	var a = 1, b = 1;
	document.write(a+b);
</script>
</head>
<body>
<H1>Hello, World</H1>
현재 시간은 <%= new HelloWorld().now() %> 입니다.
<% 
	int a = Integer.parseInt(request.getParameter("a"));
	int b = Integer.parseInt(request.getParameter("b"));
%>
a와 b를 곱한 값은 <%= a * b %> 입니다.
<br>
<% for (int i = 0; i < 10; i++ ){  %>
	<br>안녕하세요<%= multiply(i,10) %>
<% } %>

</body>
</html>