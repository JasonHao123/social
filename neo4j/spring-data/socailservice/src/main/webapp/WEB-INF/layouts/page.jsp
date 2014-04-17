<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page session="false" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="format-detection" content="telephone=no" />
<!-- WARNING: for iOS 7, remove the width=device-width and height=device-height attributes. See https://issues.apache.org/jira/browse/CB-4323 -->
<meta name="viewport"
	content="user-scalable=no, initial-scale=1, maximum-scale=1, minimum-scale=1, width=device-width, height=device-height, target-densitydpi=device-dpi" />
<title>Spring Social Showcase</title>
<link rel="stylesheet" href="<c:url value="/resources/css/jquery.mobile-1.4.2.min.css" />">
<script src="<c:url value="/resources/js/jquery.js" />"></script>
<script src="<c:url value="/resources/js/jquery.mobile-1.4.2.min.js" />"></script>
</head>
<body>

	<div data-role="page" class="jqm-demos">
		<div data-role="header" data-position="fixed" >
			<h1>系统登录</h1>
		</div>
		<!-- /header -->

		<div id="main" class="ui-content" role="main">
			<tiles:insertAttribute name="content" />
		</div>
		<!-- /content -->

		<div data-role="footer" data-position="fixed" data-fullscreen="true">
			<h2>Copyright © 2013-2014 Jason Hao. All rights reserved. </h2>
		</div>
		<!-- /footer -->

	</div>
	<!-- /page -->
</body>
</html>