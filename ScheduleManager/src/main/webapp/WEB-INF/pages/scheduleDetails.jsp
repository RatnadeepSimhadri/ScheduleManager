<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form id="searchScheduleresult" method="post" style="text-align:center; valign:middle" action="searchScheduleresult"> 

<div>
<c:if test="${not empty result }">
<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
		<p><span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
		<strong>${result}</strong> </p>
	</div>
</c:if>
</div>

 <c:if test="${ empty result }">
    <table style="padding-top:20px;" align="center">
    <tr>
    <td colspan="2"><label class="label" >Shift details of ${form.name} for Lab: ${form.labName}</label></td>
    </tr>
    <tr>
    <td height="20"></td>
    <td height="20"></td>
    </tr>
     <tr>
        <td><label class="radio-label">Shift Number</label></td>
        <td><label class="radio-label">Start Time</label></td>
        <td><label class="radio-label">End Time</label></td>
    </tr>
    <c:forEach var="schedule" items="${form.schedule}">
    <tr>
    <td height="20"></td>
    <td height="20"></td>
    </tr>
    <tr>
        <td><label class="label" >${schedule.shiftNumber}</label></td>
        <td><label class="label" >${schedule.startTime}</label></td>
        <td><label class="label" >${schedule.endTime}</label></td>
    </tr>
    </c:forEach>
</table>
</c:if>  
     
</form:form>
<script>
$(function() {
	 $("#date").datepicker();
});

$( "#button" ).button();
$( "#tabs" ).tabs();
$("#tabs").tabs( "option", "active", 0);
</script>
