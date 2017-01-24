<%@ page language="java" contentType="text/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.test.helloworld.HelloWorld" %>
{"currentTime":"<%= new HelloWorld().now() %>"}