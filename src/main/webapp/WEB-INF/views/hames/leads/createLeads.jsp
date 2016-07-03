<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
	
<!-- URL's -->	
<c:url value="/leads/save" var="leadSaveUrl" />
<c:url value="/leads/view" var="leadViewUrl" />
<c:url value="/leads/list" var="leadListUrl" />

<script type="text/javascript">

	function save(){
		var newLead = $('#newLead').serialize();
		$.ajax({
			type:'POST',
			url:'${leadSaveUrl}',
			data:newLead,
			async:false,
			success:function(data){
				SuccessAlert.handleSuccess(data);
				setTimeout(function(){
					window.location.href='${leadListUrl}';
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
				<span class="panel-title panel-title hidden-xs"><i class="imoon imoon-drawer2"></i>Create Leads</span>
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
								Save
							</c:if>	
							<c:if test ="${newLead.leadId != null }">
								Update
							</c:if>	</a>
				</div>
			</div>
			<form:form modelAttribute="newLead" method="POST" action="#">
				<div class="panel-body">
					<div class="tab-content">
						<div id="tab1" class="tab-pane active">
							<form:hidden path="leadId" />
							<div class="row">
									<div class="col-md-8">
										<div class="form-group">
											<label path="leadNo" class="col-lg-3 control-label">Lead ID</label>
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
									<div class="col-md-6">
										<div class="form-group">
											<form:label path="companyName" cssClass="control-label">Company</form:label>
											<form:input path="companyName" cssClass="form-control input-sm" placeholder="Company"></form:input>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<form:label path="title" cssClass="control-label">Title</form:label>
											<form:input path="title" cssClass="form-control input-sm" placeholder="Title"></form:input>
										</div>
									</div>
							</div>
							<div class="row">
									<div class="col-md-3">
										<div class="form-group">
											<form:label path="phoneNo" cssClass="control-label">Phone No</form:label>
											<div class="input-group">
												<span class="input-group-addon"><i class="fa fa-phone fa-lg"></i></span>
												<form:input path="phoneNo" cssClass="form-control " placeholder="Phone"></form:input>
											</div>
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<form:label path="mobileNo" cssClass="control-label">Mobile No</form:label>
											<div class="input-group">
												<span class="input-group-addon"><i class="fa fa-mobile fa-lg"></i></span>
												<form:input path="mobileNo" class="form-control" placeholder="Mobile No" ></form:input>
											</div>
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<form:label cssClass="control-label" path="emailId">E-mail</form:label>
											<div class="input-group">
												<span class="input-group-addon">@</span>
												<form:input path="emailId" cssClass="form-control" placeholder="Email Addres"></form:input>
											</div> 
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<form:label cssClass="control-label" path="website">Website</form:label>
											<div class="input-group">
												<span class="input-group-addon"><i class="fa fa-cloud fa-lg"></i></span>
												<form:input path="website" cssClass="form-control" placeholder="Website"></form:input>
											</div>
										</div>
									</div>
									
							</div>
							<div class="row">
									<div class="col-md-6">	
										<div class="form-group">
											<form:label path="LeadSource" cssClass="control-label">Lead Source</form:label>
											<form:input path="leadSource" cssClass="form-control input-sm" placeholder="Lead Source"/>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<form:label cssClass="control-label" path="leadStatus">Lead Status</form:label>
											<form:select path="leadStatus" cssClass="form-control input-sm">
												<form:options items="${leadStatus}" itemLabel="text"/>
											</form:select> 
										</div>
									</div>
							</div>
							<div class="row">
									<div class="col-md-4">	
										<div class="form-group">
											<form:label path="industry" cssClass="control-label">Industry</form:label>
											<form:input path="industry" cssClass="form-control input-sm" placeholder="Industry"></form:input>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<form:label path="annualRevenue" cssClass="control-label">Annual Revenue</form:label>
											<form:input path="annualRevenue" cssClass="form-control input-sm" placeholder="Annual Revenue"></form:input>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<form:label path="noOfEmployees" cssClass="control-label">No Of Employees</form:label>
											<form:input path="noOfEmployees" cssClass="form-control input-sm" placeholder="No Of Employees"></form:input>
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
