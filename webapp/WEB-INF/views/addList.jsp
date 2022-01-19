<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action ="/guestbook4/guest/add" method="post">
		<table border="1" style="width:600px;">
			<colgroup>
				<col width="8%">
				<col width="38%">
				<col width="16%">
				<col width="38%">
			</colgroup>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="4"> <textarea name="content" cols="75" rows="5"></textarea> </td>
			</tr>
			<tr>
				<td colspan="4"> <button type="submit">확인</button> </td>
			</tr>
		</table>
	</form><br>
	
	<c:forEach items="${gList}" var="vo">
	
		<table border="1" style="width:600px;">
			<colgroup>
				<col width="5%">
				<col width="25%">
				<col width="55%">
				<col width="15%">
			</colgroup>
			<tr>
				<td>${vo.no}</td>
				<td>${vo.name}</td>
				<td>${vo.regDate}</td>
				<td><a href="/guestbook4/guest/deleteForm?no=${vo.no}">삭제</a></td>
			</tr>
			<tr>
				<td colspan="4">${vo.content}</td>
			</tr>
		</table>
		<br>
	</c:forEach>
	
	
</body>
</html>