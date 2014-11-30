<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body>


<div class="content">
<div>
<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
		<p><span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
		<strong>Please assign shifts for the day</strong> </p>
	</div>
</div>

<form:form id="saveShifts" method="post" style="text-align:center; valign:middle" action="saveShifts"> 
 
    <table style="padding-top:20px;" align="center">
    <tr>
    <th>Employees</th>
    <c:forEach varStatus="shift" begin="1" end="${shifts}">
    <th>Shift <c:out value="${shift.count}"/></th>
    </c:forEach>
    </tr>
    
    <c:forEach varStatus="now" begin="1" end="${noofworkers}">
    <tr>
    <td> Employee <c:out value="${now.count}"/></td>
    <c:forEach varStatus="shift" begin="1" end="${shifts}">
    <td><select class="selectMenu" id ="employee_${now.count}shift_${shift.count}">
    	<option value="NONE">Please Select</option>
    	<c:if test="${ not empty employees}">
	<c:forEach items="${employees}" var="employee">
  		<option value="${employee}">${employee}</option>
    </c:forEach>
    </c:if>
	</select>
	</td>
    </c:forEach>
    </tr>
    </c:forEach>
    
    <tr>
    <td height="10"></td>
    <td height="10"></td>
   	</tr>
    <!-- Button -->
    <tr>
        <td colspan="${shifts+1}"style="text-align:center;">
            <input id="button" type="button" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" onclick="saveShifts()" value="Save"/>
        </td>
    </tr>
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