<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>

<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->

<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<title>阳阳科技 | 采购进货</title>
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
		<div class="page-content ">
			<%@ include file="/WEB-INF/page/include/SETTING.jsp"%>
			<!-- BEGIN PAGE HEADER-->
			<h3 class="page-title">
			采购管理 <small>采购进货</small>
			</h3>
			<div class="page-bar bg-inverse">
				<ul class="page-breadcrumb">
					<li>
						<i class="fa fa-home"></i>
						<a href="${ctx }/home">控制台</a>
						<i class="fa fa-angle-right"></i>
					</li>
					<li>
						<a href="#">采购管理</a>
						<i class="fa fa-angle-right"></i>
					</li>
					<li>
						<a href="#">采购进货</a>
					</li>
				</ul>
				
			</div>
			<!-- END PAGE HEADER-->
				<div class="portlet light bg-inverse">
									
			
			<!-- BEGIN PAGE CONTENT-->
			
			<div class="portlet-body form">
										<!-- BEGIN FORM-->
										<form action="#" class="form-horizontal">
											<div class="form-body">
												<h3 class="form-section">采购进货申请单</h3>
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">进货申请单号</label>
															<div class="col-md-9">
																<input type="text" class="form-control" placeholder="NYT_013213123">
																<span class="help-block">
																 </span>
															</div>
														</div>
													</div>
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">物料</label>
															<div class="col-md-9">
																<select name="foo" class="select2me form-control">
																	<option value="1">商</option>
																	<option value="1">周</option>
																</select>
																<span class="help-block">
																<a href="#">增加新物料</a> </span>
															</div>
														</div>
													</div>
													<!--/span-->
												</div>
												<!--/row-->
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">供应商</label>
															<div class="col-md-9">
																<select class="form-control">
																	<option value="">Male</option>
																	<option value="">Female</option>
																</select>
																<span class="help-block">
																<a href="#">增加新供应商</a> </span> </span>
															</div>
														</div>
													</div>
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">业务类型</label>
															<div class="col-md-9">
																<input type="text" class="form-control" value="采购入库" readonly>
															</div>
														</div>
													</div>
													<!--/span-->
												</div>
												
<!-- 												<h3 class="form-section">物料信息</h3>
 -->												<!--/row-->
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">单价</label>
															<div class="col-md-9">
																<input type="text" class="form-control">
															</div>
														</div>
													</div>
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">数量</label>
															<div class="col-md-9">
																<input type="text" class="form-control">
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">总额</label>
															<div class="col-md-9">
																<input type="text" class="form-control" readonly>
															</div>
														</div>
													</div>
												
												</div>
												<!--/row-->
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">备注</label>
															<div class="col-md-9">
																<!-- <input type="text" class="form-control"> -->
																<textarea rows="4" class="form-control"></textarea>
															</div>
														</div>
													</div>
													<!--/span-->
													
													<!--/span-->
												</div>
												<!--/row-->
											</div>
											<div class="form-actions">
												<div class="row">
													<div class="col-md-6">
														<div class="row">
															<div class="col-md-offset-3 col-md-9">
																<button type="submit" class="btn green">保存</button>
																<button type="button" class="btn default">取消</button>
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