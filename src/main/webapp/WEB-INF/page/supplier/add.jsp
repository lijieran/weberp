<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>


<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->

<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<title>阳阳科技 | 供应商信息</title>
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
			采购管理 <small>供应商添加</small>
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
						<a href="#">供应商信息</a>
					</li>
				</ul>
				
			</div>
			<!-- END PAGE HEADER-->
				<div class="portlet light bg-inverse">
									
			
			<!-- BEGIN PAGE CONTENT-->
			
			<div class="portlet-body form">
										<!-- BEGIN FORM-->
										<form action="${ctx }/supplier/save" class="form-horizontal" id="validateSubmitForm" method="post">
											<div class="form-body">
												<h3 class="form-section">供应商信息</h3>
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">公司名称<span class="required">
										* </span></label>
															<div class="col-md-9">
																<input type="text" class="form-control" name="companyName">
																
															</div>
														</div>
													</div>
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">公司地址</label>
															<div class="col-md-9">
																<input type="text" class="form-control" name="address">
																
															</div>
														</div>
													</div>
													<!--/span-->
												</div>
												<!--/row-->
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">主要产品</label>
															<div class="col-md-9">
																<input type="text" class="form-control" name="mainProduct">
																
															</div>
														</div>
													</div>
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">联系人</label>
															<div class="col-md-9">
																<input type="text" class="form-control" name="linkname">
																
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
															<label class="control-label col-md-3">公司电话</label>
															<div class="col-md-9">
																<input type="text" class="form-control" name="companyPhone">
																
															</div>
														</div>
													</div>
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">联系人电话</label>
															<div class="col-md-9">
																<input type="text" class="form-control" name="mobile">
																
															</div>
														</div>
													</div>
													<!--/span-->
												</div>
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">联系人邮箱</label>
															<div class="col-md-9">
																<input type="text" class="form-control" name="email">
																
															</div>
														</div>
													</div>
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">联系人QQ</label>
															<div class="col-md-9">
																<input type="text" class="form-control" name="qq">
																
															</div>
														</div>
													</div>
													<!--/span-->
												
												</div>
												<!--/row-->
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">公司规模</label>
															<div class="col-md-9">
																<!-- <select class="form-control" name="useable">
																    <option value="1" selected>启用</option>
																    <option value="0" >停用</option>
																    
																	
																</select> -->
																
																<mytag:select name="companySize" cssClass="form-control" metaType="companySize"/>
																
															</div>
															
														</div>
													</div>
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">备注</label>
															<div class="col-md-9">
																<!-- <input type="text" class="form-control"> -->
																<textarea rows="4" class="form-control" name="remark"></textarea>
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