<jsp:include page="header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="${pageContext.request.contextPath}/resources/styles/main.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/styles/jquery-ui.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/scripts/jquery.1.10.2.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/scripts/main.js" /></script>
<script src="${pageContext.request.contextPath}/resources/scripts/jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/scripts/jquery-ui.js"></script>
<body>
<div class="content">
<div id="tabs">
	<ul>
		<li><a id="#tab1" href="#" onclick="loadPage('loadSearchSchedule')">View Schedule</a></li>
		<li><a id="#tab2" href="#" onclick="loadPage('loadSchedulePage')">Schedule Details</a></li>
		<li><a id="#tab3" href="#" onclick="loadPage('loadProfilePage')">Profile Details</a></li>
		<li><a id="#tab4" href="#" onclick="loadPage('loadCreateLabPage')">Lab Details</a></li>
	</ul>
<div id="search">
	<jsp:include page="${page}"></jsp:include>
</div>
</div>

</div>
<div class="content">
<div id="searchresult">
</div>
</div>
	
</body>
<jsp:include page="footer.jsp"></jsp:include>