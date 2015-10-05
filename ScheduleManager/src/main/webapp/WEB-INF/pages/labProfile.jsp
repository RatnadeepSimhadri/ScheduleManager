<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body>


<div class="content">
<div>
<c:if test="${ empty result }">
<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
		<p><span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
		<strong>Please enter Lab Details</strong> </p>
	</div>
</c:if>
</div>

<div>
<c:if test="${not empty result }">
<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
		<p><span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
		<strong>${result}</strong> </p>
	</div>
</c:if>
</div>

<form:form id="createLabProfile" method="post" style="text-align:center; valign:middle" action="createLabProfile"> 
 
    <table style="padding-top:20px;" align="center">
    <tr>
        <td style="text-align:left"><form:label class="label" path="labName">Name :</form:label></td>
        <td><form:input id ="labName" path="labName" /></td> 
    </tr>
    <tr>
    <td height="10"></td>
    <td height="10"></td>
    </tr>
    <tr>
				<td style="text-align:left"><form:label class="label" path="manager">Manager:</form:label></td>
				<td><form:select id ="manager" path="manager">
					  <form:option value="0" label="Select a value" />
					   <form:options items="${managers}" itemValue="value" itemLabel="label"/>
				       </form:select>
                </td>
	</tr>
	<tr>
    <td height="20"></td>
    <td height="20"></td>
    </tr>
   
    <tr>
    <td colspan="2"><hr style="height:2px;border-width:0;color:gray;background-color:gray"></td>
    </tr>
    <tr>
    <td colspan="2">
    <table>
    <tr>
    <td style="text-align:left"><form:label class="label" path="address.street">Street :</form:label></td>
    <td><form:input id="email" path="address.street" /></td>
    <td>&nbsp;</td>
    <td style="text-align:left"><form:label class="label" path="address.city">City :</form:label></td>
    <td><form:input id="email" path="address.city" /></td>
    </tr>
    <tr>
    <td height="5"></td>
    <td height="5"></td>
    </tr>
    <tr>
    <td style="text-align:left"><form:label class="label" path="address.state">State :</form:label></td>
    <td><form:input id="email" path="address.state" /></td>
    <td>&nbsp;</td>
    <td style="text-align:left"><form:label class="label" path="address.zip">Zip :</form:label></td>
    <td><form:input id="email" path="address.zip" /></td>
    </tr>
    </table>
    </td>
    </tr>	
    <tr>
    <td height="10"></td>
    <td height="10"></td>
    </tr>
    <!-- Button -->
    <tr>
        <td colspan="2"style="text-align:center;">
            <input id="button" type="button" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" onclick="saveLabProfile()" value="Save"/>
        </td>
    </tr>
</table>  
     
</form:form>
</div>


<script type="text/javascript">
$( "#button" ).button();
$( "#tabs" ).tabs();
$("#manager").selectmenu();
$("#tabs").tabs( "option", "active", 3);

</script>
</body>