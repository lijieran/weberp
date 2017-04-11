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
			
		<div class="row">	
			<div class="col-md-12">
					<!-- BEGIN EXAMPLE TABLE PORTLET-->
					<div class="portlet box grey-cascade">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-cogs"></i>菜单列表
							</div>
							<div class="actions">
								<a href="${ctx }/menu/add" class="btn btn-default btn-sm">
								<i class="fa fa-plus"></i> 新增 </a>
								<a href="#" class="btn btn-default btn-sm">
								<i class="fa fa-print"></i> 打印 </a>
							</div>
						</div>
						<div class="portlet-body">
							<table class="table table-striped table-bordered table-hover" id="datatable_ajax">
							<thead>
							<tr>
								<th width="5%">
										 编号
									</th>
									<th width="10%">
										名称
									</th>
									<th width="15%">
										 图标
									</th>
									<th width="15%">
										 权限标识
									</th>
									<th width="15%">
										 状态
									</th>
									<th width="15%">
										 父菜单编号
									</th>
									<th width="15%">
										 排序
									</th>
									<th width="15%">
										 链接
									</th>
									<th width="10%">
										 
									</th>
									<th width="10%">
										 
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
			<!-- BEGIN PAGE CONTENT-->
			
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
			"searching": true,
			"bSort": false,
			 "pageLength": 10,
			"ajax": {
               "url": ctx+"/menu/list", // ajax source
           },
           "language": {
        	   "url":"${ctxStatic}/metronic/assets/global/scripts/Chinese.json"
               
           },"columnDefs": [{
               "render": function(data, type, row) {
            	   if(data==3) return '显示型菜单';
            	   if(data==0) return '停用';
            	   if(data==2) return '启用';
                   return data;
               },
               "targets": 4
           }],
			"columns": [
       				{"data": "id"},
       				{"data": "name"},
       				{"data": "icon"},
       				{"data": "permission"},
       				{"data": "status"},
       				{"data": "parentId"},
       				{"data": "sort"},
       				{"data": "href"},
       				{"defaultContent": "<button class='btn green edit'>编辑</button>"},
       				{"defaultContent": "<button class='btn red delete'>删除</button>"}
       		]
		});
	   $('#datatable_ajax tbody').on( 'click', '.edit', function () {
		   var nRow = $(this).parents('tr')[0];
		   var jqTds = $('>td', nRow);
	      // console.info(jqTds[0].innerHTML);
	       window.location.href = "${ctx}/menu/update?id="+jqTds[0].innerHTML;
	    } );
	   $('#datatable_ajax tbody').on( 'click', '.delete', function () {
		   var nRow = $(this).parents('tr')[0];
		   var jqTds = $('>td', nRow);
		   if (confirm("确认要删除该行吗？") == false) {
               return;
           }
		   window.location.href = "${ctx}/menu/delete?id="+jqTds[0].innerHTML;

           //var nRow = $(this).parents('tr')[0];
           //oTable.fnDeleteRow(nRow);
          // alert("Deleted! Do not forget to do some ajax to sync with backend :)");
	      // console.info(jqTds[0].innerHTML);
	       
	    } );
	});
	</script>

	<!-- END JAVASCRIPTS -->


</html>