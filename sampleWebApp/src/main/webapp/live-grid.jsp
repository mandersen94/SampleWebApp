
<html>

<head>


<script src="openrico/rico.js" type="text/javascript" ></script>


	
<script type="text/javascript">
	Rico.loadModule('LiveGridAjax');
	Rico.loadModule('LiveGridMenu');
	Rico.include('greenHdg.css');
	var buf;
	
	
	Rico.onLoad( function() {
			//alert("loaded");
			Rico.setDebugArea('debug-area', true);

			//var buf = new Rico.Buffer.Base($('data_grid').tBodies[0])
			var url = "TableServlet";
			var options = {};
			var ajaxOptions = {};
			var buf = new Rico.Buffer.AjaxXML(url);
			var opts = {minPageRows: 50, 
						maxPageRows:50, 
						prefetchBuffer:true 
						};
			//var liveGrid = new Rico.LiveGrid('data_grid', 5, 1000, '/TableServlet', opts);
			var liveGrid = new Rico.LiveGrid('data_grid', buf, opts);
		
		}
	);
	Rico.loadModule('LiveGridAjax');
	Rico.loadModule('LiveGridMenu');	
	</script>


</head>
<body >

<!-- <textarea rows="10" cols="100" id="debug-area" ></textarea> -->
<div id="debug"></div>

<div id="viewPort" style="float: left">
<table id="data_grid" class="fixedTable" border="1" cellspacing="0"
	cellpadding="0"
	style="float: left; width: 560px; border-left: 1px solid #ababab">
	<tr>
		<th class="first tableCellHeader"
			style="width: 30px; text-align: center">#</th>
		<th class="tableCellHeader" style="width: 280px">Title</th>
		<th class="tableCellHeader" style="width: 80px">Genre</th>
		<th class="tableCellHeader" style="width: 50px">Rating</th>
		<th class="tableCellHeader" style="width: 60px">Votes</th>
		<th class="tableCellHeader" style="width: 60px">Year</th>
	</tr>
</table>
</div>


</body>

</html>
