<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>

<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->

<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<title>阳阳科技 | 用户管理</title>
	<%@ include file="/WEB-INF/page/include/META.jsp"%>

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class="page-header-fixed page-quick-sidebar-over-content">

	<!-- BEGIN HEADER -->
	<%@ include file="/WEB-INF/page/include/HEADER.jsp"%>
	<!-- END HEADER -->
	<!-- BEGIN CONTAINER -->
	<div class="page-container">
	<!-- BEGIN SIDEBAR -->
	<%@ include file="/WEB-INF/page/include/SIDEBAR.jsp"%>
	<!-- END SIDEBAR -->
	
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">
			<%@ include file="/WEB-INF/page/include/SETTING.jsp"%>
			<!-- BEGIN PAGE HEADER-->
			<h3 class="page-title">
			权限模块 <small>管理登录用户</small>
			</h3>
			<div class="page-bar">
				<ul class="page-breadcrumb">
					<li>
						<i class="fa fa-home"></i>
						<a href="${ctx }/home">控制台</a>
						<i class="fa fa-angle-right"></i>
					</li>
					<li>
						<a href="#">系统管理</a>
						<i class="fa fa-angle-right"></i>
					</li>
					<li>
						<a href="#">用户模块</a>
					</li>
				</ul>
				
			</div>
			<!-- END PAGE HEADER-->
			<!-- BEGIN PAGE CONTENT-->
			<div class="portlet-body form">
										<!-- BEGIN FORM-->
										<form  class="form-horizontal" action="${ctx }/user/save" method="post" id="validateSubmitForm">
											<div class="form-body">
												<h3 class="form-section">用户信息<label class="error">${error }</label></h3>
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">登录账号</label>
															<div class="col-md-9">
																<input type="text" class="form-control" id="username" name="username" >
																
															</div>
														</div>
													</div>
													
												</div>
												<!--/row-->
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">姓名</label>
															<div class="col-md-9">
																<input type="text" class="form-control" id="name" name="name" >
																
															</div>
														</div>
													</div>
													
												</div>
												<!--/row-->
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">工号</label>
															<div class="col-md-9">
																<input type="text" class="form-control" id="no" name="no" >
																
															</div>
														</div>
													</div>
													
												</div>
												<!--/row-->
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">密码</label>
															<div class="col-md-9">
																<input type="password" class="form-control" id="password" name="password">
															</div>
														</div>
													</div>
													<!--/span-->

												
											     </div>
											     
											     	<!--/row-->
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">确认密码</label>
															<div class="col-md-9">
																<input type="password" class="form-control" id="confirm_password" name="confirm_password">
															</div>
														</div>
													</div>
													<!--/span-->

												
											     </div>
											     
											     <!--/row-->
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">电子邮箱</label>
															<div class="col-md-9">
																<input type="text" class="form-control" id="email" name="email">
															</div>
														</div>
													</div>
													<!--/span-->

												
											     </div>
											     
											      <!--/row-->
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">角色权限</label>
															<div class="col-md-9">
															     <c:forEach items="${roles }" var="entity">
															       <label class="checked-label">
																		<input name="roles" type="checkbox"  value="${entity.value }"/>
																		<span class="lbl">${entity.name }</span>
																   </label>
															    </c:forEach>
																
															</div>
														</div>
													</div>
													<!--/span-->

												
											     </div>
											     
											<div class="form-actions">
												<div class="row">
													<div class="col-md-6">
														<div class="row">
															<div class="col-md-offset-3 col-md-9">
																<button type="submit" class="btn green">确认</button>
																<button type="button" class="btn default" onclick="history.go(-1)">取消</button>
															</div>
														</div>
													</div>
													<div class="col-md-6">
													</div>
												</div>
											</div>
										</form>
										<!-- END FORM-->
									</div>
		</div>
	</div>
</div>
<!-- END CONTAINER -->

	<!-- BEGIN FOOTER -->

	<%@ include file="/WEB-INF/page/include/FOOTER.jsp"%>

	<!-- END FOOTER -->

	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->

    <%@ include file="/WEB-INF/page/include/SCRIPTS.jsp"%>

	<!-- END PAGE LEVEL SCRIPTS -->  

	<script>
	jQuery(document).ready(function() {    
	   Metronic.init(); // init metronic core componets
	   Layout.init(); // init layout
	   QuickSidebar.init(); // init quick sidebar
	   Demo.init(); // init demo features 
	   TableManaged.init();
	   
	   $("#validateSubmitForm").validate({
			rules: {
				name: "required",
				username: {
					required: true,
					remote: "${ctx}/user/checkLoginName",
					minlength: 2
				},
				password: {
					required: true,
					minlength: 5
				},
				confirm_password: {
					required: true,
					minlength: 5,
					equalTo: "#password"
				},
				email: {
					//required: true,
					email: true
				}
			},
			messages: {
				id: "请输入你的用户ID",
				name: "请输入你的姓名",
				username: {
					required: "请输入你的账号",
					remote: "用户登录名已存在",
					minlength: "请输入一个长度最少是 2 的字符串"
				},
				password: {
					required: "请提供一个密码",
					minlength: "请输入一个长度最少是 5 的字符串"
				},
				confirm_password: {
					required: "请确认一下密码",
					minlength: "请输入一个长度最少是 5 的字符串",
					equalTo: "请输入与上面相同的密码"
				},
				email: "请输入正确格式的电子邮件"
			}
		});
	});
	</script>

	<!-- END JAVASCRIPTS -->


</html>