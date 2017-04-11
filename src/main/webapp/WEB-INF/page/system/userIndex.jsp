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
			用户模块 <small>管理登录用户</small>
			</h3>
			<!-- <div class="page-bar">
				<ul class="page-breadcrumb">
					<li>
						<i class="fa fa-home"></i>
						<a href="index.html">Home</a>
						<i class="fa fa-angle-right"></i>
					</li>
					<li>
						<a href="#">Data Tables</a>
						<i class="fa fa-angle-right"></i>
					</li>
					<li>
						<a href="#">Managed Datatables</a>
					</li>
				</ul>
				
			</div> -->
			<!-- END PAGE HEADER-->
			<!-- BEGIN PAGE CONTENT-->
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN EXAMPLE TABLE PORTLET-->
					<div class="portlet box grey-cascade">
						<div class="portlet-title">
							
							<div class="caption">
								<i class="fa fa-cogs"></i>用户列表
							</div>
							<div class="actions">
								<a href="${ctx }/user/add" class="btn btn-default btn-sm">
								<i class="fa fa-plus"></i> 新增 </a>
								<a href="#" class="btn btn-default btn-sm">
								<i class="fa fa-print"></i> 打印 </a>
							</div>
						</div>
						<div class="portlet-body">
							
								
							<table class="table table-striped table-bordered table-hover" id="datatable_ajax">
								<thead>
								<tr role="row" class="heading">
									
									<th width="5%">
										 编号
									</th>
									<th width="10%">
										名称
									</th>
									<th width="15%">
										登录账号
									</th>
									<th width="15%">
										 工号
									</th>
									<th width="15%">
										 邮箱
									</th>
									<th width="15%">
										 电话
									</th>
									<th width="15%">
										 最后登录时间
									</th>
									<th width="5%">
										 状态
									</th>
									<th width="5%">
										
									</th>
									<th width="5%">
										 
									</th>
									
									
								</tr>
								
								</thead>
								<tbody>
								</tbody>
								</table>
								
							
						</div>
					</div>
					<!-- END EXAMPLE TABLE PORTLET-->
				</div>
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
	   //TableAjax.init();
	   
	   var table = $("#datatable_ajax").dataTable({
			"processing": true,
			//"serverSide": true,
			"searching": false,
			"bSort": false,
			 "pageLength": 10,
			"ajax": {
               "url": ctx+"/user/list", // ajax source
           },
           "language": {
        	   "url":"${ctxStatic}/metronic/assets/global/scripts/Chinese.json"
           },"columnDefs": [{
               "render": function(data, type, row) {
            	   if(data==0) return '停用';
            	   if(data==1) return '启用';
                   return data;
               },
               "targets": 7
           }],
			"columns": [
       				{"data": "id"},
       				{"data": "name"},
       				{"data": "username"},
       				{"data": "no"},
       				{"data": "email"},
       				{"data": "phone"},
       				{"data": "loginTime"},
       				{"data": "useable"},
       				{"defaultContent": "<button class='btn green edit'>编辑</button>"},
       				{"defaultContent": "<button class='btn red delete'>删除</button>"}
       		]
		});
	   $('#datatable_ajax tbody').on( 'click', '.edit', function () {
		   var nRow = $(this).parents('tr')[0];
		   var jqTds = $('>td', nRow);
	      // console.info(jqTds[0].innerHTML);
	       window.location.href = "${ctx}/user/update?id="+jqTds[0].innerHTML;
	    } );
	   $('#datatable_ajax tbody').on( 'click', '.delete', function () {
		   var nRow = $(this).parents('tr')[0];
		   var jqTds = $('>td', nRow);
		   if (confirm("确认要删除该行吗？") == false) {
               return;
           }
		   window.location.href = "${ctx}/user/delete?id="+jqTds[0].innerHTML;

           //var nRow = $(this).parents('tr')[0];
           //oTable.fnDeleteRow(nRow);
          // alert("Deleted! Do not forget to do some ajax to sync with backend :)");
	      // console.info(jqTds[0].innerHTML);
	       
	    } );
	});
	</script>

	<!-- END JAVASCRIPTS -->


</html>