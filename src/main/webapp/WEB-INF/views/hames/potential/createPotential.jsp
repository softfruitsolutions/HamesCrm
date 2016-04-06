<%@ taglib uri="http://www.springframework.org/tags/form"	prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>

<!-- URL's -->
<c:url value="/potential/list" var="potentialListUrl" />
<c:url value="/potential/view" var="potentialViewUrl" />
<c:url value="/potential/save" var="potentialSaveUrl" />

<script type="text/javascript">
	
	$(function(){
		$('#deliveryDate').mask("99/99/9999");
	})
	
	function save(){
		var potential = $('#potential').serialize();
		
		$.ajax({
			type :'POST',
			url :'${potentialSaveUrl}',
			data : potential,
			async : false,
			success:function(data){
				SuccessAlert.handleSuccess(data);
				setTimeout(function(){
					window.location.href='${potentialListUrl}';
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
				<span class="panel-title panel-title hidden-xs"><i class="imoon imoon-drawer2"></i>Create Potentials</span>
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
					<a href="${potentialListUrl }" class="btn btn-info"><i class="fa fa-reply"></i></a>
					<shiro:hasPermission name="CREATE_CLIENT">
						<a class="btn btn-primary" href="${potentialViewUrl }" title="Refresh "><i class="fa fa-refresh"></i></a>
					</shiro:hasPermission>	
					<a class="btn btn-success" onclick="save()">
					<i class="glyphicon glyphicon-floppy-save"></i>
					<c:if test = "${potential.potentialId == null}">
						Save
					</c:if>
					<c:if test="${potential.potentialId != null }">
						Update
					</c:if> </a>
					
				</div>
			</div>
			<form:form modelAttribute="potential" method="POST" action="#">
				<div class="panel-body">
					<div class="tab-content">
						<div id="tab1" class="tab-pane active">
							<form:hidden path="potentialId"></form:hidden>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<form:label path="leadSource" cssClass="control-lead">Lead Name</form:label>
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-user fa-lg"></i></span>
												<form:select path="leadSource" cssClass="form-control">
													<form:options items="${leads}" itemLabel="firstName" itemValue="firstName"/>
												</form:select>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-4">
									<div class="form-group">
										<form:label path="potentialName" cssClass="control-lead">Potential Name</form:label>
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-user fa-lg"></i></span>
											<form:input path="potentialName" cssClass="form-control" placeholder="Potential Name"></form:input>
										</div>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<form:label path="status" cssClass="control-lead">Status</form:label>
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-info-circle fa-lg"></i></span>
											<form:select path="status" cssClass="form-control">
												<form:options items="${status}" itemLabel="text"/>
											</form:select>	 
										</div>	
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<form:label path="currentDate" cssClass="control-lead">Current Date</form:label>
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-calendar fa-lg"></i></span>
											<form:input path="currentDate" cssClass="form-control" placeholder="__/__/____" />
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-4">
									<div class="form-group">
										<form:label path="quotedAmount" cssClass="control-label">Quoted Amount</form:label>
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-inr fa-lg"></i></span>
											<form:input path="quotedAmount" cssClass="form-control" placeholder="Quoted Amount"></form:input>
										</div>	
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<form:label path="negotiatedAmount" cssClass="control-label">Negotiated Amount</form:label>
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-inr fa-lg"></i></span>
											<form:input path="negotiatedAmount" cssClass="form-control" placeholder="Negotiated Amount"></form:input>
										</div>
									</div> 
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<form:label path="deliveryDate" cssClass="control-label">Delivery Date</form:label>
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-calendar fa-lg"></i></span>
											<form:input path="deliveryDate" cssClass="form-control"  type="text"></form:input>
										</div>
									</div>
								</div>
							</div>
							<hr />
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<form:label path="description">Description/Remarks</form:label>
										<form:textarea path="description" class="form-control" placeholder="Description/Remarks"></form:textarea>
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