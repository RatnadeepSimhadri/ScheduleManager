<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form id="loadCreateProfile" method="post" style="text-align:center; valign:middle" action="loadcreateProfile"> 
 
    <table style="padding-top:20px;" align="center">
    <tr>
        <td colspan="2"><form:label class="label" path="option">Select an Option</form:label></td>
    </tr>
    <tr>
    <td height="20"></td>
    <td height="20"></td>
    </tr>
    <tr>
        <td><form:radiobutton path="option" value="C"/><label class="radio-label">Create Employee Profile</label></td>
        <td><form:radiobutton path="option" value="U"/><label class="radio-label">Update Employee Profile</label></td>
    </tr>
    <tr>
    <td height="20"></td>
    <td height="20"></td>
    </tr>	
    <tr>
        <td  colspan="2" style="text-align:center;">
            <input id="profileButton" type="button" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" onclick="loadCreateProfile()" value="Continue"/>
        </td>
        
    </tr>
</table>  
     
</form:form>
<script>
$(function() {
	 $("#date").datepicker();
});
</script>