
<link href="${pageContext.request.contextPath}/resources/styles/main.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/styles/jquery-ui.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/scripts/jquery.1.10.2.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/scripts/main.js" /></script>
<script src="${pageContext.request.contextPath}/resources/scripts/jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/scripts/jquery-ui.js"></script>
<body>
<div id="tabs">
	<ul>
		<li><a href="#tabs-1">First</a></li>
		<li><a href="#tabs-2">Second</a></li>
		<li><a href="#tabs-3">Third</a></li>
	</ul>
	<div id="tabs-1">Tab 1 - Data</div>
	<div id="tabs-2">Tab 2 - Data</div>
	<div id="tabs-3">Tab 3 - Data</div>
</div>


<script>
$( "#tabs" ).tabs();
</script>	
</body>
