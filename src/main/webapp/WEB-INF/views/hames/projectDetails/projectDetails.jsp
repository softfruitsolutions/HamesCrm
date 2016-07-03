<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>

<!-- URL's -->
<c:url value="/project/view" var="projectDetailsViewUrl" />
<c:url value="/project/save" var="projectDetailsSaveUrl" />
<c:url value="/project/list" var="projectDetailsListUrl" />

<script type="text/javascript">


function save(){
	var projectDetails = $('#projectDetails').serialize();
	
	$.ajax({
		type: 'POST',
		url : '${projectDetailsSaveUrl}',
		data: projectDetails,
		async : false,
		success: function(data){
			SuccessAlert.handleSuccess(data);
			setTimeout(function(){
				window.location.href='${projectDetailsListUrl}';
			},1000);
		},
		error:function(data){
			ErrorAlert.handleError(data.responseJSON.message);
		}
	});
}
</script>

<div class="row">
	<div class="col-md-12">
		<div class="panel panel-primary panel-border top">
			<div class="panel-heading">
				<span class="panel-title hidden-xs"><i class="imoon imoon-drawer2"></i>Project Details</span>
				<ul class="nav panel-tabs">
					<li class="active">
						<a href="#tab1" data-toggle="tab">Create</a>
					</li>
					<li class="">
						<a href="#tab2" data-toggle="tab">Audit</a>
					</li>		
				</ul>
			</div>
			<div class="panel-menu">
				<div class="btn-group">
					<a href="${projectDetailsListUrl }" class="btn  btn-info"><i class="fa fa-reply"></i></a>
					<shiro:hasPermission name="project:create">
					 <a class="btn btn-primary" href="${projectDetailsViewUrl }" title="Refresh "><i class="fa fa-refresh"></i></a>
					</shiro:hasPermission>
					<a class="btn btn-success" onclick="save()">
						<i class="glyphicon glyphicon-floppy-save"></i>
						<c:if test="${projectDetails.projectId == null }">
							Save
						</c:if>
						<c:if test="${projectDetails.projectId != null}">
							Update
						</c:if>
					</a>
				</div>
			</div>
			<form:form modelAttribute="projectDetails" method="POST" action="#">
				<div class="panel-body">
					<div class="tab-content">
						<div id="tab1" class="tab-pane active">
							<form:hidden path="projectId" />
							<div class="row">
								<div class="col-md-8">
									<div class="form-group">
										<form:label path="potentialName" cssClass="control-label">Customer Name</form:label>
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-google-wallet"></i></span>
											<form:select path="potentialName" cssClass="form-control">
												<form:options items="${clientName }" itemLabel="firstName" itemValue="firstName"/>
											</form:select>
										</div>
									</div>
								</div>
								<shiro:hasPermission name="project:create">
								<div class="col-md-4">
									<div class="form-group">
										<form:label path="engineer" cssClass="control-label">Handled By</form:label>
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-cog"></i></span>
											<form:select path="engineer" class="form-control">
												<form:options items="${engineer }" itemLabel="text"/>
											</form:select>
										</div>
									</div>
								</div>
								</shiro:hasPermission>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<form:label path="projectName" cssClass="control-label">Project Name</form:label>
										<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-users fa-lg"></i></span>
											<form:input path="projectName" cssClass="form-control" placeholder="Project Name" />
										</div>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<form:label path="date" cssClass="control-label">Date</form:label>
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-calendar fa-lg"></i></span>
											<form:input path="date" cssClass="form-control" placeholder="__/__/____"/>
										</div>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<form:label path="status" class="control-lead">Status</form:label>
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-info-circle fa-lg"></i></span>
											<form:select path="status" class="form-control" >
												<form:options items="${status }"	itemLabel="text"/>	
											</form:select>
										</div>
									</div>
								</div>
							</div>
							<hr />
							
							<div class="panel panel-default">
     							<div class="panel-heading">Payment Details</div>
   								<div class="panel-body">
								<div class="row">
									<div class="col-md-3">
										<div class="form-group">
											<form:label path="advanceAmount" cssClass="control-label">Level 1</form:label>
											<div class="input-group">
												<span class="input-group-addon"><i class="fa fa-inr"></i></span>
												<form:input path="advanceAmount" cssClass="form-control" placeholder="Advance"/>
											</div>
										</div>
									</div>	
									<div class="col-md-3">
										<form:label path="floorLevel" cssClass="control-label">Level 2</form:label>
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-inr"></i></span>
											<form:input path="floorLevel" cssClass="form-control" placeholder="Floor Level"/>
										</div>
									</div>
									<div class="col-md-3">
										<form:label path="mainConcrete" cssClass="control-label" >Level 3</form:label>
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-inr"></i></span>
											<form:input path="mainConcrete" cssClass="form-control" placeholder="Main Concrete"/>
										</div>
									</div>
									<div class="col-md-3">
										<form:label path="plastering" cssClass="control-label">Level 4</form:label>
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-inr"></i></span>
											<form:input path="plastering" cssClass="form-control" placeholder="Plastering"/>
										</div>
									</div>
							</div>		

								</div>
							</div>	
							<hr />	
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<form:label path="description" cssClass="control-label">Project Description</form:label>
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-building"></i></span>
											<form:textarea path="description" cssClass="form-control" placeholder="Project Description"/>
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<form:label path="reminder" cssClass="control-label">Reminder</form:label>
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-file"></i></span>
											<form:textarea path="reminder" cssClass="form-control" placeholder="Reminder"/>	
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<form:label class="control-label" path="remark">Remarks</form:label>
										<form:textarea path="remark" class="form-control" placeholder="Remark"></form:textarea>
									</div>
								</div>
							</div>
						</div>
					<div id="tab2" class="tab-pane">
								<jsp:include page="/WEB-INF/views/hames/audit.jsp" />
					</div>	
					</div>		
				</div>
			</form:form>
		</div>
	</div>
</div>