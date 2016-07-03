<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
	
<!-- URL's -->	
<c:url value="/client/save" var="clientSaveUrl" />
<c:url value="/client/list" var="clientListUrl" />

<script type="text/javascript">

	function save(){
		var newLead = $('#newclient').serialize();
		$.ajax({
			type:'POST',
			url:'${clientSaveUrl}',
			data:newLead,
			async:false,
			success:function(data){
				SuccessAlert.handleSuccess(data);
				setTimeout(function(){
					window.location.href='${clientListUrl}';
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
				<span class="panel-title panel-title hidden-xs"><i class="imoon imoon-drawer2"></i>Update To Client</span>
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
					<a href="${leadViewUrl }" class="btn btn-info"><i class="fa fa-reply"></i></a>
					<a class="btn btn-primary" href="${leadViewUrl }" title="Refresh "><i class="fa fa-refresh"></i></a>
						<a class="btn btn-success" onclick="save()">
							<i class="glyphicon glyphicon-floppy-save"></i>
							<c:if test ="${newLead.leadId==null }">
								SAVE
							</c:if>	
							<c:if test ="${newLead.leadId != null }">
								UPDATE
							</c:if>	</a>
				</div>
			</div>
			<form:form modelAttribute="newclient" method="POST" action="#">
				<div class="panel-body">
					<div class="tab-content">
						<div id="tab1" class="tab-pane active">
							<form:hidden path="leadId" />
							<div class="row">
									<div class="col-md-8">
										<div class="form-group">
											<label path="leadNo" class="col-lg-3 control-label">Lead ID potential</label>
											<form:input path="leadNo" class="form-control input-sm" placeholder="Lead Id" readonly="true"></form:input>
										</div>
									</div>	
									
							</div> 
							<div class="row">	
									<div class="col-md-4">
										<div class="form-group">
											<form:label path="firstName" cssClass="col-lg-3 control-label">First Name</form:label>
											<form:input path="firstName" cssClass="form-control input-sm" placeholder="First Name"></form:input>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<form:label path="middleName" cssClass="control-label">Middle Name</form:label>
											<form:input path="middleName" cssClass="form-control input-sm" placeholder="Middle Name"></form:input>
										</div> 
									</div>	
									<div class="col-md-4">
										<div class="form-group">
											<form:label path="lastName" cssClass="control-label">Last Name</form:label>
											<form:input path="lastName" cssClass="form-control input-sm" placeholder="Last Name"></form:input>
										</div>
									</div>	
							</div>
							<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<form:label path="phoneNo" cssClass="control-label">Phone No</form:label>
											<div class="input-group">
												<span class="input-group-addon"><i class="fa fa-phone fa-lg"></i></span>
												<form:input path="phoneNo" cssClass="form-control " placeholder="Phone"></form:input>
											</div>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<form:label path="mobileNo" cssClass="control-label">Mobile No</form:label>
											<div class="input-group">
												<span class="input-group-addon"><i class="fa fa-mobile fa-lg"></i></span>
												<form:input path="mobileNo" class="form-control" placeholder="Mobile No" ></form:input>
											</div>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<form:label cssClass="control-label" path="emailId">E-mail</form:label>
											<div class="input-group">
												<span class="input-group-addon">@</span>
												<form:input path="emailId" cssClass="form-control" placeholder="Email Addres"></form:input>
											</div> 
										</div>
									</div>
							</div>
							<hr />
							<div class="row">
								<div class="col-md-3">
										<div class="form-group">
											<form:label path="projectType" cssClass="control-label">Project Type</form:label>
											<form:input path="projectType" cssClass="form-control input-sm" placeholder="Project Type"/>
										</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<form:label path="buildingType" cssClass="control-label" >Building Type</form:label>
										<form:input path="buildingType" cssClass="form-control input-sm" placeholder="Building Type"/>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<form:label path="totalArea" cssClass="control-label">Total Square Feet</form:label>
										<form:input path="totalArea" cssClass="form-control input-sm" placeholder="Total Area"/>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<form:label path="floorType" cssClass="control-label">Floor Type</form:label>
										<form:input path="floorType" cssClass="form-control input-sm" placeholder="Floor Type"/>
									</div>
								</div>
								<div class="col-md-12">
									<div class="form-group">
										<form:label path="notes" cssClass="cotrol-label">Notes</form:label>
										<form:textarea path="notes" cssClass="form-control input-sm" placeholder="Notes"/>
									</div>
								</div>
							</div>
						<hr />
							<div class="row">
								<div class="col-md-4">
									<div class="form-group">
										<form:label path="quotedAmount" cssClass="control-label">Quoted Amount</form:label>
										<form:input path="quotedAmount" cssClass="form-control input-sm" placeholder="Quoted Amount"/>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<form:label path="negotiatedAmount" cssClass="control-label">Negotiated Amount</form:label>
										<form:input path="negotiatedAmount" cssClass="form-control input-sm" placeholder="Negotiated Amount"/>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<form:label path="completionPeriod" cssClass="control-label">Completion Period</form:label>
										<form:input path="completionPeriod" cssClass="form-control input-sm" placeholder="Completion Period"/>
									</div>
								</div>
							</div>
							
							<hr />
							<div class="row">
								<div class="col-md-6">
									<div class=form-group>
										<form:label cssClass="control-label" path="address">Address</form:label>
										<form:textarea path="address" cssClass="form-control" placeholder="Address"></form:textarea>
									</div>
								</div>							
								<div class="col-md-6">
									<div class="form-group">
										<form:label cssClass="control-label" path="description">Description/Remarks</form:label>
										<form:textarea path="description" cssClass="form-control" placeholder="Description/Remarks"></form:textarea>
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
