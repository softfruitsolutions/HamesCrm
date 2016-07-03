<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!-- URL's -->
<c:url value="/leads/view" var="leadCreateViewUrl" />
<c:url value="/leads/datatable" var="leadDatatableurl" />
<c:url value="/leads/list" var="leadListUrl" />
 

<script type="text/javascript">
	
	$(function() {
		$('#leadDatatable').dataTable({
			"bProcessing" : true,
			"bServerSide" : true,
			"bPaginate" : true,
			"sAjaxSource": 'datatable',
			"fnServerParams":function(aoData){
				aoData.push({ "name" : "sortField","value":"firstName"});
				
			},
				"aoColumns": [
				              {mDataProp : 'firstName'},
				              {mDataProp : 'companyName'},
				              {mDataProp : 'mobileNo'},
				              {mDataProp : 'title'},
				              {mDataProp : 'emailId'},
				              {mDataProp : 'leadStatus'},
								
				              	{
				            	  "mData" : 'leadId',
				            		  "bSortable": false,
				                        "mRender": function(data, type, full) {
				                          return " <a href='/hames/leads/view?id="+data + "' data-toggle='tooltip' title='Edit Lead'><i class='fa fa-bars'></i></a> <a href='../client/view?id="+
				                        		  data + "' data-toggle='tooltip' title='Change to Client'><i class='fa fa-bars'></i></a> ";
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
	<div class="col-md-9">
		<div class="panel panel-primary panel-border top">
			<div class="panel-heading">
				<span class="panel-title panel-title hidden-xs"><i class="imoon imoon-drawer2"></i>Leads</span>
			</div>
			<div class="panel-menu">
				<div class="btn-group">
				 <a class="btn btn-info" href="${leadListUrl }" title="Refresh "><i class="fa fa-refresh"></i></a>
					<a class="btn btn-primary" href="${leadCreateViewUrl}" title="Create Lead"><i class="fa fa-edit"></i>Create Leads</a>
				</div>
			</div>
			<div class="panel-body">
				<table id="leadDatatable" class="table table-striped table-hover table-condensed dataTable">
					<thead>
						<tr>
							<th>Lead Namer</th>
							<th>Company Name</th>
							<th>Mobile</th>
							<th>Title</th>
							<th>E_mail</th>
							<th>Lead Status</th>
							<th>Action</th>
						</tr>
					</thead>	
				</table>	
			</div>
		</div>
	</div>
</div>