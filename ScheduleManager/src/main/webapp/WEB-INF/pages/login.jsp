<jsp:include page="header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body>

<div class="content">
<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
		<p><span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
		<strong>Please Enter your User Name and Password</strong> </p>
	</div>
	


<form:form id="login" method="post" style="text-align:center; valign:middle" action="validateLogin"> 
 
    <table style="padding-top:80px;" align="center">
    <tr>
        <td><form:label class="label" path="username">User Name :</form:label></td>
        <td><form:input id ="username" path="username" /></td> 
    </tr>
    <tr>
    <td height="20"></td>
    <td height="20"></td>
    </tr>
    <tr>
        <td><form:label class="label" path="password">Password :</form:label></td>
        <td><form:password id="password" path="password" /></td>
    </tr>
    <tr>
    <td height="20"></td>
    <td height="20"></td>
    </tr>	
    <tr>
        <td style="text-align:right;">
            <input id="button" type="button" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" onclick="validateLogin()" value="Login"/>
        </td>
        <td style="text-align:right;">
            <input class ="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only "type="reset" value="Reset"/>
        </td>
    </tr>
</table>  
     
</form:form>
</div>

<c:if test="${validUser=='false'}">
<div class="ui-widget">
	<div class="ui-state-error ui-corner-all" style="padding: 0 .7em;">
		<p><span class="ui-icon ui-icon-alert" style="float: left; margin-right: .3em;"></span>
		<strong>Alert:</strong> Entered Credentials are Incorrect. Please enter Valid Credentials.</p>
	</div>
</div>

</c:if>
<script type="text/javascript">
$( "#button" ).button();
</script>
</body>
<jsp:include page="footer.jsp"></jsp:include>