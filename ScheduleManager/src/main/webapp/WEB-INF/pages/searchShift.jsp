<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form id="loadAssignShift" method="post" style="text-align:center; valign:middle" action="loadAssignShift"> 
 
    <table style="padding-top:20px;" align="center">
    <tr>
				<td><form:label class="label" path="lab">Lab:</form:label></td>
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
        <td><form:label class="label" path="date">Date :</form:label></td>
        <td><form:input id="date" path="date" /></td>
    </tr>
    <tr>
    <td height="20"></td>
    <td height="20"></td>
    </tr>	
    <tr>
        <td  colspan="2" style="text-align:center;">
            <input id="searchShift" type="button" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" onclick="loadAssignShift()" value="Search"/>
        </td>
        
    </tr>
</table>  
     
</form:form>
<script>
$(function() {
	 $("#date").datepicker();
});

$("#lab").selectmenu();
$( "#button" ).button();

</script>
