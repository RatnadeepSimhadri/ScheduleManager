<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form id="searchSchedule" method="post" style="text-align:center; valign:middle" action="searchSchedule"> 
 
    <table style="padding-top:20px;" align="center">
    <tr>
        <td><form:label class="label" path="name">First Name :</form:label></td>
        <td><form:input id ="name" path="name" /></td> 
    </tr>
    <tr>
    <td height="20"></td>
    <td height="20"></td>
    </tr>
    <tr>
        <td><form:label class="label" path="date">Date :</form:label></td>
        <td><form:password id="date" path="date" /></td>
    </tr>
    <tr>
    <td height="20"></td>
    <td height="20"></td>
    </tr>	
    <tr>
        <td  colspan="2" style="text-align:center;">
            <input id="searchSchedule" type="button" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" onclick="searchSchedule()" value="Search"/>
        </td>
        
    </tr>
</table>  
     
</form:form>
<script>
$(function() {
	 $("#date").datepicker();
});

$( "#button" ).button();
$( "#tabs" ).tabs();
$("#tabs").tabs( "option", "active", 0);
</script>
