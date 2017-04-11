<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>


<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->

<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<title>阳阳科技 | 物料信息</title>
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
			库存管理 <small>物料信息修改</small>
			</h3>
			<div class="page-bar bg-inverse">
				<ul class="page-breadcrumb">
					<li>
						<i class="fa fa-home"></i>
						<a href="${ctx }/home">控制台</a>
						<i class="fa fa-angle-right"></i>
					</li>
					<li>
						<a href="#">库存管理</a>
						<i class="fa fa-angle-right"></i>
					</li>
					<li>
						<a href="#">物料信息</a>
					</li>
				</ul>
				
			</div>
			<!-- END PAGE HEADER-->
				<div class="portlet light bg-inverse">
									
			
			<!-- BEGIN PAGE CONTENT-->
			
			<div class="portlet-body form">
										<!-- BEGIN FORM-->
										<form action="${ctx }/material/update" class="form-horizontal" id="validateSubmitForm" method="post">
											<div class="form-body">
												<h3 class="form-section">物料信息修改</h3>
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">物料编号<span class="required">* </span></label>
															<div class="col-md-9">
																<input type="text" class="form-control" name="id" value="${entity.id }" readonly>
																
															</div>
														</div>
													</div>
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">物料名称<span class="required" >* </span></label>
															<div class="col-md-9">
																<input type="text" class="form-control" name="name" value="${entity.name }">
																
															</div>
														</div>
													</div>
													<!--/span-->
												</div>
												<!--/row-->
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">物料规格</label>
															<div class="col-md-9">
																<input type="text" class="form-control" name="spec" value="${entity.spec }">
																
															</div>
														</div>
													</div>
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">单位</label>
															<div class="col-md-9">
																<input type="text" class="form-control" name="unit" value="${entity.unit }">
																
															</div>
														</div>
													</div>
													<!--/span-->
												</div>
												
												<!--/row-->
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">物料种类</label>
															<div class="col-md-9">
																<input type="text" class="form-control" name="kind" value=${entity.kind }>
																
															</div>
														</div>
													</div>
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">颜色</label>
															<div class="col-md-9">
																<input type="text" class="form-control" name="color" value="${entity.color }">
																
															</div>
														</div>
													</div>
													<!--/span-->
												</div>
												
											</div>
											<div class="form-actions">
												<div class="row">
													<div class="col-md-6">
														<div class="row">
															<div class="col-md-offset-3 col-md-9">
																<button type="submit" class="btn green">保存</button>
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
				companyName: {
					required: true,
					remote: {type: "Post",url:"${ctx}/supplier/checkCompanyName"}
				},
				
				email: {
					//required: true,
					email: true
				}
			},
			messages: {
				companyName: {
					required: "公司名称不能为空",
					remote: "公司名称已存在"
				},
				email: "请输入正确格式的电子邮件"
			}
		});
	});
	</script>

	<!-- END JAVASCRIPTS -->


</html>