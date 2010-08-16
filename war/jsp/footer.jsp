</div>
</div>

<div id="col_right">

</div>

<div id="footer">Deicer - another app engine blog application by Jørund Nydal</div>

</div>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.4.2.min.js"></script> 
<script type="text/javascript" src="/static/scripts/jquery-ui-1.8.4.custom.min.js"></script>
<script type="text/javascript" src="/static/scripts/jshash-2.2/sha1-min.js"></script>
<script type="text/javascript" src="/static/scripts/deicer.js"></script>
<script type="text/javascript" src="/static/scripts/jquery.hoverIntent.minified.js"></script>
<script type="text/javascript" src="/static/scripts/superfish.js"></script>
<script type="text/javascript" src="/static/tinymce/jscripts/tiny_mce/jquery.tinymce.js"></script>
  
<script type="text/javascript">

	var DeicerChallenge = "";

	try {
	
		DeicerChallenge = AuthenticationChallenge;
		
	}catch(error) {}

	Deicer.init(DeicerChallenge);
	Deicer.seversalt = "${serversalt}";
 
</script>

</body>
</html>
