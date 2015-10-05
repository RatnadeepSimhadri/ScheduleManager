<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body>


<div class="content">
<div>
<c:if test="${ empty result }">
<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
		<p><span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
		<strong>Please enter shift Details (HH:MM 24HR)</strong> </p>
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

<form:form id="configureShifts" method="post" style="text-align:center; valign:middle" action="configureShifts"> 
 
    <table style="padding-top:20px;" align="center">
    <tr>
				<td style="text-align:center"><form:label class="label" path="day">Day:</form:label></td>
				<td style="text-align:left"><form:select id ="day" path="day">
					  <form:option value="0" label="Select a value" />
					   <form:options items="${days}" itemValue="value" itemLabel="label"/>
				       </form:select>
                </td>
	</tr>
    <tr>
    <td height="10"></td>
    <td height="10"></td>
    </tr>
    <tr>
				<td style="text-align:center"><form:label class="label" path="labId">Lab:</form:label></td>
				<td  style="text-align:left"><form:select id ="labId" path="labId">
					  <form:option value="0" label="Select a value" />
					   <form:options items="${labs}" itemValue="value" itemLabel="label"/>
				       </form:select>
                </td>
	</tr>
	<tr>
    <td height="10"></td>
    <td height="10"></td>
    </tr>
   
    <tr>
    <td colspan="2"><hr style="height:2px;border-width:0;color:gray;background-color:gray"></td>
    </tr>
    <tr>
    <td colspan="2">
    <table style="padding-left:80px;">
    <tr>
    <td colspan="1" style="text-align:left"><form:label class="heading-label" path="shiftone.shiftNo">Shifts</form:label></td>
    <td colspan="1" style="text-align:left"><form:label class="heading-label" path="shiftone.shiftNo">Shift Start Time </form:label></td>
    <td></td>
    <td colspan="1" style="text-align:left"><form:label class="heading-label" path="shiftone.shiftNo">Shift End Time </form:label></td>
    <td></td>
    <td colspan="1" style="text-align:left"><form:label class="heading-label" path="shiftone.shiftNo">Select </form:label></td>
    </tr>
    <tr>
    <td height="5"></td>
    <td height="5"></td>
    </tr>
    <tr>
    <td style="text-align:left"><form:label class="label" path="shiftone.shiftNo">Shift one :</form:label></td>
    <form:hidden path="shiftone.shiftNo" value="1"/>
    <td><form:input path="shiftone.startTime" /></td>
    <td>&nbsp;</td>
    <td><form:input path="shiftone.endTime" /></td>
    <td>&nbsp;</td>
    <td><form:checkbox path="shiftone.selected" /></td>
    </tr>
    <tr>
    <td height="5"></td>
    <td height="5"></td>
    </tr>
    <tr>
    <td style="text-align:left"><form:label class="label" path="shifttwo.shiftNo">Shift Two :</form:label></td>
    <form:hidden path="shifttwo.shiftNo" value="2"/>
    <td><form:input path="shifttwo.startTime" /></td>
    <td>&nbsp;</td>
    <td><form:input path="shifttwo.endTime" /></td>
    <td>&nbsp;</td>
    <td><form:checkbox path="shifttwo.selected" /></td>
    </tr>
    <tr>
    <td height="5"></td>
    <td height="5"></td>
    </tr>
    <tr>
    <td style="text-align:left"><form:label class="label" path="shiftthree.shiftNo">Shift Three :</form:label></td>
    <form:hidden path="shiftthree.shiftNo" value="3"/>
    <td><form:input path="shiftthree.startTime" /></td>
    <td>&nbsp;</td>
    <td><form:input path="shiftthree.endTime" /></td>
    <td>&nbsp;</td>
    <td><form:checkbox path="shiftthree.selected" /></td>
    </tr>
    <tr>
    <td height="5"></td>
    <td height="5"></td>
    </tr>
    <tr>
    <td style="text-align:left"><form:label class="label" path="shiftfour.shiftNo">Shift Four :</form:label></td>
    <form:hidden path="shiftfour.shiftNo" value="4"/>
    <td><form:input path="shiftfour.startTime" /></td>
    <td>&nbsp;</td>
    <td><form:input path="shiftfour.endTime" /></td>
    <td>&nbsp;</td>
    <td><form:checkbox path="shiftfour.selected" /></td>
    </tr>
    <tr>
    <td height="5"></td>
    <td height="5"></td>
    </tr>
    <tr>
    <td style="text-align:left"><form:label class="label" path="shiftfive.shiftNo">Shift Five :</form:label></td>
    <form:hidden path="shiftfive.shiftNo" value="5"/>
    <td><form:input path="shiftfive.startTime" /></td>
    <td>&nbsp;</td>
    <td><form:input path="shiftfive.endTime" /></td>
    <td>&nbsp;</td>
    <td><form:checkbox path="shiftfive.selected" /></td>
    </tr>
    <tr>
    <td height="5"></td>
    <td height="5"></td>
    </tr>
    <tr>
    <td style="text-align:left"><form:label class="label" path="shiftsix.shiftNo">Shift Six :</form:label></td>
    <form:hidden path="shiftsix.shiftNo" value="6"/>
    <td><form:input path="shiftsix.startTime" /></td>
    <td>&nbsp;</td>
    <td><form:input path="shiftsix.endTime" /></td>
    <td>&nbsp;</td>
    <td><form:checkbox path="shiftsix.selected" /></td>
    </tr>
    <!-- Button -->
    <tr>
    <td height="10"></td>
    <td height="10"></td>
    </tr>
    <tr>
        <td colspan="6"style="text-align:center;">
            <input id="button" type="button" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" onclick="configureShifts()" value="Save"/>
        </td>
    </tr>
</table>
</td>
</tr>
</table>  
     
</form:form>
</div>


<script type="text/javascript">
$( "#button" ).button();
$( "#tabs" ).tabs();
$("#labId").selectmenu();
$("#day").selectmenu();
$("#tabs").tabs( "option", "active", 3);

</script>
</body>