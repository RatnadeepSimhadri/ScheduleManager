<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body>


<div class="content">
<div>
<c:if test="${ empty result }">
<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
		<p><span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
		<strong>Please assign shifts for the day</strong> </p>
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
<input id=size type="hidden" value="${size}"></input>

<form:form id="saveShifts" method="post" style="text-align:center; valign:middle" action="saveShifts"> 
 
 <form:hidden path="date"/>
 <form:hidden path="lab"/>
    <table style="padding-top:20px;" align="center">
    <tr>
    <c:if test="${ empty result }">
    <th>Employees</th>
    </c:if>
    <c:forEach varStatus="shiftcount" var="shift" items="${shifts}">
    <th>Shift <c:out value="${shift.shiftNo}"/> (<c:out value="${shift.startTime}"/> to <c:out value="${shift.endTime}"/>)</th>
    </c:forEach>
    </tr>
    
    <tr>
    <c:if test="${ empty result }">
    <td>Employee :</td>
    </c:if>
    <c:forEach varStatus="shiftcount" items="${shifts}">
    <td><select class="selectMenu" id ="employee_${shiftcount.count}shift_${shiftcount.count}">
    	<option value="0">Please Select</option>
    	<c:if test="${ not empty employees}">
	<c:forEach items="${employees}" var="employee">
  		<option value="${employee.value}">${employee.label}</option>
    </c:forEach>
    </c:if>
	</select>
	</td>
    </c:forEach>
    </tr>
    
    
    <tr>
    <td height="10"></td>
    <td height="10"></td>
   	</tr>
   	<c:if test="${ empty result }">
    <!-- Button -->
    <tr>
        <td colspan="${size+1}"style="text-align:center;">
            <input id="button" type="button" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" onclick="saveShifts()" value="Save"/>
        </td>
    </tr>
    </c:if>
</table>  
     
</form:form>
</div>


<script type="text/javascript">
$("#button" ).button();
$(".selectMenu").selectmenu();
$( "#tabs" ).tabs();
$("#tabs").tabs( "option", "active", 1);
</script>
</body>