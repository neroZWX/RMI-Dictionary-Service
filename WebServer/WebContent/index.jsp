<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>dictionary query</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
<script>
	
	var intervalFunction;

	function query() {
	
		var xmlhttp;
		if (window.XMLHttpRequest) {
			//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
			xmlhttp = new XMLHttpRequest();
		} else {
			// IE6, IE5 浏览器执行代码
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				queryResult(xmlhttp.responseText);
				document.getElementById("queryDiv").style.display="none";
				document.getElementById("resultDiv").innerHTML = 'Waiting for response...';
			}
		}
		
		var url = "query?key="+document.getElementById("key").value;
		xmlhttp.open("GET", url, true);
		xmlhttp.send();
	}
	
	function queryResult(jobId){
		intervalFunction = window.setInterval(queryResultAction, 10000, jobId);
	}
	
	function queryResultAction(jobId) {
	
		var xmlhttp;
		if (window.XMLHttpRequest) {
			//  IE7+, Firefox, Chrome, Opera, Safari 
			xmlhttp = new XMLHttpRequest();
		} else {
			// IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				console.info(xmlhttp.responseText);
				if(xmlhttp.responseText != ""){
					document.getElementById("resultDiv").innerHTML = "Response:"+xmlhttp.responseText;
					document.getElementById("queryAgainBtn").style.display="block";
					window.clearInterval(intervalFunction);
				}
			}
		}
		
		var url = "queryResult?jobId="+jobId;
		xmlhttp.open("GET", url, true);
		xmlhttp.send();
	}
	
	function queryAgain(){
		document.getElementById("queryDiv").style.display="block";
		document.getElementById("queryAgainBtn").style.display="none";
		document.getElementById("key").value = null;
		document.getElementById("resultDiv").innerHTML = null;
	}
	
</script>

<body>
	
  	<center>
  			<p><font size="6">Dictionary Service</font></p>
  			<div id="queryDiv">
			  	Dictionary:
			  	<input type="text" id="key" placeholder="Enter Query here"/>
				<button type="button" onclick="query()">Submit</button>
			</div>
			<div id="resultDiv"></div>
			<p><button id="queryAgainBtn" style="display:none" onclick="queryAgain()">Make another query</button></p>
	</center>
  </body>
</html>
