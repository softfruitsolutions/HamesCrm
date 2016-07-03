<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!-- URL's -->
<c:url value="/client/list" var="clientListUrl" />
	
<script type="text/javascript">
$(function(){
	$('#leadDatatable').dataTable({
		"bProcessing" : true,
		"bServerSide" : true,
		"bPaginate" : true,
		"sAjaxSource":'datatable',
		"fnServerParams":function(aoData){
			aoData.push({
				"name" : "sortField" , "value":"projectId"
			});
		},	
			"aoColumns":[
			             
			             {mDataProp : 'firstName'},
			             {mDataProp : 'lastName'},
			             {mDataProp : 'mobileNo'},
			             {mDataProp : 'projectType'},
			             {mDataProp : 'buildingType'},
			             {mDataProp : 'totalArea'},
			             {mDataProp : 'negotiatedAmount'},
			             {mDataProp : 'completionPeriod'},

			             
			             {
			            	 "mData" : 'leadId',
			            	 "bSortable":false,
			            	 "mRender":function(data,type,full){
			            		 return"<a href='viewEdit?id=" + data + "' data-toggle='tooltip' title='Edit Lead'><i class='fa fa-pencil-square-o'></i></a>";
                       		 
			            	 },
			             }
			             ],
			             "bfilter":false,
			             "aLengthMenu":[[10,20,25,-1],[10,20,30,40]],
			             "iDisplayLength":10
	});
});
	

</script>

<div class="row">
	<div class="col-md-12">
		<div class="panel panel-primary panel-border top">
			<div class="panel-heading">
				<span class="panel-title panel-title hidden-xs"><i class="fa fa-user-plus"></i>Customers</span>
			</div>
			<div class="panel-menu">
				<div class="btn-group">
				 <a class="btn btn-info" href="${clientListUrl }" title="Refresh "><i class="fa fa-refresh"></i></a>
				</div>
			</div>
			<div class="panel-body">
				<table id="leadDatatable"  class="table table-striped table-hover table-condensed dataTable">
					<thead>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Mobile</th>	
							<th>Project Type</th>
							<th>Building Type</th>
							<th>Total Area</th>
							<th>Amount</th>
							<th>Completion Period</th>
							<th>Action</th>
						</tr>
					</thead>	
				</table>	
			</div>
		</div>
	</div>
</div>