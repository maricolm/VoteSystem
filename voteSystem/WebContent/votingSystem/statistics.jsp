<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Voting Statistics</title>
</head>
<!-- 这里使用了一张背景，注释掉了。
<body style="background-image:url(body.jpeg); background-size:100%; background-repeat: no-repeat;">
 -->
 <body>
	<div align="center"><img src="${pageContext.request.contextPath }/votingSystem/img/head2.png" /></div>
	<div  align="center">
	<h4>Hello：${user.name }</h4>
	<h4>Statistics list</h4>
		<table id="main" >
			<% int i=0; %>
			<c:forEach items="${campaigner }" var="cam">
			<% i++;%>
				<tr >
					<td>
						<a href="${pageContext.request.contextPath }/vote/votingDetile.do?campaignerId=${cam.id }" name="option">${cam.name }</a> 
					</td>
				</tr>
				<tr>
					<td style="width:550px">
						<div id="<%= i %>"  style="background-color:#acd6ff; width:0; height:20px; border-width:0px;">
						</div>
					</td>
					<td>
						Count:<label id="label<%= i %>" >${cam.totalVote }</label>
					</td>
				</tr>
			</c:forEach>
			<tr>
				Click on any candidate, you can check the ballots to him/her！
			</tr>
		</table>
	</div>
</body>
<script type="text/javascript">
 
	//在每个投票选项后面写了个div，用div的宽度来代表当前该选项的投票数。
	function vote(){	//函数vote，当点击确认投票的时候，调用vote方法
		//for循环的条件是，所有投票选项的个数。
		for(var i = 0; i < document.getElementsByName("option").length; i++){
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
    