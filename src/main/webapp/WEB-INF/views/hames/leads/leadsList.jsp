<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
				                            return "<a href='view?id="+data+"'><i class='fa fa-pencil-square-o'></i></a>";
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



<!-- 
<div class="col-lg-6">
								<div class="panel panel-default">	
									<div class="panel-heading clearfix">
										<span class="pull-left">Feeds</span>
										<ul class="tool-bar">
											<li><a href="#" class="refresh-widget" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="Refresh"><i class="fa fa-refresh"></i></a></li>
											<li><a href="#feedList" data-toggle="collapse"><i class="fa fa-arrows-v"></i></a></li>
										</ul>
									</div>		
									<ul class="list-group collapse in" id="feedList">
										<li class="list-group-item clearfix">
											<div class="activity-icon small">
												<i class="fa fa-camera"></i>
											</div>
											<div class="pull-left m-left-sm">
												<span>John Doe Add a new photo.</span><br/>
												<small class="text-muted"><i class="fa fa-clock-o"></i> 2m ago</small>
											</div>
										</li>
										<li class="list-group-item clearfix">
											<div class="activity-icon bg-success small">
												<i class="fa fa-usd"></i>
											</div>
											<div class="pull-left m-left-sm">
												<span>2 items sold.</span><br/>
												<small class="text-muted"><i class="fa fa-clock-o"></i> 30m ago</small>
											</div>	
										</li>
										<li class="list-group-item clearfix">
											<div class="activity-icon bg-info small">
												<i class="fa fa-comment"></i>
											</div>
											<div class="pull-left m-left-sm">
												<span>John Doe commented on <a href="#">This Article</a></span><br/>
												<small class="text-muted"><i class="fa fa-clock-o"></i> 1hr ago</small>
											</div>
										</li>
										<li class="list-group-item clearfix">
											<div class="activity-icon bg-success small">
												<i class="fa fa-usd"></i>
											</div>
											<div class="pull-left m-left-sm">
												<span>3 items sold.</span><br/>
												<small class="text-muted"><i class="fa fa-clock-o"></i> 2days ago</small>
											</div>	
										</li>
									</ul>/list-group	
									<div class="loading-overlay">
										<i class="loading-icon fa fa-refresh fa-spin fa-lg"></i>
									</div> -->
								</div><!-- /panel -->
							</div><!-- /.col -->
						</div><!-- ./row -->
					</div><!-- /.col -->


