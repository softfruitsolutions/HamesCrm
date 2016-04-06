<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!-- URL's -->
<c:url value="/potential/view" var="potentialCreateViewUrl"/>
<c:url value="/potential/list" var="potentialListUrl" />
<c:url value="/potential/datatable" var="potentialDataTable"/>

<script type="text/javascript">
		$(function() {
			$('#potentialDatatable').dataTable({
				"bProcessing" : true,
				"bServerSide" : true,
				"bPaginate" : true,
				"sAjaxSource": 'datatable',
				"fnServerParams":function(aoData){
					aoData.push({ "name" : "sortField","value":"potentialId"});
					
				},
					"aoColumns": [
					              {mDataProp : 'leadSource'},
					              {mDataProp : 'potentialName'},
					              {mDataProp : 'status'},
					              {mDataProp : 'quotedAmount'},
					              {mDataProp : 'negotiatedAmount'},
					              {
					            	  "mData":'deliveryDate',
					            	  "bSortable":false,
					            	  "mRender":function(data, type, full){
					            		  return DateUtil.getDate(data);
					            	  },
					              },
					              	{
					            	  "mData" : 'potentialId',
					            		  "bSortable": false,
					                        "mRender": function(data, type, full) {
					                            return "<a href='${potentialCreateViewUrl}?id="+data+"'><i class='fa fa-pencil-square-o'></i></a>";
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
				<span class="panel-title panel-title hidden-xs"><i class="i moon-drawer2"></i>Potential</span>
			</div>
			<div class="panel-menu">
				<shiro:hasPermission name="client:create">
				<div class="btn-group">
				 	<a class="btn btn-info" href="${potentialListUrl }" title="Refresh "><i class="fa fa-refresh"></i></a>
					<a class="btn btn-primary" href="${potentialCreateViewUrl }" title="createPotential"><i class="fa fa-file-text-o"></i>Create Potential</a>
				</div>
				</shiro:hasPermission>
			</div>
			<div class="panel-body">
				<table id="potentialDatatable" class="table table-striped table-hover table-condensed dataTable">
					<thead>
						<tr>
							<td>Potential Owner</td>
							<td>Potential Name</td>
							<td>Status</td>
							<td>Quoted Amount</td>
							<td>Negotiated amount</td>
							<td>Delivery Date</td>
							<td>Action</td>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>
</div>