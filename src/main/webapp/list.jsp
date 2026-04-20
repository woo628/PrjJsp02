<%@page import="db.DBHandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String userid = request.getParameter("userid");
	String username = request.getParameter("username");
	String email = request.getParameter("email");

	DBHandler db = new DBHandler();
	db.listUser();
	
%>
	