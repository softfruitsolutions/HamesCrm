<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!-- URL's -->
<c:url value="/project/view" var="prjctDtlVwUrl" />
<c:url value="/project/list" var="prjctDtllstUrl" />

<script type="text/javascript">
	$(function(){
		$('#prjctDtlsTbl').dataTable({
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
				             {mDataProp : 'potentialName'},
				             {mDataProp : 'projectName'},
				             {mDataProp : 'engineer'},
				             {mDataProp : 'status'},
				             
				             {mDataProp : 'advanceAmount'},
				             {mDataProp : 'floorLevel'},
				             {mDataProp : 'mainConcrete'},
				             {mDataProp : 'plastering'},
				             {
				            	  "mData":'date',
				            	  "bSortable":false,
				            	  "mRender":function(data, type, full){
				            		  return DateUtil.getDate(data);
				            	  },
				             },
				             
				             {
				            	 "mData" : 'projectId',
				            	 "bSortable":false,
				            	 "mRender":function(data,type,full){
				            		 return"<a href='view?id=" + data + "'><i class='fa fa-pencil-square-o'></i></a>";
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
				<span class="panel-title panel-title hidden-xs"><i class="i moon-drawer2"></i>Project Details</span>
			</div>
			<div class="panel-menu">
				<shiro:hasPermission name="project:create">
				<div class="btn-group">
				 <a class="btn btn-info" href="${prjctDtllstUrl }" title="Refresh "><i class="fa fa-refresh"></i></a>
					<a class="btn btn-primary" href="${prjctDtlVwUrl}" title="createProjectDetails"><i class="fa fa-file-text-o"></i>New Project</a>
				</div>
				</shiro:hasPermission>
			</div>
			<div class="panel-body">
				<table id="prjctDtlsTbl" class="table table-striped table-hover table-condensed dataTable">
					<thead>
						<tr>
							<td>Potential Name </td>
							<td>Project Name </td>
							<td>Handled By</td>
							<td>Status</td>
							<td>Advance Amount</td>
							<td>Floor Level</td>
							<td>Main Concrete</td>
							<td>Plastering</td>
							<td>Date</td>
							<td>Action</td>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>
</div>
