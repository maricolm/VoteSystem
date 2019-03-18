<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ballot Details</title>
</head>
<!-- 这里使用了一张背景，注释掉了。
<body style="background-image:url(body.jpeg); background-size:100%; background-repeat: no-repeat;">
 -->
 <body>
	<div  align="center">
	<h4>${user.name }</h4>
		<table id="main" border="1" cellspacing="0" >
			<tr colspan="2">For confidentiality，ballot will be presented using ciphertext</tr>
			<tr >
				<th>Voter</th>
				<th style="display:inline-block; width:600px;">Ballot cihpertext<br>&nbsp;</th>
			<%--	<th>Corresponding <br>plaintext</th>  --%>
			</tr>
			<c:forEach items="${voted }" var="vote">
				<tr>
					<td >${vote.voteUser }</td>
					<td style="display:inline-block; width:600px; word-break:break-all; word-wrap:break-word;">${vote.voteCiphertext }</td>
					<%--<td style="text-align:center;">${vote.votePlaintext }</td> --%>
				</tr>
			</c:forEach>
			<tr style="color: red;">
				<td >count</td>
				<td style="display:inline-block; width:600px; word-break:break-all; word-wrap:break-word;">${countVote.countCiphertext }</td>
				<%--<td style="text-align:center;">${countVote.countPlaintext }</td> --%>
			</tr>
			<tr style="color: red;">
				<td >plaintext</td>
				<td style="text-align:center;">${countVote.countPlaintext }</td>
			</tr>
		</table>
	</div>
</body>

</html>
