<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form id="loadCreateLabProfile" method="post" style="text-align:center; valign:middle" action="loadcreateLabProfile"> 
 
    <table style="padding-top:20px;" align="center">
    <tr>
        <td colspan="2"><form:label class="label" path="option">Select an option</form:label></td>
    </tr>
    <tr>
    <td height="20"></td>
    <td height="20"></td>
    </tr>
    <tr>
        <td><form:radiobutton path="option" value="C"/><label class="radio-label">Create a Lab Profile</label></td>
        <td><form:radiobutton path="option" value="S"/><label class="radio-label">Configure Lab Shifts</label></td>
    </tr>
    <tr>
    <td height="20"></td>
    <td height="20"></td>
    </tr>	
    <tr>
        <td  colspan="2" style="text-align:center;">
            <input id="labButton" type="button" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" onclick="loadCreateLabProfile()" value="Continue"/>
        </td>
        
    </tr>
</table>  
     
</form:form>
<script>

</script>