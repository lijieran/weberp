<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>

<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->

<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<title>阳阳科技 | 菜单管理</title>
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
			权限模块 <small>管理权限菜单</small>
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
						<a href="#">权限菜单</a>
					</li>
				</ul>
				
			</div>
			<!-- END PAGE HEADER-->
			<!-- BEGIN PAGE CONTENT-->
			<div class="portlet-body form">
										<!-- BEGIN FORM-->
										<form  class="form-horizontal" action="${ctx }/menu/save" method="post">
											<div class="form-body">
												<h3 class="form-section">菜单信息</h3>
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">名称</label>
															<div class="col-md-9">
																<input type="text" class="form-control" id="name" name="name" >
																
															</div>
														</div>
													</div>
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group ">
															<label class="control-label col-md-3">链接</label>
															<div class="col-md-9">
																<input type="text" class="form-control" id="href"  name="href" >
																<span class="help-block">
																点击菜单跳转的页面 </span>
															</div>
														</div>
													</div>
													<!--/span-->
												</div>
												<!--/row-->
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">上级菜单</label>
															<div class="col-md-9">
																<select class="form-control" name="parentId">
																    <option value="" selected></option>
																    <c:forEach items="${menus }" var="entity">
																      <option value="${entity.id }">${entity.name }</option>
																    </c:forEach>
																	
																</select>
																
															</div>
														</div>
													</div>
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">排序</label>
															<div class="col-md-9">
																<input type="text" class="form-control" id="sort" name="sort" value="1">
															</div>
														</div>
													</div>
													<!--/span-->
												</div>
												<!--/row-->
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">图标</label>
															<div class="col-md-9">
																<input type="text" class="form-control" id="icon" name="icon">
															</div>
														</div>
													</div>
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">权限标识</label>
															<div class="col-md-9">
																<input type="text" class="form-control" id="permission" name="permission">
																	
															</div>
														</div>
													</div>
													<!--/span-->
						
												
											     </div>
											     
											     	<!--/row-->
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">菜单状态</label>
															<div class="col-md-9">
																<select class="form-control" name="status">
																	<option value="3" selected>启用并停靠菜单</option>
																	<option value="2">启用</option>
																	<option value="1">虚拟</option>
																	<option value="0">停用</option>
																</select>
																
															</div>
														</div>
													</div>
													<!--/span-->
													
												</div>
												<!--/row-->
											     
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
	});
	</script>

	<!-- END JAVASCRIPTS -->


</html>