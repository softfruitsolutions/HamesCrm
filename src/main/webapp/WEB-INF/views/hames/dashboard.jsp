<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">
$(function(){
	var currentUser = $('#userCount').text();
	$({numberValue: 0}).animate({numberValue: currentUser}, {
		duration: 2500,
		easing: 'linear',
		step: function() { 
			$('#userCount').text(Math.ceil(this.numberValue)); 
		}
	});
});

$(function(){
	var currentUser = $('#userCountPotential').text();
	$({numberValue: 0}).animate({numberValue: currentUser}, {
		duration: 2500,
		easing: 'linear',
		step: function() { 
			$('#userCountPotential').text(Math.ceil(this.numberValue)); 
		}
	});
});

/**
 * Table for project
 */
$(function() {
	$('#projectReviewTable').dataTable({
		"bProcessing" : true,
		"bServerSide" : true,
		"bPaginate"	  : false,
		"sAjaxSource" :	'project/dashboardDatatable',
		"fnServerParams" : function( aoData ) {
			aoData.push({ "name" : "sortField","value":"projectId"});
		},
			"aoColumns": [
			              	{mDataProp : 'potentialName'},
			              	{ mDataProp: 'projectName'},
			              	{ "mData": 'date',
			              		"bSortable":false,
			              		"mRender":function(data,type,full){
			              			return DateUtil.getDate(data);
			              		},
			              	},
			              	{ mDataProp: 'status'},
			             
			              ],
			"bFilter":false,
			"aLengthMenu":[[10,25,30,-1],[10,25,30,50]],
			"iDisplayLength":10
	});
});

/**
 * Table for task potential
 */
 $(function() {
		$('#taskListPotential').dataTable({
			"bProcessing" : true,
			"bServerSide" : true,
			"bPaginate"	  : false,
			"sAjaxSource" :	'task/dashboardDatatable',
			"fnServerParams" : function( aoData ) {
				aoData.push({ "name" : "sortField","value":"potentialName"});
			},
				"aoColumns": [
				              	{ mDataProp: 'subject'},
				              	{ "mData": 'taskDate',
				              		"bSortable":false,
				              		"mRender":function(data,type,full){
				              			return DateUtil.getDate(data);
				              		},
				              	},
				              	{ mDataProp: 'status'},
				              ],
				"bFilter":false,
				"aLengthMenu":[[10,25,30,-1],[10,25,30,50]],
				"iDisplayLength":10
		});
	});
 
</script>


<div class="row">
	<div class="col-sm-3">
		<div class="bs-component">
			<div class="panel panel-tile text-primary br-b bw5 br-primary-light">
			  <div class="panel-body pl20 p5">
			    <i class="icon-users icon-bg"></i>
			    <h2 class="mt20 lh20" id="userCount">
			      <b><c:out value="${leadCount}" /></b>
			    </h2>
			    <h5 class="text-muted">LEADS</h5>
			  </div>
			</div>
		</div>	
	</div>
	<div class="col-sm-3">
		<div class="bs-component">
			<div class="panel panel-tile text-primary br-b bw5 br-primary-light">
				<div class="panel-body pl20 p5">
					<i class="icon-users icon-bg"></i>
					<h2 class="mt20 lh20" id="userCountPotential">
						<b><c:out value="${potentialCount }" /></b>
					</h2>
					<h5 class="text-muted">CLIENTS</h5>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-sm-6">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<i class="glyphicon glyphicon-wrench"></i>
				Project Progress
				<span class="badge badge-info">	
					${projectDeatailsCount}
				</span>
			</div>
		<div class="panel-body">
			<table class="table table-striped table-hover table-condensed dataTable" id="projectReviewTable">
				<thead>
					<tr>
						<th>Potential Name</th>
						<th>Project Name</th>
						<th>Delivery Date</th>
						<th>Status</th>
					</tr>
				</thead> 
			</table>
			</div>
		</div>
	</div>
	
	<div class="col-sm-6">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<i class="glyphicon glyphicon-th"></i>
				TASK REMINDER CLIENT
				<span class="badge badge-info">	
				</span>
			</div>
		<div class="panel-body">
			<table class="table table-striped table-hover table-condensed dataTable" id="taskListPotential">
				<thead>
					<tr>
						<th>Subject</th>
						<th>Date</th>
						<th>Status</th>
					</tr>
				</thead> 
			</table>
			</div>
		</div>
	</div>
	
 </div> 
