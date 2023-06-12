<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.korail.vo.MemberVo"%>
<%@ page import="com.korail.dao.PmyDao"%>

<jsp:useBean id="memberVo" class="com.korail.vo.MemberVo" />
<jsp:setProperty property="*" name="memberVo" />

<%
	PmyDao pymDao = new PmyDao();
	
%>
