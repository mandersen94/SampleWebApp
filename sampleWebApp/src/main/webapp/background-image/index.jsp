
<html>

	<head>
		<script src="../prototype/1.6.0.2/prototype-1.6.0.2.js" type="text/javascript">
			
		</script>
		
		<script>
			function init(){
				
				var height = Element.getHeight($("timmy")); 				
				var width = Element.getWidth($("timmy")); 				
				var offset = Element.cumulativeOffset($("timmy"));
				var top = offset["top"];
				var right = offset["left"];
				
				temp = {};
				temp["height"] = height;
				temp["width"] = width;
				temp["top"] = top;
				temp["right"] = right;
				Element.setStyle($("background"), temp);
			}
		
		</script>
		<link media="screen" href="background.css" type="text/css" rel="stylesheet"></link>
		<style>
			.mark {
				background-color: red;
				background-image: url("test.jpg");
				background-repeat: no-repeat;
			}
			
			img#background { 
				height: 100%; 
				width: 100%; 
				z-index: -1; 
				position: absolute; 
				color: white; 
				background: transparent;
			}
			
			
		</style>

	</head>
	<body onload="init();">
	
	<p>test information.  test text</p>
	<br/>

	<div id="timmy" class="marks" >
		Here's my info.<br/>
		Here's my info.<br/>
		Here's my info.<br/>
		Here's my info.<br/>
		Here's my info.<br/>
		Here's my info.<br/>
		Here's my info.<br/>
		Here's my info.<br/>
		Here's my info.<br/>
		Here's my info.<br/>
		Here's my info.<br/>
		Here's my info.<br/>

	</div>
	
	<br/>
	<p>test footer</p>
	<p>test footer</p>
	<p>test footer</p>
	<p>test footer</p>
	<p>test footer</p>
	<p>test footer</p>
	<p>test footer</p>
	<p>test footer</p>
	
	<img id="background" src="test.jpg"/>

		<script>
					
		</script>

	</body>
</html>
