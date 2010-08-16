<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<META HTTP-EQUIV="CONTENT-TYPE" CONTENT="text/html; charset=UTF-8" />

<title>Deicer :: Simple app engine blog</title>

<link rel="stylesheet" type="text/css" href="/static/css/screen.css" />
<link rel="stylesheet" type="text/css" media="screen" href="/static/css/superfish.css" />
<link rel="stylesheet" type="text/css" media="screen" href="/static/css/superfish-navbar.css" />
<link type="text/css" href="/static/css/custom-theme/jquery-ui-1.8.4.custom.css" rel="stylesheet" />

</head>

<body>

<img alt="background image" src="/static/images/deicer_back.png" class="bg" />

<div id="page_wrapper">

<div id="header">

<c:choose>
<c:when test="${not empty sessionScope.LOGIN_DATA}">

<div id="session_info">Logged in as <b>${sessionScope.LOGIN_DATA}</b> - <a href="/admin_console.html">Admin console</a> | <a href="/logout.html">Log out</a></div>

</c:when>

<c:otherwise>

<div id="session_info"><a href="/login.html"><b>Login</b></a></div>

</c:otherwise>
</c:choose>

<div id="top_logo"><h1>Deicer - another app engine blog application</h1></div>

<!-- begin the top menu -->
<%@ include file="topmenu.jsp" %>
<!-- end of top menu -->

</div>

<div id="main_wrapper">
<div id="main_content">

<div id="delete_post_dialog"><span id="post_id"></span><p>Are you sure you want to delete the post?</p></div>
<div id="delete_page_dialog"><span id="page_id"></span><p>Are you sure you want to delete the page?</p></div>
