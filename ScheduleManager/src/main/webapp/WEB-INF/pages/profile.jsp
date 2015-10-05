<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body>


<div class="content">
<div>
<c:if test="${ empty result }">
<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
		<p><span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
		<strong>Please enter Employee Details</strong> </p>
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





<input id="formLab" name="formLab" type="hidden" value="${form.lab}"/>

<form:form id="createProfile" method="post" style="text-align:center; valign:middle" action="createProfile"> 
 
    <table style="padding-top:20px;" align="center">
    <tr>
        <td style="text-align:left"><form:label class="label" path="netId">NetId :</form:label></td>
        <td><form:input id ="netId" path="netId" /></td> 
    </tr>
    <tr>
    <td height="10"></td>
    <td height="10"></td>
    </tr>
    <tr>
        <td style="text-align:left"><form:label class="label" path="firstName">First Name :</form:label></td>
        <td><form:input id="firstName" path="firstName" /></td>
    </tr>
    <tr>
    <td height="10"></td>
    <td height="10"></td>
    </tr>
    <tr>
        <td style="text-align:left"><form:label class="label" path="LastName">Last Name :</form:label></td>
        <td><form:input id="LastName" path="LastName" /></td>
    </tr>
    <tr>
    <td height="10"></td>
    <td height="10"></td>
    </tr>
    <tr>
        <td style="text-align:left"><form:label class="label" path="email">Email :</form:label></td>
        <td><form:input id="email" path="email" /></td>
    </tr>
    <tr>
    <td height="10"></td>
    <td height="10"></td>
    </tr>
    <tr>
        <td style="text-align:left"><form:label class="label" path="phone">Phone :</form:label></td>
        <td><form:input id="phone" path="phone" /></td>
    </tr>
    <tr>
    <td height="20"></td>
    <td height="20"></td>
    </tr>
    <tr>
    	<td style="text-align:left"><form:label class="label" path="phone">Gender :</form:label></td>
        <td><form:radiobutton path="gender" value="M"/><label class="radio-label">Male</label></td>
        <td><form:radiobutton path="gender" value="F"/><label class="radio-label">Female</label></td>
    </tr>
    <tr>
    <tr>
    <td height="20"></td>
    <td height="20"></td>
    </tr>
    <tr>
    	<td style="text-align:left"><form:label class="label" path="phone">Role :</form:label></td>
        <td><form:radiobutton path="role" value="S"/><label class="radio-label">Student Worker</label></td>
        <td><form:radiobutton path="role" value="M"/><label class="radio-label">Manager</label></td>
    </tr>
    <tr>
    <td height="20"></td>
    <td height="20"></td>
    </tr>
    <tr>
				<td style="text-align:left"><form:label class="label" path="lab">Lab:</form:label></td>
				<td><form:select id ="lab" path="lab">
					  <form:option value="0" label="--Please Select--" />
					   <form:options items="${labs}" itemValue="value" itemLabel="label"/>
				       </form:select>
                </td>
	</tr>
	<tr>
    <td height="20"></td>
    <td height="20"></td>
    </tr>
     <tr>
        <td style="text-align:left"><form:label class="label" path="username">Username :</form:label></td>
        <td><form:input id="username" path="username" /></td>
    </tr>
    <tr>
    <td height="10"></td>
    <td height="10"></td>
    </tr>
    <tr> 	 	 	
        <td style="text-align:left"><form:label class="label" path="password">Password :</form:label></td>
        <td><form:password id="password" path="password" /></td>
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
            <input id="button" type="button" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" onclick="saveProfile()" value="Save"/>
        </td>
    </tr>
</table>  
     
</form:form>
</div>


<script type="text/javascript">
$( "#button" ).button();
$( "#tabs" ).tabs();
$("#lab").selectmenu();
$("#tabs").tabs( "option", "active", 2);
$( document ).ready(function() {
	var selectedLab = document.getElementById('formLab').value;
	if(selectedLab!=null||selectedLab!=""){}
    $("#lab").val(selectedLab);
});

</script>
</body>