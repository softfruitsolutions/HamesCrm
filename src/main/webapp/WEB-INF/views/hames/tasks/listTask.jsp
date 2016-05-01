<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!-- URL's -->
<c:url value="/task/view" var="taskCreateViewUrl" />
<c:url value="/task/potTask" var="taskCreatePotUrl"></c:url>
<c:url value="/task/leadTask" var="taslCreateLeadUrl"></c:url>
<c:url value="/task/datatable" var="taskDatatableUrl" />
<c:url value="/task/list" var="taskListUrl" />

<script type="text/javascript">
$(function() {
	$('#taskDataTableLead').dataTable({
		"bProcessing" : true,
		"bServerSide" : true,
		"bPaginate"	  : true,
		"sAjaxSource" :	'datatable',
		"fnServerParams" : function( aoData ) {
			aoData.push({ "name" : "sortField","value":"taskOwner"});
			aoData.push({"name": "leadName", "value": "leadName"});
		},
			"aoColumns": [
			              	{ mDataProp: 'taskOwnerText'},
			              	{ mDataProp: 'subject'},
			              	{ "mData": 'taskDate',
			              		"bSortable":false,
			              		"mRender":function(data,type,full){
			              			return DateUtil.getDate(data);
			              		},
			              	},
			              	{ mDataProp: 'status'},
			              	{ mDataProp: 'leadName'},
			              	
			              	{ 
			              		"mData": 'taskId',
			              		"bSortable": false,
			              		"mRender":function(data,type,full){
			              			 return "<a href='leadTask?id="+data+"'><i class='fa fa-pencil-square-o'></i></a>";
			              		},
			              	}
			              ],
			"bFilter":false,
			"aLengthMenu":[[10,25,30,-1],[10,25,30,50]],
			"iDisplayLength":10
	});
});

/**
 * Listing values for potential
 */

$(function() {
	$('#taskDataTablePotential').dataTable({
		"bProcessing" : true,
		"bServerSide" : true,
		"bPaginate"	  : true,
		"sAjaxSource" :	'datatable',
		"fnServerParams" : function( aoData ) {
			aoData.push({ "name" : "sortField","value":"potentialName"});
		},
			"aoColumns": [
			              	{ mDataProp: 'taskOwnerText'},
			              	{ mDataProp: 'subject'},
			              	{ "mData": 'taskDate',
			              		"bSortable":false,
			              		"mRender":function(data,type,full){
			              			return DateUtil.getDate(data);
			              		},
			              	},
			              	{ mDataProp: 'status'},
			              	{ mDataProp:'potentialName'},
			              	
			              	{ 
			              		"mData": 'taskId',
			              		"bSortable": false,
			              		"mRender":function(data,type,full){
			              			 return "<a href='potTask?id="+data+"'><i class='fa fa-pencil-square-o'></i></a>";
			              		},
			              	}
			              ],
			"bFilter":false,
			"aLengthMenu":[[10,25,30,-1],[10,25,30,50]],
			"iDisplayLength":10
	});
});
</script>

<div class="row">
	<div class="col-md-9">
		<div class="panel panel-primary panel-border top">
			<div class="panel-heading">
				<span class="panel-title panel-title hidden-xs"><i class="i moon-drawer2"></i>LEAD-Task List</span>
			</div>
			<div class="panel-menu">
				<shiro:hasPermission name="task:create">
				<div class="btn-group">
					<a class="btn btn-info" href="${taskListUrl }" title="Refresh "><i class="fa fa-refresh"></i></a>
					<a class="btn btn-primary" href="${taslCreateLeadUrl}" title="createTasks"><i class="fa fa-edit"></i>Create Task</a> 
				</div>
				</shiro:hasPermission>
			</div>
			<div class="panel-body">
				<table id="taskDataTableLead" class="table table-striped table-hover table-condensed dataTable">
					<thead>
						<tr>
							<th>Task Owner</th>
							<th>Subject</th>
							<th>Task Date</th>
							<th>Status</th>
							<th>Lead Name </th>
							<th>Actions</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>
</div>


<div class="row">
	<div class="col-md-9">
		<div class="panel panel-primary panel-border top">
			<div class="panel-heading">
				<span class="panel-title panel-title hidden-xs"><i class="i moon-drawer2"></i>CLIENTS-Task List</span>
			</div>
			<div class="panel-menu">
			<shiro:hasPermission name="task:create">
				<div class="btn-group">
					<a class="btn btn-info" href="${taskListUrl }" title="Refresh "><i class="fa fa-refresh"></i></a>
					<a class="btn btn-primary" href="${taskCreatePotUrl}" title="createTasks"><i class="fa fa-edit"></i>Create Task</a> 
				</div>
			</shiro:hasPermission>	
			</div>
			<div class="panel-body">
				<table id="taskDataTablePotential" class="table table-striped table-hover table-condensed dataTable">
					<thead>
						<tr>
							<th>Task Owner</th>
							<th>Subject</th>
							<th>Task Date</th>
							<th>Status</th>
							<th>Potential Name</th>
							<th>Actions</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>
</div>