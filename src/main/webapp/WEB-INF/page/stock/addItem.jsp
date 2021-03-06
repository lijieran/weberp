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
			库存管理 <small>物料信息添加</small>
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
			
				<div class="portlet-title">
						<div class="caption">
							<!-- <i class="icon-equalizer font-blue-hoki"></i>  --><span
								class="caption-subject font-blue-hoki bold uppercase">物料信息</span>
							<span class="caption-helper"></span>
						</div>
						<div class="actions">
							<!-- <a class="btn btn-circle btn-icon-only btn-default" href="#">
								<i class="icon-cloud-upload"></i>
							</a> <a class="btn btn-circle btn-icon-only btn-default" href="#">
								<i class="icon-wrench"></i>
							</a> <a class="btn btn-circle btn-icon-only btn-default" href="#">
								<i class="icon-trash"></i>
							</a> -->
						</div>
					</div>
					<!-- BEGIN PAGE CONTENT-->
									
			
			<!-- BEGIN PAGE CONTENT-->
			
			<div class="portlet-body form">
								<!-- BEGIN FORM-->
						<form action="${ctx }/suppliers/save" class="form-horizontal form-bordered" method="post" id="validateSubmitForm">
							<div class="form-body">
								<div class="form-group">
									<label class="control-label col-md-3">物料编号<span class="required">* </span></label>
									<div class="col-md-9">
										<input type="text" placeholder="" class="form-control" name="stockid" />
										<span class="help-block"> 物料编号唯一标识,不能重复,不能修改 </span>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3">物料描述<span class="required">* </span></label>
									<div class="col-md-9">
										<input type="text"  class="form-control" name="description"/>
										<!-- <span class="help-block"> This is inline help </span> -->
									</div>
								</div>
								
							
								<div class="form-group last">
									<label class="control-label col-md-3">物料组</label>
									<div class="col-md-9">
										<mytag:myselect cssClass="form-control" type="supplierType" name="typeid"/>
										<span class="help-block"><a href="${ctx }/stock/category">新增或修改物料组</a></span>
									</div>
								</div>
								<div class="form-group last">
									<label class="control-label col-md-3">付款条款</label>
									<div class="col-md-9">
										<mytag:myselect cssClass="form-control" type="paymentterms" name="termscode"/>
									</div>
								</div>
								<div class="form-group last">
									<label class="control-label col-md-3">供应商货币</label>
									<div class="col-md-9">
										<mytag:myselect cssClass="form-control" type="currencies" name="currabrev"/>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3">备注</label>
									<div class="col-md-9">
										<input type="text" class="form-control" name="remark">
									</div>
								</div>
							</div>
							<div class="form-actions">
								<div class="row">
									<div class="col-md-offset-3 col-md-9">
										<button type="submit" class="btn green">
											<i class="fa fa-check"></i> 保存
										</button>
										<button type="button" class="btn default" onclick="history.go(-1)">返回</button>
									</div>
								</div>
							</div>
						</form>
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