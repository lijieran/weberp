<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>

<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->

<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<title>阳阳科技 | 角色增加</title>
	<%@ include file="/WEB-INF/page/include/META.jsp"%>
	<link href="${ctxStatic}/metronic/assets/global/plugins/jquery-ztree/3.5.12/css/zTreeStyle/zTreeStyle.min.css" rel="stylesheet" type="text/css"/>
	

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
			系统模块 <small>管理系统角色</small>
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
						<a href="#">角色设置</a>
					</li>
				</ul>
				
			</div>
			<!-- END PAGE HEADER-->
			<!-- BEGIN PAGE CONTENT-->
			<div class="portlet-body form">
										<!-- BEGIN FORM-->
										<form  class="form-horizontal" action="${ctx }/role/update" method="post" id="validateSubmitForm">
											<input type="hidden" name="id" value="${entity.id }">
											<div class="form-body">
												<h3 class="form-section">角色信息</h3>
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">名称</label>
															<div class="col-md-9">
																<input type="text" class="form-control" id="name" name="name" value="${entity.name }">
																
															</div>
														</div>
													</div>
													<!--/span-->
													
												</div>
												<!--/row-->
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">状态</label>
															<div class="col-md-9">
																<select class="form-control" name="useable">
																    <option value="1" <c:if test="${entity.useable=='1' }">selected</c:if> >启用</option>
																    <option value="0" <c:if test="${entity.useable=='0' }">selected</c:if>>停用</option>
																    
																	
																</select>
																
															</div>
														</div>
													</div>
													<!--/span-->
													
												</div>
												<!--/row-->
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">描述</label>
															<div class="col-md-9">
																<input type="text" class="form-control" id="description" name="description" value="${entity.description }">
															</div>
														</div>
													</div>
													<!--/span-->
													
						
												
											     </div>
											     
											     
												<!--/row-->
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">角色授权</label>
															<div class="col-md-9">
																<input type="hidden" id="menus"  name="menus">
																	<div id="treeDemo" class="ztree" style=""></div>
																</input>
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
    <script src="${ctxStatic}/metronic/assets/global/plugins/jquery-ztree/3.5.12/js/jquery.ztree.all-3.5.min.js" type="text/javascript"></script>
    

	<!-- END PAGE LEVEL SCRIPTS -->  

	<script>
	var setting = {
			check: {
				enable: true
			},
			data: {
				simpleData: {
					enable: true
				}
			}
		};

	var zNodes =${treelist};
		
	jQuery(document).ready(function() {    
	   Metronic.init(); // init metronic core componets
	   Layout.init(); // init layout
	   QuickSidebar.init(); // init quick sidebar
	   Demo.init(); // init demo features 
	   TableManaged.init();
	   var tree = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
		// 不选择父节点
	   tree.setting.check.chkboxType = { "Y" : "ps", "N" : "s" };
		
	   $("#validateSubmitForm").validate({
			rules: {
				name: "required"
			},
			messages: {
				name: "请输入角色名"
			
			},
			submitHandler: function(form){
				var ids = [], nodes = tree.getCheckedNodes(true);
				for(var i=0; i<nodes.length; i++) {
					ids.push(nodes[i].id);
				}
				$("#menus").val(ids);
				loading('正在提交，请稍等...');
				form.submit();
			}
		});
	});
	</script>

	<!-- END JAVASCRIPTS -->


</html>