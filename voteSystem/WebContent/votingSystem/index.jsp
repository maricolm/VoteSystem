<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>E-Voting System</title>
</head>
<!-- 这里使用了一张背景，注释掉了。
<body style="background-image:url(body.jpeg); background-size:100%; background-repeat: no-repeat;">
 -->
 <body onload="vote()">
	<div align="center"><img src="${pageContext.request.contextPath }/votingSystem/img/head2.png" /></div>
	<div  align="center">
	<h5>Hello： ${user.name }</h5>
	<h4>Candidate list</h4>
	<c:if test="${!empty msg }">
		<span style="color: red">${msg } </br> Your choice</span>
	</c:if>
	<form action="${pageContext.request.contextPath }/vote/voting.do" method="post">
		<input name="userName" type="hidden" value="${user.name }">
		<table id="main" >
		<% int i=0; %>
			<c:forEach items="${campaigner }" var="cam">
			<% i++;%>
				<tr >
					<td>
					<c:if test="${empty msg }">
						<input type="radio" name="idNum" value="${cam.id }" />
					</c:if>
						${cam.name }
					</td>
				</tr>
				<tr>
				<c:if test="${!empty msg }">
					<td style="width:550px">
						<div id="<%= i %>"  style="background-color:#99FFFF; width:100%; height:20px; border-width:0px;">You voted ${count }
						</div>
					</td>
				</c:if>
				<c:if test="${empty msg }">
					<td style="width:550px">
						<div id="<%= i %>"  style="background-color:#acd6ff; width:0; height:20px; border-width:0px;">
						</div>
					</td>
				</c:if>
					<td>
						<c:if test="${cam.id == idNum }">
							<span style="color: red"> Your select! </span>
						</c:if>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td>
				<c:if test="${empty msg }">
					<input type="submit" value="Submit"/>
				</c:if>
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
<script type="text/javascript" defer="defer" >
 
//在每个投票选项后面写了个div，用div的宽度来代表当前该选项的投票数。
function vote(){	//函数vote，当点击确认投票的时候，调用vote方法
	//for循环的条件是，所有投票选项的个数。
	for(var i = 0; i < document.getElementsByName("idNum").length; i++){
		//查找到是哪个投票选项被选中
		//if(document.getElementsByName("option")[i].checked == true){
			var width = document.getElementById("label"+(i+1)).innerHTML;	//获取到当前选项的宽度。
			width = parseInt(width);//将宽度转化为int型，因为获取到的width的单位是px
			if(width!=0){
				width += 3;
			}
			//改变width的值，这里就是定义每次投票的进度条的增速
			document.getElementById(i+1).style.width = width+"px";//修改原div的宽度
			//var label = "label"+i;//lable标签里面写的是当前的投票数目。
			//var num = document.getElementById(label).innerText;//获取到当前的票数
			//document.getElementById(label).innerText = ++num;//票数加1，并修改原值
		//}
	}
	//alert("投票成功");
}
window.onload = vote;
</script>
</html>
