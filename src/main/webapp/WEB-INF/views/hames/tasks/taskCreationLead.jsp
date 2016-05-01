<%@ taglib uri="http://www.springframework.org/tags/form"	prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>


<c:url value="/task/list" var="taskListUrl" />
<c:url value="/task/leadTask" var="taskViewUrl" />
<c:url value="/task/save" var="taskSaveUrl" />


<script type="text/javascript">
	
	$(function(){
		$('#taskDate').mask("99/99/9999");
	})
	
	function save(){
		var task = $('#task').serialize();
		
		$.ajax({
			type :'POST',
			url :'${taskSaveUrl}',
			data : task,
			async : false,
			success:function(data){
				SuccessAlert.handleSuccess(data);
				setTimeout(function(){
					window.location.href='${taskListUrl}';
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
				<span class="panel-title panel-title hidden-xs"><i class="imoon imoon-drawer2"></i>Create Task</span>
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
					<a href="${taskListUrl }" class="btn btn-info"><i class="fa fa-reply"></i></a>
					<shiro:hasPermission name="task:create">
						<a class="btn btn-primary" href="${taskViewUrl }" title="Refresh "><i class="fa fa-refresh"></i></a>
					</shiro:hasPermission>
					<a class="btn btn-success" onclick="save()"> 
					<i class="glyphicon glyphicon-floppy-save"></i>
						<c:if test="${task.taskId == null }">
							Save
						</c:if>
						<c:if test="${task.taskId != null }">
							Update
						</c:if></a>
				</div>
			</div>
			<form:form modelAttribute="task" method="POST" action="#">
				<div class="panel-body">
					<div class="tab-content">
						<div id="tab1" class="tab-pane active">
						<form:hidden path="taskId" />
							<div class="row">	
								<div class="col-md-6">
									<div class="form-group">
										<form:label path="taskOwner" cssClass="control-lead">Task ID</form:label>
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-user fa-lg"></i></span>
											<form:input path="leadId" cssClass="form-control" readonly="true"/>
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<form:label path="taskOwner" cssClass="control-lead">Task Owner</form:label>
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-user fa-lg"></i></span>
											<form:select path="taskOwner" class="form-control">
												<form:options items="${staffs }" itemLabel="fullName" itemValue="staffId"/>
											</form:select>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-4">
									<div class="form-group">
										<form:label path="leadName" cssClass="control-lead">Lead Name</form:label>
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-user"></i></span>
											<form:select path="leadName" cssClass="form-control">
												<form:options items="${leads }" itemLabel="firstName" itemValue="firstName"/>
											</form:select>
										</div>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<form:label path="eventName" cssClass="control-lead">Task Name</form:label>
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-commenting"></i></span>
											<form:input path="eventName" cssClass="form-control" placeholder="Task Name"/>
										</div>
									</div>
								</div> 
								<div class="col-md-4">
									<div class="form-group">
										<form:label path="currentDate" cssClass="control-lead">Current Date</form:label>
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
											<form:input path="currentDate" cssClass="form-control" />
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-4">
									<div class="form-group">
										<form:label path="subject" cssClass="control-lead">Subject</form:label>
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-desktop"></i></span>
											<form:input path="subject" cssClass="form-control" placeholder="Subject"/>
										</div>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<form:label path="status" cssClass="control-lead">Status</form:label>
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-bars"></i></span>
											<form:select path="status" cssClass="form-control" placeholder="Status">
												<form:options items="${status}" itemLabel="text"/> 
											</form:select>	
										</div>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<form:label path="taskDate" cssClass="control-lead">Task Date</form:label>
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
											<form:input path="taskDate" cssClass="form-control" />
										</div>
									</div>
								</div>
							</div>
							<hr />
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<form:label path="remark" cssClass="control-lead">Description/Remarks</form:label>
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-pencil-square-o fa-lg"></i></span>
											<form:textarea path="remark" cssClass="form-control" />
										</div>
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

